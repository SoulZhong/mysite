/**
 * 
 */
package com.soullleo.converters;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * Class Description      
 *                            
 * @version  V1.0         
 * @Date     2011-2-24         
 * @author   E019481          
 * @Comment  Created
 */
public class ConvertToLong extends StrutsTypeConverter {

	/* (non-Javadoc)
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		return Long.valueOf(arg1[0]);
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
