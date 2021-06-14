<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style > 
		
.register{
	color: 	#008000;
}

.containerRegister {
  width: 200px;
  height: 350px;
   padding: 75px;
   border: 1px solid black;
   margin-top: 25px;
   margin-bottom: 50px;
   margin-left: 500px;
   background: antiquewhite;
}

.boderText{
  border: 1px solid black;
  padding: 7px;
}
.boderText1{
  padding: 100px;
}

	
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include> <br>
	<div class="containerRegister">
		<h1 class="register">Register</h1>
        <form action="${pageContext.request.contextPath}/register" 
	    method="post" >
			<div style="color: red">${errorMessage}</div>
			<label for="Name"><b>Name</b></label><br>
			<input type ="text" name="username" placeholder="Name" required class="boderText"> <br>
			<label for="Email"><b>Email</b></label><br>
			<input type ="email" name="email" placeholder="Email" required class="boderText"> <br>
			<label for="Phone"><b>Phone</b></label><br>
			<input type ="text" name="phone" placeholder="Phone" required class="boderText"> <br>
			<label for="Address"><b>Address</b></label><br>
			<input type ="text" name="address" placeholder="Address" required class="boderText"> <br>
			<label for="Password"><b>Password</b></label><br>
			<input type ="password" name="password" placeholder="Password" required class="boderText">  <br>
		   	<br>
			<input type="submit" value="Register">
		</form>
	</div>

	<jsp:include page="footer.jsp"></jsp:include> <br>
</body>
</html>