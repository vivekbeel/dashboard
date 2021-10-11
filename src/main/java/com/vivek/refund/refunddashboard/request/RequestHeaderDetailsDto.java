package com.policybazaar.refund.refunddashboard.request;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class RequestHeaderDetailsDto implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private String accessToken;
	private String browser;
	private String browserVersion;
	private String os;
	private String ipAddress;

}
