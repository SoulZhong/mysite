/**
 * 
 */
package com.soullleo.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class Description      
 *                            
 * @version  V1.0         
 * @Date     2010-10-12         
 * @author   E019481          
 * @Comment  Created    
 */
public class DateUtil {
	
	public static String DATE_FORMAT_1 = "yyyy/MM/dd hh:mm";
	public static String DATE_FORMAT_2 = "yyyy/MM/dd hh:mm:ss";
	public static String DATE_FORMAT_3 = "yyyy/MM/dd";
	
	public static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat formatDateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat formatDateAndTime2 = new SimpleDateFormat("yyyyMMddHHmmss");
	public static SimpleDateFormat formatDateAndTime3 = new SimpleDateFormat("yyyyMMdd_HHmmss");
	public static SimpleDateFormat formatTime = new  SimpleDateFormat("HH:mm:ss");
	public static SimpleDateFormat formatMonth = new SimpleDateFormat("yyyy-MM");
	public static final double MillisecondAnHour = 3600000000.0;
	public static final long MillisecondAMinite = 60000000;
	
	public static int getHour(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	public static double calculateTimePeriod(Calendar cal1, Calendar cal2){
		cal1.set(Calendar.YEAR, 0);
		cal1.set(Calendar.MONTH, 0);
		cal1.set(Calendar.DAY_OF_MONTH, 0);

		cal2.set(Calendar.YEAR, 0);
		cal2.set(Calendar.MONTH, 0);
		cal2.set(Calendar.DAY_OF_MONTH, 0);
		
		return (cal2.getTimeInMillis() - cal1.getTimeInMillis())/MillisecondAnHour;
	}
	
	public static double calculateMinitesTimePeriodBy(Date date1, Date date2){
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		cal1.set(Calendar.YEAR, 0);
		cal1.set(Calendar.MONTH, 0);
		cal1.set(Calendar.DAY_OF_MONTH, 0);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		cal2.set(Calendar.YEAR, 0);
		cal2.set(Calendar.MONTH, 0);
		cal2.set(Calendar.DAY_OF_MONTH, 0);
		
		//System.out.println("cal2.getTimeInMillis() = " + cal2.getTimeInMillis());
		//System.out.println("cal1.getTimeInMillis() = " + cal1.getTimeInMillis());
		//System.out.println("(cal2.getTimeInMillis() - cal1.getTimeInMillis()) = " + (cal2.getTimeInMillis() - cal1.getTimeInMillis()));
		return (cal1.getTimeInMillis() - cal2.getTimeInMillis())/MillisecondAMinite;
	}
	
	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return date1 == date2 return 0; date1 < date2 return < 0; date1 > date2 return >0.
	 */
	
	public static int compareTime(Date date1, Date date2){
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		
		int result = cal1.get(Calendar.HOUR_OF_DAY) - cal2.get(Calendar.HOUR_OF_DAY);
		
		if(result == 0){
			result = cal1.get(Calendar.MINUTE) - cal2.get(Calendar.MINUTE);
			if(result == 0){
				result = cal1.get(Calendar.SECOND) - cal1.get(Calendar.SECOND);
			}
		}
		
		return result;
		
	}
	
	public static Date getStartTimeOfMonth(Date aDateInMonth){
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(aDateInMonth);
		cal.get(Calendar.MONTH);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
		return cal.getTime();
	}
	public static Date getStartTimeOfNextMonth(Date aDateInMonth){
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(aDateInMonth);
		cal.get(Calendar.MONTH);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, 1, 0, 0, 0);
		return cal.getTime();
	}
	/**
	 * @param currentDate: The standard date
	 * @param offset: The offset days, positive "+" means after currentDate, negative "-" means before currentDate 
	 * @return Date
	 */
	public static Date getDateByOffset(Date currentDate,int offset){
		//TODO return the Date according to standard date and offset
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.DATE,offset);
		return cal.getTime();
	}
	
	public static Date get7DaysAgo(Date currentDay){
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDay);
		cal.add(Calendar.DATE,-7);
		return cal.getTime();
	}
	
	public static Date getPreviousDay(Date currentDay){
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(currentDay);
		cal.add(Calendar.DATE,-1);
		return cal.getTime();
	}

	public static Date getNextDate(Date currentDate){
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.DATE,1);
		return cal.getTime();
	}
}
