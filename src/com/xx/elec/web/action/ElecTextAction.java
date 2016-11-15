package com.xx.elec.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xx.elec.domain.ElecText;
import com.xx.elec.service.IElecTextService;

/**
 * @Controller("elecTextAction")
 * 相当于spring容器中定义
 * <bean id="elecTextAction" class="com.xx.elec.web.action.ElecTextAction" scope="prototype"/>
 * scope="prototype" 多例 每一次访问action时，都创建一个实例
 * @author xin
 *
 */
@SuppressWarnings("serial")
@Controller("elecTextAction")
@Scope(value="prototype")
public class ElecTextAction extends BaseAction<ElecText>{
	
	ElecText elecText = this.getModel();
	
	/**
	 * Dependence Injection Service
	 */
	@Resource(name=IElecTextService.SERVICE_NAME)
	IElecTextService elecTextService;
	
	public String save(){
		elecTextService.saveElecText(elecText);
		String textDate = request.getParameter("textDate");
		//System.out.println(textDate);
		return "save";
	}


	
}
