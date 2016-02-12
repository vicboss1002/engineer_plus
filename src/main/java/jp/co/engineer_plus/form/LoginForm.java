package jp.co.engineer_plus.form;

import java.io.Serializable;

public class LoginForm implements Serializable, EqForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1762690224122362382L;
	private String userId;
	private String password;
	private Boolean login = false;
	public Boolean isLogin() {
		return login;
	}
	public void setLogin(Boolean login) {
		this.login = login == null? false: true;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
