
	<div id="bg">
	</div>
<#list favorites?if_exists?sort_by("createTime")?reverse as favorite>
	<div>
		<span>${favorite.name?if_exists}</span>
		<span><a href="${favorite.url?if_exists}">${favorite.description?if_exists}</a></span>
	</div>
	
	<div id="pop_${favorite_id}">
	</div>
</#list>