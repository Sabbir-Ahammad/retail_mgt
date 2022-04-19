package com.spring.dao.impl;

import com.spring.common.ICommonDAO;
import com.spring.model.POSSales;

public interface POSRepository extends ICommonDAO<POSSales>{
	public int getTransactionId();
}
