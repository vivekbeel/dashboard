package com.policybazaar.refund.refunddashboard.exception;

public class InvailedDataException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public InvailedDataException(){
		super();
	}
	
	public InvailedDataException(String message){
		super(message);
	}
}
