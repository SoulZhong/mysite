
<#if p != 1>
  <a href="?p=${p - 1}&c=${c}">上一页</a>
</#if>
<#assign unit=10 />
<#assign a=(p - p%unit)/unit />
<#assign totalPage=(total/c + 1) />
  <#list 1..totalPage as num >
 	<#if num == p>
  		- <a href="?p=${num}&c=${c}"><B>${num}</B></a>
  	<#else>
  		- <a href="?p=${num}&c=${c}">${num}</a>
  	</#if>
  </#list>
  <a href="?p=${p + 1}&c=${c}">下一页</a>