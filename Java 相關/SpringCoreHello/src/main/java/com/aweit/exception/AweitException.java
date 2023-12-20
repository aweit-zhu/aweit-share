package com.aweit.exception;

public class AweitException extends Exception{

	public AweitException() {
		super();
	}

	public AweitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AweitException(String message, Throwable cause) {
		super(message, cause);
	}

	public AweitException(String message) {
		super(message);
	}

	public AweitException(Throwable cause) {
		super(cause);
	}

}
