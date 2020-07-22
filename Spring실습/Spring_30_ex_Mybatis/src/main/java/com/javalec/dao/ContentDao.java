package com.javalec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.dto.ContentDto;

public class ContentDao implements IDao{
	JdbcTemplate tmp;
	@Autowired
	public void setTemplate(JdbcTemplate tmp) {
		this.tmp = tmp;
	}
	
	public ContentDao() {
		
	}
	@Override
	public ArrayList<ContentDto> listDao(){
		String query = "select * from board order by mId desc";
		ArrayList<ContentDto> dtos = (ArrayList<ContentDto>)tmp.query(query,new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
		return dtos;
	}
	@Override
	public void writeDao(final String mWriter, final String mContent) {
		System.out.println("writeDao()");
		this.tmp.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into board (mId,mWriter,mContent) values(board_seq.nextval,?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, mWriter);
				pstmt.setString(2, mContent);
				return pstmt;
			}
		});
	}
	@Override
	public ContentDto viewDao(String strID) {
		System.out.println("viewDao");
		String query = "select * from board where mId = ?";
		return tmp.queryForObject(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
	}
	@Override
	public void deleteDao(final String bId) {
		System.out.println("delete");
		String query = "delete from board where mId = ?";
		this.tmp.update(query,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
	}
}