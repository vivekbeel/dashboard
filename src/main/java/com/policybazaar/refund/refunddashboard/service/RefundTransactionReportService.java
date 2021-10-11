package com.policybazaar.refund.refunddashboard.service;

import java.util.Map;

import com.policybazaar.refund.refunddashboard.entity.RefundTransactionReport;
import com.policybazaar.refund.refunddashboard.request.RefundTransactionReportRequest;

public interface RefundTransactionReportService {

	public RefundTransactionReport getRefundTransactionReport(
			RefundTransactionReportRequest refundTransactionReportRequest);

	public Map<String, Object> getAllStatsApi();
}
