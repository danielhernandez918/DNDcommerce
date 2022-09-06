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
				<form action="/search" method="GET">
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
		<div class="imgBanner col-12">
			<div class="col-8">
				<img class="primaryImg" src="https://media.miniaturemarket.com/media/wysiwyg/4-6-2022_Pathfinder-Battles-Miniatures-The-Mwangi-Expanse_Slider_1.jpg" alt="dndPic">
			</div>
			<div class="secondImgs col-3">
				<img class="groupImg" src="https://s.yimg.com/lo/api/res/1.2/AtBOlCG_1M30R6lzgDquYw--/YXBwaWQ9ZWNfaG9yaXpvbnRhbDtoPTQwMDtzcz0xO3c9NDAw/https://i.etsystatic.com/22601771/r/il/ed8d0b/2863153706/il_fullxfull.2863153706_d0cm.jpg.cf.jpg" alt="dndPic">
				<img class="groupImg" src="https://bowandblade.co.uk/wp-content/uploads/2019/08/vox-machina-critical-role-miniatures-steamforged-games.jpg" alt="dndPic">
			</div>
		</div>
		<h3 class="center elden bg-dark">Searched Items</h3>
		<div class="product-grid">
			<c:forEach var="item" items="${items}">
				<div class="col-3 section">
					<div>
						<a href="/item/${item.id}"><img class="smallImg" src="${item.image}" alt="Item image"></a>
					</div>
					<c:set var="price" >
						<fmt:formatNumber type="number"  minFractionDigits="2" maxFractionDigits="2" value="${item.price}"/>
					</c:set>
					<p class="bold smallFont"><c:out value="${item.name}"/><br> Price:$<c:out value="${price}"/> <br> <c:out value="${item.stock}"/> in stock</p>
					<c:choose>
						<c:when test = "${userId != null}">
							<div class="buttons">
								<form:form action="/cart/add/main" method="post" modelAttribute="cart">
									<form:hidden path="user" value="${userId}" />
									<form:hidden path="item" value="${item.id}" />
									<form:hidden path="quantity" value="1"/>
									<input class="add" type="submit" value="Add" onclick="addedToCart()">
								</form:form>
								<form:form action="/wishlist/add/main" method="post" modelAttribute="wish">
									<form:hidden path="user" value="${userId}" />
									<form:hidden path="item" value="${item.id}" />
									<input class="wish" type="submit" value="Wish" onclick="addedToWish()">
								</form:form>
							</div>
						</c:when>
						<c:otherwise>
							<div class="buttons">
								<form action="/">
									<input class="add" type="submit" value="Add" onclick="loginFirst()">
								</form>
								<form action="/" >
									<input class="wish" type="submit" value="Wish" onclick="loginFirst()">
								</form>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</c:forEach>
		</div>
	</div>
<body>
</html>