package com.xx.elec.util;

import java.lang.reflect.ParameterizedType;

/**
 * 
 * @author xin
 *
 */
public class TUtil {
	//泛型转化
	public static Class getActualType(Class entity) {
		ParameterizedType parameterizedType= (ParameterizedType) entity.getGenericSuperclass();
		Class entityClass = (Class) parameterizedType.getActualTypeArguments()[0];
		return entityClass;
	}
	
}
