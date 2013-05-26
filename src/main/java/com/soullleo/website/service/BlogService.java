/**
 * 
 */
package com.soullleo.website.service;

import java.util.List;

import com.soullleo.website.domain.Blog;

/**
 * @author Soul
 * @date 2012-3-10
 */
public interface BlogService {

	List<Blog> query(int first, int size);

	long total();

}
