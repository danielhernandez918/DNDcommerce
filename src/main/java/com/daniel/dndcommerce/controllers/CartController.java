package com.daniel.dndcommerce.controllers;

import java.util.List;

import javax.naming.Binding;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.daniel.dndcommerce.models.Cart;
import com.daniel.dndcommerce.models.ChargeRequest;
import com.daniel.dndcommerce.models.User;
import com.daniel.dndcommerce.models.Item;
import com.daniel.dndcommerce.models.Order;
import com.daniel.dndcommerce.services.CartService;
import com.daniel.dndcommerce.services.ItemService;
import com.daniel.dndcommerce.services.UserService;

@Controller
public class CartController {
	@Autowired
	CartService cartService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	UserService userService;
	
    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;
	
	
	@GetMapping("/cart")
	public String cartPage(Model model, @ModelAttribute("order") Order order, HttpSession session) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/login";
    	}
		Long userId = (Long) session.getAttribute("userId");
    	List<Cart> cart = cartService.userCart(userId);
    	model.addAttribute("cart", cart);
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.USD);
		return "cart.jsp";
	}
	
	@PostMapping("/cart/add")
	public String cartCreate(@Valid @ModelAttribute("cart") Cart cart, BindingResult result ) {
		cartService.addToCart(cart);
		return "redirect:/cart";
	}
	
	@PostMapping("/cart/add/main")
	public String cartCreateMain(@Valid @ModelAttribute("cart") Cart cart, BindingResult result) {
		cartService.addToCart(cart);
		return "redirect:/";
	}
	
	@PostMapping("/cart/add/sets")
	public String cartCreateSets(@Valid @ModelAttribute("cart") Cart cart, BindingResult result ) {
		cartService.addToCart(cart);
		return "redirect:/sets";
	}
	
	@PostMapping("/cart/add/indi")
	public String cartCreateIndi(@Valid @ModelAttribute("cart") Cart cart, BindingResult result ) {
		cartService.addToCart(cart);
		return "redirect:/individuals";
	}
	
	@PostMapping("/cart/add/large")
	public String cartCreateLarge(@Valid @ModelAttribute("cart") Cart cart, BindingResult result ) {
		cartService.addToCart(cart);
		return "redirect:/largeMonsters";
	}
	
	@DeleteMapping("/cart/{id}/delete")
	public String deleteCartedItem(@PathVariable("id")Long id) {
		cartService.deleteCart(id);
		return "redirect:/cart";
	}
	
	@PutMapping("/cart/{id}/edit")
	public String updateCart(@ModelAttribute("cart") Cart cart, Binding Result) {
		cartService.updateCart(cart);
		return "redirect:/cart";
	}
	
	@GetMapping("cart/{cartId}/edit")
    public String editBook(Model model, @PathVariable("cartId") Long cartId, HttpSession session) {

		Cart cart = cartService.findCart(cartId);
		model.addAttribute("cart",cart);    
		return "test.jsp";
	}
	
	@DeleteMapping("/cart/user")
	@Transactional
	public String deleteCartList( HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		cartService.userCartDelete(userId);
		return "redirect:/cart";
	}
 	
	
	
	
	
	
	
	
	
	
}
