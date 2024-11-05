package com.project.BlogApp.payload;

public class ApiResponse {
	String message;
	boolean sucess;

	public ApiResponse(String message, boolean b) {
		super();
		this.message = message;
		this.sucess = b;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isB() {
		return sucess;
	}

	public void setB(boolean b) {
		this.sucess = b;
	}

}
