package com.spring.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "inventory")
@Table(name = "inventory")
public class Inventory {

	@Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
	@Column(name = "inventory_code")
	private String inventoryCode;
	@Column(name = "purchase_demand_code")
	private String purchaseDemandCode;
	@Column(name = "product_code")
	private String productCode;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "category_code")
	private String categoryCode;
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "sub_category_code")
	private String subCategoryCode;
	@Column(name = "subcategory_Name")
	private String subcategoryName;
	@Column(name = "supplier_code")
	private String supplierCode;
	@Column(name = "supplier_name")
	private String supplierName;
	@Column(name = "average_price")
	private double averagePrice;
	@Column(name = "average_discount")
	private double averageDiscount;
	@Column(name = "average_tax")
	private double averageTax;
	@Column(name = "stored_amount")
	private int storedAmount;
	@Column(name = "selling_price")
	private double sellingPrice;
	@Column(name = "selling")
	private double selling;
	@Column(name = "sellingTax")
	private double sellingTax;
	@Column(name = "profitPerUnit")
	private double profitPerUnit;
	@Column(name = "lotNumber")
	private String lotNumber;
	@Column(name = "receivedDate")
	private Date receivedDate;
	@Column(name = "productImage")
	private String productImage;
	
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
	public String getSubcategoryName() {
		return subcategoryName;
	}
	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
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
	public double getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(double averagePrice) {
		this.averagePrice = averagePrice;
	}
	public double getAverageDiscount() {
		return averageDiscount;
	}
	public void setAverageDiscount(double averageDiscount) {
		this.averageDiscount = averageDiscount;
	}
	public double getAverageTax() {
		return averageTax;
	}
	public void setAverageTax(double averageTax) {
		this.averageTax = averageTax;
	}
	public int getStoredAmount() {
		return storedAmount;
	}
	public void setStoredAmount(int storedAmount) {
		this.storedAmount = storedAmount;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public double getSelling() {
		return selling;
	}
	public void setSelling(double selling) {
		this.selling = selling;
	}
	public double getSellingTax() {
		return sellingTax;
	}
	public void setSellingTax(double sellingTax) {
		this.sellingTax = sellingTax;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public String getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
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
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public double getProfitPerUnit() {
		return profitPerUnit;
	}
	public void setProfitPerUnit(double profitPerUnit) {
		this.profitPerUnit = profitPerUnit;
	}
	
}
