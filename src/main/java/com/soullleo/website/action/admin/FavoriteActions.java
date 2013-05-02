/**
 * 
 */
package com.soullleo.website.action.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soullleo.website.domain.Favorite;

/**
 * @author Soul
 * @date 2012-3-21
 */
public class FavoriteActions extends BaseAdminAction {
	
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

	public Favorite getFavorite() {
		return favorite;
	}

	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
	}

}
