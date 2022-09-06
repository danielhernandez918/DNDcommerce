package com.daniel.dndcommerce.controllers;

//import com.daniel.dndcommerce.common.ApiResponse;
import com.daniel.dndcommerce.models.Category;
import com.daniel.dndcommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/category")

public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/allCategories")
	public String mainPage(Model model) {
//    	if(session.getAttribute("userId")==null) {
//    		return "redirect:/";
//    	}
		List<Category> categories = categoryService.listCategories();
		model.addAttribute("categories", categories);
		return "main.jsp";
	}
	

	
}
