package com.javalec.tcommand;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.javalec.tdao.TicketDao;
import com.javalec.tdto.TicketDto;

public class TicketCommand implements TCommand{
	private TicketDao ticketDao;
	private TransactionTemplate transactionTmp2;
	
	public void setTransactionTmp2(TransactionTemplate transactionTmp2) {
		this.transactionTmp2 = transactionTmp2;
	}
	public TicketDao getTicketDao() {
		return ticketDao;
	}
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	
	
	@Override
	public void execute(final TicketDto ticketDto) {
		if(transactionTmp2==null) System.out.println("transaction is nothing");
		
		transactionTmp2.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				
				ticketDao.buyTicket(ticketDto);
				
			}
		 
		});
	}
	
}
