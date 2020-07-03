package com.javalec.ex;

public class Student {
	private String name;
	private int age;
	private int classNum;
	private int gradeNum;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getClassNum() {
		return classNum;
	}
	public int getGradeNum() {
		return gradeNum;
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
		System.out.println("이름 : "+ getName());
		System.out.println("나이 : "+ getAge());
		System.out.println("반이름 : "+ getClassNum());
		System.out.println("학년 : "+ getGradeNum());
		try {
			System.out.println(10/0);//일부러 오류내서 aop:after실험
		}catch(Exception e) {System.out.println("error");}
	}
}
