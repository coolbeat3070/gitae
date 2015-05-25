package com.gite.simple.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gite.simple.beans.JoinBean;
import com.gite.simple.beans.LoginCommand;
import com.gite.simple.beans.LoginInfoSessionBean;
import com.gite.simple.beans.PasswordChangeCommand;
import com.gite.simple.beans.UserInfoCommand;
import com.gite.simple.repositories.MemberRepository;



@Service
public class MemberServiceImpl implements MemberService{

	@Autowired private MemberRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public boolean checkIdDuplicate(String id) {
		int count = this.repository.getIdCount(id);
		
		if(count >= 1)
			return true;
		
		return false;
	}
	
	@Override
	@Transactional
	public void insertNewMember(JoinBean joinBean) {
		this.repository.insertNewMember(joinBean);
	}
	
	@Override
	@Transactional(readOnly=true)
	public LoginInfoSessionBean login(LoginCommand loginCommand) {
		return this.repository.login(loginCommand);
	}

	@Override
	@Transactional
	public void editUserInfo(UserInfoCommand userInfoCommand) {
		this.repository.editUserInfo(userInfoCommand);
	}
	
	@Override
	@Transactional
	public void changePassword(PasswordChangeCommand command) {
		this.repository.changePassword(command);
	}
	
	
}
