package dev.jeniffer.recipebook.exception;

import java.util.Date;

public class ApiError {
	
	private int status;
	private Date date;
	private String message;	
	private String debugMessage;
	
	
	public ApiError(int status, Date date, String message, String debugMessage) {
		super();
		this.status = status;
		this.date = date;
		this.message = message;
		this.debugMessage = debugMessage;
	}
	
	public int getStatus() {
		return status;
	}
	public Date getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}
	public String getDebugMessage() {
		return debugMessage;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	
}
