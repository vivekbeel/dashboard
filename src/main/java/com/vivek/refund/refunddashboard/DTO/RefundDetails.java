package com.policybazaar.refund.refunddashboard.DTO;

import lombok.Data;

@Data
public class RefundDetails {
	private String eligibleForRefund;
	private double refundRequestedAmount;
	private double refundedAmount;
	private double cancellationFee;
}
