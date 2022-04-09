package com.spring.model;

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
    @Column(name = "productCode")
    private String productCode;
    @Column(name = "productName")
    private String productName;
    @Column(name = "categoryCode")
    private String categoryCode;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "subCategoryCode")
    private String subCategoryCode;
    @Column(name = "subCategoryName")
    private String subCategoryName;
    @Column(name = "supplierCode")
    private String supplierCode;
    @Column(name = "supplierName")
    private String supplierName;
    @Column(name = "productImage")
    private String productImage;
    @Column(name = "price")
    private Double price;
    @Column(name = "salesTaxRate")
    private Double salesTaxRate;
    @Column(name = "salesDiscount")
    private Double salesDiscount;
    @Column(name = "profitMargin")
    private Double profitMargin;
    @Column(name = "sellingPrice")
    private Double sellingPrice;
    @Column(name = "customerName")
    private String customerName;
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
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSubCategoryCode() {
		return subCategoryCode;
	}
	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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
    
}
