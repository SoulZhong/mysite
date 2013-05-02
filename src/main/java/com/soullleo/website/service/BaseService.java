/**
 * 
 */
package com.soullleo.website.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author Soul
 * @date 2011-11-19
 */
public interface BaseService {

	public void create(Object entity);
	public List findAll(Class entityClass);

	public HibernateTemplate getHibernateTemplate();
	
	public void saveOrUpdate(Object entity);
	public void saveOrUpdateByList(List collection);
	public Object loadById(Class entity, Serializable id);
	public void update(Object entity);
	public void delete(Object entity);
	
	public void createToDB(Object entity);
	public void updateToDB(Object entity);

	public List<?>findByCriterion(Class<?> c, Map<String, Object>criterion);
	
	public Long findCountByCriterion(Class<?> entity, Map<String, Object>criterion);
}
