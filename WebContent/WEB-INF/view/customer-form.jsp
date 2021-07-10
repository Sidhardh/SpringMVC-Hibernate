<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Save Customers</title>
<link type="text/css" 
	rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
	
	<link type="text/css" 
	rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h3> CRM - Customer Relation Ship Manager</h3>		
	</div>
	<div id="container">
		<h3> Save Customer</h3>
		 <form:form action="saveCustomer" modelAttribute="customer" method="POST">
		 
		<!--  need to associate customer id to form tag -->
		 <form:hidden path="id"/>
		 	<table>
		 	<tbody>
		 		<tr>
		 		<td><label>First Name : </label></td>
		 		<td><form:input path="firstName" /></td>
		 		</tr>
		 		<tr>
		 		<td><label>Last Name : </label></td>
		 		<td><form:input path="lastName" /></td>
		 		</tr>
		 		<tr>
		 		<td><label>Email : </label></td>
		 		<td><form:input path="email" /></td>
		 		</tr>
		 		<tr>
		 		<td><label></label></td>
		 		<td><input type="submit" value="Save Customer" class="save" /></td>
		 		</tr>
		 		
		 	</tbody>
		 	
		 	</table>
		 </form:form>
		 
		 <div style="clear; both;">
		 
		 <p><a href="${pageContext.request.contextPath}/customer/list">Back to List</a></p>
		 
		 </div>
		 
	
	</div>
	
</div>
	
</body>
</html>