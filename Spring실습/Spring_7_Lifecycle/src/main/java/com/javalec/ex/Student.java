package com.javalec.ex;
import org.springframework.beans.factory.*;
import javax.annotation.*;
public class Student implements InitializingBean, DisposableBean{
	private String name;
	private int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public void afterPropertiesSet() throws Exception{
		System.out.println("호출");
	}
	@Override
	public void destroy() throws Exception{
		System.out.println("소멸");
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("init");
	}
	@PreDestroy
	public void destroym() {
		System.out.println("destroy");
	}
}
