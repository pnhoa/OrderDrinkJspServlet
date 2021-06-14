<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>History</title>
<style>
.mid{
    margin-left: 300px;
    margin-bottom: 10px;
}
.content{
    margin-left: 300px;
    margin-top: 20px;
    margin-bottom: 300px;
}
</style>
</head>
<body>
 	<jsp:include page="header.jsp"></jsp:include> <br>
	<div class="content">
		<h1 class="mid">History</h1>
		<h4>Dưới đây là lịch sử mua hàng của bạn</h4>
		<table border="1">
		<tr>
				<th>Drinks</th>
				<th>Image</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>The total amount</th>
				<th>Date</th>
		</tr>
		<c:forEach items="${orderHistoryList}" var= "order" >
		<tr class="mid1">
				<td >${order.drink_name}</td>
				<td><img src="${order.image} " width="120px" height="150px"></td>
				<td>${order.price} VNĐ</td>
				<td>${order.quantity}</td>
				<td>${order.total} VNĐ</td>
				<td>${order.order_date}</td>
				
		</tr>
		</c:forEach>
		
	
	</table>
	</div>

	<jsp:include page="footer.jsp"></jsp:include> <br>
</body>
</html>