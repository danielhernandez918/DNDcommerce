package com.daniel.dndcommerce.controllers;

import com.daniel.dndcommerce.models.ChargeRequest;
import com.daniel.dndcommerce.models.ChargeRequest.Currency;
import com.daniel.dndcommerce.models.Order;
import com.daniel.dndcommerce.services.CartService;
import com.daniel.dndcommerce.services.UserService;
import com.daniel.dndcommerce.services.OrderService;
import com.daniel.dndcommerce.services.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import lombok.extern.java.Log;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Log
@Controller
public class ChargeController {

    @Autowired
    StripeService paymentsService;
    
    @Autowired
    CartService cartService;
    
    @Autowired
    OrderService orderService;
    
	@Autowired
	UserService userService;
//
//    @PostMapping("/charge")
//    public String charge(ChargeRequest chargeRequest, Model model) throws StripeException {
//        chargeRequest.setDescription("Example charge");
//        chargeRequest.setCurrency(Currency.USD);
//        Charge charge = paymentsService.charge(chargeRequest);
//        model.addAttribute("id", charge.getId());
//        model.addAttribute("status", charge.getStatus());
//        model.addAttribute("chargeId", charge.getId());
//        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
//        return "result";
//    }
//    
    @PostMapping("/charge")
    @Transactional
    public String charge(@Valid @ModelAttribute("order") Order order, BindingResult result, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		orderService.addToCharge(order);
		cartService.userCartDelete(userId);
		
        return "redirect:/orderSubmit";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
    
    
}
