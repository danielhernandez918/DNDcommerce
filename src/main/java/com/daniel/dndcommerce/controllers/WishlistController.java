package com.daniel.dndcommerce.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.daniel.dndcommerce.models.Wishlist;
import com.daniel.dndcommerce.models.User;
import com.daniel.dndcommerce.models.Cart;
import com.daniel.dndcommerce.models.Item;
import com.daniel.dndcommerce.services.WishlistService;
import com.daniel.dndcommerce.services.ItemService;
import com.daniel.dndcommerce.services.UserService;

@Controller
public class WishlistController {
	@Autowired
	WishlistService wishService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/wishlist")
	public String wishlistPage(Model model, @ModelAttribute("cart") Cart cart, HttpSession session) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/login";
    	}
		Long userId = (Long) session.getAttribute("userId");
    	List<Wishlist> wish = wishService.userWish(userId);
    	model.addAttribute("wish", wish);
		return "wishlist.jsp";
	}
	
	@PostMapping("/wishlist/add")
	public String wishCreate(@Valid @ModelAttribute("wish") Wishlist wish, BindingResult result ) {
		wishService.addToWish(wish);
		return "redirect:/wishlist";
	}
	
	@PostMapping("/wishlist/add/main")
	public String wishCreateMain(@Valid @ModelAttribute("wish") Wishlist wish, BindingResult result ) {
		wishService.addToWish(wish);
		return "redirect:/";
	}
	
	@PostMapping("/wishlist/add/sets")
	public String wishCreateSets(@Valid @ModelAttribute("wish") Wishlist wish, BindingResult result ) {
		wishService.addToWish(wish);
		return "redirect:/sets";
	}
	
	@PostMapping("/wishlist/add/indi")
	public String wishCreateIndi(@Valid @ModelAttribute("wish") Wishlist wish, BindingResult result ) {
		wishService.addToWish(wish);
		return "redirect:/individuals";
	}
	
	@PostMapping("/wishlist/add/large")
	public String wishCreateLarge(@Valid @ModelAttribute("wish") Wishlist wish, BindingResult result ) {
		wishService.addToWish(wish);
		return "redirect:/largeMonsters";
	}
	
	@DeleteMapping("wishlist/{id}/delete")
	public String deleteWish(@PathVariable("id")Long id) {
		wishService.deleteWish(id);
		return "redirect:/wishlist";
	}
	
	@DeleteMapping("/wishlist/user")
	@Transactional
	public String deleteWishList( HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
//		System.out.println(userId);
		wishService.userWishDelete(userId);
		return "redirect:/wishlist";
	}

}
