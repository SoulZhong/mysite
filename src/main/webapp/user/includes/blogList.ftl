
<#include "page.ftl"/>
  <#list blogs?if_exists?sort_by('createTime')?reverse as blog>
	  	<div id="blog_${blog.id}"></div>
	  	<script type="text/javascript">
	  		$("#blog_${blog.id}").load(
	  			"Blog_load.action",
	  			{"blogId":${blog.id}},
	  			function(){}
	  		);
	  		
	  	</script>
  </#list>
<#include "page.ftl"/>  
