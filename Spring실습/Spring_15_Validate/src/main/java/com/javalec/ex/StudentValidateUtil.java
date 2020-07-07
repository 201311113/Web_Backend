package com.javalec.ex;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidateUtil implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validate");
		Student std = (Student)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id", "trouble");
	}
	
}
