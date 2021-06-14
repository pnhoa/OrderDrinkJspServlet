<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Drink</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include> <br>
<h1> Update Drink</h1>
	<form action="${pageContext.request.contextPath}/updateDrink" 
	method="post" enctype="multipart/form-data" >
	    <input type ="text" name="drink_id" value="${drink.drink_id}" hidden="true" >  <br>
		<input type ="text" name="drink_name" value="${drink.drink_name}" placeholder=" Name"> <br>
		<input type ="text" name="type" value="${drink.type}" placeholder="Type"> <br>
		<input type ="text" name="description" value="${drink.description}" placeholder="Description"> <br>
		<input type ="text" name="price" value="${drink.price}" placeholder="Price"> <br>
		 <input type="file" name="image" value="${drink.image}"  placeholder="Image"> <br> 
		<input type="submit" value="Update">
	</form>
	<jsp:include page="footer.jsp"></jsp:include> <br>
</body>
</html>