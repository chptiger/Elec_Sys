package com.xx.elec.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xx.elec.dao.IElecTextDao;
import com.xx.elec.domain.ElecText;
import com.xx.elec.service.IElecTextService;

/**
 * @author xin
 */

/**
 * @Service
 * 相当于在spring容器总定义
 * <bean id="com.xx.elec.service.impl.ElecTextServiceImpl" class="com.xx.elec.service.impl.ElecTextServiceImpl"/>
 *
 */
@Service(IElecTextService.SERVICE_NAME)
@Transactional(readOnly=true)
public class ElecTextServiceImpl implements IElecTextService{
	
	@Resource(name=IElecTextDao.SERVICE_NAME)
	IElecTextDao elecTextDao;
	
	// 保存测试表
	@Transactional(readOnly=false)
	public void saveElecText(ElecText elecText) {
		elecTextDao.save(elecText);
	}

	// 指定查询条件 查询列表
	/**
	 *  select * from elec_text o where 1=1  			// Dao tier
	 *  and o.textName like "%save%"					// Service tier
	 *  and o.textRemark like "%save%"					// Service tier
	 *  order by o.textDate asc, o,textName desc		// Service tier
	 */
	public List<ElecText> findCollectionByConditionNoPage(ElecText elecText) {
		// 查询条件
		String condition = "";
//		查询条件对应参数
		List<Object> paramsList = new ArrayList<Object>();
		// if(StringUtils.isNotBlank(elecText.getTextName())){
		if( elecText.getTextName()!=null && !elecText.getTextName().equals("")){
			condition +=" and o.textName like ?";
			paramsList.add("%"+elecText.getTextName()+"%");
		}
		
		if(StringUtils.isNotBlank(elecText.getTextRemark())){
			condition +=" and o.textRemark like ?";
			paramsList.add("%"+elecText.getTextRemark()+"%");
		}
//		传递可变参数
		Object [] params = paramsList.toArray();// 能用集合尽量不用数组， 数组修改条件麻烦，一改全改
		
//		sort
		Map<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.textDate", "asc");
		orderby.put("o.textName", "desc");
		
		List<ElecText> list = elecTextDao.findCollectionByConditionNoPage( condition, params, orderby);
		
		return list;
	}

}
