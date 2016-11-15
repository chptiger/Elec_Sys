package com.xx.elec.util;

import org.apache.struts2.ServletActionContext;

import com.xx.elec.domain.ElecCommonMsg;

public class ValueUtil {
//	将对象压入栈顶
	public static void pushValueStack(Object object) {
		ServletActionContext.getContext().getValueStack().push(object);
	}

}
