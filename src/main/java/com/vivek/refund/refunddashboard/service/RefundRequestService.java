package com.policybazaar.refund.refunddashboard.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.policybazaar.refund.refunddashboard.entity.RefundRequest;

public interface RefundRequestService {

	public List<RefundRequest> getStatusWiseRefundRequestList(String refundStatus);

	public Map<String, Object> getStatusWiseRefundRequestCountAndTxAmount();

	public List<RefundRequest> getRefundRequestSearchDetails(String productName, String orderNo, long itemId,
			long leadId, long planId, String proposalNo, double minAmount, double maxAmount, String policyStatus,
			String policyId, String paymentMode, String fromDate, String toDate) throws ParseException;
}
