package com.paysyslabs.rest.models.request;

import java.io.Serializable;

public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5086546220328459082L;

	private String batchId;
	private String instructionId;
	private String iban;
	private String customerName;
	private String identification_type;
	private String identification_value;
	private String currency;
	private String amount;
	private String purposeCode;

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(String batchId, String instructionId, String iban, String customerName,
			String identification_type, String identification_value, String currency, String amount,
			String purposeCode) {
		super();
		this.batchId = batchId;
		this.instructionId = instructionId;
		this.iban = iban;
		this.customerName = customerName;
		this.identification_type = identification_type;
		this.identification_value = identification_value;
		this.currency = currency;
		this.amount = amount;
		this.purposeCode = purposeCode;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getInstructionId() {
		return instructionId;
	}

	public void setInstructionId(String instructionId) {
		this.instructionId = instructionId;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getIdentification_type() {
		return identification_type;
	}

	public void setIdentification_type(String identification_type) {
		this.identification_type = identification_type;
	}

	public String getIdentification_value() {
		return identification_value;
	}

	public void setIdentification_value(String identification_value) {
		this.identification_value = identification_value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPurposeCode() {
		return purposeCode;
	}

	public void setPurposeCode(String purposeCode) {
		this.purposeCode = purposeCode;
	}

	@Override
	public String toString() {
		return "PreValidRequest [batchId=" + batchId + ", instructionId=" + instructionId + ", iban=" + iban
				+ ", customerName=" + customerName + ", identification_type=" + identification_type
				+ ", identification_value=" + identification_value + ", currency=" + currency + ", amount=" + amount
				+ ", purposeCode=" + purposeCode + "]";
	}

}
