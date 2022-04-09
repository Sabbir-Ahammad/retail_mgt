package com.spring.dao.impl;

import com.spring.common.ICommonDAO;
import com.spring.model.PurchaseDemand;

public interface PurchaseDemandRepository extends ICommonDAO<PurchaseDemand>{
	public PurchaseDemand updateStatus(PurchaseDemand p);
}
