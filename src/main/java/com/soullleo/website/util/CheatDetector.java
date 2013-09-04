/**
 * 
 */
package com.soullleo.website.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Soul
 * @date Sep 4, 2013
 */
public class CheatDetector {

	private static final Pattern aTag_Pattern = Pattern.compile("^.*<a\\s+href=.*$");
	
	public static boolean containLink(String value) {

		if (value == null)
			return false;
		Matcher matcher = aTag_Pattern.matcher(value);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
}
