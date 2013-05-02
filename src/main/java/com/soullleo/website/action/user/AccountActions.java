/**
 * 
 */
package com.soullleo.website.action.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.soullleo.website.domain.Account;
import com.soullleo.website.util.Constant;
import com.soullleo.website.util.DomainConstants;

/**
 * @author Soul
 * @date 2011-11-28
 */
public class AccountActions extends BaseUserAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4994191793383837672L;
	
	private Account account;
	
	
	public String doRegisterAction(){
		
		getBaseService().create(account);
		
		return SUCCESS;
	}
	
	public String doLoginAction(){
		
		if(account != null && account.getUsername() != null){
			Map<String, Object> criterion = new HashMap<String, Object>();
			criterion.put(DomainConstants.USERNAME, account.getUsername());
			criterion.put(DomainConstants.PASSWORD,account.getPassword());
			List accounts = this.getBaseService().findByCriterion(Account.class, criterion);
			if(accounts == null || accounts.size() == 0){
				addActionMessage("no username or password is incorrect!");
				return INPUT;
			}else{

				ActionContext actionContext = ActionContext.getContext();
				Map<String, Object> session = actionContext.getSession();
				session.put(Constant.LOGIN_ACCOUNT, account);
			}
			
		}else{
			addActionMessage("Please input username!");
		}
		
		return SUCCESS;
	}
	
	
	public List getAccountList(){
		return this.getBaseService().findAll(Account.class);
	}
	
	
	public String doLogoutAction(){
		ActionContext.getContext().getSession().remove(Constant.LOGIN_ACCOUNT);
		
		return SUCCESS;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	

}
