<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
<style >
.content{
	
	margin-bottom: 30px;
    padding-left: 50px;
}
	
.form{
 
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include> <br>
	<div class= "content">
		<h1 >${drink.drink_name}</h1>
 		<img src="${drink.image}" width="120px" height="150px" alt="drink">
 		<h4>${drink.description}</h4> <br>
  		Giá 1 sản phẩm: <h2>${drink.price} VNĐ</h2>  <br>
  		<form action="${pageContext.request.contextPath}/orderDrink" 
		method="post"  class ="form">
		     <input type ="text" name="drink_id" value="${drink.drink_id}" hidden="true" >  <br>
		     <input type ="text" name="price" value="${drink.price}" hidden="true" > <br>
			 <input type="number" name="quantity" value=1 min="1"  placeholder="Số lượng"> <br> 
			 <input type="text" name ="comment" placeholder="Yêu cầu thêm"> <br>
			 <input type="submit" value="Thanh toán">
		</form>
	</div>

	<jsp:include page="footer.jsp"></jsp:include> <br>
</body>
</html>