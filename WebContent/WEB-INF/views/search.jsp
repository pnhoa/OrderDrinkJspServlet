<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
<style >
.content{
	margin-bottom: 340px;
    padding: 20px;
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include> <br>
<div class="content">
 		<h1> Search</h1>
        <form action="${pageContext.request.contextPath}/search" method="post">
			<input type="text" name="textSearch">
			<input type="submit" value="Search">
 		</form>
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
		    </tr>
		</c:forEach>
	</table>
</div>

	<jsp:include page="footer.jsp"></jsp:include> <br>
</body>
</html>