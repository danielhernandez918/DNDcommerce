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
	<title>Project Manager Dashboard</title>
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
		<div class="col-12 itemBox">
			<div class="col-6">
				<img class="itemImage" onmouseover="scale(this,1.5)" onmouseleave="scale(this,1)" src="${item.image}" alt="image of item">
			</div>
			<div class="col-3">
				<p class="bold">${item.name}</p>
				<p>Product# ${item.product}</p>
				<c:set var="price" >
					<fmt:formatNumber type="number"  minFractionDigits="2" maxFractionDigits="2" value="${item.price}"/>
				</c:set>
				<p class="bold">Price: $${price}</p>
				<p>${item.stock} in stock</p>
				<c:choose>
					<c:when test = "${userId != null}">	
						<div class="d-flex align-items-end">
							<form:form action="/cart/add" method="post" modelAttribute="cart">
								<form:hidden path="user" value="${userId}" />
								<form:hidden path="item" value="${item.id}" />
								<form:input class="numInput" type="number" path="quantity"/>
								<input class="numInputAdd" type="submit" value="Add">
							</form:form>
							<form:form action="/wishlist/add" method="post" modelAttribute="wish">
								<form:hidden path="user" value="${userId}" />
								<form:hidden path="item" value="${item.id}" />
								<input class="wish" type="submit" value="Wish">
							</form:form>
						</div>
					</c:when>
					<c:otherwise>
						<div class="d-flex align-items-end">
							<form action="/">
								<input class="numInput" type="number"/>
								<input class="numInputAdd" type="submit" value="Add" onclick="loginFirst()">
							</form>
							<form action="/" >
								<input class="wish" type="submit" value="Wish" onclick="loginFirst()">
							</form>
						</div>
					</c:otherwise>
				</c:choose>							
			</div>
		</div>
		<div class="descriptionBox">
			<p>Manufacturer: ${item.manufacturer}</p>
			<p>Product#: ${item.product}</p>
			<p>Universe: ${item.universe}</p>
			<p>Set: ${item.setName}</p>
			<p>Number: ${item.setNumber}</p>
			<p>Rarity: ${item.rarity}</p>
			<p>Base Size: ${item.base}</p>
			<p>Height: ${item.height}</p>
		</div>
	</div>
<body>
</html>