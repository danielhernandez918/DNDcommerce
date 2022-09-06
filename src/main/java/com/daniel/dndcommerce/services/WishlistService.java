package com.daniel.dndcommerce.services;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.dndcommerce.models.Cart;
import com.daniel.dndcommerce.models.Category;
import com.daniel.dndcommerce.models.Item;
import com.daniel.dndcommerce.repositories.CartRepository;
import com.daniel.dndcommerce.repositories.ItemRepository;
import com.daniel.dndcommerce.services.UserService;
import com.daniel.dndcommerce.services.ItemService;
import com.daniel.dndcommerce.models.User;
import com.daniel.dndcommerce.models.Wishlist;
import com.daniel.dndcommerce.repositories.WishlistRepository;



@Service
public class WishlistService {
    @Autowired
    private  WishlistRepository wishRepo;

	@Autowired
	private UserService userservice;
	
	@Autowired
	private ItemService itemservice;
	
	public List<Wishlist> allWish() {
		return wishRepo.findAll();
	}
	
	public List<Wishlist> userWish(Long userid) {
		User user = userservice.findUser(userid);
		return wishRepo.findByUser(user);
	}
	
	public Wishlist findWish(Long id) {
		
		Optional<Wishlist> wish = wishRepo.findById(id);
		if (wish.isPresent()) {
			return wish.get();
		}
		else {
			return null;
		}
	}
	
	public Wishlist addToWish(Wishlist wish) {
		return wishRepo.save(wish);
	}
	
	public Wishlist updateWish(Wishlist wish) {
		return wishRepo.save(wish);
	}
	
	public void deleteWish(Long id) {
		wishRepo.deleteById(id);
	}
	
	public void userWishDelete(Long userid) {
		User user = userservice.findUser(userid);
		wishRepo.deleteByUser(user);
	}
}
