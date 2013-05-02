<#assign ckeditor=JspTaglibs["http://ckeditor.com"] />
<html>
	<head>
		<link rel="stylesheet" type="text/css"  href="${base}/css/blogStyle.css"/>
		<link type="text/css" rel="stylesheet" href="${base}/ckeditor/_samples/sample.css" />
	</head>
	<body>
		<div class="blogEdit">
			<form action="Blog_save.action" method="post">
				<@s.hidden name="blog.id"/>
					<div>
						<@s.text name="title"/>:<input type="text" name="blog.title" value="${blog?if_exists.title?if_exists}"/>
					</div>
					<div>
						<@s.text name="keyWord"/>:<input type="text" name="blog.keyWords" value="${blog?if_exists.keyWords?if_exists}" />
					</div>
					<div>
						<@s.text name="tag"/>:<input type="text" name="blog.tags" value="${blog?if_exists.tags?if_exists}" />
					</div>
					<textarea cols="80" id="blog.content" name="blog.content" rows="10" >
						${blog?if_exists.content?default('&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using &lt;a href="http://ckeditor.com/"&gt;CKEditor&lt;/a&gt;.&lt;/p&gt;')}					
					</textarea>
					<#if blog?has_content>
						<input type="submit" value="${action.getText('update')}"/>
					<#else>
						<input type="submit" value="${action.getText('submit')}"/>
					</#if>
			</form>
			<@ckeditor.replace  replace="blog.content" basePath="${base}/ckeditor/" />
		</div>
	</body>