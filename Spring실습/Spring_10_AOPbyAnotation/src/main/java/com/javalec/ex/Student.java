package com.javalec.ex;

import javax.print.DocFlavor.STRING;

public class Student {

	private String name;
	private int age;
	private int gradeNum;
	private int classNum;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getGradeNum() {
		return gradeNum;
	}
	public int getClassNum() {
		return classNum;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}
	public void getStudentInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("나이 : " + getAge());
		System.out.println("반 : " + getClassNum());
		System.out.println("학년 : " + getGradeNum());
	}
}
