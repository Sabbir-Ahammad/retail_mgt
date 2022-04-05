package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "upplierSuppliedProduct")
@Table(name = "supplierSuppliedProduct")
public class SupplierSuppliedProduct {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "productCode")
	private String productCode;
	@Column(name = "supplierCode")
	private String supplierCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	
}
