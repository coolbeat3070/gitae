package com.gite.simple.repositories;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gite.simple.beans.JoinBean;
import com.gite.simple.beans.LoginCommand;
import com.gite.simple.beans.LoginInfoSessionBean;
import com.gite.simple.beans.PasswordChangeCommand;
import com.gite.simple.beans.UserInfoCommand;



@Repository
public class MemberRepositoryImpl implements MemberRepository{

	@Autowired private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int getIdCount(String id) {
		String statement = "users.getIdCount";
		return (int)sqlSessionTemplate.selectOne(statement, id);
	}
	
	@Override
	public void insertNewMember(JoinBean joinBean) {
		String statement = "users.insertNewMember";
		sqlSessionTemplate.insert(statement, joinBean);
	}
	
	@Override
	public LoginInfoSessionBean login(LoginCommand loginCommand) {
		String statement = "users.login";
		return (LoginInfoSessionBean)this.sqlSessionTemplate.selectOne(statement, loginCommand);
	}
	
	@Override
	public void editUserInfo(UserInfoCommand userInfoCommand) {
		String statement = "users.editUserInfo";
		this.sqlSessionTemplate.update(statement, userInfoCommand);
	}
	
	@Override
	public void changePassword(PasswordChangeCommand command) {
		String statement = "users.changePassword";
		this.sqlSessionTemplate.update(statement, command);
		
	}
}

