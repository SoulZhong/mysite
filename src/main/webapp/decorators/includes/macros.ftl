<!-- 
this macro will render a tab item
PARAMETERS:
title		- the text of the link
url 		- the URI to link to
selected	- the nav item will be selected if this link matches request.getServletPath().startsWith(selected)
tooltip		- an optional phrase to be used as the tooltip for the navitem link.
accessKey   - an optional access key
-->
<#macro tabItem title url selected tooltip="" accessKey="">
	<#assign matched = request.servletPath?starts_with(selected)>
	<#if matched><th><#else><td></#if>
	<a href="${url}" title="${tooltip}" accessKey="${accessKey}">${title}</a>
	<#if matched></th><#else></td></#if>
</#macro>


<!--
this macro will render the directory link and a getEmployeeInfo function must be existed in action or base action
    public EmployeeInfo getEmployeeInfo(String employeeNo) {
        EmployeeInfo result = ((EmployeeService) Application.getInstance().getContainer().getComponent(EmployeeService.class)).loadEmployeeInfoById(employeeNo);
        if(result == null) {
            result = new EmployeeInfoImpl(employeeNo);
        }
        return result;
    }
PARAMETERS:
employeeNo
-->

<#macro directoryLink employeeNo>
	<#if employeeNo?has_content>
	<#assign employeeInfo = action.getEmployeeInfo(employeeNo)>
		<#if employeeInfo?has_content>
			<a href="http://ap1hr01:8080/directory/control/empDirDetail?employeeId=${employeeInfo.employeeNo}" target="_blank">${employeeNo} ${employeeInfo.preferredName}</a>
		<#else>
			${employeeNo} ${employeeNo}
		</#if>
	</#if>
</#macro>

<#macro directoryLinkWithoutName employeeNo>
	<#if employeeNo?has_content>
			<a href="http://ap1hr01:8080/directory/control/empDirDetail?employeeId=${employeeNo}" target="_blank">${employeeNo}</a>
	</#if>
</#macro>

<#macro directoryLinkForOrg orgId>
	<#if orgId?has_content>
	<a href="http://ap1hr01:8080/directory/control/search?keyWord=${orgId}" target="_blank">${orgId}</a>
	</#if>
</#macro>


<!--
this macro will render a PaginationSupport index switcher
PARAMETERS:
formName - which form will be submited
-->
<#macro pager formName exportActionName="">
<#assign base = request.contextPath />
<script>
	function paginationSearch(formName, index){
		var formObj = document.forms[formName];
		formObj.reset();
		formObj['paginationSupport.startIndex'].value = index;
		formObj.submit();
	}
</script>
<div align="center">
<#if paginationSupport.previousStartIndexes?has_content>
	<a href="#" onClick="paginationSearch('${formName}', 0);"><img src="${base}/images/icon_first_16.gif" align="absmiddle" alt="First" title="First"/></a> &nbsp;
	<a href="#" onClick="paginationSearch('${formName}', ${paginationSupport.previousIndex});"><img src="${base}/images/icon_previous_16.gif" align="absmiddle" alt="Previous" title="Previous"/></a> &nbsp;
</#if>	
	Displaying ${paginationSupport.startIndex + 1} to ${paginationSupport.endIndex} of ${paginationSupport.totalCount}
<#if paginationSupport.nextStartIndexes?has_content>
	&nbsp; <a href="#" onClick="paginationSearch('${formName}', ${paginationSupport.nextIndex});"><img src="${base}/images/icon_next_16.gif" align="absmiddle" alt="Next" title="Next"/></a>
	&nbsp; <a href="#" onClick="paginationSearch('${formName}', ${paginationSupport.nextStartIndexes?last});"><img src="${base}/images/icon_last_16.gif" align="absmiddle" alt="Last" title="Last"/></a>
</#if>
</div>

<#if exportActionName != "">
<script>
	function paginationExport(formName) {
		var formObj = document.forms[formName];
		formObj.reset();
		//backup old form values
		var actionName = formObj.action;
		var startIndex = formObj['paginationSupport.startIndex'].value;
		var countOnEachPage = formObj['paginationSupport.countOnEachPage'].value;
		
		//submit to export action
		formObj.action = '${exportActionName}';
		formObj['paginationSupport.startIndex'].value = 0;
		formObj['paginationSupport.countOnEachPage'].value = 999999;
		formObj.target = "_blank";
		formObj.submit();
		
		//restore
		formObj.action = actionName;
		formObj['paginationSupport.startIndex'].value = startIndex;
		formObj['paginationSupport.countOnEachPage'].value = countOnEachPage;
		formObj.target = "_self";		
	}
</script>
<div align="center">
	<a href="#" onClick="paginationExport('${formName}');">Export To Excel: <img src="${base}/images/icon_file_excel.png" align="absmiddle"/></a>
</div>
</#if>
</#macro>

<!--
this macro will render an employee no selector
PARAMETERS:
fieldName
callbackName - callback function name, default will call the field filling funtion.
-->
<#macro employeeSelector fieldName callbackName="">
<script type="text/javascript" src="${base}/js/xmlextras.js"></script>
<script>
	var employeeSearchPopup;
	var windowOptions = "directories=no,location=no,width=700,height=500,alwaysRaised=yes,resizable=yes,scrollbars=yes";
	function popupSelector_${fieldName?replace(".", "_")?replace("[","_")?replace("]","_")}() {
		employeeSearchPopup = window.open('${base}/exporthr/index.action', 'employeeSearchPopup', windowOptions);
		employeeSearchPopup.focus();
		<#if callbackName == "">
		callback = function (employeeNo){
			document.getElementById('${fieldName}').value = employeeNo;
			employeeSearchPopup.close();
		};
		<#else>
		callback = function (employeeNo) {
			${callbackName}(employeeNo);
		};
		</#if>
	}
	function checkEmployeeNo(inputField) {
	
		var employeeNo = inputField.value;
	    inputField.value = employeeNo.toUpperCase();		
		if(employeeNo != null && employeeNo.length > 0){
			var xmlHttp = XmlHttp.create();
		   	var async = false;
		   	xmlHttp.open("GET", "${base}/exporthr/checkEmployeeNo.action?employeeNo=" + inputField.value, async);
		    xmlHttp.send(null);
			if(xmlHttp.responseText != null && xmlHttp.responseText == '<success/>'){
				//success
		    }else if(xmlHttp.responseXML != null && xmlHttp.responseXML.getElementsByTagName("success").length > 0){
		    	//success
		    }else{
		    	alert("Can not find an employee with the No. " + employeeNo);
		    	inputField.focus();		    	
		    	inputField.select();
		    }
		}
	}
</script>

<input type="text" name="${fieldName}" id="${fieldName}" size="20" theme="simple" onblur="checkEmployeeNo(this);"/> 
<a href="#" onclick="popupSelector_${fieldName?replace(".", "_")?replace("[","_")?replace("]","_")}();">
	<img src="${base}/images/icon_usergroups_sml.gif" align="absmiddle"/>
</a>

</#macro>


<!--
this macro will render i18n value
PARAMETERS:
key - key in properties files, default as empty string to avoid NPE
-->
<#macro i18n key="">
	${action.getText(key)}
</#macro>

<!--
this macro will render a check box for boolean field and data binding 
PARAMETERS:
fieldName - a boolean field name
-->
<#macro checkBoxBoolean fieldName>
	<#assign value = ("(" + fieldName + ")?default(false)")?eval/>
	<input type="checkbox" <#if value>checked="true"</#if> onclick="javascript:document.getElementById('_${fieldName}_hidden_').value = this.checked ? 'true' : 'false'">
	<input type="hidden" id="_${fieldName}_hidden_" name="${fieldName}" value="${value?string}"/>
</#macro>

<!--
By Soul 2011-03-03
add the param --attachToId
-->
<#macro mainRefreshForm2 actionName attachToId module includeFile spanId width length>

<#assign attachmentList=action.getAttachmentListByAttachToId(attachToId,module)/>
<span id="${spanId}">
  <#include "${includeFile}"/>
</span>
<input type="button" value="Add/Modify" class="button" onClick="javascript:openWindow('${actionName}',${width},${length})"/>
<script language="javascript">
	function openWindow(url,width,height){
	    if (!width) { width = 400; }
	    if (!height){ height = 300; }
	    	    
	    var topPos = screen.height/2-height/2
	    var leftPos = screen.width/2-width/2
	    var win_cfg = "status=no,scrollbars=yes,location=no,resizable=yes,top="+topPos+",left="+leftPos+",width=" + width + ",height=" + height;
	   	var win = window.open(url, "_NEW_WIN_" + window.name,win_cfg);
	    win.focus() ;
	}
	
</script>
</#macro>

<#macro subRefreshForm2 includeFile attachToId module spanId>
	<#assign attachmentList=action.getAttachmentListByAttachToId(attachToId,module)/>
<textarea id="_HIDDEN_TABLE_${spanId}" style="display:none">
	<#include "${includeFile}"/>
</textarea>	

<script>
    window.opener.document.getElementById("${spanId}").innerHTML = document.getElementById("_HIDDEN_TABLE_${spanId}").value;
</script>
</#macro>

<#macro mainRefreshForm actionName includeFile spanId width length>

<span id="${spanId}">
  <#include "${includeFile}"/>
</span>
<input type="button" value="Add/Modify" class="button" onClick="javascript:openWindow('${actionName}',${width},${length})"/>
<script language="javascript">
	function openWindow(url,width,height){
	    if (!width) { width = 400; }
	    if (!height){ height = 300; }
	    	    
	    var topPos = screen.height/2-height/2
	    var leftPos = screen.width/2-width/2
	    var win_cfg = "status=no,scrollbars=yes,location=no,resizable=yes,top="+topPos+",left="+leftPos+",width=" + width + ",height=" + height;
	   	var win = window.open(url, "_NEW_WIN_" + window.name,win_cfg);
	    win.focus() ;
	}
	
</script>
</#macro>

<#macro subRefreshForm includeFile spanId>
<textarea id="_HIDDEN_TABLE_${spanId}" style="display:none">
	<#include "${includeFile}"/>
</textarea>	

<script>
//alert(document.getElementById("_HIDDEN_TABLE_${spanId}").value);
    window.opener.document.getElementById("${spanId}").innerHTML = document.getElementById("_HIDDEN_TABLE_${spanId}").value;
</script>
</#macro>

<#macro directoryList employeeNo>
	<#if employeeNo?has_content>
    	<#assign employeeInfo = action.getEmployeeInfo(employeeNo)>
    	${employeeNo} ${employeeInfo.preferredName} ${employeeInfo.localName}
	</#if>
</#macro>