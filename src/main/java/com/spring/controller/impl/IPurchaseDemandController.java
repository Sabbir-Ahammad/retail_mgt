package com.spring.controller.impl;

import org.springframework.web.servlet.ModelAndView;

import com.spring.common.ICommonController;
import com.spring.model.PurchaseDemand;

public interface IPurchaseDemandController extends ICommonController{
	public ModelAndView save(PurchaseDemand p);
	public ModelAndView updateStatus(PurchaseDemand p);
}
