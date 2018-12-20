package com.example.demo.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<E> {

	public void saveOrUpdate(E entity);

	boolean deleteById(Class<?> type, Serializable id);

	void deleteAll();

	List<E> findAll();

	E findById(Serializable id);

}
