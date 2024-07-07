package com.web.run.model;

public class Data {
	public String exp;
	public String token;

	public Data() {

	}

	public Data(String exp, String token) {
		super();
		this.exp = exp;
		this.token = token;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
