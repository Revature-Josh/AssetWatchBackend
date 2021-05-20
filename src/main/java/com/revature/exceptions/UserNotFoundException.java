package com.revature.exceptions;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super();
	
	}

	public UserNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UserNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public UserNotFoundException(String arg0) {
		super(arg0);
		
	}

	public UserNotFoundException(Throwable arg0) {
		super(arg0);
		
	}

}
