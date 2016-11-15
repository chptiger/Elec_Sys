package com.xx.elec.service;

import java.util.List;

import com.xx.elec.domain.ElecText;
/**
 * 
 * @author xin
 *
 */
public interface IElecTextService {
	public static final String SERVICE_NAME="com.xx.elec.service.impl.ElecTextServiceImpl";
	void saveElecText(ElecText elecText);
	List<ElecText> findCollectionByConditionNoPage(ElecText elecText);
}
