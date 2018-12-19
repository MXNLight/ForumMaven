package com.pojo;

public class User {
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPsd() {
		return loginPsd;
	}
	public void setLoginPsd(String loginPsd) {
		this.loginPsd = loginPsd;
	}
	//注意，在使用EI表达式的情况下，类中的属性，前两个字母不能大写。
	private String loginId;
	private String loginPsd;
}
