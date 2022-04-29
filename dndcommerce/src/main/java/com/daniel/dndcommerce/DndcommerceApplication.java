package com.daniel.dndcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stripe.Stripe;

@SpringBootApplication
public class DndcommerceApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(DndcommerceApplication.class, args);
		Stripe.apiKey = "sk_test_51KsYMIE0zVytateR5fLyw8me49nWwfMttaGUmTNsyWwWLeRLgeKMLXhOKpwB2UxwKdodJUIYkJ9Vre2WwAvtNone0044iNpto9";
	
	}

}
