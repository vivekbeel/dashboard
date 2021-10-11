package com.policybazaar.refund.refunddashboard.serviceimpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.policybazaar.refund.constant.Constant;
import com.policybazaar.refund.constant.SearchQuery;
import com.policybazaar.refund.refunddashboard.entity.RefundRequest;
import com.policybazaar.refund.refunddashboard.impl.RefundStatusCodeImpl;
import com.policybazaar.refund.refunddashboard.repository.RefundRequestQueryRepository;
import com.policybazaar.refund.refunddashboard.repository.RefundRequestRepository;
import com.policybazaar.refund.refunddashboard.service.RefundRequestService;

@Service
public class RefundRequestServiceImpl implements RefundRequestService {

	@Autowired
	RefundRequestRepository refundRequestRepository;

	@Autowired
	RefundRequestQueryRepository refundRequestQueryRepository;

	@Autowired
	RefundStatusCodeImpl refundStatusCodeImpl;

	@Autowired
	SearchQuery searchQuery;

	private List<RefundRequest> getComlatedRefundRequestList() {
		List<RefundRequest> refundRequests = refundRequestRepository
				.getStatusWiseRefundRequestList(refundStatusCodeImpl.getStatusCode(Constant.completed));
		for (RefundRequest refundRequest : refundRequests) {
			refundRequest.setOrderNoitemId(refundRequest.getOrderNo() + " (" + refundRequest.getItemId() + ")");
		}
		return refundRequests;
	}

	private List<RefundRequest> getCancelRefundRequestList() {
		List<RefundRequest> refundRequests = refundRequestRepository
				.getStatusWiseRefundRequestList(refundStatusCodeImpl.getStatusCode(Constant.canceled));
		for (RefundRequest refundRequest : refundRequests) {
			refundRequest.setOrderNoitemId(refundRequest.getOrderNo() + " (" + refundRequest.getItemId() + ")");
		}
		return refundRequests;
	}

	private List<RefundRequest> getPendingRefundRequestList() {
		List<RefundRequest> refundRequests = refundRequestRepository
				.getStatusWiseRefundRequestList(refundStatusCodeImpl.getStatusCode(Constant.pending));
		for (RefundRequest refundRequest : refundRequests) {
			refundRequest.setOrderNoitemId(refundRequest.getOrderNo() + " (" + refundRequest.getItemId() + ")");
		}
		return refundRequests;
	}

	private List<RefundRequest> getNewRefundRequestList() {
		List<RefundRequest> refundRequests = refundRequestRepository
				.getStatusWiseRefundRequestList(refundStatusCodeImpl.getStatusCode(Constant.refundRequested));
		for (RefundRequest refundRequest : refundRequests) {
			refundRequest.setOrderNoitemId(refundRequest.getOrderNo() + " (" + refundRequest.getItemId() + ")");
		}
		return refundRequests;
	}

	private Map<String, Object> getAllRefundRequest() {
		Map<String, Object> refundRequestCountAndAmount = new LinkedHashMap<>();
		List<RefundRequest> refundRequests = refundRequestRepository.getSortAllRefundRequestList();

		double amount = 0;
		if (!CollectionUtils.isEmpty(refundRequests)) {
			for (RefundRequest refundRequest : refundRequests) {
				amount += refundRequest.getTransactionAmount();
			}

			refundRequestCountAndAmount.put("requestCount", refundRequests.size());
			refundRequestCountAndAmount.put("amount", amount);
			refundRequestCountAndAmount.put("lastUpdatedOn",
					refundRequests.get(refundRequests.size() - 1).getModifiedOn() == null
							? refundRequests.get(refundRequests.size() - 1).getCreatedOn()
							: refundRequests.get(refundRequests.size() - 1).getModifiedOn());
		}
		return refundRequestCountAndAmount;
	}
	
	private Map<String, Object> getNewRefundRequest() {
		Map<String, Object> refundRequestCountAndAmount = new LinkedHashMap<>();
		List<RefundRequest> refundRequests = refundRequestRepository
				.getStatusWiseRefundRequestList(refundStatusCodeImpl.getStatusCode(Constant.refundRequested));

		double amount = 0;
		if (!CollectionUtils.isEmpty(refundRequests)) {
			for (RefundRequest refundRequest : refundRequests) {
				amount += refundRequest.getTransactionAmount();
			}

			refundRequestCountAndAmount.put("requestCount", refundRequests.size());
			refundRequestCountAndAmount.put("amount", amount);
			refundRequestCountAndAmount.put("lastUpdatedOn",
					refundRequests.get(refundRequests.size() - 1).getModifiedOn() == null
							? refundRequests.get(refundRequests.size() - 1).getCreatedOn()
							: refundRequests.get(refundRequests.size() - 1).getModifiedOn());
		}
		return refundRequestCountAndAmount;
	}

	private Map<String, Object> getComlatedRefundRequest() {
		Map<String, Object> refundRequestCountAndAmount = new LinkedHashMap<>();
		List<RefundRequest> refundRequests = refundRequestRepository
				.getSortedStatusWiseRefundRequestList(refundStatusCodeImpl.getStatusCode(Constant.completed));

		double amount = 0;
		if (!CollectionUtils.isEmpty(refundRequests)) {
			for (RefundRequest refundRequest : refundRequests) {
				amount += refundRequest.getTransactionAmount();
			}

			refundRequestCountAndAmount.put("requestCount", refundRequests.size());
			refundRequestCountAndAmount.put("amount", amount);
			refundRequestCountAndAmount.put("lastUpdatedOn",
					refundRequests.get(refundRequests.size() - 1).getModifiedOn() == null
							? refundRequests.get(refundRequests.size() - 1).getCreatedOn()
							: refundRequests.get(refundRequests.size() - 1).getModifiedOn());
		}
		return refundRequestCountAndAmount;
	}

	private Map<String, Object> getCancelRefundRequest() {
		Map<String, Object> refundRequestCountAndAmount = new LinkedHashMap<>();
		List<RefundRequest> refundRequests = refundRequestRepository
				.getSortedStatusWiseRefundRequestList(refundStatusCodeImpl.getStatusCode(Constant.canceled));

		double amount = 0;
		if (!CollectionUtils.isEmpty(refundRequests)) {
			for (RefundRequest refundRequest : refundRequests) {
				amount += refundRequest.getTransactionAmount();
			}

			refundRequestCountAndAmount.put("requestCount", refundRequests.size());
			refundRequestCountAndAmount.put("amount", amount);
			refundRequestCountAndAmount.put("lastUpdatedOn",
					refundRequests.get(refundRequests.size() - 1).getModifiedOn() == null
							? refundRequests.get(refundRequests.size() - 1).getCreatedOn()
							: refundRequests.get(refundRequests.size() - 1).getModifiedOn());
		}
		return refundRequestCountAndAmount;
	}

	private Map<String, Object> getPendingRefundRequest() {
		Map<String, Object> refundRequestCountAndAmount = new LinkedHashMap<>();
		List<RefundRequest> refundRequests = refundRequestRepository
				.getSortedStatusWiseRefundRequestList(refundStatusCodeImpl.getStatusCode(Constant.pending));

		double amount = 0;
		if (!CollectionUtils.isEmpty(refundRequests)) {
			for (RefundRequest refundRequest : refundRequests) {
				amount += refundRequest.getTransactionAmount();
			}

			refundRequestCountAndAmount.put("requestCount", refundRequests.size());
			refundRequestCountAndAmount.put("amount", amount);
			refundRequestCountAndAmount.put("lastUpdatedOn",
					refundRequests.get(refundRequests.size() - 1).getModifiedOn() == null
							? refundRequests.get(refundRequests.size() - 1).getCreatedOn()
							: refundRequests.get(refundRequests.size() - 1).getModifiedOn());
		}
		return refundRequestCountAndAmount;
	}

	@Override
	public List<RefundRequest> getStatusWiseRefundRequestList(String refundStatus) {
		List<RefundRequest> refundRequests = null;
		if (Constant.completed.equalsIgnoreCase(refundStatus)) {
			return getComlatedRefundRequestList();
		} else if (Constant.canceled.equalsIgnoreCase(refundStatus)
				|| Constant.rejected.equalsIgnoreCase(refundStatus)) {
			return getCancelRefundRequestList();
		} else if (Constant.pending.equalsIgnoreCase(refundStatus)) {
			return getPendingRefundRequestList();
		} else if (Constant.newRequest.equalsIgnoreCase(refundStatus)
				|| Constant.refundRequested.equalsIgnoreCase(refundStatus)) {
			return getNewRefundRequestList();
		} else if (refundStatus == null || refundStatus.isBlank() || Constant.all.equalsIgnoreCase(refundStatus)) {
			refundRequests = refundRequestRepository.getAllRefundRequestList();
			for (RefundRequest refundRequest : refundRequests) {
				refundRequest.setOrderNoitemId(refundRequest.getOrderNo() + " (" + refundRequest.getItemId() + ")");
			}
			return refundRequests;
		}
		RefundRequest refundRequest = new RefundRequest();
		refundRequest.setRemarks("Incorrect status");
		List<RefundRequest> list = new ArrayList<>();
		list.add(refundRequest);
		return list;
	}

	@Override
	public Map<String, Object> getStatusWiseRefundRequestCountAndTxAmount() {

		Map<String, Object> refundRequestType = new HashMap<>();
		refundRequestType.put("totalRequestReceived", getAllRefundRequest());
		refundRequestType.put("pendingRequests", getPendingRefundRequest());
		refundRequestType.put("rejectedRequests", getCancelRefundRequest());
		refundRequestType.put("completedRequests", getComlatedRefundRequest());
		refundRequestType.put("newRequests", getNewRefundRequest());
		return refundRequestType;
	}

	@Override
	public List<RefundRequest> getRefundRequestSearchDetails(String productName, String orderNo, long itemId,
			long leadId, long planId, String proposalNo, double minAmount, double maxAmount, String policyStatus,
			String policyId, String paymentMode, String fromDate, String toDate) throws ParseException {
		String query = searchQuery.searchQuery(productName, orderNo, itemId, leadId, planId, proposalNo, minAmount,
				maxAmount, policyStatus, policyId, paymentMode, fromDate, toDate);
		return refundRequestQueryRepository.getOrdersUsingWhereClause(query, productName, orderNo, itemId, leadId,
				planId, proposalNo, minAmount, maxAmount, policyStatus, policyId, paymentMode, fromDate, toDate);
	}

}
