package com.daniel.dndcommerce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.dndcommerce.models.Category;
import com.daniel.dndcommerce.models.Item;
import com.daniel.dndcommerce.models.Cart;
import com.daniel.dndcommerce.models.User;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

    List<Cart> deleteByUser(User user);
    
    List<Cart> findByUser(User user);
    
    List<Cart> findAll();

}
