package com.policybazaar.refund.refunddashboard.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class TokenValidationResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ok;
	
	
	public TokenValidationResponse(int ok) {
		super();
		this.ok = ok;
	}
	public TokenValidationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOk() {
		return ok;
	}
	public void setOk(int ok) {
		this.ok = ok;
	}
	
	
}
