package com.policybazaar.refund.refunddashboard.DTO;

import lombok.Data;

@Data
public class PaymentAttempts {

	private String payId;
	private String pgGatewayName;
	private double txnAmount;
	private String responseMessage;
	private String bankName;
	private String cardType;
	private String pbGatewayName;
	private String mid;
	private String pgTxId;
	private String txnDate;
	private String paymentMode;
	private String status;
}
