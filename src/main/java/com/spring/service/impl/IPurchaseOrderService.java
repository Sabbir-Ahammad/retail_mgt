package com.spring.service.impl;

import com.spring.common.ICommonService;
import com.spring.model.PurchaseOrder;

public interface IPurchaseOrderService extends ICommonService<PurchaseOrder>{
	public PurchaseOrder save(PurchaseOrder p);
}
