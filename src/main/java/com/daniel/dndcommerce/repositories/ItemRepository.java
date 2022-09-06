package com.daniel.dndcommerce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.dndcommerce.models.Category;
import com.daniel.dndcommerce.models.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	
    // this method retrieves all the names from the database
    List<Item> findAll();
    
    List<Item> findByGroupContains(Category group);
    
	List<Item> findByNameContaining(String search);
    // this method counts how many names contain a certain string
//    Long countByNameContaining(String search);
    // this method deletes a item that starts with a specific name
//    Long deleteByNameStartingWith(String search);
    
}
