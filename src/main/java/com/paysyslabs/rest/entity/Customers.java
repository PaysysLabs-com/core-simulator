package com.paysyslabs.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "iban", length = 255)
	private String iban;

	@Column(name = "status", length = 255)
	private String status;

	@Column(name = "credit_allow")
	private boolean creditAllow;

	@Column(name = "credit_limit", length = 255)
	private String creditLimit;

	@Column(name = "identification_type_list", length = 255)
	private String identificationTypeList;

	@Column(name = "identification_value_list", length = 255)
	private String identificationValueList;

	@Column(name = "credit_timeout")
	private boolean creditTimeout;

	@Column(name = "credit_inquiry_timeout")
	private boolean creditInquiryTimeout;

	@Column(name = "credit_success")
	private boolean creditSuccess;

	@Column(name = "credit_inquiry_success")
	private boolean creditInquirySuccess;

	public Customers() {
	}

	public Customers(Long id, String iban, String status, boolean creditAllow, String creditLimit,
			String identificationTypeList, String identificationValueList, boolean creditTimeout,
			boolean creditInquiryTimeout, boolean creditSuccess, boolean creditInquirySuccess) {
		super();
		this.id = id;
		this.iban = iban;
		this.status = status;
		this.creditAllow = creditAllow;
		this.creditLimit = creditLimit;
		this.identificationTypeList = identificationTypeList;
		this.identificationValueList = identificationValueList;
		this.creditTimeout = creditTimeout;
		this.creditInquiryTimeout = creditInquiryTimeout;
		this.creditSuccess = creditSuccess;
		this.creditInquirySuccess = creditInquirySuccess;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isCreditAllow() {
		return creditAllow;
	}

	public void setCreditAllow(boolean creditAllow) {
		this.creditAllow = creditAllow;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getIdentificationTypeList() {
		return identificationTypeList;
	}

	public void setIdentificationTypeList(String identificationTypeList) {
		this.identificationTypeList = identificationTypeList;
	}

	public String getIdentificationValueList() {
		return identificationValueList;
	}

	public void setIdentificationValueList(String identificationValueList) {
		this.identificationValueList = identificationValueList;
	}

	public boolean isCreditTimeout() {
		return creditTimeout;
	}

	public void setCreditTimeout(boolean creditTimeout) {
		this.creditTimeout = creditTimeout;
	}

	public boolean isCreditInquiryTimeout() {
		return creditInquiryTimeout;
	}

	public void setCreditInquiryTimeout(boolean creditInquiryTimeout) {
		this.creditInquiryTimeout = creditInquiryTimeout;
	}

	public boolean isCreditSuccess() {
		return creditSuccess;
	}

	public void setCreditSuccess(boolean creditSuccess) {
		this.creditSuccess = creditSuccess;
	}

	public boolean isCreditInquirySuccess() {
		return creditInquirySuccess;
	}

	public void setCreditInquirySuccess(boolean creditInquirySuccess) {
		this.creditInquirySuccess = creditInquirySuccess;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}

}
