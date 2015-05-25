package com.gite.simple.beans;

import java.util.Date;

public class BbsCommand {
	private String bbsNo;
	private String title;
	private String preContents;
	private String content;
	private String regDateStringType; // �����Ҷ� dateŸ��, �����ö� stringŸ�� 
	private Date regDateDateType;
	private int viewCnt;
	private String userNo;
	private String userId;
	private String userName;
	
	public String getRegDateStringType() {
		return regDateStringType;
	}
	public void setRegDateStringType(String regDateStringType) {
		this.regDateStringType = regDateStringType;
	}
	public Date getRegDateDateType() {
		return regDateDateType;
	}
	public void setRegDateDateType(Date regDateDateType) {
		this.regDateDateType = regDateDateType;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	
	public String getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(String bbsNo) {
		this.bbsNo = bbsNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPreContents() {
		return preContents;
	}
	public void setPreContents(String preContents) {
		this.preContents = preContents;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
