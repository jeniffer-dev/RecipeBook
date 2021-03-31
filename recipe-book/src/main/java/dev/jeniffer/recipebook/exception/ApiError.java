package dev.jeniffer.recipebook.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ApiError {
	
	private HttpStatus status;
	private Date date;
	private String message;	
	private String debugMessage;
	
	
	public ApiError(HttpStatus status, Date date, String message, String debugMessage) {
		super();
		this.status = status;
		this.date = date;
		this.message = message;
		this.debugMessage = debugMessage;
	}
	
	public HttpStatus getStatus() {
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
	public void setStatus(HttpStatus status) {
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
