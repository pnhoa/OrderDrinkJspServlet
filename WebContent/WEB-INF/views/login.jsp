<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style > 
		
.login{
	color: 	#008000;
}
.reg{
	 font-style: italic;
	 text-decoration:underline;
	 font-size: 20px;
}
.containerLogin {
  width: 200px;
  height: 300px;
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
.bottomSignUp{
  background-color: lightblue;
  border: 50px;
  padding top: 10px;
}
	
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<div class="containerLogin">
		<h1 class="login">Login</h1><br>
		<form action="${pageContext.request.contextPath}/login" 
		 method="post" >
			<div style="color: red">${errorMessage}</div>
			<label for="Username"><b>Username</b></label><br>
			<input type ="text" name="username" placeholder="Username" required class="boderText"> <br><br>
			<label for="Password"><b>Password</b></label><br>
			<input type ="password" name="password" placeholder="Password" required class="boderText">  <br><br>
			<input type="submit" value="Login"><br>
		</form>
		<a href="${pageContext.request.contextPath}/register" class="reg">Register</a> if you haven't account
		<br>
	</div>

	<jsp:include page="footer.jsp"></jsp:include> <br>
</body>
</html>