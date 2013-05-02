<div class="app">
	<h3>Unfinished Tasks</h3>
</div>
	<table border="1" cellspacing="2" cellpadding="3" width="100%" id="sortableTable" class="sort-table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Invoker</th>
				<th>Site</th>
				<th>RecDate</th>
				<th>StartTime</th>
				<th>EndTime</th>
				<th>Duration</th>
				<th>Remark</th>
				<th>Statues</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<#list allUnfinishTaskList as taskLog>
			<tr>
				<td>${taskLog.name?if_exists}</td>
				<td>${taskLog.invoker?if_exists}</td>
				<td>${taskLog.site?if_exists}</td>
				<td>${taskLog.recDate?if_exists}</td>
				<td>${taskLog.startTime?if_exists}</td>
				<td>${taskLog.endTime?if_exists}</td>
				<td>${taskLog.duration?if_exists}</td>
				<td>${taskLog.remark?if_exists}</td>
				<td><#if taskLog.endTime?has_content>Finished<#else>Ongoing</#if></td>
				<td><a href="forceCompleteTask.action?taskLog.id=${taskLog.id}">Force complete</a></td>
			</tr>
			</#list>
		</tbody>
	</table>
	<script>
		var st0 = new SortableTable(document.getElementById("sortableTable"), ["String" ,"String" ,"String","String","String","String","String","String","String","String"]);
	
	</script>

