package com.policybazaar.refund.refunddashboard.DTO;

import lombok.Data;

@Data
public class SettledDetails {

	private double SettledAmount;
	private String settledDate;
	private String UTR_NO;
	private String status;
	private String PaymentRef_no;
	private String settled_to;
	private String processing_date;
}
