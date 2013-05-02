<#assign actionErrors = stack.findValue("actionErrors")?if_exists/>
<#if actionErrors?has_content>
<div class="errorBox">
<div class="errorMessage">
	<p><strong>${action.getText("errors.occurred")}</strong></p>
	<p>
		<ul>
	    	<#list actionErrors as error>
	    	<li>${action.getText(error)}</li>
	    	</#list>
	    </ul>
	</p>
</div>
</div>
</#if>