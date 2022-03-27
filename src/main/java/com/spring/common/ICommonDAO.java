package com.spring.common;

import java.util.List;

public interface ICommonDAO <T> {
	public T save(T t);
	public List<T> getAll();
	public T getByID(int id);
	public T delete(T t);
	public T update(T t);
	
}
