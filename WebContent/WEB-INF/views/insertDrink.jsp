<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Drink</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include> <br>
	<h1> Add new Drink</h1>
	<form action="${pageContext.request.contextPath}/insertDrink" 
	method="post" enctype="multipart/form-data" >
	    <label for="Drinkname"><b>Drinkname</b></label><br>
		<input type ="text" name="drink_name" placeholder=" Name"> <br>
		<label for="Type"><b>Type</b></label><br>
		<input type ="text" name="type" placeholder="Type"> <br>
		<label for="Description"><b>Description</b></label><br>
		<input type ="text" name="description" placeholder="Description"> <br>
		<label for="Price"><b>Price</b></label><br>
		<input type ="text" name="price" placeholder="Price"> <br>
		<label for="Image"><b>Image</b></label><br>
		<input type="file" name="image"> <br> 
		<input type="submit" value="Add">
	</form>
	<br>
	<jsp:include page="footer.jsp"></jsp:include> <br>
</body>
</html>