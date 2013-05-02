<#assign actionMessages = stack.findValue("actionMessages")?if_exists/>
<#if actionMessages?has_content>
<div class="donemessage">
	<p><strong>${action.getText("messages.occurred")}</strong></p>
	<p>
		<ul>
	    	<#list actionMessages as msg>
	    	<li>${action.getText(msg)}</li>
	    	</#list>
	    </ul>
	</p>
</div>
</#if>
