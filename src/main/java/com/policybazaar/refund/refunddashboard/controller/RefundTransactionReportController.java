package com.policybazaar.refund.refunddashboard.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.policybazaar.refund.refunddashboard.entity.RefundTransactionReport;
import com.policybazaar.refund.refunddashboard.request.RefundTransactionReportRequest;
import com.policybazaar.refund.refunddashboard.request.RequestHeaderDetailsDto;
import com.policybazaar.refund.refunddashboard.service.RefundTransactionReportService;

@RequestMapping("/dashboard")
public class RefundTransactionReportController {

	@Autowired
	RefundTransactionReportService refundTransactionReportService;
	
	@Autowired
	RequestHeaderDetailsDto requestHeaderDetailsDto;

	@PostMapping("/paymentDetails")
	public RefundTransactionReport getRefundTransactionReport(
			@RequestBody RefundTransactionReportRequest refundTransactionReportRequest,
			@RequestHeader(name="access_token",required = true) String access_token) {
		requestHeaderDetailsDto.setAccessToken(access_token);
		return refundTransactionReportService.getRefundTransactionReport(refundTransactionReportRequest);
	}

	@GetMapping("/getAllStatus")
	public Map<String, Object> getAllStatsApi(@RequestHeader(name="access_token",required = true) String access_token) {
		requestHeaderDetailsDto.setAccessToken(access_token);
		return refundTransactionReportService.getAllStatsApi();
	}

		
}
