package com.web.run.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class HotelBookingRS {
	private String success;
	private String message;
	private String bookingId;
	private Object data;

	public HotelBookingRS() {

	}

	public HotelBookingRS(String success, String message, String bookingId, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.bookingId = bookingId;
		this.data = data;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
