package com.web.run.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RegistrationRS {
	private boolean success;
	private String message;
	private String userId;
	private Object data;

	public RegistrationRS(boolean success, String message, String userId, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.userId = userId;
		this.data = data;
	}

	public RegistrationRS() {
		
	}

	public RegistrationRS(boolean success, String message, String userId) {
		super();
		this.success = success;
		this.message = message;
		this.userId = userId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
