<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login/Register</title>
</head>
<body>
	<div class="container my-2">
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
		<div class="d-flex justify-content-evenly">
			<form:form action="/register" method="post" modelAttribute="newUser">
				<h1>Register</h1>
				<div class="form-group">
					<form:label path="userName"> Name</form:label>
					<form:input path="userName" class="form-control"/>
					<form:errors path="userName" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="email"> Email</form:label>
					<form:input path="email" class="form-control"/>
					<form:errors path="email" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="password"> Password</form:label>
					<form:password path="password" class="form-control"/>
					<form:errors path="password" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="confirm"> Confirm Password</form:label>
					<form:password path="confirm" class="form-control"/>
					<form:errors path="confirm" class="text-danger"/>
				</div>
				<input type="submit" value="Register" class="btn btn-primary"/>
			</form:form>

			<form:form action="/login" method="post" modelAttribute="newLogin">
				<h1>Login</h1>
				<div class="form-group">
					<form:label path="email"> Email</form:label>
					<form:input path="email" class="form-control"/>
					<form:errors path="email" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="password"> Password</form:label>
					<form:password path="password" class="form-control"/>
					<form:errors path="password" class="text-danger"/>
				</div>
				<input type="submit" value="Login" class="btn btn-primary"/>
			</form:form>
		</div>
		
	</div>
	
<body>
</html>