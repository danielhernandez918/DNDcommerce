<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>   
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cart</title>
	<meta name="description" content="A demo of a payment on Stripe" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" type="text/css" href="/css/style.css">

	<script src="https://js.stripe.com/v3/"></script>
	<script src="https://polyfill.io/v3/polyfill.min.js?version=3.52.1&features=fetch"></script>
	<script src="/script/script.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <style>
        #checkout-form input,
        #checkout-form button {
            display: block;
            margin: 12px;
        }
    </style>

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
			<table class="table subTable">
				<tr>
					<th>Product</th>
					<th>Price</th>
					<th>Qty</th>
					<th>Subtotal</th>
					<th>Actions</th>
				</tr>
				<c:set var="subtotal" value="${0}"/>
				<c:forEach var="c" items="${cart}">
							<tr>
								<td>
									<img class="thumbImg" src="${c.item.image}" alt="image of item">
									${c.item.name}
								</td>
								<c:set var="price"  >
								<fmt:formatNumber type="number"  minFractionDigits="2" maxFractionDigits="2" value="${c.item.price}"/>
								</c:set>
								<td>${price}</td>
								<td>${c.quantity}</td>
								<c:set var="subtotal"  >
								<fmt:formatNumber type="number"  minFractionDigits="2" maxFractionDigits="2" value="${c.quantity * c.item.price}"/>
								</c:set>
								<td>${subtotal}</td>
								<td class="">
									<form:form action="/cart/${c.id}/delete" method="post">
										<input type="hidden" name="_method" value="delete">
										<input class="deleteItemCart" type="submit" value="Delete">
									</form:form>
								</td>
							</tr>
				</c:forEach>
			</table>
			<div class="col-3" >
				<div class="d-flex">
					<p class="sub1 col-6">
						Subtotal<br>
						Tax<br>
						Grand Total
					</p>
					<p class="sub2 col-6">

						$${subtotal}<br>
						<c:set var="tax" value="${subtotal*.09}" />
						<fmt:setLocale value = "en_US"/>
						<fmt:formatNumber value = "${tax}" type = "currency"/>
						<br>
						<c:set var="grand" value="${subtotal+tax}" />
						<fmt:setLocale value = "en_US"/>
						<fmt:formatNumber value = "${grand}" type = "currency"/>
						

					</p>

				</div>
				<form:form action='/charge' method='POST' modelAttribute="order" id='checkout-form'>
						<form:hidden value='${subtotal}' path='subtotal' />
						<form:hidden value='${tax}' path='taxes' />
						<form:hidden value='${grand}' path='amount' />
						<form:hidden path="user" value="${userId}" />
						
						<script 
							src="https://checkout.stripe.com/checkout.js" class="stripe-button"
							<c:set var="amount" value="${grand}"  />
							data-key=${stripePublicKey}
							data-amount=${(amount+.001)*100}
							data-currency=${currency}
							data-name='DND Miniatures'
							data-description='DND Miniatures checkout'
							data-image='https://icon-library.com/images/dnd-icon/dnd-icon-3.jpg'
							data-locale='auto'
							data-zip-code='false'>
						</script>
				</form:form>
			</div>
					

		
		

		</div>

		<div class="d-flex">
			<div class="">
				<button class="continueShopping"> <a class="noLine" href="/main"> Continue Shopping</button>
			</div>
			<div class="mx-5">
				<button class="updateCart"> <a class="noLine" href="/cart"> Update Shopping Cart</button>
			</div>
			<form:form class="" action="/cart/user" method="post">
				<input type="hidden" name="_method" value="delete">
				<input class="wishDelete" type="submit" value="Delete Cart">
			</form:form>
		</div>
	</div>
<body>
</html>