package com.people10.exceptionhandler;

public class ExceptionResponse {

	public ExceptionResponse(String message, String statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

	private String message;
	
	private String statusCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
}
