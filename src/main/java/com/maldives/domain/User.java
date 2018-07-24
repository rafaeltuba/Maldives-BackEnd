package com.maldives.domain;

public class User {
	
	public static final Integer USERTYPE_CANDIDATE = 1;
	public static final Integer USERTYPE_COMPANY = 2;

	private Integer userId;
	private String emailId;
	private String password;
	private Integer userType;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
}
