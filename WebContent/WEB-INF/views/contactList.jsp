<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact List</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include> <br>
<h1>Contact List</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Message</th>
		</tr>
		<c:forEach items="${contactList}" var= "contact" 
		>
			<tr>
				<td>${contact.contact_id}</td>
				<td>${contact.firstname} </td>
				<td>${contact.lastname}</td>
				<td>${contact.email}</td>
				<td>${contact.message}</td>
				
			</tr>
		</c:forEach>
		
	
	</table>
	<jsp:include page="footer.jsp"></jsp:include> <br>
</body>
</html>