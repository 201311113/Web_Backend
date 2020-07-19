package com.javalec.tdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.javalec.tdto.TicketDto;

public class TicketDao {
	JdbcTemplate tmp;
	
	TransactionTemplate transactiontmp1;
	
	public void setTmp(JdbcTemplate tmp) {
		this.tmp = tmp;
	}
	
	public void setTransactiontmp1(TransactionTemplate transactiontmp1) {
		this.transactiontmp1 = transactiontmp1;
	}
	public TicketDao() {
		System.out.println(tmp);
	}
	public void buyTicket(final TicketDto dto) {
		System.out.println("buyticket");
		System.out.println("consumerId is "+dto.getConsumerId());
		System.out.println("amount is "+dto.getAmount());
		
		transactiontmp1.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				tmp.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						// TODO Auto-generated method stub
						String query = "insert into card (consumerId,amount) values(?,?)";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setString(2, dto.getAmount());
						
						return pstmt;
					}
				});
				
				tmp.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						// TODO Auto-generated method stub
						String query = "insert into ticket (consumerId, countnum) values(?,?)";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setString(2,dto.getAmount());
						return pstmt;
					}
				});
			} 
		});
	}
}
