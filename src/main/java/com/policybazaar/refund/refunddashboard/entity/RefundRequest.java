package com.policybazaar.refund.refunddashboard.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//@Data
@Entity
@Table(name="refund_request")
public class RefundRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private String orderNo;
	private long itemId;
	private long leadId;
	private String proposalNo;
	private long productId;
	private int statusCode;
	private long insurerId;
	private String insurerName;
	private String entrySource;
	private long entrySourceId;
	private long planId;
	@Column(name="txStatus")
	private int txStatus;
	@Column(name="refundRetaintionSchedulingStatus")
	private int refundRetaintionSchedulingStatus;
	@Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
	private Date createdOn;
	@Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
	private Date modifiedOn;
	private String createdBy;
	private String lastModifiedBy;
	private String platform;
	private String browser;
	private String browserVersion;
	private String os;
	private String ipAddress;
	@Transient
	private boolean isEligible;
	@Transient
	private boolean intermediateEligibilityFlag;
	@Transient
	private String orderNoitemId;
	private String remarks;
	private String otp;
	private Date otpDate;
	private double transactionAmount;
	private String transactionDate;
	private String policyStatus;
	private Integer policyStatusId;
	private String policyId;
	private String pgRefundRequestId;
	private String productName;	
	private String paymentMode;
	@Transient
	private String errorMsg;	
	@Transient
	private boolean exceptionFlag;
	
	
	public RefundRequest(RefundRequest refundEligibility) {
		if(refundEligibility != null) {
			RefundRequest returnEntity = new RefundRequest();
			returnEntity.setOrderNo(refundEligibility.getOrderNo());
			returnEntity.setItemId(refundEligibility.getItemId());
			returnEntity.setLeadId(returnEntity.getLeadId());
			returnEntity.setProposalNo(refundEligibility.getProposalNo());
			returnEntity.setPlanId(refundEligibility.getPlanId());
			returnEntity.setPolicyStatus(refundEligibility.getPolicyStatus());
			returnEntity.setPolicyId(refundEligibility.getPolicyId());
			returnEntity.setEntrySource(refundEligibility.getEntrySource());
			returnEntity.setEntrySourceId(refundEligibility.getEntrySourceId());
			returnEntity.setInsurerId(refundEligibility.getInsurerId());
			returnEntity.setInsurerName(refundEligibility.getInsurerName());
			returnEntity.setEntrySource(refundEligibility.getEntrySource());
			returnEntity.setEntrySourceId(refundEligibility.getEntrySourceId());
			returnEntity.setPlanId(refundEligibility.getPlanId());
			returnEntity.setTxStatus(refundEligibility.getTxStatus());
			returnEntity.setCreatedBy(refundEligibility.getEntrySource());
			returnEntity.setLastModifiedBy(refundEligibility.getEntrySource());
			returnEntity.setBrowser(refundEligibility.getBrowser());
			returnEntity.setBrowserVersion(refundEligibility.getBrowserVersion());
			returnEntity.setOs(refundEligibility.getOs());
			returnEntity.setIpAddress(refundEligibility.getIpAddress());
			returnEntity.setTransactionAmount(refundEligibility.getTransactionAmount());
			returnEntity.setTransactionDate(refundEligibility.getTransactionDate());
			returnEntity.setPolicyId(refundEligibility.getPolicyId());
			returnEntity.setPolicyStatus(refundEligibility.getPolicyStatus());
		}
	}
	
	
	public RefundRequest(int statusCode, String remarks) {
		super();
		this.statusCode = statusCode;
		this.remarks = remarks;
	}



	public RefundRequest(String orderNo, long itemId, long leadId, String proposalNo, long productId,
			int statusCode, long insurerId, String insurerName, String entrySource, long entrySourceId, long planId,
			int txStatus, int refundRetaintionSchedulingStatus, Date createdOn, Date modifiedOn, String createdBy,
			String lastModifiedBy, String platform, String browser, String browserVersion, String os,
			String ipAddress) {
		super();
		this.orderNo = orderNo;
		this.itemId = itemId;
		this.leadId = leadId;
		this.proposalNo = proposalNo;
		this.productId = productId;
		this.statusCode = statusCode;
		this.insurerId = insurerId;
		this.insurerName = insurerName;
		this.entrySource = entrySource;
		this.entrySourceId = entrySourceId;
		this.planId = planId;
		this.txStatus = txStatus;
		this.refundRetaintionSchedulingStatus = refundRetaintionSchedulingStatus;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.platform = platform;
		this.browser = browser;
		this.browserVersion = browserVersion;
		this.os = os;
		this.ipAddress = ipAddress;
	}
	
	
	
	public RefundRequest(String orderNo, long itemId, long leadId, String proposalNo, long productId,
			long insurerId, String insurerName, String entrySource, long entrySourceId, long planId,
			String createdBy, String platform, String browser, String browserVersion, String os, String ipAddress) {
		super();
		this.orderNo = orderNo;
		this.itemId = itemId;
		this.leadId = leadId;
		this.proposalNo = proposalNo;
		this.productId = productId;
		this.insurerId = insurerId;
		this.insurerName = insurerName;
		this.entrySource = entrySource;
		this.entrySourceId = entrySourceId;
		this.planId = planId;
		this.createdBy = createdBy;
		this.platform = platform;
		this.browser = browser;
		this.browserVersion = browserVersion;
		this.os = os;
		this.ipAddress = ipAddress;
	}



	public RefundRequest(String orderNo, long itemId, long leadId, String proposalNo, long productId,
			long insurerId, String insurerName, long planId, int txStatus, String createdBy, String lastModifiedBy,
			String platform,boolean isEligible,
			String otp, Date otpDate, float transactionAmount, String transactionDate,String policyId) {
		super();
		this.orderNo = orderNo;
		this.itemId = itemId;
		this.leadId = leadId;
		this.proposalNo = proposalNo;
		this.productId = productId;
		this.insurerId = insurerId;
		this.insurerName = insurerName;
		this.planId = planId;
		this.txStatus = txStatus;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.platform = platform;
		this.isEligible = isEligible;
		this.otp = otp;
		this.otpDate = otpDate;
		this.transactionAmount= transactionAmount;
		this.transactionDate = transactionDate;
		this.policyId=policyId;
	}



	public RefundRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void setPolicyStatusId(Integer policyStatusId) {
		this.policyStatusId = policyStatusId;
	}
	public Integer getPolicyStatusId() {
		return policyStatusId;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Date getOtpDate() {
		return otpDate;
	}
	public void setOtpDate(Date otpDate) {
		this.otpDate = otpDate;
	}
	public boolean isEligible() {
		return isEligible;
	}

	public void setEligible(boolean isEligible) {
		this.isEligible = isEligible;
	}

	public boolean isIntermediateEligibilityFlag() {
		return intermediateEligibilityFlag;
	}

	public void setIntermediateEligibilityFlag(boolean intermediateEligibilityFlag) {
		this.intermediateEligibilityFlag = intermediateEligibilityFlag;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public long getLeadId() {
		return leadId;
	}
	public void setLeadId(long leadId) {
		this.leadId = leadId;
	}
	public String getProposalNo() {
		return proposalNo;
	}
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public long getInsurerId() {
		return insurerId;
	}
	public void setInsurerId(long insurerId) {
		this.insurerId = insurerId;
	}
	public String getInsurerName() {
		return insurerName;
	}
	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	}
	public String getEntrySource() {
		return entrySource;
	}
	public void setEntrySource(String entrySource) {
		this.entrySource = entrySource;
	}
	public long getEntrySourceId() {
		return entrySourceId;
	}
	public void setEntrySourceId(long entrySourceId) {
		this.entrySourceId = entrySourceId;
	}
	public long getPlanId() {
		return planId;
	}
	public void setPlanId(long planId) {
		this.planId = planId;
	}
	public int getTxStatus() {
		return txStatus;
	}
	public void setTxStatus(int txStatus) {
		this.txStatus = txStatus;
	}
	public int getRefundRetaintionSchedulingStatus() {
		return refundRetaintionSchedulingStatus;
	}
	public void setRefundRetaintionSchedulingStatus(int refundRetaintionSchedulingStatus) {
		this.refundRetaintionSchedulingStatus = refundRetaintionSchedulingStatus;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getBrowserVersion() {
		return browserVersion;
	}
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double d) {
		this.transactionAmount = d;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public String getPgRefundRequestId() {
		return pgRefundRequestId;
	}
	public void setPgRefundRequestId(String pgRefundRequestId) {
		this.pgRefundRequestId = pgRefundRequestId;
	}
	public String getOrderNoitemId() {
		return orderNoitemId;
	}
	public void setOrderNoitemId(String orderNoitemId) {
		this.orderNoitemId = orderNoitemId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public boolean isExceptionFlag() {
		return exceptionFlag;
	}
	public void setExceptionFlag(boolean exceptionFlag) {
		this.exceptionFlag = exceptionFlag;
	}	
}
