package com.soullleo.website.domain;

import java.util.Date;

public class Comment {

	private long id;
	private String value;
	private Date updateTime;
	private Boolean effective;
	
	private Account account;
	private Blog blog;	

	public Comment() {
		this.updateTime = new Date();
		this.effective = true;		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Boolean getEffective() {
		return effective;
	}

	public void setEffective(Boolean effective) {
		this.effective = effective;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}


}
