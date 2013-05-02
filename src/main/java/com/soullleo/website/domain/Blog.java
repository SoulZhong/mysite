/**
 * 
 */
package com.soullleo.website.domain;

import java.util.Date;
import java.util.List;

/**
 * @author Soul
 * @date 2011-11-22
 */
public class Blog {
	
	private long id;
	private String title;
	private String keyWords;
	private String content;
	private String summary;
	private String tags;
	private Account author;
	private Date createTime;
	private Date updateTime;	
	private String status;
	private List<Comment> comments;
	
	public Blog(){
		this.createTime = new Date();
	}
	public Blog(String title, String keyWords, String content,
			String tags, Account author){
		this.title = title;
		this.keyWords = keyWords;
		this.content = content;
		this.tags = tags;
		this.author = author;
		this.createTime = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Account getAuthor() {
		return author;
	}

	public void setAuthor(Account author) {
		this.author = author;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

}
