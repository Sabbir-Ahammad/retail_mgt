package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "product")
@Table(name = "product")
public class Product { 
     
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "productCode")
    private String productCode;
    @Column(name = "productName")
    private String productName;
    
    @OneToOne
    @JoinColumn(name = "c_id")
    private Category categoryId;
    
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
    @Column(name = "unitCost")
    private Double unitCost;
    @Column(name = "taxRate")
    private Double taxRate;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "profitMargin")
    private Double profitMargin;
    @Column(name = "sellingPrice")
    private Double sellingPrice;
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
	
	public Double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}
	public Double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public Double getProfitMargin() {
		return profitMargin;
	}
	public void setProfitMargin(Double profitMargin) {
		this.profitMargin = profitMargin;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getSubCategoryCode() {
		return subCategoryCode;
	}
	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}
	public Category getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	
    
}
