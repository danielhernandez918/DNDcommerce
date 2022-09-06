package com.daniel.dndcommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.dndcommerce.models.Cart;
import com.daniel.dndcommerce.models.Order;
import com.daniel.dndcommerce.models.User;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
    List<Order> findAll();
    
    List<Order> findByUser(User user);
    
    Order findTopByOrderByIdDesc();
}
