package com.policybazaar.refund.refunddashboard.exception;

public class InvailedTokenException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvailedTokenException(){
		super();
	}
	
	public InvailedTokenException(String message){
		super(message);
	}
	
}
