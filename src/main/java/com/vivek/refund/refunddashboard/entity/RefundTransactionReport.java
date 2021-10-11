package com.policybazaar.refund.refunddashboard.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.policybazaar.refund.refunddashboard.DTO.PaymentAttempts;
import com.policybazaar.refund.refunddashboard.DTO.PaymentDetails;
import com.policybazaar.refund.refunddashboard.DTO.ProductDetails;
import com.policybazaar.refund.refunddashboard.DTO.RecurringDetails;
import com.policybazaar.refund.refunddashboard.DTO.RefundDetails;
import com.policybazaar.refund.refunddashboard.DTO.SettledDetails;
import com.policybazaar.refund.refunddashboard.DTO.SplitDetails;
import com.policybazaar.refund.refunddashboard.DTO.TransactionDetail;
import com.policybazaar.refund.refunddashboard.DTO.UserDetails;
import com.policybazaar.refund.refunddashboard.DTO.UserDeviceDetails;

import lombok.Data;

@Data
//@Entity
//@Builder
public class RefundTransactionReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	TransactionDetail transactionDetail;
	PaymentDetails paymentDetails;
	PaymentAttempts paymentAttempts;
	RecurringDetails recurringDetails;
	SettledDetails settledDetails;
	UserDetails userDetails;
	ProductDetails productDetails;
	SplitDetails splitDetails;
	UserDeviceDetails userDeviceDetails;
	RefundDetails refundDetails;
}	
