/**
 * 
 */
package com.soullleo.util;

import java.util.List;

/**
 * Class Description      
 *                            
 * @version  V1.0         
 * @Date     2010-9-13         
 * @author   E019481          
 * @Comment  Created
 */

public class SQLUtil {
	
	public static  String arrayToString(String[] array){
		if(array == null || array.length == 0){
			return "";
		}else{
			String result = "'" + array[0] + "'";
			for(int i = 1; i < array.length; i++){
				result += ",'" + array[i] + "'";
			}
			return result;
		}
	}
	
	public static String addEqSqlCondition(String sql, String field, Object value, List<Object>parameters) {
        parameters.add(value);
        return sql + " and " + field + " = ?";
    }

	public static String addLikeSqlCondition(String sql, String field, String value, List<Object>parameters) {
        parameters.add(value);
        return sql + " and " + field + " like ?";
    }

	public static String addGtSqlCondition(String sql, String field, Object value, List<Object>parameters) {
        parameters.add(value);
        return sql + " and " + field + " > ?";
    }

	public static String addLtSqlCondition(String sql, String field, Object value, List<Object>parameters) {
        parameters.add(value);
        return sql + " and " + field + " < ?";
    }
	
	public static String addGtEqSqlCondition(String sql, String field, Object value, List<Object>parameters) {
        parameters.add(value);
        return sql + " and " + field + " >= ?";
    }

	public static String addLtEqSqlCondition(String sql, String field, Object value, List<Object>parameters) {
        parameters.add(value);
        return sql + " and " + field + " <= ?";
    }
}
