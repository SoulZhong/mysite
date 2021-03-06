/**
 * 
 */
package com.soullleo.website.action.user;

import java.util.List;

import com.soullleo.website.domain.Account;
import com.soullleo.website.domain.Message;
import com.soullleo.website.util.CheatDetector;
import com.soullleo.website.util.DomainConstants;

/**
 * @author Soul
 * @date 2011-11-19
 */
public class MessageActions extends BaseUserAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1820684907286409755L;
	
	private Message message;
	private String username;
	private String email;

	public String doCreateAction(){
		Account loginAccount = super.getLoginAccount();
		if(loginAccount != null){
			message.setAccount(loginAccount);
		}else{
			message.setAccount(new Account(DomainConstants.ROLE_GUEST, username, email, getClientIp()));
		}
		
		System.out.println("message.getValue()>>>>>>>>>>>>>>"+message.getValue());
		System.out.println("containLink>>>>>>>>>>>>>>>>>>>>>"+CheatDetector.containLink(message.getValue()));
		if(CheatDetector.containLink(message.getValue())){
			return "noPermission";
		}
		
		getBaseService().create(message);
		return SUCCESS;
	}
	
	public List getMessages(){
		return getBaseService().findAll(Message.class);
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
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
}
