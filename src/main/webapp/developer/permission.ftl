
<#import "/decorators/includes/macros.ftl" as m>

<table  border="0" cellspacing="0" cellpadding="0" width="100%">
	<tr> <td><div class="app"><h3>Permission Maintain</h3></div></td></tr>
</table>

<div class="app">
	<@s.form name="permissionForm" method="POST" action="permissionCreate">		
		<table border="1" cellspacing="2" cellpadding="3">
			<tr>
				<td></td>
				<td><@s.textfield label="Group Name" name="permission.groupName" required="true"/></td>
			</tr>
			<tr>
				<td></td>
				<td><@s.select label="FabSite" name="permission.fabSite" list="fabSiteList" emptyOption="false"/></td>
			</tr>
			<tr>
				<td></td>
				<td><@s.select label="Role Name" name="permission.roleName" list="roleNameList" emptyOption="false" required="true"/></td>
			</tr>
			<tr>
				<td></td>
				<td><@s.textarea label="Description" name="permission.description"/></td>
			</tr>
			<tr class="b">
				<td colspan="2" class="center"><@s.submit name="submit" value="Save"/></td>
			</tr>		
		</table>																
	</@s.form>
</div>

<table border="1" cellspacing="2" cellpadding="3" width="99%" id="sortableTable">
	<thead>
		<tr class=head2>
			<th>Group Name</th>
			<th>FabSite</th>
			<th>Role Name</th>
			<th>Description</th>
			<th>Group Type</th>
			<th>Update Person</th>
			<th>Update Time</th>
			<th>Action</th>
		</tr>
	</thead>
	
	<tbody>
		<#list permissionList as permission>
				<tr class=odder  onMouseOver="this.style.background='#a1a1a1';" onMouseOut="this.style.background='#eeeeee';">
					<@s.hidden name="permission.id" value="permission.id"/>
					<td>${permission.groupName?if_exists}</td>
					<td>${permission.fabSite?if_exists}</td>
					<td>${permission.roleName?if_exists}</td>
					<td>${permission.description?if_exists}</td>
					<td>${permission.groupType?if_exists}</td>
					<td>${permission.updatePerson?if_exists}</td>
					<#if permission.updateTime?has_content>
						<td>${permission.updateTime?string("yyyy-MM-dd hh:mm:ss")}</td>
					<#else>				
						<td>${permission.updateTime?if_exists}</td>	
					</#if>
					<td><a href="permissionDelete.action?permission.id=${permission.id}">Delete</a></td>
				</tr>
		</#list>
	</tbody>
</table>

<script>
	
	var st0 = new SortableTable(document.getElementById("sortableTable"), ["String" ,"String" ,"String","String","String","String","String"]);
		
	function checkType() {
	
	//alert(document.getElementById("user.userType").value);
	    if(document.getElementById("user.userType").value == "true") {
	        document.getElementById("org").style.display="block";
	        document.getElementById("person").style.display="none";
	        document.getElementById("user.userValue").value = "";
	    }else{
	        document.getElementById("org").style.display="none";
	        document.getElementById("person").style.display="block";
	        document.getElementById("user.userValue").value = "";
	    }
	}
</script>

