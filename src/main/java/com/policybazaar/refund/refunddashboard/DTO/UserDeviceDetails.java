package com.policybazaar.refund.refunddashboard.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDeviceDetails {

	private String userAgent;
	private String platform;
	private String browserName;
	private String browserVersion;
	private String 	osName;
	private String osVersion;
	private String clientIpAddress;
	private String agentId;
}
