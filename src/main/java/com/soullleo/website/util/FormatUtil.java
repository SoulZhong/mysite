package com.soullleo.website.util;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FormatUtil {
	
	
  	public static boolean isInteger(String num){
  		try{
  			Integer int1 = Integer.valueOf(num);
  			int1.intValue();
  			return true;
  		}catch(Exception e){
  			return false;
  		}
  	}
  	public static boolean checkChineseChar(String value){
		if(value!=null && !value.equalsIgnoreCase("")){
			for(int i=0;i<value.length();i++){
				if(value.charAt(i)>256){
					return true;
				}
			}
		}
		return false;
  	}
	
	public static List<String>splitStrBySeparator(String src,String separator)
	{
		List<String>subStrs=new ArrayList<String>();
		//subStrs.
		StringTokenizer st=new StringTokenizer(src,separator); 
	    while (st.hasMoreTokens()) 
	    {
	         subStrs.add(st.nextToken());
	    }
		return subStrs;
	}	
	
	
	public static String formatNumber2XX(String number)
	{
		NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumIntegerDigits(2);
		nf.setMinimumIntegerDigits(2);
		int num=Integer.parseInt(number);
		return nf.format(num);
	}
	public static boolean includeChineseChar(String str)
	{
		boolean result=false;
		if(str==null||str.equalsIgnoreCase(""))
		{
			result= false;
		}else
		{
			for(int i=0;i<str.length();i++)
			{
				if(str.charAt(i)>255)
				{
					result=true;
					break;
				}
			}
		}
		return result;
	}
	/*
	 * check if the string is numeric
	 */
	public static boolean isNumeric(String str)
	{
		try{   
			new Double(str).doubleValue();   
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	} 
	public static void print(String objectName,String objectValue)
	{
		//System.out.println("======="+objectName+"="+objectValue+"=======");
	}
	

	public static String preventUserSpecialChar(String str1){
		if(str1!=null){
			if(str1.indexOf("'")>=0){
				return "please donot keyin the single quotes";
			}
		}
		return null; 
	}
	public static String validateBaseDocumentName(String name){
		/*
		 * cannot be empty
		 */
		if(name == null || name.trim().equalsIgnoreCase("")){
			return "Sorry, the name cannot be empty!";
		}
		/*
		 * cannot include chinese char and special char
		 */
		if(checkChineseChar(name)==true){
			return "Sorry, the chinese char cannot be supported!";
		}
		return null;
	}
	public static String getFileType(String name){
		/*
		 * file the last post name.
		 */
		////System.out.println("name="+name);
		if(name==null || name.equalsIgnoreCase("")){
			return null;
		}
		for(int i=name.length()-1;i>0;i--){
			//System.out.println("i="+i);
			if(name.substring(i,i+1).equalsIgnoreCase(".")){
				return name.substring(i+1);
			}
		}
		return null;
	}
	public static String getIPDomain(String ip){
		if(ip==null || ip.equalsIgnoreCase("")==true){
			return ip;
		}else{
			int i = ip.indexOf(".");
			i = ip.indexOf(".",i+1);
			if(i>0){
				return ip.substring(0,i);
			}else{
				return ip;
			}
		}
	}
	
	public static String arrayToSQL(List<String>array){
		if(array==null || array.size()==0){
			return "";
		}else{
			String tmp = "";
			for(int i=0;i<array.size();i++){
				tmp = tmp + "'"+ array.get(i)+"',";
			}
			return tmp.substring(0,tmp.length()-1);
		}
	}
	public static String arrayToSQL(String[] array){
		if(array==null || array.length==0){
			return "";
		}else{
			String tmp = "";
			for(int i=0;i<array.length;i++){
				tmp = tmp + "'"+array[i]+"',";
			}
			return tmp.substring(0,tmp.length()-1);
		}
	}
	public static String arrayToSQL(int[] array){
		if(array==null || array.length==0){
			return "";
		}else{
			String tmp = "";
			for(int i=0;i<array.length;i++){
				tmp = tmp + array[i]+",";
			}
			return tmp.substring(0,tmp.length()-1);
		}
	}
	public static String arrayToSQL(double[] array){
		if(array==null || array.length==0){
			return "";
		}else{
			String tmp = "";
			for(int i=0;i<array.length;i++){
				tmp = tmp + array[i]+",";
			}
			return tmp.substring(0,tmp.length()-1);
		}
	}
	public static String arrayToSQL(long[] array){
		if(array==null || array.length==0){
			return "";
		}else{
			String tmp = "";
			for(int i=0;i<array.length;i++){
				tmp = tmp + array[i]+",";
			}
			return tmp.substring(0,tmp.length()-1);
		}
	}
	public static String arrayToSQL(float[] array){
		if(array==null || array.length==0){
			return "";
		}else{
			String tmp = "";
			for(int i=0;i<array.length;i++){
				tmp = tmp + array[i]+",";
			}
			return tmp.substring(0,tmp.length()-1);
		}
	}
	public static String getPostFileName(String fileName){
		int index = fileName.lastIndexOf(".");
		if(index>=0){
			return fileName.substring(index+1);
		}
		return null;
	}
	
}