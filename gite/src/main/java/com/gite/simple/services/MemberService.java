package com.gite.simple.services;

import com.gite.simple.beans.JoinBean;
import com.gite.simple.beans.LoginCommand;
import com.gite.simple.beans.LoginInfoSessionBean;
import com.gite.simple.beans.PasswordChangeCommand;
import com.gite.simple.beans.UserInfoCommand;

public interface MemberService {
	public boolean checkIdDuplicate(String id);
	public void insertNewMember(JoinBean joinBean);
	public LoginInfoSessionBean login(LoginCommand loginCommand);
	public void editUserInfo(UserInfoCommand userInfoCommand);
	public void changePassword(PasswordChangeCommand command);
}

