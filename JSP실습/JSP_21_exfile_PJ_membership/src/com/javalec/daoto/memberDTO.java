package com.javalec.daoto;
import java.sql.*;
public class memberDTO {

	private String id;
	private String pw;
	private String name;
	private String eMail;
	private Timestamp rDate;
	private String address;
	
	//���⼭ ������ �Ⱦ��� ���� : bean�� ����ؼ� �����ϱ� ����
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEMail() {
		return eMail;
	}
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}
	public Timestamp getRDate() {
		return rDate;
	}
	public void setRDate(Timestamp rDate) {
		this.rDate = rDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}