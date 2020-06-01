package com.javalec.daoto;
import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class memberDAO {
	public static final int MEMBER_NONEXISTENT =0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL=0;
	public static final int MEMBER_JOIN_SUCCESS=1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IN_NOT = -1;
	
	private static memberDAO instance = new memberDAO();
	
	private memberDAO() {
		
	}
	public static memberDAO getInstance() {
		return instance;
	}
	public int insertMember(memberDTO dto) {
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "insert into members values(?,?,?,?,?,?)";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEMail());
			pstmt.setTimestamp(5, dto.getRDate());
			pstmt.setString(6, dto.getAddress());
			pstmt.executeUpdate();
			ri = memberDAO.MEMBER_JOIN_SUCCESS;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ri;
	}
	
	public int confirmId(String id) {//아이디 검사
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select id from members where id = ?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);//아이디만 뽑아서
			set = pstmt.executeQuery();//result set
			if(set.next()) {
				ri = memberDAO.MEMBER_EXISTENT;
			}else {
				ri = memberDAO.MEMBER_NONEXISTENT;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ri;
	}
	
	public int userCheck(String id, String pw) {
		int ri = 0;
		String dbpw;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select pw from members where id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				dbpw = set.getString("pw");
				if(dbpw.equals(pw)) {
					ri = memberDAO.MEMBER_LOGIN_SUCCESS;
				}else {
					ri = memberDAO.MEMBER_LOGIN_PW_NO_GOOD;
				}
			} else {
				ri = memberDAO.MEMBER_LOGIN_IN_NOT;
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return ri;
	}
	
	public memberDTO getMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select * from members where id = ? ";
		memberDTO dto = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				dto = new memberDTO();
				dto.setId(set.getString("id"));
				dto.setPw(set.getString("pw"));
				dto.setName(set.getString("name"));
				dto.setEMail(set.getString("eMail"));
				dto.setRDate(set.getTimestamp("rDate"));
				dto.setAddress(set.getString("address"));
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	public int updateMember(memberDTO dto) {
		int ri=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update members set pw=?,eMail=?,address=? where id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getEMail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getId());
			ri = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ri;
	}
	
	public ArrayList<memberDTO> membersAll(){
		ArrayList<memberDTO> dtos = new ArrayList<memberDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from members";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			System.out.println("================");
			while(rs.next()) {
				memberDTO dto = new memberDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setEMail(rs.getString("eMail"));
				dto.setRDate(rs.getTimestamp("rDate"));
				dto.setAddress(rs.getString("address"));
				dtos.add(dto);
			}
			System.out.println("----------------");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
		
	}
	
	
	private Connection getConnection() {
		Context context = null;
		DataSource dataSource = null;
		Connection con = null;
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle18");
			con = dataSource.getConnection();
		}catch(Exception e) {e.printStackTrace();}
		return con;
	}
}
