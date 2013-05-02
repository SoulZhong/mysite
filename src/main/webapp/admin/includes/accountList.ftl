

<table width="100%" class="sort-table" id="accountTable">
	<thead>
		<tr>
			<th><@s.text name="id"/></th>
			<th><@s.text name="role"/></th>
			<th><@s.text name="username"/></th>
			<th><@s.text name="password"/></th>
			<th><@s.text name="email"/></th>
			<th><@s.text name="sessionId"/></th>
			<th><@s.text name="lastLoginIp"/></th>
			<th><@s.text name="effective"/></th>
		</tr>
	</thead>
	<tbody>
		<#list accountList?if_exists as account>
		<tr>
			<td>${account.id?if_exists}</td>
			<td>${account.role?if_exists}</td>
			<td>${account.username?if_exists}</td>
			<td>${account.password?if_exists}</td>
			<td>${account.email?if_exists}</td>
			<td>${account.sessionId?if_exists}</td>
			<td>${account.lastLoginIp?if_exists}</td>
			<td>${account.effective?if_exists?string}</td>
		</tr>
		</#list>
	</tbody>
</table>

<script type="text/javascript">
	new SortableTable(document.getElementById("accountTable"),
	["Number", "String", "String", "String", "String", "String","Number", "String"]);
</script>