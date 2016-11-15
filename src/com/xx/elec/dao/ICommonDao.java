package com.xx.elec.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author xin
 *
 * @param <T>
 */
public interface ICommonDao<T> {
	 void save( T entity);

	void update( T entity);
	
	T findObjectById(Serializable id);

	void deleteObjectByIds(Serializable... ids);
	
	void deleteObjectByCollection(List<T> list);
	
	List<T> findCollectionByConditionNoPage(String condition, Object[] params, Map<String, String> orderby);

}
