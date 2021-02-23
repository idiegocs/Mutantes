package com.mpc.exception;

public class MutantFunctionalException  extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 214561585936392387L;

	public MutantFunctionalException() {
		
	}

	public MutantFunctionalException(String message) {
		super(message);
		
	}

	public MutantFunctionalException(Throwable cause) {
		super(cause);
		
	}

	public MutantFunctionalException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public MutantFunctionalException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}
}
