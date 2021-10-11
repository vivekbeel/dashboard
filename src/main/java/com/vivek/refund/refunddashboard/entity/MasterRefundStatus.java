package com.policybazaar.refund.refunddashboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="MasterRefundStatus")
public class MasterRefundStatus {
	
	@Id
	@GeneratedValue
	private int id;
	private String status;
	private String subStatus;
	private String subSubStatus;
	private String pgRefundStatus;
	private String uniqueKey;
	@Column(name="isActive")
	private boolean isActive;
	@Column(name="priority")
	private int priority;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubStatus() {
		return subStatus;
	}
	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}
	public String getSubSubStatus() {
		return subSubStatus;
	}
	public void setSubSubStatus(String subSubStatus) {
		this.subSubStatus = subSubStatus;
	}
	public String getPgRefundStatus() {
		return pgRefundStatus;
	}
	public void setPgRefundStatus(String pgRefundStatus) {
		this.pgRefundStatus = pgRefundStatus;
	}
	public String getUniqueKey() {
		return uniqueKey;
	}
	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
}
