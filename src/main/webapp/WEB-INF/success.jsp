<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Order Placed!</title>
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
		<h1 class="orderPlaced" >Order Placed!</h1>

		<h2 class="center" >Order Details</h2>

		<div class="orderPlaced">
			<div class="d-flex justify-content-center">
					<h3 class="sub1 col-3">
						Order Number<br>
						Subtotal<br>
						Tax<br>
						Grand Total
					</h3>
					<h3 class="sub2 col-3">
						${order.id}<br>
						$${order.subtotal}<br>
						$${order.taxes}<br>
						$${order.amount}
					</h3>
			</div>
		</div>
	</div>
<body>
</html>