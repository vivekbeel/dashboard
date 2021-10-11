package com.policybazaar.refund.constant;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class SearchQuery {

	public String searchQuery(String productName, String orderNo, long itemId, long leadId, long planId,
			String proposalNo, double minAmount, double maxAmount, String policyStatus, String policyId,
			String paymentMode, String fromDate, String toDate) {
		String query = "select r from RefundRequest r ";
		if (StringUtils.isBlank(productName)) {
			return query;
		}
		else {
			query += "where r.productName=:productName ";
		}
		if (StringUtils.isNotBlank(orderNo)) {
			query += "and r.orderNo=:orderNo ";
		}
		if (itemId > 0) {
			query += "and r.itemId=:itemId ";
		}
		if (leadId > 0) {
			query += "and r.leadId=:leadId and ";
		}
		if (StringUtils.isNotBlank(proposalNo)) {
			query += "r.proposalNo=:proposalNo ";
		}
		if (planId > 0) {
			query += "and r.planId=:planId and ";
		}
		if (minAmount > 0 && maxAmount == 0) {
			query += "and r.transactionAmount<=:minAmount ";
		}
		if (maxAmount > 0 && minAmount == 0) {
			query += "and r.transactionAmount>=:maxAmount ";
		}
		if (maxAmount > 0 && minAmount > 0) {
			query += "and r.transactionAmount BETWEEN :minAmount AND :maxAmount ";
		}

		if (StringUtils.isNotBlank(policyStatus)) {
			query += "and r.policyStatus=:policyStatus ";
		}
		if (StringUtils.isNotBlank(policyId)) {
			query += "and r.policyId=:policyId ";
		}
		if (StringUtils.isNotBlank(paymentMode)) {
			query += "and r.paymentMode=:paymentMode ";
		}
		if (fromDate != null && toDate != null) {
			query += "and r.createdOn BETWEEN :fromDate AND :toDate ";
		}

		return query;
	}

}
