package com.spring.controller.impl;

import org.springframework.web.servlet.ModelAndView;

import com.spring.common.ICommonController;
import com.spring.model.PurchaseOrder;

public interface IPurchaseOrderController extends ICommonController{
	public ModelAndView save(PurchaseOrder p);
}
