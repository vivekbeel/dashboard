package com.policybazaar.refund.refunddashboard.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.policybazaar.refund.refunddashboard.entity.RefundRequest;

@Component
public class RefundRequestQueryRepository {

	@Autowired
	EntityManager entityManager;

	@Transactional
	public List<RefundRequest> getOrdersUsingWhereClause(String query, String productName, String orderNo, long itemId,
			long leadId, long planId, String proposalNo, double minAmount, double maxAmount, String policyStatus,
			String policyId, String paymentMode, String fromDate, String toDate) throws ParseException {
		TypedQuery<RefundRequest> typedQuery = entityManager.createQuery(query, RefundRequest.class);
		if (StringUtils.isNotBlank(productName))
			typedQuery.setParameter("productName", productName);
		if (StringUtils.isNotBlank(orderNo))
			typedQuery.setParameter("orderNo", orderNo);
		if (itemId>0)
			typedQuery.setParameter("itemId", itemId);
		if (leadId>0)
			typedQuery.setParameter("leadId", leadId);
		if (StringUtils.isNotBlank(proposalNo))
			typedQuery.setParameter("proposalNo", proposalNo);
		if (planId>0)
			typedQuery.setParameter("planId", planId);
		if (minAmount>0)
			typedQuery.setParameter("minAmount", minAmount);
		if (maxAmount>0)
			typedQuery.setParameter("maxAmount", maxAmount);
		if (StringUtils.isNotBlank(policyStatus))
			typedQuery.setParameter("policyStatus", policyStatus);
		if (StringUtils.isNotBlank(policyId))
			typedQuery.setParameter("policyId", policyId);
		if (StringUtils.isNotBlank(paymentMode))
			typedQuery.setParameter("paymentMode", paymentMode);
		if (StringUtils.isNotBlank(fromDate)&&StringUtils.isNotBlank(toDate)) {
			typedQuery.setParameter("fromDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fromDate));
			typedQuery.setParameter("toDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(toDate));
		}
		
		List<RefundRequest> list = typedQuery.getResultList();
		entityManager.flush();
		return list;
	}

}
