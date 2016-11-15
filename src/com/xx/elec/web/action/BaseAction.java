package com.xx.elec.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xx.elec.util.TUtil;

/**
 * 
 * @author xin
 *
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>, ServletRequestAware, ServletResponseAware{
	
	T entity;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	// T Get instance 
	public BaseAction(){
		
		Class entityClass = (Class)TUtil.getActualType(this.getClass());

		try {
			entity = (T) entityClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public T getModel() {
		
		return entity;
	}

	@Override
	public void setServletResponse(HttpServletResponse res) {
		this.response = res;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}
	 
}
