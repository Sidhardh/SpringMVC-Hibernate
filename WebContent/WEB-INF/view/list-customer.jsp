<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<title>List Customers</title>
<link type="text/css" 
	rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
<body>


	<div id="wrapper">
		<div id="header">
			<h3>CRM- Customer Relationship Management</h3>
			
		</div>

		<div id="container">
			<div id="content">
			<!-- put button -->
			<form:form action="search" method="GET">
				<input type="text" name="theSearchName" placeholder="Search Name..."/>
				 <input type="submit" value="Search" class="add-button" />
			</form:form>
			
			
			<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"></input>
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>

					</tr>
					<c:forEach var="tempCustomer" items="${customers}">
						
						<!-- Update link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
						
						<!-- Delete link with customer id -->
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
						 
						
						<tr>
							<td>${tempCustomer.firstName }</td>
							<td>${tempCustomer.lastName }</td>
							<td>${tempCustomer.email }</td>
							<td><a href="${updateLink }">Update</a> | 
							<a href="${deleteLink }" onclick="if(!(confirm('Are you sure to delete the Customer?'))) return false">Delete</a></td>

						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>