package com.daniel.dndcommerce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.dndcommerce.models.Category;
import com.daniel.dndcommerce.models.Item;
import com.daniel.dndcommerce.models.Wishlist;
import com.daniel.dndcommerce.models.User;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, Long>  {

    List<Wishlist> findAllByUserOrderByCreatedDateDesc(User user);

    List<Wishlist> deleteByUser(User user);

    
    List<Wishlist> findByUser(User user);
    
    List<Wishlist> findAll();
    

}
