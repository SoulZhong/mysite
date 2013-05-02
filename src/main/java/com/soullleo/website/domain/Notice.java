/**
 * 
 */
package com.soullleo.website.domain;

/**
 * @author SoulLina
 * @date 2011-10-25
 */
public class Notice {
	
	private Long id;
	private String value;
	private String updatePerson;
	private String updateTime;
	private Boolean effective;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getUpdatePerson() {
		return updatePerson;
	}
	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Boolean getEffective() {
		return effective;
	}
	public void setEffective(Boolean effective) {
		this.effective = effective;
	}

}
