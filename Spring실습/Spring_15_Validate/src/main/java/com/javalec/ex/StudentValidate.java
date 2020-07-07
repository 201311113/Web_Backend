package com.javalec.ex;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidate implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate");
		Student std = (Student)obj;
		
		String stdname = std.getName();
		if(stdname == null || stdname.trim().isEmpty()) {
			System.out.println("stdname is null or empty");
			errors.rejectValue("name", "trouble");
		}
		int stdId = std.getId();
		if(stdId == 0) {
			System.out.println("stdId is 0");
			errors.rejectValue("id", "trouble");
		}
	}
}
