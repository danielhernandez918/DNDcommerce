package com.daniel.dndcommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.dndcommerce.models.User;
import com.daniel.dndcommerce.models.Order;
import com.daniel.dndcommerce.services.UserService;
import com.daniel.dndcommerce.repositories.CartRepository;
import com.daniel.dndcommerce.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private  OrderRepository orderRepo;

	@Autowired
	private UserService userservice;
	
	@Autowired
	private CartService cartservice;
	
	public List<Order> allCharges() {
		return orderRepo.findAll();
	}
	
	public List<Order> userCharge(Long userid) {
		User user = userservice.findUser(userid);
		return orderRepo.findByUser(user);
	}
	
	public Order addToCharge(Order charge) {
		return orderRepo.save(charge);
	}
	public Order lastCharge () {
		return orderRepo.findTopByOrderByIdDesc();
	}
}
