package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.InventoryDAO;
import com.spring.model.Inventory;
import com.spring.model.Product;
import com.spring.model.PurchaseDemand;
import com.spring.service.impl.IInventoryService;
@Service(value = "inventoryService")
public class InventoryService implements IInventoryService{
	
	@Autowired
	InventoryDAO inventoryDAO;
	@Autowired
	ProductService productService;

	@Override
	public Inventory save(HttpServletRequest request) {
		return null;
	}

	@Override
	public Inventory edit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> getAll() {
        return inventoryDAO.getAll();
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Inventory save(PurchaseDemand p) {
		Product product = productService.getProductDetailsByCode(p.getProductCode());
		Inventory in = new Inventory();
		in.setProductName(p.getProductName());
		in.setProductCode(p.getProductCode());
		in.setCategoryName(p.getCategoryName());
		in.setPurchaseDemandCode(p.getPurchaseDemandCode());
		in.setReceivedDate(p.getReceivedDate());
		in.setSubcategoryName(p.getSubCategoryName());
		in.setSupplierName(p.getSupplierName());
		in.setLotNumber(p.getLotNumber());
		in.setProductImage(p.getProductImage());
		
		Double pdis = p.getDiscount();
		Double pap = p.getPurchasePrice();
		Double pat = p.getTax();
		Integer psa = p.getQuantity();
		Double idis = null,iap = null,iat = null;
		Integer isa = null;
		Double taxRate = product.getTaxRate(), discount=product.getDiscount(), profitMargin=product.getProfitMargin();
		Double taxedPrice = null, sellingPrice=null;
		Double price=null;
		double profit=0;
		try {
			 Inventory i = inventoryDAO.getByProductCode(p.getProductCode());
			 isa = i.getStoredAmount() + psa;
			 idis = ((i.getAverageDiscount() * i.getStoredAmount()) + pdis)/ isa;
			 iap = ((i.getAveragePrice() * i.getStoredAmount()) + ((pap-pdis)+pat))/isa;
			 iat = ((i.getAverageTax() * i.getStoredAmount()) + pat)/isa;
			 
			 i.setAverageDiscount(idis);
			 i.setAveragePrice(iap);
			 i.setAverageTax(iat);
			 i.setStoredAmount(isa);
			 profit=i.getSellingPrice() - i.getAveragePrice();
			 i.setProfitPerUnit(profit);
			 return inventoryDAO.update(i);
		} catch (Exception e) {
			idis = (pdis/ psa);
			iap = (pap/ psa);
			iat = (pat/ psa);
			isa = psa;
		}
		in.setAverageDiscount(idis);
		in.setAveragePrice(iap);
		in.setAverageTax(iat);
		in.setStoredAmount(isa);
		return inventoryDAO.save(in);
		//return null;

	}
	
	Inventory getProductsDetails(String productCode){
    	return inventoryDAO.getByProductCode(productCode);
    }

	@Override
	public Product updateSellingPrice(Product p) {
		inventoryDAO.updateSellingprice(p);
		return null;
	}

	@Override
	public Inventory updateSold(String i, int j) {
		Inventory ii = new Inventory();
		ii.setProductCode(i);
		ii.setStoredAmount(Integer.valueOf(j));
		//System.err.println(ii.getProductCode() + "" + ii.getStoredAmount());
		
		//System.err.println("procode"+i);
		//System.err.println("quantity"+j);
		return inventoryDAO.updateSold(ii);
	}
}
