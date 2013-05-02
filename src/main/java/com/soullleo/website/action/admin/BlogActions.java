/**
 * 
 */
package com.soullleo.website.action.admin;

import java.util.List;

import com.soullleo.html.KeepStructureHTMLParser;
import com.soullleo.website.domain.Blog;

/**
 * @author Soul
 * @date 2012-3-15
 */
public class BlogActions extends BaseAdminAction {
	
	public String doUpdateSummaryAction(){
		
		List blogs = getBaseService().findAll(Blog.class);
		
		for(int i = 0; i < blogs.size(); i++){
			
			Blog blog = (Blog) blogs.get(i);
			blog.setSummary(KeepStructureHTMLParser.parse(blog.getContent()));
			
			getBaseService().update(blog);
			
		}
		
		
		return SUCCESS;
	}

}
