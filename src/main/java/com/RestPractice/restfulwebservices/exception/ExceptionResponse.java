package com.RestPractice.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse   {

	private String details;
	private String message;
	private Date timeStamp;

	public ExceptionResponse(String details, String message, Date timeStamp) {
		super();
		this.details = details;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public String getDetails() {
		return details;
	}

	public String getMessage() {
		return message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

}
