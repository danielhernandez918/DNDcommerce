package com.daniel.dndcommerce.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniel.dndcommerce.models.Category;
import com.daniel.dndcommerce.models.Item;
import com.daniel.dndcommerce.models.Cart;
import com.daniel.dndcommerce.models.Wishlist;
import com.daniel.dndcommerce.services.ItemService;
import com.daniel.dndcommerce.services.OrderService;
import com.daniel.dndcommerce.services.CartService;
import com.daniel.dndcommerce.services.WishlistService;
import com.daniel.dndcommerce.models.Order;

@Controller
public class ItemController {
	@Autowired
	ItemService itemService;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/")
	public String mainPage(Model model, @ModelAttribute("cart") Cart cart, @ModelAttribute("wish") Wishlist wish, HttpSession session) {
		List<Item> items = itemService.allItems();
		model.addAttribute("items", items);
		return "main.jsp";
	}
	
	@GetMapping("/item/{itemId}")
	public String itemPage(Model model, @ModelAttribute("cart") Cart cart, @ModelAttribute("wish") Wishlist wish, @PathVariable("itemId") Long itemId, HttpSession session) {
		Item item = itemService.findItem(itemId);
		model.addAttribute("item", item);
		return "item.jsp";
	}
	
	
	@GetMapping("/orderSubmit")
	public String successPage(Model model, HttpSession session) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/login";
    	}
		Order order = orderService.lastCharge();
		model.addAttribute("order",order);
		return "success.jsp";
	}
	
	@GetMapping("/individuals")
	public String individualsPage(Model model, @ModelAttribute("cart") Cart cart, @ModelAttribute("wish") Wishlist wish) {
		List<Item> items = itemService.allItems();
		model.addAttribute("items", items);
		return "individuals.jsp";
	}
	
	@GetMapping("/sets")
	public String setsPage(Model model, @ModelAttribute("cart") Cart cart, @ModelAttribute("wish") Wishlist wish) {
		List<Item> items = itemService.allItems();
		model.addAttribute("items", items);
		return "sets.jsp";
	}
	
	@GetMapping("/largeMonsters")
	public String largeMonsterPage(Model model, @ModelAttribute("cart") Cart cart, @ModelAttribute("wish") Wishlist wish) {
		List<Item> items = itemService.allItems();
		model.addAttribute("items", items);
		return "largeMonsters.jsp";
	}
	@GetMapping("/dice")
	public String dicePage(Model model, @ModelAttribute("cart") Cart cart, @ModelAttribute("wish") Wishlist wish) {
		List<Item> items = itemService.allItems();
		model.addAttribute("items", items);
		return "dice.jsp";
	}
	
	@RequestMapping("/search")
    public String search(Model model, @ModelAttribute("cart") Cart cart, @ModelAttribute("wish") Wishlist wish, @RequestParam(value="name", required=false)  String searchQuery ) {
    	if (searchQuery == null) {
    		return ("searchedItems.jsp");
    	}
    	List<Item> items = itemService.searchItem(searchQuery);
    	model.addAttribute("items", items);
    	return "searchedItems.jsp";
    }
    


}
