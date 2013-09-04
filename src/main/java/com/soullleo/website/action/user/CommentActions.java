/**
 * 
 */
package com.soullleo.website.action.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.soullleo.website.domain.Account;
import com.soullleo.website.domain.Blog;
import com.soullleo.website.domain.Comment;
import com.soullleo.website.util.CheatDetector;
import com.soullleo.website.util.DomainConstants;

/**
 * @author Soul
 * @date 2012-3-17
 */
public class CommentActions extends BaseUserAction {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7122568583983998653L;
	private Blog blog;
	private Comment comment;

	private String username;
	private String email;

	public String doListAction() {

		return "done";
	}

	public String doCreateAction() {

		Account loginAccount = super.getLoginAccount();

		if (loginAccount != null) {
			comment.setAccount(loginAccount);
		} else {
			comment.setAccount(new Account(DomainConstants.ROLE_GUEST,
					username, email, getClientIp()));
		}

		String value = comment.getValue();

		if (CheatDetector.containLink(value)) {
			return "noPermission";
		}

		comment.setAccount(loginAccount);
		getBaseService().saveOrUpdate(comment);
		return SUCCESS;
	}

	

	public List getComments() {
		Map<String, Object> criterion = new HashMap<String, Object>();
		criterion.put("blog", blog);
		return getBaseService().findByCriterion(Comment.class, criterion);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}
