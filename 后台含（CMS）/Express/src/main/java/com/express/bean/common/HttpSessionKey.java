package com.express.bean.common;

public enum HttpSessionKey {
	/**
	 * 管理员登陆
	 */
	ADMIN_SESSION("admin_login_user");
	private String code;
	private HttpSessionKey(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
