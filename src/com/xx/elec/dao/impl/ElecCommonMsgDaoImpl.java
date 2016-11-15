package com.xx.elec.dao.impl;

import org.springframework.stereotype.Repository;

import com.xx.elec.dao.IElecCommonMsgDao;
import com.xx.elec.dao.IElecTextDao;
import com.xx.elec.domain.ElecCommonMsg;

/**
 * 
 * @author xin
 *
 * @param <T>
 */
@Repository(IElecCommonMsgDao.SERVICE_NAME)
public class ElecCommonMsgDaoImpl<T> extends CommonDaoImpl<ElecCommonMsg> implements IElecCommonMsgDao{



}
