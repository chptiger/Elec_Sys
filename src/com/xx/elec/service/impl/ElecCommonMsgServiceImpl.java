package com.xx.elec.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xx.elec.dao.IElecCommonMsgDao;
import com.xx.elec.domain.ElecCommonMsg;
import com.xx.elec.service.IElecCommonMsgService;

/**
 * 
 * @author xin
 * 
 */
@Service(IElecCommonMsgService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecCommonMsgServiceImpl implements IElecCommonMsgService {

	@Resource(name = IElecCommonMsgDao.SERVICE_NAME)
	IElecCommonMsgDao elecCommonMsgDao;

	/**
	 * @Name: findCommonMsg
	 * @Description:search data from running monitor table
	 * @Author: Xin
	 * @Version: V1.00
	 * @Create Date： 2016-03-25
	 * @Parameters: 无
	 * @Return: ElecCommonMsg:PO object（running monitor data）
	 */
	public ElecCommonMsg findCommonMsg() {
		List<ElecCommonMsg> list = elecCommonMsgDao
				.findCollectionByConditionNoPage("", null, null);
		// return unique parameter
		ElecCommonMsg elecCommonMsg = null;
		if (list != null && list.size() > 0) {
			elecCommonMsg = list.get(0);
		}
		return elecCommonMsg;
	}

}
