/**
 * For NTO HCS system
 * Created by Soul
 * 
 */

/**
 * 
 * @param action
 * @param formId
 */

function doSubmit(formAction, formId, buttonId){
	if(confirm($F(buttonId) + " now?")){
			var form=document.getElementById(formId);		
			form.action=formAction;
			form.submit();
	}
}

function doSignOff_handbookForm(formAction, formId, actionName, actionId){
	if(confirm(actionName + " now?")){
		if(actionName == "Reject" && $F("remark") == ""){
			alert("Please input the remark!");
			return;
		}else{
			var form=document.getElementById(formId);		
			form.action=formAction+"?actionName="+actionName+"&actionId="+actionId;
			form.submit();
		}
	}
}

function doSubmit_handbookForm(id, formAction, formId, actionName, actionId, currentStatus){

	if(confirm($F(actionName) + " now?")){
		if(actionName=="Submit"){	
			
			if("Revise" == $F("handbookForm.caseType")){
				var url="../ajax/HandbookForm_validateSubmit.action?id="+id;
				validateSubmit_handbookForm(id, formId, formAction, actionId, actionName, url);	
			}else{
				
				if("" == $F("handbookForm.name")){
					alert("Please fill the name!");
				}else if("" == $F("handbookForm.product.id") || null == $F("handbookForm.product.id") ){

					alert("There is no product belong to the technology, Please contact the system administrator!");
				}else{
						
					var url="../ajax/HandbookForm_validateSubmit.action?id="+id
					+"&name="+$F("handbookForm.name")
					+"&productId="+$F("handbookForm.product.id");
					validateSubmit_handbookForm(id, formId, formAction, actionId, actionName, url);	
				}
				
			}
		} 
	}
}

function validateSubmit_handbookForm(id, formId, formAction, actionId, actionName, url){
	createXMLHttpRequest();
		
	xmlHttp.open("POST",url,true);
	xmlHttp.onreadystatechange = function() {
	      if(xmlHttp.readyState == 4) {
	        var result=xmlHttp.responseText;
	        
	        if(result.indexOf("Warning")>-1){
	        	
	        	alert(result);
	    		
	        }else{
	        	
	    		var form = document.getElementById(formId);
	    		form.action = formAction + "?actionId=" + actionId + "&actionName=" + actionName;		
	    		form.submit();
				
	        }
	      }
	};
	
	xmlHttp.send(null);
}

/**
 * 
 * @param id
 * @param formAction
 * @param formId
 * @param buttenValue
 * @param actionId
 * @param actionName
 * @param currentStatus
 */

function doSignOff(id, formAction, formId, actionName, actionId, currentStatus){
	
	if(confirm($F(actionName) + " now?")){
		
		if(actionName=="Approve"){
			if( currentStatus == "Co-SignOff"){
				validateApprove(id, formId, formAction, actionId, actionName);				
			}else{
	    		var form = document.getElementById(formId);
	    		form.action = formAction + "?actionId=" + actionId + "&actionName=" + actionName;		
	    		form.submit();
			}
		}else if(actionName=="Submit"){
			if($F("checklistForm.product") == "" || $F("checklistForm.product") == null){
				alert("Please select a product! If there is no product belong to the technology, Please contact the system administrator!");
			}else{
				validateSubmit(id, formId, formAction, actionId, actionName);
			}
		}else if(actionName=="Reject"){
			if($F("remark") == ""){
				alert("Please input the remark!");
				return;
			}else{
	    		var form = document.getElementById(formId);
	    		form.action = formAction + "?actionId=" + actionId + "&actionName=" + actionName;		
	    		form.submit();
			}
			
		}else{

    		var form = document.getElementById(formId);
    		form.action = formAction + "?actionId=" + actionId + "&actionName=" + actionName;		
    		form.submit();
		}
	}
	
}

function validateSubmit(id, formId, formAction, actionId, actionName){
	createXMLHttpRequest();
	var url="../ajax/ChecklistForm_validateSubmit.action?"
		+ "id="+id;
	
	xmlHttp.open("POST",url,true);
	xmlHttp.onreadystatechange = function() {
	      if(xmlHttp.readyState == 4) {
	        var result=xmlHttp.responseText;
	        
	        if(result.indexOf("Warning")>-1){
	        	
	        	alert(result);
	    		
	        }else{
	        	
	    		var form = document.getElementById(formId);
	    		form.action = formAction + "?actionId=" + actionId + "&actionName=" + actionName;		
	    		form.submit();
				
	        }
	      }
	};
	
	xmlHttp.send(null);
}

function validateApprove(id, formId, formAction, actionId, actionName){
	
		createXMLHttpRequest();
		var url="../ajax/ChecklistForm_validateAllFinish.action?"
			+ "id="+id;
		
		xmlHttp.open("POST",url,true);
		xmlHttp.onreadystatechange = function() {
		      if(xmlHttp.readyState == 4) {
		        var result=xmlHttp.responseText;

		        if(result.indexOf("SUCCESS")>-1){

		    		var form = document.getElementById(formId);
		    		form.action = formAction + "?actionId=" + actionId + "&actionName=" + actionName;		
		    		form.submit();
		    		
		        }else{
		        	alert("Please finish all check item before Approve!");
					
		        }
		      }
		};
		
		xmlHttp.send(null);
		
}

