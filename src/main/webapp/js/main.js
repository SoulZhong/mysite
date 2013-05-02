var bXmlHttpSupport = (typeof XMLHttpRequest != "undefined" || window.ActiveXObject);
if (typeof XMLHttpRequest == "undefined" && window.ActiveXObject) {
    function XMLHttpRequest() {
        var arrSignatures = ["MSXML2.XMLHTTP.5.0", "MSXML2.XMLHTTP.4.0",
                             "MSXML2.XMLHTTP.3.0", "MSXML2.XMLHTTP",
                             "Microsoft.XMLHTTP"];
                         
        for (var i=0; i < arrSignatures.length; i++) {
            try {        
                var oRequest = new ActiveXObject(arrSignatures[i]);            
                return oRequest;        
            } catch (oError) { /*ignore*/ }
        }          

        throw new Error("MSXML is not installed on your system.");               
    }
}
function showAlert(message){
  var alertWindow = dojo.byId("messageArea");
	alertWindow.innerHTML = message;
	dijit.byId('alertDialog').show();
	document.getElementById("alertButtonOK").focus();
}
function showCurrentSigner(){
	document.getElementById("divShowCurrentSigner").style.display="block";
  document.getElementById("divHideCurrentSigner").style.display="none";
}
function hideCurrentSigner(){
	document.getElementById("divShowCurrentSigner").style.display="none";
  document.getElementById("divHideCurrentSigner").style.display="block";
}
function trim(strIn) {
	strOut = strIn;
	for (var t = 0; t < strIn.length; t++ ) {
		if (  strIn.substring( t, t+1 ) != " " ) {
			break;
		} else { 
			strOut = strIn.substring( t+1, strIn.length); 
		}   
	}
	strIn = strOut;
	for (var t = strIn.length; t > 0; t-- ) {
		if (  strIn.substring( t-1,t ) != " " ) {
			return (strOut); 
		} else { 
			strOut = strIn.substring( 0, t-1); 
		}   
	}
	return (strOut)
}
function checkLength(field,length){
	var fieldValue=field.value;
	if(field.value.length()>length){
		alert("The field's length cannot >"+length);
		field.value=field.value.substring(0,length);
	}
}
function doCheckEmployee(empNo,empDesc){
	if(empNo.value==""){
		empDesc.value="";
		return false;
	}
	empNo.value=empNo.value.toUpperCase();
	empDesc.value="";
	var employeeNo = empNo.value;
	if(employeeNo != null && employeeNo.length > 0){
		var xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		var async = false;
		xmlHttp.open("GET", "checkEmployee.action?empNo="+employeeNo, async);
		xmlHttp.send(null);
		if(xmlHttp.responseText != null){
			var i=xmlHttp.responseText.indexOf("<success>");
			var q=xmlHttp.responseText.indexOf("</success>");
			if(i>=0 && q>0){
				empDesc.value=xmlHttp.responseText.substring(i+9,q);
				empNo.focus();		    	
				empNo.select();
				return true;
			}
		}
		alert("Can not find an employee with the No. " + employeeNo);
  }
}
function removeZero(value){
  if(value.substring(0,1) == "0"){
    return value.substring(1);
  }else{
    return value.substring(0);
  }
}
function retrieveTime() {
  if(bXmlHttpSupport) {
    var sUrl = '../ajax/getRelatedTime.action?lotId='+document.getElementById("main.lotId").value+"&suspectTool="+document.getElementById("main.suspectTool").value;
    var oRequest = new XMLHttpRequest();
    oRequest.onreadystatechange = function() {
      if(oRequest.readyState == 4) {
        dojo.byId("main.eqTrackInTime").value="";
        document.getElementById("main.eqTrackInHour").options.selectedIndex=0;
        document.getElementById("main.eqTrackInMinute").options.selectedIndex=0;
        document.getElementById("main.eqTrackInSecond").options.selectedIndex=0;
        dojo.byId("main.yeInspectionTime").value="";
        document.getElementById("main.yeInspectionHour").options.selectedIndex=0;
        document.getElementById("main.yeInspectionMinute").options.selectedIndex=0;
        document.getElementById("main.yeInspectionSecond").options.selectedIndex=0;
        var result = oRequest.responseText;
        if(result!=""){
          var temp = result.substring(0,result.indexOf(","));
          var time="";
          var hour=0;
          var minute=0;
          var second=0;
          if(temp!=""){
            var i =0;
            var q =0;
            i=temp.indexOf(" ");
            if(i>0){
              //get date
              time = temp.substring(0,i);
              q=i+1;
              i=temp.indexOf(":",q);
              if(i>0){
                //get hour
                hour = parseInt(removeZero(temp.substring(q,i)));
                q=i+1;
                i=temp.indexOf(":",q);
                if(i>0){
                  //get Minute
                  minute = parseInt(removeZero(temp.substring(q,i)));
                  q=i+1;
                  second = parseInt(removeZero(temp.substring(q)));
                }
              }
            }
          }
          dojo.byId("main.eqTrackInTime").value=time;
          //document.getElementById("main.eqTrackInTime").value = time;
          document.getElementById("main.eqTrackInHour").options.selectedIndex=hour;
          document.getElementById("main.eqTrackInMinute").options.selectedIndex=minute;
          document.getElementById("main.eqTrackInSecond").options.selectedIndex=second;
          //get ye inspection time.
          var temp = result.substring(result.indexOf(",")+1);
          if(temp!=""){
            var i =0;
            var q =0;
            i=temp.indexOf(" ");
            if(i>0){
              //get date
              time = temp.substring(0,i);
              q=i+1;
              i=temp.indexOf(":",q);
              if(i>0){
                //get hour
                hour = parseInt(removeZero(temp.substring(q,i)));
                q=i+1;
                i=temp.indexOf(":",q);
                if(i>0){
                  //get Minute
                  minute = parseInt(removeZero(temp.substring(q,i)));
                  q=i+1;
                  second = parseInt(removeZero(temp.substring(q)));
                }
              }
            }
          }
          dojo.byId("main.yeInspectionTime").value=time;
          //document.getElementById("main.yeInspectionTime").value = time;
          document.getElementById("main.yeInspectionHour").options.selectedIndex=hour;
          document.getElementById("main.yeInspectionMinute").options.selectedIndex=minute;
          document.getElementById("main.yeInspectionSecond").options.selectedIndex=second;
        }
      }
    };
    oRequest.open('POST', sUrl);
    oRequest.send(null);
  }
}
function disableAllButtons(){
  var allForms = document.forms;
  for(var i=0;i<allForms.length;i++){
    var allElements = allForms[i].elements;
    for(var q=0;q<allElements.length;q++){
      if(allElements[q].type=="button" || allElements[q].type=="submit"){
        allElements[q].disabled = true;
      }
    }
  }
}
function enableAllButtons(){
  var allForms = document.forms;
  for(var i=0;i<allForms.length;i++){
    var allElements = allForms[i].elements;
    for(var q=0;q<allElements.length;q++){
      if(allElements[q].type=="button"){
        allElements[q].disabled = false;
      }
    }
  }
}
function validation(fieldName){
		var a = document.getElementById(fieldName);
		if(a.value == "" || a.value == null){
			a.focus();
			return false;
		}
		return true;
}
function doGetSuspectTool(){
  disableAllButtons();
  retrieveTime();
  enableAllButtons();
}
function getSignOffDepartmentMember(mainId){
  var assignEmployee = document.getElementById("assignEmployee");
  assignEmployee.options.length=0;
  if(mainId!=""){
    if(bXmlHttpSupport) {
      var sUrl = '../ajax/getSignOffDepartmentMember.action?main.id='+mainId;
      var oRequest = new XMLHttpRequest();
      oRequest.onreadystatechange = function() {
        if(oRequest.readyState == 4) {
          var result = oRequest.responseText;
          if(result!=""){
            var i=0;
    		    while(result.indexOf(";",i)>0){
    		      tmpValue = result.substring(i,result.indexOf(";",i));
    		      if(tmpValue.indexOf(":",1)>0){
                var employeeNo = tmpValue.substring(0,tmpValue.indexOf(":",1));
                var employeeInfo = tmpValue;
                assignEmployee.options.length++;
                assignEmployee.options[assignEmployee.options.length-1].value=employeeNo;
                assignEmployee.options[assignEmployee.options.length-1].text=employeeInfo;
              }
    			    i=result.indexOf(";",i)+1;
            }
          }
        }
      };
      oRequest.open('POST', sUrl);
      oRequest.send(null);
    }
  }
}
