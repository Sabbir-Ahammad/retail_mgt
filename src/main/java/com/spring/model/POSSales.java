package com.spring.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "posSales")
@Table(name = "posSales")
public class POSSales {

	@Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
	@Column(name = "transactionCode")
    private int transactionCode;
    @Column(name = "productCode")
    private String productCode;
    @Column(name = "productName")
    private String productName;
    @Column(name = "salesAmount")
    private int salesAmount;
    @Column(name = "productImage")
    private String productImage;
    @Column(name = "price")
    private Double price;
    @Column(name = "salesTaxRate")
    private Double salesTaxRate;
    @Column(name = "salesDiscount")
    private Double salesDiscount;
    @Column(name = "salesQuantity")
    private int salesQuantity;
    public int getSalesQuantity() {
		return salesQuantity;
	}
	public void setSalesQuantity(int salesQuantity) {
		this.salesQuantity = salesQuantity;
	}
	@Column(name = "profitMargin")
    private Double profitMargin;
    @Column(name = "profit")
    private Double profit;
    @Column(name = "sellingPrice")
    private Double sellingPrice;
    @Column(name = "customerCode")
    private String customerCode;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "salesDate")
	private Date salesDate;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getSalesTaxRate() {
		return salesTaxRate;
	}
	public void setSalesTaxRate(Double salesTaxRate) {
		this.salesTaxRate = salesTaxRate;
	}
	public Double getSalesDiscount() {
		return salesDiscount;
	}
	public void setSalesDiscount(Double salesDiscount) {
		this.salesDiscount = salesDiscount;
	}
	public Double getProfitMargin() {
		return profitMargin;
	}
	public void setProfitMargin(Double profitMargin) {
		this.profitMargin = profitMargin;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}
	public Double getProfit() {
		return profit;
	}
	public void setProfit(Double profit) {
		this.profit = profit;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	public int getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}
    
}
