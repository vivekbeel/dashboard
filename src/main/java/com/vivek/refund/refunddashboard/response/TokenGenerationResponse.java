package com.policybazaar.refund.refunddashboard.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class TokenGenerationResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String access_token;
	private String scope;
	private String isValid;
	private String token_type;
	private String ok;
	private String expires_in;
}
