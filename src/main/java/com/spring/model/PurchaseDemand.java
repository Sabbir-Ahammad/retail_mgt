package com.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "purchaseDemand")
@Table(name = "purchaseDemand")
public class PurchaseDemand {

	@Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
	@Column(name = "purchaseDemandCode")
	private String purchaseDemandCode;
	@Column(name = "description")
	private String description;
	@Column(name = "lotNumber")
	private String lotNumber;
	@Column(name = "productName")
	private String productName;
	@Column(name = "statedPrice")
	private Double statedPrice;
	@Column(name = "discount")
	private Double discount;
	@Column(name = "discountRate")
	private Double discountRate;
	@Column(name = "tax")
	private Double tax;
	@Column(name = "taxRate")
	private Double taxRate;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "purchasePrice")
	private Double purchasePrice;
	@Column(name = "supplierName")
	private String supplierName;
	@Column(name = "categoryName")
	private String categoryName;
	@Column(name = "subCategoryName")
	private String subCategoryName;
	@Column(name = "status")
	private String status;
	@Column(name = "orderDate")
	private Date orderDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPurchaseDemandCode() {
		return purchaseDemandCode;
	}
	public void setPurchaseDemandCode(String purchaseDemandCode) {
		this.purchaseDemandCode = purchaseDemandCode;
	}
	public String getLotNumber() {
		return lotNumber;
	}
	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getStatedPrice() {
		return statedPrice;
	}
	public void setStatedPrice(Double statedPrice) {
		this.statedPrice = statedPrice;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public Double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}
	public Double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
}
