<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>   
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Wishlist</title>
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
		<div class="d-flex col-12">
			<table class="table ">
				<tr>
					<th class="col-1">Wishlist Products</th>
					<th class="col-1">Price</th>
					<th class="col-1">Actions</th>
				</tr>
				<c:forEach var="w" items="${wish}">
							<tr>
								<td class="col-10">
									<img class="thumbImg" src="${w.item.image}" alt="image of item">
									${w.item.name}
								</td>
								<c:set var="price" >
									<fmt:formatNumber type="number"  minFractionDigits="2" maxFractionDigits="2" value="${w.item.price}"/>
								</c:set>
								<td class="col-1">${price}</td>
								<td class="col-1">
									<div class="d-flex">							
										<form:form action="/cart/add" method="post" modelAttribute="cart">
											<form:hidden path="user" value="${userId}" />
											<form:hidden path="item" value="${w.item.id}" />
											<form:hidden path="quantity" value="1"/>
											<input class="add" type="submit" value="Add">
										</form:form>
										<form:form class="mx-5" action="/wishlist/${w.id}/delete" method="post">
											<input type="hidden" name="_method" value="delete">
											<input class="wishDelete" type="submit" value="Delete">
										</form:form>
									</div>
								</td>
							</tr>
				</c:forEach>
			</table>
		</div>

		<div class="d-flex">
			<div class="">
				<button class="continueShopping"> <a class="noLine" href="/main"> Continue Shopping</button>
			</div>
			<form:form class="mx-5" action="/wishlist/user" method="post">
				<input type="hidden" name="_method" value="delete">
				<input class="wishDelete" type="submit" value="Delete Wishlist">
			</form:form>
		</div>
	</div>
<body>
</html>