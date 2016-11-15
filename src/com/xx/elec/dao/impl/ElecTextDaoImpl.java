package com.xx.elec.dao.impl;

import org.springframework.stereotype.Repository;

import com.xx.elec.dao.IElecTextDao;
import com.xx.elec.domain.ElecText;

/**
 * 
 * @author xin
 *
 */
/*
 * @Repository(IElecTextDao.SERVICE_NAME)
 * <bean id="com.itheima.elec.dao.impl.ElecTextDaoImpl" class="com.itheima.elec.dao.impl.ElecTextDaoImpl"/>
 */
@Repository(IElecTextDao.SERVICE_NAME)
public class ElecTextDaoImpl extends CommonDaoImpl<ElecText> implements IElecTextDao{

}
