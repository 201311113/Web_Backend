package com.javalec.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.dto.BDto;

public class BDao {

	DataSource dataSource;
	
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle18");
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Dao Object connect complete");
	}
	
	public void write(String bName,String bTitle,String bContent) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup,bStep,bIndent) values(mvc_board_seq.nextval,?,?,?,0,mvc_board_seq.currval,0,0)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			int ri = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("Write complete in dao");
	}
	
	public ArrayList<BDto> list(){
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				BDto dto = new BDto(bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("bring list complete");
		return dtos;
		
	}
	
	public BDto contentView(String strID) {
		upHit(strID);
		BDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String query = "select *from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strID));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("now can watch the writing");
		return dto;
	}
	public void modify(String bId,String bName,String bTitle,String bContent) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String query = "update mvc_board set bName = ? , bTitle = ? , bContent = ? where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bId));
			int ri = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("modify successed");
	}
	
	public void delete(String bId) {
		Connection con =null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String query = "delete from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bId));
			int ri = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("delete successed");
	}
	
	public BDto reply_view(String str) {
		
		BDto dto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			con = dataSource.getConnection();
			String query = "select * from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(str));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
			
				dto = new BDto(bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("bring reply successed");
		return dto;
	}
	
	public void reply(String bId,String bName, String bTitle,String bContent,String bGroup,String bStep,String bIndent) {
		replyShape(bGroup,bStep);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String query = "insert into mvc_board (bId , bName,bTitle,bContent,bGroup,bStep,bIndent) values(mvc_board_seq.nextval,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
		
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep)+1);
			pstmt.setInt(6, Integer.parseInt(bIndent)+1);
			
			int ri = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("reply is made");
	}
	private void replyShape(String strGroup, String strStep ) {
		Connection con =null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, Integer.parseInt(strGroup));
			pstmt.setInt(2, Integer.parseInt(strStep));
			
			int rn = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
		
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	private void upHit(String bId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String query= "update mvc_board set bHit = bHit + 1 where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bId);
			int ri = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("uphit complete");
	}
}
