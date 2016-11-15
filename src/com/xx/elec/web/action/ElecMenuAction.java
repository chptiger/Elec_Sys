package com.xx.elec.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xx.elec.web.form.MenuForm;


@SuppressWarnings("serial")
@Controller("elecMenuAction")
@Scope(value="prototype")
public class ElecMenuAction extends BaseAction<MenuForm>{
	
	MenuForm menuForm = this.getModel();
	
	/**
	 * @return： String redirect: ../munu/home.jsp
	 */
	public String menuHome(){
		//System.out.println( menuForm.getName() + "" + menuForm.getPassword());
		return "menuHome";
	}

	public String title(){
		return "title";
	}

	public String left(){
		return "left";
	}
	
	public String change(){
		return "change";
	}
	
	public String loading(){
		return "loading";
	}
	
	public String logout(){
		/**
		 * clear all sessions
		 */
		request.getSession().invalidate();
		return "logout";
	}
	
	public String alermStation(){
		return "alermStation";
	}
	
	public String alermDevice(){
		return "alermDevice";
	}
	
}
