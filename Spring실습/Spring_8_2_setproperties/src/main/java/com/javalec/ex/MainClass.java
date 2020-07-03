package com.javalec.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainClass {
	public static void main(String[] args) {
		//java파일 어노테이션사용방법시주석 해제//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AdminConfig1.class);
		//java파일 어노테이션사용방법시주석 해제//minConnection connection = ctx.getBean("adminConfig",AdminConnection.class);
		//xml파일 사용시 주석해제//AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		//xml파일 사용시 주석해제//AdminConnection connection = ctx.getBean("adminConnection",AdminConnection.class);
		System.out.println("adminID : "+ connection.getAdminId());
		System.out.println("adminPW : "+ connection.getAdminPw());
		System.out.println("sub_adminID : "+ connection.getSub_adminId());
		System.out.println("sub_adminPW : "+ connection.getSub_adminPw());
		ctx.close();
	}
}
