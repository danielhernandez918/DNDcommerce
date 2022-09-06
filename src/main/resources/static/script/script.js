function cartDelete() {
    alert("Your Cart is empty!");
}

function addedToCart() {
    alert("Added to Cart");
}

function addedToWish() {
    alert("Added to Wishlist");
}

function loginFirst() {
	alert("Must login first!")
}

function enlarge(x) {
	x.style.width= "150%";
    x.style.height= "150%";
}

function normal(x) {
	x.style.width= "77%";
    x.style.height= "77%";
}


function scale(element, value) {
    element.style.transform = "scale(" + value +")";
}