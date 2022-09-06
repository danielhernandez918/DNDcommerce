package com.daniel.dndcommerce.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.dndcommerce.models.Category;
import com.daniel.dndcommerce.models.Item;
import com.daniel.dndcommerce.repositories.ItemRepository;
import com.daniel.dndcommerce.services.UserService;
import com.daniel.dndcommerce.services.ItemService;
import com.daniel.dndcommerce.models.User;
import com.daniel.dndcommerce.models.Cart;
import com.daniel.dndcommerce.repositories.CartRepository;



@Service
public class CartService {

    @Autowired
    private  CartRepository cartRepo;

	@Autowired
	private UserService userservice;
	
	@Autowired
	private ItemService itemservice;
	
	public List<Cart> allCarts() {
		return cartRepo.findAll();
	}
	
	public List<Cart> userCart(Long userid) {
		User user = userservice.findUser(userid);
		return cartRepo.findByUser(user);
	}
	
	public Cart findCart(Long id) {
		
		Optional<Cart> cart = cartRepo.findById(id);
		if (cart.isPresent()) {
			return cart.get();
		}
		else {
			return null;
		}
	}
	
	public Cart addToCart(Cart cart) {
		return cartRepo.save(cart);
	}
	
	public Cart updateCart(Cart cart) {
		return cartRepo.save(cart);
	}
	
	public void deleteCart(Long id) {
		cartRepo.deleteById(id);
	}
	
	public void userCartDelete (Long userid) {
		User user = userservice.findUser(userid);
		cartRepo.deleteByUser(user);
	}
	
	
	
	
}
