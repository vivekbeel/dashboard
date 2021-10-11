package com.policybazaar.refund.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/**
 * 
 * @author dharmendra
 *
 * @param <T>
 */
public class BrokenResponse<T> extends ResponseEntity<String> {

    private String message;
    Throwable throwable;
    Class<T> expectedResponseType;

    public BrokenResponse(String message, Throwable throwable){
        super(throwable.getMessage(), HttpStatus.EXPECTATION_FAILED);
        this.message = message;
        this.throwable = throwable;
    }

    public BrokenResponse(String message, Throwable throwable, Class<T> expectedResponseType){
        this(message, throwable);
        this.expectedResponseType = expectedResponseType;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public Class<T> getExpectedResponseType() {
        return expectedResponseType;
    }
}

