package com.xx.elec.web.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xx.elec.domain.ElecCommonMsg;
import com.xx.elec.domain.ElecText;
import com.xx.elec.service.IElecCommonMsgService;
import com.xx.elec.service.IElecTextService;
import com.xx.elec.util.ValueUtil;

/**
 * @Controller("ElecCommonMsgAction")
 * 相当于spring容器中定义
 * <bean id="elecCommonMsgAction" class="com.xx.elec.web.action.ElecCommonMsgAction" scope="prototype"/>
 * scope="prototype" 多例 每一次访问action时，都创建一个实例
 * @author xin
 *
 */
@SuppressWarnings("serial")
@Controller("elecCommonMsgAction")
@Scope(value="prototype")
public class ElecCommonMsgAction extends BaseAction<ElecCommonMsg>{
	
	ElecCommonMsg elecCommonMsg = this.getModel();
	
	/**
	 * 注入运行监控Service
	 */
	@Resource(name=IElecCommonMsgService.SERVICE_NAME)
	IElecCommonMsgService elecCommonMsgService;
	
	/**
	 * 
	 * @return String "home" 跳转至 actionIndex.jsp
	 */
	public String home(){
//		1:查询数据库运行监控表的数据，返回唯一ElecCommonMsg
		ElecCommonMsg commonMsg = elecCommonMsgService.findCommonMsg();
//		2:将ElecCommonMsg对象压入栈顶，支持表单回显
		ValueUtil.pushValueStack(commonMsg);
		
		return "home";
	}
}
