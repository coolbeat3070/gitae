package com.gite.simple.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gite.simple.beans.JoinBean;


public class JoinValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return JoinBean.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		JoinBean bean = (JoinBean) target;
		
		String id = bean.getId();
		String password = bean.getPassword();
		String passwordConfirm = bean.getPasswordConfirm();
		String name = bean.getName();

		// ���� �պκа� ���� �޺κ� ����� ���ԵǴ��� üũ
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "emptyOrWhitespace.id");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "emptyOrWhitespace.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "emptyOrWhitespace.passwordConfirm");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "emptyOrWhitespace.name");
		
		// �ʵ忡 ����� ����ִ��� üũ
		if(id.contains(" "))
			errors.rejectValue("id", "whitespaceInserted.id");
		if(password.contains(" "))
			errors.rejectValue("password", "whitespaceInserted.password");
		if(passwordConfirm.contains(" "))
			errors.rejectValue("passwordConfirm", "whitespaceInserted.passwordConfirm");
		
		// �ʵ尪 ���� üũ
		if(!(id.length() > 5 && id.length() < 13))
			errors.rejectValue("id", "notEnoughLength.id");
		if(!(password.length() > 3 && password.length() < 13))
			errors.rejectValue("password", "notEnoughLength.password");
		if(!(name.length() > 1 && name.length() < 13))
			errors.rejectValue("name", "notEnoughLength.name");
		
		// ���̵� ����� ���ڸ� ������ üũ
		for(int i=0; i<id.length(); i++){
			char ch = id.charAt(i);
			
			if( !(ch >= '0' && ch <= '9')
					&&
				!(ch >= 'a' && ch <= 'z')
					&&
				!(ch >= 'A' && ch <= 'Z')
			)
				errors.rejectValue("id", "notAlphaNumeric.id");
		}
		
		if(!password.equals(passwordConfirm))
			errors.rejectValue("passwordConfirm", "noMatchPasswordWithPasswordConfirm.passwordConfirm");
	}
}
