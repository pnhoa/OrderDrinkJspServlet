<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administration</title>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include> <br>
	<h1> Administration</h1>
	<button><a href="${pageContext.request.contextPath}/insertDrink">Add Drink</a></button>
	<button><a href="${pageContext.request.contextPath}/orderList">Order List</a></button>
	<button><a href="${pageContext.request.contextPath}/contactList">Contact List</a> <br></button>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Type</th>
			<th>Description</th>
			<th>Price</th>
			<th>Image</th>
		</tr>
		<c:forEach items="${drinkList}" var= "drink">
			<tr>
				<td>${drink.drink_id}</td>
				<td>${drink.drink_name}</td>
				<td>${drink.type}</td>
				<td>${drink.description}</td> 
				<td>${drink.price}</td>
				<td><img src="${drink.image} " width="120px" height="150px"> </td>
				<td>
				  	<button><a href="deleteDrink?drink_id=${drink.drink_id}" class="font">Delete</a></button>
				  	<button><a href="updateDrink?drink_id=${drink.drink_id}" class="font">Update</a></button>

				</td>
			</tr>
		</c:forEach>
		
	
	</table>
	<jsp:include page="footer.jsp"></jsp:include> <br>
</body>
</html>