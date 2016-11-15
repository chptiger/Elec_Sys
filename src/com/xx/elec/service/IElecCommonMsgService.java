package com.xx.elec.service;

import com.xx.elec.domain.ElecCommonMsg;

/**
 * 
 * @author xin
 *
 */
public interface IElecCommonMsgService {
	public static final String SERVICE_NAME="com.xx.elec.service.impl.ElecCommonMsgServiceImpl";

	ElecCommonMsg findCommonMsg();
	
}
