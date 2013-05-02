/**
 * 
 */
package com.soullleo.website.domain;

import java.util.Date;

/**
 * @author Soul
 * @date 2012-3-18
 */
public class Favorite {
	
	private Long id;
	private String name;
	private String description;
	private String url;
	private Date createTime;
	private Boolean effective;
	
	public Favorite(){
		this.createTime = new Date();
		this.effective = true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Boolean getEffective() {
		return effective;
	}
	public void setEffective(Boolean effective) {
		this.effective = effective;
	}

}
