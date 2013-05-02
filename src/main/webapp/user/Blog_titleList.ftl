  
<html>
	<head>
		<link rel="stylesheet" type="text/css"  href="${base}/css/sortabletable.css"/>
		<script type="text/javascript" src="${base}/js/sortabletable.js"></script>
		<style type="text/css">
			.sort-table{
				margin: auto;
			}
		</style>
	</head>
	<body>
		<table class="sort-table" id="blogList">
		  	<thead>
		  		<tr>
		  			<th><@s.text name="title"/></th>
		  			<th><@s.text name="createTime"/></th>
		  			<th><@s.text name="lastUpdateTime"/></th>
		  			<th><@s.text name="author"/></th>
		  		</tr>
		  	</thead>
		  	<tbody>
		  		<#list blogs?if_exists?sort_by('createTime')?reverse as blog>
		  		<tr>
		  			<td><a href="Blog_view.action?blogId=${blog.id}" target="_blank">${blog.title?if_exists}</a></td>
		  			<td>${blog.createTime?if_exists}</td>
		  			<td>${blog.updateTime?if_exists}</td>
		  			<td>${blog.author?if_exists.username?if_exists}</td>
		  		</tr>				  
			  </#list>
		  	</tbody>
		  </table>
		  <script type="text/javascript">
		  	new SortableTable(document.getElementById("blogList"),["String","Number","Number","String"]);
		  </script>
	</body>
</html>
  