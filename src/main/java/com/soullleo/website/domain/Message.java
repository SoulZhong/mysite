/**
 * 
 */
package com.soullleo.website.domain;

import java.util.Date;

/**
 * @author Soul
 * @date 2011-11-18
 */
public class Message {

	private long id;
	private String value;
	private Date updateTime;
	private boolean effective;
	
	private Account account;

	public Message(){
		this.updateTime = new Date();
		this.effective = true;
	}
	public Message(String value, Account account){
		this.value = value;
		this.account = account;
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

	public boolean isEffective() {
		return effective;
	}

	public void setEffective(boolean effective) {
		this.effective = effective;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

		
}
