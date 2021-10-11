package com.policybazaar.refund.refunddashboard.request;

import lombok.Data;

@Data
public class RefundTransactionReportRequest {

	private String orderNo;
	private String itemNo;
}
