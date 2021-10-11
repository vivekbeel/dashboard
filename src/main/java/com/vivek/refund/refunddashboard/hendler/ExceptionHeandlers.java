package com.policybazaar.refund.refunddashboard.hendler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.policybazaar.refund.refunddashboard.exception.InvailedDataException;
import com.policybazaar.refund.refunddashboard.exception.InvailedTokenException;
import com.policybazaar.refund.refunddashboard.model.ErrorType;


@ControllerAdvice
@RestController
public class ExceptionHeandlers extends ResponseEntityExceptionHandler{

	@ExceptionHandler(InvailedTokenException.class)//InvalidPropertyException
	public ResponseEntity<ErrorType> hendleInvailedTokenException(InvailedTokenException ex){
		return new ResponseEntity<ErrorType>(new ErrorType(ex.getMessage(),"invailed access_token",
				"invailed access_token for given access_token","RefundEligibility"),HttpStatus.GATEWAY_TIMEOUT);
	}
	
	@ExceptionHandler(InvailedDataException.class)//InvailedDataException
	public ResponseEntity<ErrorType> hendleInvailedDataException(InvailedDataException ex){
		return new ResponseEntity<ErrorType>(new ErrorType(ex.getMessage(),"invailed Data Formate",
				"invailed data for given url","InvailedData"),HttpStatus.NOT_ACCEPTABLE);
	}
	
}
