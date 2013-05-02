/**
 * 
 */
package com.soullleo.website.action.admin;

import java.util.List;

import com.soullleo.website.domain.Account;

/**
 * @author Soul
 * @date 2011-11-28
 */
public class AccountActions extends BaseAdminAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4994191793383837672L;
	
	private Account account;
	
	public String doCreateAction(){
		getBaseService().create(account);
		return SUCCESS;
	}
	
	public List getAccountList(){
		return this.getBaseService().findAll(Account.class);
	}
	
	
	public String doLogoutAction(){
		return SUCCESS;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	

}
