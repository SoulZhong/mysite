/**
 * By Soul Since 2011-01-21
 * 
 * Common functions
 */

	function createXMLHttpRequest(){
		if(window.ActiveXObject){
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}else if(window.XMLHttpRequest){
			xmlHttp = new XMLHttpRequest();
		}
	}
	
	function trimToUpper(id){
		var str1 = $F(id);
		$(id).value = trim(str1).toUpperCase();
	}
	
function getDateTime(){
	var date = new Date(); //日期对象
	var now = "";
	now = date.getFullYear()+"-"; //读英文就行了
	now = now + (date.getMonth()+1)+"-";//取月的时候取的是当前月-1如果想取当前月+1就可以了
	now = now + date.getDate()+" ";
	now = now + date.getHours()+":";
	now = now + date.getMinutes()+":";
	now = now + date.getSeconds()+"";
	return now;
}
 
 /**  
 * 对Date的扩展，将 Date 转化为指定格式的String  
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符  
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)  
 * eg:  
 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423  
 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04  
 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04  
 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04  
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18  
 */  
Date.prototype.pattern=function(fmt) {   
    var o = {   
    "M+" : this.getMonth()+1, //月份   
    "d+" : this.getDate(), //日   
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时   
    "H+" : this.getHours(), //小时   
    "m+" : this.getMinutes(), //分   
    "s+" : this.getSeconds(), //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S" : this.getMilliseconds() //毫秒   
    };   
    var week = {   
    "0" : "\u65e5",   
    "1" : "\u4e00",   
    "2" : "\u4e8c",   
    "3" : "\u4e09",   
    "4" : "\u56db",   
    "5" : "\u4e94",   
    "6" : "\u516d"  
    };   
    if(/(y+)/.test(fmt)){   
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
    }   
    if(/(E+)/.test(fmt)){   
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);   
    }   
    for(var k in o){   
        if(new RegExp("("+ k +")").test(fmt)){   
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
        }   
    }   
    return fmt;   
}  
/**
 *功能: 1)去除字符串前后所有空格 
 *		2)去除字符串中所有空格(包括中间空格,需要设置第2个参数为:g) 
 *
 */
function trim(str) { 
	return str.replace(/\s/g,""); 
} 
/**
 * 去除两边空格
 * @param strIn
 * @returns
 */
function trimLR(strIn) { 
	return strIn.replace(/(^\s*)|(\s*$)/g, ""); 
}  
/**
 * 去除左边空格
 * @param strIn
 * @returns
 */
function lTrim(strIn) {
	return strIn.replace(/(^\s*)/g, "");
}  
/**
 * 去除右边空格
 * @param strIn
 * @returns
 */

function rTrim(strIn) { 
	return strIn.replace(/(\s*$)/g, ""); 
}  

/**
 * 
 * @param action like Technology_delete.action?technology.id=1232
 * @param actionType "delete","update"
 * @param windowType "_self","_blank"
 */
function doAction(action, actionType, windowType){
	var noticeMsg;
	if(actionType=="delete"){
		noticeMsg="Are you sure to delelte?";
	}else if(actionType="update"){
		noticeMsg="Are you sure to update?";
	}else{
		noticeMsg="Are you sure to do the action?";
	}
	
	if(confirm(noticeMsg)){
		window.open(action, windowType);
	}
}

/**
 * For validating permission of operate data since 2010-06-04
 * @param action
 * @param site
 * @param formId
 * @returns
 */

function permission_validate(action,site,formId){

  var form = document.getElementById(formId);
//  var loginUser = document.getElementById("loginUser").value;
//  var siteOfCurrentUser = document.getElementById("siteOfCurrentUser").value;
  
//  if(location != siteOfCurrentUser){
//  	alert("No permission! The data belongs to " + location +".");
 // 	return;
//  }
  
  if(!confirm("Are you sure to do the action?")){
  	return;
  }
  
  form.action = action;
  form.submit();
}


