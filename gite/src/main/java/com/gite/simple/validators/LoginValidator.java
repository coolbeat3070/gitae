package com.gite.simple.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gite.simple.beans.LoginCommand;


public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		// LoginCommand loginCommand = (LoginCommand) target;
		// String id = loginCommand.getId();
		// String password = loginCommand.getPassword();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "zerolength.loginCommand.id");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "zerolength.loginCommand.password");
	}
}
