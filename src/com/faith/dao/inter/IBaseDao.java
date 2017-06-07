package com.faith.dao.inter;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
	Serializable add(T entity);
	boolean delete(String id);
	T findById(String id);
	boolean update(T entity);
	List<T> findAll();
}
