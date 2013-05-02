/**
 * 
 */
package com.soullleo.website.domain;

import java.util.List;

/**
 * @author Soul
 * @date 2011-11-17
 */
public class Account {
	
	private long id;
	private String role;
	private String username;
	private String password;
	private String email;
	private String lastLoginIp;
	private String sessionId;
	private boolean effective;
	
	private List<Comment>comments;
	private List<Message> messages;
	private List<Blog>blogs;
	
	public Account(){}
	public Account(String role, String username){
		this.role = role;
		this.username = username;
	}
	
	public Account(String role, String username, String email, String lastLoginIp) {
		this.role = role;
		this.username = username;
		this.email = email;
		this.lastLoginIp = lastLoginIp;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public boolean isEffective() {
		return effective;
	}
	public void setEffective(boolean effective) {
		this.effective = effective;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Blog> getBlogs() {
		return blogs;
	}
	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	
}
