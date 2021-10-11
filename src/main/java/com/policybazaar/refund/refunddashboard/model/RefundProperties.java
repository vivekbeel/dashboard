package com.policybazaar.refund.refunddashboard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="refund_properties")
public class RefundProperties implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")	
	@GeneratedValue
	private long id;
	
	@Column(unique = true,name="keys")
	private String keys;
	
	@Column(name="value")
	private String values;
	
	
	public RefundProperties() {
		super();
	}
	public RefundProperties(long id, String keys, String values) {
		super();
		this.id = id;
		this.keys = keys;
		this.values = values;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
	public String getValues() {
		return values;
	}
	public void setValues(String values) {
		this.values = values;
	}	
}
