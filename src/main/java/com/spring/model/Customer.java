package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "customer")
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "customerCode")
	private String customerCode;
	@Column(name = "customerName")
	private String customerName;
	@Column(name = "customerContract")
	private String customerContract;
	@Column(name = "customerAdderss")
	private String customerAdderss;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerContract() {
		return customerContract;
	}
	public void setCustomerContract(String customerContract) {
		this.customerContract = customerContract;
	}
	public String getCustomerAdderss() {
		return customerAdderss;
	}
	public void setCustomerAdderss(String customerAdderss) {
		this.customerAdderss = customerAdderss;
	}
	
}
