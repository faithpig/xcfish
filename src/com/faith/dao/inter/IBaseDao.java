package com.faith.dao.inter;

import java.util.List;

public interface IBaseDao<T> {
	T add(T entity);
	boolean delete(String id);
	T findById(String id);
	boolean update(T entity);
	List<T> findAll();
}
