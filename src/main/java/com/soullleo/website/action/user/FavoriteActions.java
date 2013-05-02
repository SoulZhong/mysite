/**
 * 
 */
package com.soullleo.website.action.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soullleo.website.domain.Favorite;

/**
 * @author Soul
 * @date 2012-2-22
 */
public class FavoriteActions extends BaseUserAction {
	
	private Favorite favorite;
	
	public String doCreateAction(){
		getBaseService().saveOrUpdate(favorite);
		return SUCCESS;
	}
	

	public List getFavorites(){
		Map<String, Object>criterion = new HashMap<String, Object>();
		criterion.put("effective", true);
		return getBaseService().findByCriterion(Favorite.class, criterion);
	}
}
