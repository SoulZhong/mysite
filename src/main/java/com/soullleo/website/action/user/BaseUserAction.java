/**
 * 
 */
package com.soullleo.website.action.user;

import java.util.List;

import com.soullleo.website.action.BaseAction;
import com.soullleo.website.domain.Blog;
import com.soullleo.website.service.BaseService;
import com.soullleo.website.service.BlogService;

/**
 * @author Soul
 * @date 2011-10-25
 */
public class BaseUserAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -95548442105047807L;
	
	private BaseService baseService;
	private BlogService blogService;
	
	public List<Blog> getLast10Blogs(){
		return getBlogService().query(0, 10);
	}

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public BlogService getBlogService() {
		return blogService;
	}

}
