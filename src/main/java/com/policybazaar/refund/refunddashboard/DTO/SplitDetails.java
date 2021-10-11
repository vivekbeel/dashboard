package com.policybazaar.refund.refunddashboard.DTO;

import lombok.Data;

@Data
public class SplitDetails {

	private String settlementProcessId;
	private String txPaymentId;
	private String UTR_NO;
	private String settledDate;
	private String insurerMerchantId;
	private String txSubPaymentId;
	private String txMessage;
	private String settledAmount;
}
