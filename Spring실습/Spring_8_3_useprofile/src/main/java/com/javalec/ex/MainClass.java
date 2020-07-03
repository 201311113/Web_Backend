package com.javalec.ex;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String config = null;
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		if(str.equals("A")) {
			config = "A";
		}else {
			config = "B";
		}
		scanner.close();
		/* XML파일 사용하려면 주석 제거
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("applicationCTX_A.xml","applicationCTX_B.xml");
		*/
		/* 어노테이션으로 사용하려면 주석 제거
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.register(ApplicationConfigA.class,ApplicationConfigB.class);
		*/
		ctx.refresh();
		ServerInfo info = ctx.getBean("serverInfo",ServerInfo.class);
		System.out.println("ip : "+ info.getIpNum());
		System.out.println("port : "+ info.getPortNum());
		ctx.close();
	}
}
