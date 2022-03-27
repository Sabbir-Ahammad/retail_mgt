package com.spring.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

public interface ICommonService <T>{
	public T save(HttpServletRequest request);
	public T edit(int id);
	public T update(HttpServletRequest request);
	public List<T> getAll();
	public boolean delete(int id);

}
