<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<style >
.font{
	 font-size: 15px;
}
.content{
	
	margin-bottom: 300px;
    padding: 20px;
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include> <br>
	<div class="content">
		<h1>Menu 5Ý coffee</h1>
	<div class ="font" >${capheMessage}</div>
	<div class ="font" >${traMessage}</div>
	<div class ="font">${daxayMessage}</div>
	<div class ="font">${nuocepMessage}</div>
	<div class ="font">${suachuaMessage}</div>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Type</th>
			<th>Description</th>
			<th>Price</th>
			<th>Image</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${drinkList}" var= "drink">
			<tr>
				<td>${drink.drink_name}</td>
				<td>${drink.type}</td>
				<td>${drink.description}</td> 
				<td>${drink.price}</td>
				<td><img src="${drink.image} " width="120px" height="150px"> </td>
				<td>
				<button><a href="orderDrink?drink_id=${drink.drink_id}" class ="font">Order</a></button>
					
				</td>
			</tr>
		</c:forEach>
		
	
	</table>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include> <br>
</body>
</html>