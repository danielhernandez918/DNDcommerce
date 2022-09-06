package com.daniel.dndcommerce.repositories;

import com.daniel.dndcommerce.models.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	List<Category> findAll();
	
	Category findByCategoryName(String categoryName);
	
}
