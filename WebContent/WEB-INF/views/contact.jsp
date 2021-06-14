<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact</title>
<style > 
		
#menu ul{
  background: pink;
  list-style-type: none;
  text-align: center;
}
#menu li{
  color #f1f1f1;
  display: inline-block;
  width: 200px;
  height: 50px;
  line-height: 50px;
  margin-left: -5px;
}
#menu a{
  text-decoration: none;
  color: black;
  font-family: serif;
  display: block;
}
#menu a:hover{
  background: #f1f1f1;
  color:#333;
}
.container {
   width: 1480px;
   height: 680px;
   border: 0px solid #333;
   padding: 10px;
}
.clear { clear: both }
.container1 {
  float: left;
  width: 580px;
  height: 500px;
   padding: 75px;
   border: 1px solid black;
   /*margin-top: 25px;*/
   margin-bottom: 50px;
}
.container2 {
  float: right;
  width: 580px;
  height: 500px;
   padding: 75px;
   border: 1px solid black;
   text-align: center;
   text-decoration: inherit;
}
.picture{
  text-align: center;
}

.boderText{
  border: 1px solid black;
  padding: 7px;
}
.boderText1{
  padding: 100px;
}
.contact {
  border: 1px solid black;
  margin-top: 100px;
  margin-bottom: 100px;

/*  margin-right: 150px;*/
  margin-left: 600px;
}
.	
</style>
</head>
<body>
   <jsp:include page="header.jsp"></jsp:include>

   <div class="container">
      <div class="container1">
      <form action="${pageContext.request.contextPath}/contact" 
	method="post" >
        <label for="Firstname"><b>Firstname</b></label><br>
        <input type="text" placeholder="Enter Firstname" name="firstname" required class="boderText"><br><br>
        <label for="Lastname"><b>Lastname</b></label><br>
        <input type="text" placeholder="Enter Lastname"name="lastname" required class="boderText"><br><br>
        <label for="Contactemail"><b>Contact Email*</b></label><br>
        <input type="text" placeholder="Enter Email"name="email" required class="boderText"><br>
        <br>
        <label for="Content"><b>Content</b></label><br>
        <input type="text" name="message" placeholder="Message" required class="boderText1"><br>
        <br>
        <input type="submit" value="Send" >
        </form>
      </div>

      <div class="container2">
            <img src="resource/images/logo5y.jpg" alt="logo5ycoffee" width="200" height="200" >
           <h1 class="logo">5Ycoffee</h1>
           <p>Da Nang, VietNam</p>
           <p>02, Be Van Dan street</p>
           <p>+0328521716</p>
           <a href="" target="_blank">namycoffee@gmail.com</a>
      </div>

  </div>

  <jsp:include page="footer.jsp"></jsp:include> <br>
</body>
</html>