package com.policybazaar.refund.refunddashboard.DTO;

import lombok.Data;

@Data
public class RefundRequestCountAndTxAmountDTO {

	private int totalCount;
	private double totalTxAmount;
	private double complateTxAmount;
	private int complateTxCount;
	private double cancelTxAmount;
	private int cancelTxCount;
	private double pendingTxAmount;
	private int pendingTxCount;
}
