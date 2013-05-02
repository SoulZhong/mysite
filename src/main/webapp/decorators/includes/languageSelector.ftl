    <script type="text/javascript">
	    function langSelecter_onChanged() {
	        document.langForm.submit();
	    }
	</script>
	<@s.set name="SESSION_LOCALE" value="#session['WW_TRANS_I18N_LOCALE']"/>
	
	<form action="<@s.url includeParams="get" encode="true"/>" name="langForm" >
	   	<@s.text name="language"/>: <@s.select label="Language" 
	        list=locales listKey="value" listValue="key"
	        value="#SESSION_LOCALE == null ? locale : #SESSION_LOCALE"
	        name="request_locale" id="langSelecter" 
	        onchange="langSelecter_onChanged();" theme="simple"/>
	</form> 
	