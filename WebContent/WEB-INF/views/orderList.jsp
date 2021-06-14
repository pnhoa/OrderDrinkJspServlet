<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order List</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include> <br>
	<h1> Order List</h1>
	<table border="1">
		<tr>
			<th>Order_id</th>
			<th>Drinks</th>
			<th>Username</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Address</th>
			<th>The total amount</th>
			<th>Comment</th>
			<th>Date</th>
		</tr>
		<c:forEach items="${orderViewList}" var= "order">
			<tr>
				<td>${order.order_id}</td>
				<td>${order.drink_name}</td>
				<td>${order.username}</td>
				<td>${order.email}</td> 
				<td>${order.phone}</td>
				<td>${order.address}</td>
				<td>${order.total} VNĐ</td>
				<td>${order.comment}</td>
				<td>${order.order_date}</td>
			</tr>
		</c:forEach>
	
	</table>
	<jsp:include page="footer.jsp"></jsp:include> <br>
</body>
</html>