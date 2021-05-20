package com.revature.exceptions;

public class UserCantLogInExpection extends Exception {

	public UserCantLogInExpection() {
		super();
		
	}

	public UserCantLogInExpection(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UserCantLogInExpection(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UserCantLogInExpection(String message) {
		super(message);
		
	}

	public UserCantLogInExpection(Throwable cause) {
		super(cause);
		
	}

}
