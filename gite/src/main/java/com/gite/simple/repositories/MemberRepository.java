package com.gite.simple.repositories;

import com.gite.simple.beans.JoinBean;
import com.gite.simple.beans.LoginCommand;
import com.gite.simple.beans.LoginInfoSessionBean;
import com.gite.simple.beans.PasswordChangeCommand;
import com.gite.simple.beans.UserInfoCommand;


public interface MemberRepository {
	public int getIdCount(String id);
	public void insertNewMember(JoinBean joinBean);
	public LoginInfoSessionBean login(LoginCommand loginCommand);
	public void editUserInfo(UserInfoCommand userInfoCommand);
	public void changePassword(PasswordChangeCommand command);
}

