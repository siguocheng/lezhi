package com.lezhi.exception;

/**
 * 校验错误异常
 * 
 *
 */
public class CheckException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CheckException() {
	}

	public CheckException(String message) {
		this.message=message;
	}

	public CheckException(Throwable cause) {
		super(cause);
	}

	public CheckException(String message, Throwable cause) {
		super(message, cause);
	}

	public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	
}
