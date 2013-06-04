/**
 * 
 */
package com.soullleo.weibo;

import weibo4j.Timeline;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;

/**
 * @author SoulLina
 * 
 */
public class TimelineOperator {

	public boolean updateStatus(String access_token, String statuses) {
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		try {
			Status status = tm.UpdateStatus(statuses);
			Log.logInfo(status.toString());
			return true;
		} catch (WeiboException e) {
			e.printStackTrace();
			return false;
		}
	}

}
