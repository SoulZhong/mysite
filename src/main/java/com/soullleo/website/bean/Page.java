/**
 * 
 */
package com.soullleo.website.bean;

import java.util.List;

import com.soullleo.website.domain.Blog;

/**
 * @author Soul
 * @date May 26, 2013
 */
public class Page {

	private int p;
	private int c;
	private List<Blog> blogs;

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

}
