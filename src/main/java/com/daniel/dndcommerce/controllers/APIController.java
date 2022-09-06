package com.daniel.dndcommerce.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.dndcommerce.models.Category;
import com.daniel.dndcommerce.services.CategoryService;

import com.daniel.dndcommerce.models.Item;
import com.daniel.dndcommerce.services.ItemService;

@RestController
public class APIController {
	@Autowired
	CategoryService categoryserv;
	
	@GetMapping("/api/category")
    public List<Category> callcategories() {
        return categoryserv.listCategories();
    }
    
    @PostMapping(value="/api/category")
    public Category create(
    		@RequestParam(value="categoryName") String categoryName, 
    		@RequestParam(value="description") String description, 
    		@RequestParam(value="imageUrl") String imageUrl){
    	
        Category category = new Category(categoryName, description, imageUrl);
        return categoryserv.createCategory(category);
    }
    
    @GetMapping("/api/category/{id}")
    public Category showCategory(@PathVariable("id") Long id) {
        Category category = categoryserv.findCategory(id);
        return category;
    }
    
    @PutMapping(value="/api/category/{id}")
    public Category update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="categoryName") String categoryName, 
    		@RequestParam(value="description") String description, 
    		@RequestParam(value="imageUrl") String imageUrl){
    	
        Category category = new Category(categoryName, description, imageUrl);
    	category.setId(id);
    	
        category = categoryserv.updateCategory(category);
        
        return category;
    }
    
    @DeleteMapping(value="/api/category/{id}")
    public void destroyCategory(@PathVariable("id") Long id) {
        categoryserv.deleteCategory(id);
    }
	
	@Autowired
	ItemService itemservice;
	
	@GetMapping("/api/item")
    public List<Item> allitems() {
        return itemservice.allItems();
    }
    
    @PostMapping(value="/api/item")
    public Item create(
    		@RequestParam(value="name") String name, 
    		@RequestParam(value="image") String image, 
    		@RequestParam(value="price") BigDecimal price, 
    		@RequestParam(value="stock") Integer stock,
			@RequestParam(value="manufacturer") String manufacturer,
			@RequestParam(value="product") String product,
			@RequestParam(value="universe") String universe,
			@RequestParam(value="setName") String setName,
			@RequestParam(value="setNumber") String setNumber,
			@RequestParam(value="rarity") String rarity,
			@RequestParam(value="base") String base,
			@RequestParam(value="height") String height,
			@RequestParam(value="group") Category group){
    	
        Item item = new Item(name, image, price, stock, manufacturer, product, universe, setName, setNumber, rarity, base, height, group);
        return itemservice.createItem(item);
    }
    
    @GetMapping("/api/item/{id}")
    public Item show(@PathVariable("id") Long id) {
        Item item = itemservice.findItem(id);
        return item;
    }
    
    @PutMapping(value="/api/item/{id}")
    public Item update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="name") String name, 
    		@RequestParam(value="image") String image, 
    		@RequestParam(value="price") BigDecimal price, 
    		@RequestParam(value="stock") Integer stock,
			@RequestParam(value="manufacturer") String manufacturer,
			@RequestParam(value="product") String product,
			@RequestParam(value="universe") String universe,
			@RequestParam(value="setName") String setName,
			@RequestParam(value="setNumber") String setNumber,
			@RequestParam(value="rarity") String rarity,
			@RequestParam(value="base") String base,
			@RequestParam(value="height") String height,
			@RequestParam(value="group") Category group){
	    	
	    Item item = new Item(name, image, price, stock, manufacturer, product, universe, setName, setNumber, rarity, base, height, group);
    	item.setId(id);
    	
        item = itemservice.updateItem(item);
        
        return item;
    }
    
    @DeleteMapping(value="/api/item/{id}")
    public void destroy(@PathVariable("id") Long id) {
        itemservice.deleteItem(id);
    }

}