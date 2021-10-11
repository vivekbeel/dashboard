package com.policybazaar.refund.refunddashboard.DTO;

import lombok.Data;

@Data
public class PaymentDetails {

	private String pbGatewayName;
	private String bankTxId;
	private String paymentMode;
	private double holdPayment;
	private String bankName;
	private String isNoCostEMI;
	private String paymentSource;
	private String capturedReleasedBy;
	private String nodalName;
	private double transactionAmount;
	private String Currency;
	private String PbTxnId;
	private String PaymentDate;
	private String PGClientId;
	private double SubventionAmount;
	private String CapturedReleasedAt;
}
