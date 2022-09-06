package com.daniel.dndcommerce.services;

import com.daniel.dndcommerce.models.Category;
import com.daniel.dndcommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	public List<Category> listCategories() {
		return categoryRepo.findAll();
	}

	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category findCategory(Long id) {
		
		Optional<Category> category = categoryRepo.findById(id);
		if (category.isPresent()) {
			return category.get();
		}
		else {
			return null;
		}
	}
	
	public Category updateCategory(Category category) {
		
		return categoryRepo.save(category);
	}
	
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}
}
