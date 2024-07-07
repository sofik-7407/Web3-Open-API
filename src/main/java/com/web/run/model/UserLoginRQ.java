package com.web.run.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonPropertyOrder({"email","password"})
@JsonInclude(Include.NON_NULL)
public class UserLoginRQ {

	@Schema(description = "valid user email address",example = "example@gmail.com")
	public String email;
	@Schema(description = "valid user password",example = "2kjg")
	public String password;
	public UserLoginRQ(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
