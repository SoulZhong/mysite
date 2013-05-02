

<#import "/decorators/includes/macros.ftl" as m>

<table  border="0" cellspacing="0" cellpadding="0" width="100%">
	<tr> <td><div class="app"><h3>User Maintain</h3></div></td></tr>
</table>

<div class="app">
	<@s.form name="user" method="POST" action="userCreate">		
		<table border="1" cellspacing="2" cellpadding="3">
			<tr>
				<td></td>
				<td><@s.select label="Type" name="user.userType" list="userTypeList" onchange="checkType()" required="true"/></td>
			</tr>
			<tr>
				<td></td>
				<td><@s.select label="Permission Group" name="user.permissionId" list="permissionList" listKey="id" listValue="groupName" required="true"/></td>
			</tr>
			<tr id="person" style="display:${(user.userType)?default(false)?string('none','block')}">
				<td>Employee No*:</td>
				<td>
					<@s.textfield label="Employee No" name="employeeNo" theme="simple"/>
				</td>
			</tr>
			<tr id="org" style="display:${(user.userType)?default(false)?string('block','none')}">
				<td>Organization*:</td>
				<td>
					<@s.select name="orgId" list="loadAllOrganizations(false,300)" listKey="orgId" listValue="orgId+': '+orgDesc+' ('+site+')'"  emptyOption="true" theme="simple"/>
					<script>
						var orgFilter = new filterlist(document.getElementById('orgId'));			
					</script>
					Filter: <@s.textfield onblur="orgFilter.set(this.value);" theme="simple"/>
				</td>
			</tr>
			<tr class="b">
				<td colspan="2" class="center"><@s.submit name="submit" value="Save"/></td>
			</tr>		
		</table>																
	</@s.form>
</div>


<table border="1" cellspacing="2" cellpadding="3" width="99%" id="userTable">
	<thead>
		<tr class=head2>
			<th>Group Name</th>
			<th>User Type</th>
			<th>User Value</th>
			<th>Update Person</th>
			<th>Update Time</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<#list allUserList as user>
			<tr class=odder  onMouseOver="this.style.background='#a1a1a1';" onMouseOut="this.style.background='#eeeeee';">
				<#assign groupName = action.getPermissionGroupNameById(user.permissionId?if_exists)/>
				<td>${groupName}</td>
				<td>${user.userType?if_exists}</td>
				<#if user.userType == "ByEmpNo">
					<td><@m.directoryLink user.userValue?if_exists/></td>
				<#else>
					<td><@m.directoryLinkForOrg user.userValue?if_exists/></td>
				</#if>
				<td>${user.updatePerson?if_exists}</td>
				
				<#if user.updateTime?has_content>
					<td>${user.updateTime?string("yyyy-MM-dd hh:mm:ss")}</td>
				<#else>				
					<td>${user.updateTime?if_exists}</td>	
				</#if>
				<td><a href="userDelete.action?user.id=${user.id}">Delete</a></td>
			</tr>	
		</#list>
	</tbody>
</table>

<script>
	
	var st0 = new SortableTable(document.getElementById("userTable"), ["String" ,"String" ,"String","String" ,"String","String"]);
		
	function checkType() {
	
		//alert(document.getElementById("employeeNo").value);
	    
	    if(document.getElementById("user.userType").value == "ByOrgId") {
	        document.getElementById("org").style.display="block";
	        document.getElementById("person").style.display="none";
	        document.getElementById("employeeNo").value="";
	    }else{
	        document.getElementById("org").style.display="none";
	        document.getElementById("person").style.display="block";
	        document.getElementById("orgId").value="";
	    }
	}
</script>

