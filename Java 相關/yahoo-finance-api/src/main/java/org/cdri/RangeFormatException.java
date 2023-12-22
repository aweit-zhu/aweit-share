package org.cdri;

public class RangeFormatException extends Exception{

	public RangeFormatException() {
		super();
	}

	public RangeFormatException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RangeFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public RangeFormatException(String message) {
		super(message);
	}

	public RangeFormatException(Throwable cause) {
		super(cause);
	}

}
