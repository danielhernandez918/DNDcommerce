<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/script/script.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DND Miniatures</title>
</head>
<body>
	<div class="container">
		<div class="banner">
			<div class="d-flex justify-content-between align-items-center">
				<h1 > <a class="noLine elden" href="/" > DND Miniatures</a></h1>
				<c:choose>
					<c:when test = "${userId == null}">
						<h5 class="d-flex">
							<a class="mx-2 noLine white" href="/wishlist"> WishList</a>
							<a class="mx-2 noLine white" href="/cart"> Cart</a>
							<a class="mx-2 noLine white" href="/login"> Register/Login</a>
						</h5>
					</c:when>
					<c:otherwise>
						<h5 class="d-flex">
							<a class="mx-2 noLine white" href="/wishlist"> WishList</a>
							<a class="mx-2 noLine white" href="/cart"> Cart</a>
							<a class="mx-2 noLine white" href="/account"> Account</a>
							<a class="mx-2 noLine white" href="/logout"> Logout</a>
						</h5>	
					</c:otherwise>
				</c:choose>
			</div>
			<div class="search">
				<form action="/search" method="GET" >
					<input type="text" name="name" placeholder="Search">
					<input type ="submit" value="Search">
				</form>
			</div>
		</div>
		<div class="bar">
			<a class="white" href="/sets"> Sets</a>
			<a class="white" href="/individuals"> Individuals</a>
			<a class="white" href="/largeMonsters"> Large Monsters</a>
			<a class="white" href="/dice"> Dice</a>
			<a class="white" href="/dice"> Etc</a>
		</div>
		<h1>User Name: ${user.userName}</h1>
		<h1>Email: ${user.email}</h1>
		<h4 class="left"><a class="mx-2 noLine" href="/logout">Logout?</a></h4>
	</div>
<body>
</html>