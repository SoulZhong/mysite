/**
 * 
 */
package com.soullleo.website.action.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.soullleo.html.KeepStructureHTMLParser;
import com.soullleo.website.domain.Blog;
import com.soullleo.website.util.DomainConstants;

/**
 * @author Soul
 * @date 2011-11-21
 */
public class BlogActions extends BaseUserAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3616529175937911669L;
	
	private Log log = LogFactory.getLog(BlogActions.class);
	private volatile Blog blog;
	private Long blogId;
	
	public String doEditAction(){

		if(blogId != null)
			this.blog = (Blog) this.getBaseService().loadById(Blog.class, blogId);
		return DONE;
	}

	public String doSaveAction(){
		if(blog != null){
			blog.setStatus(DomainConstants.STATUS_EFFECTIVE);
			blog.setAuthor(getLoginAccount());
			blog.setSummary(KeepStructureHTMLParser.parse(blog.getContent()));
			blog.setUpdateTime(new Date());
			getBaseService().saveOrUpdate(blog);
		}
		return SUCCESS;
	}
	
	public String doViewAction(){
		//log.info("================= do view Action ==================");

		if(blogId != null)
			this.blog = (Blog) this.getBaseService().loadById(Blog.class, blogId);
		return SUCCESS;
	}
	
	public String doTitleListAction(){
		return "done";
	}
	
	public List<?> getBlogs(){
		HashMap<String, Object> criterion = new HashMap<String, Object>();
		criterion.put(DomainConstants.BLOG_STATUS, DomainConstants.STATUS_EFFECTIVE);
		return getBaseService().findByCriterion(Blog.class, criterion);
	}
	
	
	
	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		
		this.blogId = blogId;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}
