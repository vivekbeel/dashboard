package com.policybazaar.refund.refunddashboard.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.policybazaar.refund.constant.Constant;
import com.policybazaar.refund.refunddashboard.component.InMemoryCache;

@Component
public class RefundStatusCodeImpl {

	public List<Integer> getStatusCode(String status) {
		List<Integer> list=new ArrayList<>();
		if (Constant.pending.equalsIgnoreCase(status)) {
			return InMemoryCache.masterRefundStatusProperties.containsKey(Constant.REFUND_PROCESSING)
					? InMemoryCache.masterRefundStatusProperties.get(Constant.REFUND_PROCESSING)
					: list;
		} else if (Constant.completed.equalsIgnoreCase(status)) {
			return InMemoryCache.masterRefundStatusProperties.containsKey(Constant.REFUND_COMPLATED)
					? InMemoryCache.masterRefundStatusProperties.get(Constant.REFUND_COMPLATED)
					: list;
		} else if (Constant.canceled.equalsIgnoreCase(status)) {
			return InMemoryCache.masterRefundStatusProperties.containsKey(Constant.REFUND_CANCELLED)
					? InMemoryCache.masterRefundStatusProperties.get(Constant.REFUND_CANCELLED)
					: list;
		}else if (Constant.refundRequested.equalsIgnoreCase(status)) {
			return InMemoryCache.masterRefundStatusProperties.containsKey(Constant.REFUND_REQUESTED)
					? InMemoryCache.masterRefundStatusProperties.get(Constant.REFUND_REQUESTED)
					: list;
		}
		System.out.println(list);
		return list;
	}

}
