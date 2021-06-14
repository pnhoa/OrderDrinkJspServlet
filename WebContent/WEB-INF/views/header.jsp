<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	 <html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="resource/images/favicon.ico" />
<link rel="stylesheet" type="text/css" href="resource/css/header.css">
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Ek+Mukta">
<title>5Ý coffee</title>
</head>
<body class="background"> 
<div class="navbar-brand">
  <div class="logo"> 
    <a  href="${pageContext.request.contextPath}/home"><img  src="resource/images/logo5y.jpg" width="60px" height="60px" alt="logo5y"></a>
 	<h1>5Ýcoffee</h1>
 </div>
<div class="wrapper1">
    <nav class="menu">
        <ul class="clearfix">
            <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
            <li>
                <a href="${pageContext.request.contextPath}/menu">Thực đơn<span class="arrow">&#9660;</span></a>
 
                <ul class="sub-menu">
                    <li><a href="${pageContext.request.contextPath}/menuCaPhe">Cà Phê</a></li>
                    <li><a href="${pageContext.request.contextPath}/menuTra">Trà Trái Cây</a></li>
                    <li><a href="${pageContext.request.contextPath}/menuDaXay">Vitamin Đá Xay</a></li>
                    <li><a href="${pageContext.request.contextPath}/menuNuocEp">Nước Trái Cây</a></li>
                    <li><a href="${pageContext.request.contextPath}/menuSuaChua">Sữa Chua</a></li>
                </ul>
            </li>
            <li><a href="${pageContext.request.contextPath}/administration">Quản lý</a></li>
            <li><a href="${pageContext.request.contextPath}/contact">Liên hệ</a></li>
            <li><a href="${pageContext.request.contextPath}/login">Đăng nhập</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
           <li><a href="${pageContext.request.contextPath}/search">Tìm kiếm</a></li>
           <li><a href="${pageContext.request.contextPath}/history">Lịch sử</a></li>
        </ul>
    </nav>
</div>
</div>
</body>
</html>