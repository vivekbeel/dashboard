package com.policybazaar.refund.refunddashboard.DTO;

import lombok.Data;

@Data
public class TransactionDetail {

	private String orderNo;
	private String proposalNo;
	private long itemId;
	private long enquiryId;
	private long leadId;
	private String merchantId;
	private String gatewayName;
	private int payFrequency;
	private String responseMessage;
	private String callbackSuccessUrl;
	private String isUserVerified;
	private String inputJson;
	private String userAgent;
	private String udf2;
	private String clientIp;
	private String transactionStatus;
	private String transactionDate;
	private String transactionType;
	private String pgTxId;
	private String responseCode;
	private String description;
	private String typeOfPayment;
	private String callbackFailureUrl;
	private String userVerifiedBy;
	private String Channel;
	private String udf1;
	private String udf3;
}
