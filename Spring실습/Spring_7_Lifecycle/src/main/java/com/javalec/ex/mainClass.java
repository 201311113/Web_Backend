package com.javalec.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class mainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationCTX.xml");
		ctx.refresh();
		
		Student student = ctx.getBean("student",Student.class);
		System.out.println("이름 : "+student.getName());
		System.out.println("나이 : "+student.getAge());
		ctx.close();
	}
}
