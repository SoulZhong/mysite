/**
 * 
 */
package com.soullleo.website.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.soullleo.website.domain.Blog;
import com.soullleo.website.service.BlogService;

/**
 * @author Soul
 * @date 2012-3-10
 */
public class BlogServiceImpl extends BaseServiceImpl implements BlogService{

	
	@Override
	public List<Blog> query(int first, int size) {
		
		Session session = super.getSession();
		Query query = session.createQuery("from Blog order by updateTime ");
		
		query.setFirstResult(first);
		query.setMaxResults(size);		
		
		return query.list();
	}

}
