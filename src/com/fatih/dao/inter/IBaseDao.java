package com.fatih.dao.inter;

public interface IBaseDao<T> {
	boolean add(T entity);
	boolean delete(String id);
	T findById(String id);
	boolean update(T entity);
}
