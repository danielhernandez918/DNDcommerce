package com.daniel.dndcommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.dndcommerce.models.Category;
import com.daniel.dndcommerce.models.Item;
import com.daniel.dndcommerce.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepo;
	
	public List<Item> allItems() {
		return itemRepo.findAll();
	}
	
//	public List<Item> categoryItems(Category group) {
//		Optional<Item> item = itemRepo.findByGroupContains(group);
//		return itemRepo.findByGroupContains(group);
//	}
	
	public Item createItem(Item item) {
		return itemRepo.save(item);
	}
	
	public Item findItem(Long id) {
		
		Optional<Item> item = itemRepo.findById(id);
		if (item.isPresent()) {
			return item.get();
		}
		else {
			return null;
		}
	}
	
	public Item updateItem(Item item) {
		
		return itemRepo.save(item);
	}
	
	public void deleteItem(Long id) {
		itemRepo.deleteById(id);
	}
	
	public List<Item> searchItem(String name) {
		return itemRepo.findByNameContaining(name);
	}

}