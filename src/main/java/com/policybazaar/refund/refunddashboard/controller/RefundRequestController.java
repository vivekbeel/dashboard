package com.policybazaar.refund.refunddashboard.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.policybazaar.refund.refunddashboard.entity.RefundRequest;
import com.policybazaar.refund.refunddashboard.exception.InvailedDataException;
import com.policybazaar.refund.refunddashboard.request.RequestHeaderDetailsDto;
import com.policybazaar.refund.refunddashboard.service.RefundRequestService;

@RestController
@RequestMapping("/api/v1/refund-dashboard")
public class RefundRequestController {

	@Autowired
	RefundRequestService refundRequestService;

	@Autowired
	RequestHeaderDetailsDto requestHeaderDetailsDto;

	@GetMapping("/dummy")
	public String getDummy() {
		System.out.println("dummy data");
		return "dummy data";
	}

	@GetMapping("/getStatusRefundRequestList")
	public List<RefundRequest> getStatusWiseRefundRequestList(HttpServletRequest httpServletRequest,
			@RequestParam String refundStatus) {
		String access_token = httpServletRequest.getHeader("access_token");
		requestHeaderDetailsDto.setAccessToken(access_token);
		List<RefundRequest> refundRequestList = new ArrayList<>();
		try {
			refundRequestList = refundRequestService.getStatusWiseRefundRequestList(refundStatus);
		} catch (Exception e) {
			refundRequestList = extractedException_1(e);
		}
		return refundRequestList;
	}

	@GetMapping("/getRefundRequestCountDetails")
	public Map<String, Object> getStatusWiseRefundRequestCountAndTxAmount(HttpServletRequest httpServletRequest) {
		String access_token = httpServletRequest.getHeader("access_token");
		requestHeaderDetailsDto.setAccessToken(access_token);
		Map<String, Object> statusWiseRefundRequestCount = new LinkedHashMap<>();
		try {
			statusWiseRefundRequestCount = refundRequestService.getStatusWiseRefundRequestCountAndTxAmount();
		} catch (Exception e) {
			statusWiseRefundRequestCount = extractedException(statusWiseRefundRequestCount, e);

		}

		return statusWiseRefundRequestCount;
	}

	@GetMapping("/searchRefundRequest")
	public List<RefundRequest> getRefundRequestSearchDetails(HttpServletRequest httpServletRequest,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "orderNo", required = false) String orderNo,
			@RequestParam(value = "itemId", required = false) String itemId,
			@RequestParam(value = "leadId", required = false) String leadId,
			@RequestParam(value = "planId", required = false) String planId,
			@RequestParam(value = "proposalNo", required = false) String proposalNo,
			@RequestParam(value = "minAmount", required = false) String minAmount,
			@RequestParam(value = "maxAmount", required = false) String maxAmount,
			@RequestParam(value = "policyStatus", required = false) String policyStatus,
			@RequestParam(value = "policyId", required = false) String policyId,
			@RequestParam(value = "paymentMode", required = false) String paymentMode,
			@RequestParam(value = "fromDate", required = false) String fromDate,
			@RequestParam(value = "toDate", required = false) String toDate) throws ParseException {
		String access_token = httpServletRequest.getHeader("access_token");
		requestHeaderDetailsDto.setAccessToken(access_token);

		List<RefundRequest> searchRefundRequestList = new ArrayList<>();
		try {
			searchRefundRequestList = refundRequestService.getRefundRequestSearchDetails(productName, orderNo,
					Long.parseLong(validData(itemId, "itemId")), Long.parseLong(validData(leadId, "leadId")),
					Long.parseLong(validData(planId, "planId")), proposalNo,
					Double.parseDouble(validData(minAmount, "minAmount")),
					Double.parseDouble(validData(maxAmount, "maxAmount")), policyStatus, policyId, paymentMode,
					fromDate, toDate);
		} catch (Exception e) {
			searchRefundRequestList = extractedException_1(e);
		}

		return searchRefundRequestList;
	}

	private String validData(String data, String dataName) {
		if (StringUtils.isNumeric(data))
			return data;
		else if (data == null)
			return "0";
		else
			throw new InvailedDataException(dataName+" Is Not Right Formate " + data);
	}

	private Map<String, Object> extractedException(Map<String, Object> statusWiseRefundRequestCount, Exception e) {
		statusWiseRefundRequestCount.put("errorMsg", e.getMessage());
		statusWiseRefundRequestCount.put("exceptionFlag", true);
		return statusWiseRefundRequestCount;
	}

	private List<RefundRequest> extractedException_1(Exception e) {
		List<RefundRequest> tobeRetunredList = new ArrayList<>();
		RefundRequest returnEntity = new RefundRequest();
		returnEntity.setErrorMsg(e.getMessage());
		returnEntity.setExceptionFlag(true);
		tobeRetunredList.add(returnEntity);
		return tobeRetunredList;
	}
}
