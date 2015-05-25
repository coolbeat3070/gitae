package com.gite.simple.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gite.simple.beans.BbsCommand;


public class BbsValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return BbsCommand.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		// BbsCommand command = (BbsCommand) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "emptyOrWhitespace.BbsCommand.title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "emptyOrWhitespace.BbsCommand.content");
	}
}	
