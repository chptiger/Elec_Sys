package com.xx.elec.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xx.elec.dao.ICommonDao;
import com.xx.elec.util.TUtil;

/**
 * 
 * @author xin
 *
 * @param <T>
 */
public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T>{

	Class entityClass = TUtil.getActualType(this.getClass());
	
	@Resource(name="sessionFactory")
	public void setDi(SessionFactory sessionFactory){
		//System.out.println("sessionFactory: " + sessionFactory);
		this.setSessionFactory(sessionFactory);
	}
	
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}
	
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}
	
	public T findObjectById( Serializable id) {
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}
	
	public void deleteObjectByIds(Serializable... ids) {
		if( ids != null && ids.length > 0){
			for(Serializable id : ids){
				Object entity = this.findObjectById(id);
				this.getHibernateTemplate().delete(entity);
			}
		}
		
	}

	public void deleteObjectByCollection(List<T> list) {
		this.getHibernateTemplate().deleteAll(list);
	}

	/**
	 *  select * from elec_text o where 1=1  			// Dao tier 
	 *  and o.textName like "%save%"					// Service tier
	 *  and o.textRemark like "%save%"					// Service tier
	 *  order by o.textDate asc, o.textName desc		// Service tier
	 */
	public List<T> findCollectionByConditionNoPage(String condition, final Object[] params, Map<String, String> orderby) {
//		hql
		String hql = " from " + entityClass.getSimpleName() + " o where 1=1 ";
		
//		map   order by o.textDate asc, o.textName desc
		String orderbycondition = this.orderbyhql(orderby);
//		add search condition; 
		final String finalhql = hql + condition + orderbycondition;
		
//		method one
//		List<T> list  = this.getHibernateTemplate().find(finalhql, params);
//		method two
		List<T> list = (List<T>) this.getHibernateTemplate().execute(new HibernateCallback() {			
							public Object doInHibernate(Session session) throws HibernateException, SQLException {
								Query query = session.createQuery(finalhql);//call underlying parameters can not be changed，line75 加 final修饰
								if( params!=null && params.length >0){
									for( int i = 0; i < params.length; i++){
										query.setParameter(i, params[i]);
									}
								}
								return query.list();
							}
						});
		return list;
	}

//	map order by o.textDate asc, o,textName desc
	private String orderbyhql(Map<String, String> orderby) {
		StringBuffer sb = new StringBuffer();
		if( orderby!=null && orderby.size()>0){
			sb.append(" ORDER BY ");
			for(Map.Entry<String, String> map:orderby.entrySet()){
				sb.append(map.getKey() + " " + map.getValue() +",");
			}
//			delete last one ，
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}

}
