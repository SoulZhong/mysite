/**
 * 
 */
package com.soullleo.website.service.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.soullleo.website.service.BaseService;
import com.soullleo.website.util.Constant;
import com.soullleo.website.util.FormatUtil;

/**
 * @author Soul
 * @date 2011-11-19
 */
public class BaseServiceImpl extends HibernateDaoSupport implements BaseService {

	private boolean cacheQueries = false;
    private String queryCacheRegion;

    protected void initDao() throws Exception {
        super.initDao();
        getHibernateTemplate().setCacheQueries(cacheQueries);
        if (queryCacheRegion != null) {
            getHibernateTemplate().setQueryCacheRegion(queryCacheRegion);
        }
        getHibernateTemplate().setExposeNativeSession(true);
    }
    public void setCacheQueries(boolean cacheQueries) {
        this.cacheQueries = cacheQueries;
    }

    public void setQueryCacheRegion(String queryCacheRegion) {
        this.queryCacheRegion = queryCacheRegion;
    }
    
    public void saveOrUpdate(Object entity){
    	super.getHibernateTemplate().saveOrUpdate(entity);
    }
    
	public void create(Object entity) {
		super.getHibernateTemplate().save(entity);
	}

	@SuppressWarnings("rawtypes")
	public void saveOrUpdateByList(List collection) {
		super.getHibernateTemplate().saveOrUpdateAll(collection);
	}
	
	

	/**
	 * query by criterion.
	 * query by duration naming rule: nameFromTime,nameToTime;
	 * Example:
	 *	Field -createDate
	 *  Criterion map Key - createDateFromTime, createDateToTime;
	 * @param c
	 * @param criterion
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<?>findByCriterion(Class<?> c, Map<String, Object>criterion){
		
		String query = " from " + c.getName() + " where id is not null ";
		List<Object>params = new ArrayList<Object>();
		Field[] fields = c.getDeclaredFields();
		
		Object object = null;
		for(int i = 0; i < fields.length; i++){
			Field field = fields[i];
			
			if(field.getType().isInstance(new Date())){
				object = criterion.get(field.getName() + Constant.CRITERION_FROM_TIME);
				if(object != null){
					query = query + " and " + field.getName() + " >= ? ";
					params.add(object);
				}
				object = criterion.get(field.getName() + Constant.CRITERION_TO_TIME);
				if(object != null){
					query = query + " and " + field.getName() + " <= ? ";
					params.add(object);
				}
			}
			
			object = criterion.get(field.getName());
			
			if(object != null){
					if(object instanceof List){
						query = query + " and " + field.getName() + " in (" + FormatUtil.arrayToSQL((List) object)+ ")";
					}else{
						query = query + " and " + field.getName() + " = ? ";
						params.add(object);	
					}
			}		
		}		

		return super.getHibernateTemplate().find(query, params.toArray());
	}

	/* (non-Javadoc)
	 * @see com.smics.apps.ntohcs.service.BaseService#findCountByCriterion(java.lang.Class, java.util.Map)
	 */
	public Long findCountByCriterion(Class<?> entity,
			Map<String, Object> criterion) {
		// TODO Auto-generated method stub
		
		String query = " select count(e) " +
				" from " + entity.getName() + " e where id is not null ";
		List<Object>params = new ArrayList<Object>();
		Field[] fields = entity.getDeclaredFields();
		
		Object object = null;
		for(int i = 0; i < fields.length; i++){
			Field field = fields[i];
			
			if(field.getType().isInstance(new Date())){
				object = criterion.get(field.getName() + Constant.CRITERION_FROM_TIME);
				if(object != null){
					query = query + " and " + field.getName() + " >= ? ";
					params.add(object);
				}
				object = criterion.get(field.getName() + Constant.CRITERION_TO_TIME);
				if(object != null){
					query = query + " and " + field.getName() + " <= ? ";
					params.add(object);
				}
			}
			
			object = criterion.get(field.getName());
			if(object != null){
				query = query + " and " + field.getName() + " = ? ";
				params.add(object);
			}		
		}		

		@SuppressWarnings("unchecked")
		List<Long> result = super.getHibernateTemplate().find(query, params.toArray());
		return result.get(0);
	}

	public void createToDB(Object entity) {
		org.hibernate.Session session = super.getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try{
			session.save(entity);		
			session.flush();
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) 
				tx.rollback();
			throw e;
		}finally{
	
			session.close();
		}		
	}



	public void updateToDB(Object entity) {

		org.hibernate.Session session = super.getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try{
			session.update(entity);		
			session.flush();
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) 
				tx.rollback();
			throw e;
		}finally{
	
			session.close();
		}
		
	}

	public List findAll(Class entityClass) {
		return getHibernateTemplate().loadAll(entityClass);
	}

	public Object loadById(Class entity, Serializable id) {	
		
	    HibernateTemplate ht = getHibernateTemplate();
	    ht.setCacheQueries(false);
	    
		return ht.get(entity, id);//ht.load(entity, id);
	}

	public void update(Object entity) {
		getHibernateTemplate().update(entity);
	}

	public void delete(Object entity) {
		getHibernateTemplate().delete(entity);		
	}

}
