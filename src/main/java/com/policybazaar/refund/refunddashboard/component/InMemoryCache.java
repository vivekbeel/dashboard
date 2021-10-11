package com.policybazaar.refund.refunddashboard.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.policybazaar.refund.constant.Constant;
import com.policybazaar.refund.refunddashboard.entity.MasterRefundStatus;
import com.policybazaar.refund.refunddashboard.model.RefundProperties;
import com.policybazaar.refund.refunddashboard.repository.MasterRefundStatusRepsitory;
import com.policybazaar.refund.refunddashboard.repository.RefundPropertiesRepository;

@Component
public class InMemoryCache {
	
	@Autowired
	RefundPropertiesRepository refundPropertiesRepository;
	
	@Autowired
	MasterRefundStatusRepsitory masterRefundStatusRepsitory;
	
	private static Logger logger = Logger.getLogger(InMemoryCache.class.getName());
	public static Map<String, String> properties = new HashMap<>();
	public static Map<String, List<Integer>> masterRefundStatusProperties = new HashMap<>();
	private void getRefundProperties() {

		System.out.println("Properties Load !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!= start");

		List<RefundProperties> refundPropertiesList = refundPropertiesRepository.findAll();

		if (!CollectionUtils.isEmpty(refundPropertiesList)) {

			refundPropertiesList.forEach(x -> {
				System.out.println("Key = " + x.getKeys() + "  , value=" + x.getValues());
				properties.put(x.getKeys(), x.getValues());
			});
		}

		logger.info("Properties Load !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!= start");

	}
	
	
	public void getAllMasterRefundStatus() {
		List<MasterRefundStatus> masterRefundStatusLists = masterRefundStatusRepsitory.findAll();

		if (!CollectionUtils.isEmpty(masterRefundStatusLists)) {
			List<Integer> cancelStatusCode=new ArrayList<>();
			List<Integer> complatedStatusCode=new ArrayList<>();
			List<Integer> pendingStatusCode=new ArrayList<>();
			List<Integer> requestStatusCode=new ArrayList<>();
			masterRefundStatusLists.forEach(x -> {
				
				if(Constant.REFUND_PROCESSING.equalsIgnoreCase(x.getStatus())) {
					pendingStatusCode.add(x.getId());
				}
				if(Constant.REFUND_COMPLATED.equalsIgnoreCase(x.getStatus())||
						Constant.REFUND_SUCCESS.equalsIgnoreCase(x.getStatus())) {
					complatedStatusCode.add(x.getId());
				}
				if(Constant.REFUND_CANCELLED.equalsIgnoreCase(x.getStatus())) {
					cancelStatusCode.add(x.getId());
				}
				if(Constant.REFUND_REQUESTED.equalsIgnoreCase(x.getStatus())) {
					requestStatusCode.add(x.getId());
				}
			});
			masterRefundStatusProperties.put(Constant.REFUND_CANCELLED, cancelStatusCode);
			masterRefundStatusProperties.put(Constant.REFUND_COMPLATED, complatedStatusCode);
			masterRefundStatusProperties.put(Constant.REFUND_PROCESSING, pendingStatusCode);
			masterRefundStatusProperties.put(Constant.REFUND_REQUESTED, requestStatusCode);
		}
	}
	
	@PostConstruct
	public void init() {
		logger.info("InMemoryCache.init() ####################################################= start");

		getRefundProperties();
		
		getAllMasterRefundStatus();
		
		scheduledExecutor();

		logger.info("InMemoryCache.init() ####################################################= end");
	}

	@Scheduled(fixedRate = 86400 * 1000, initialDelay = 86400 * 1000)
	public void scheduledExecutor() {
		getRefundProperties();
	}
	

}
