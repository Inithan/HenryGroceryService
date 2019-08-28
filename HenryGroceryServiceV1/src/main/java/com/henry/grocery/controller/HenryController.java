package com.henry.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.henry.grocery.model.Discounts;
import com.henry.grocery.model.Input;
import com.henry.grocery.model.Output;
import com.henry.grocery.model.StockItems;
import com.henry.grocery.service.HenryService;

@RestController
public class HenryController {

	@Autowired
	private HenryService service;
	
	 @GetMapping("/getStocks")
	 public List<StockItems> getStockItems() {
	 return service.getStockItems();
	 }
	
	 @GetMapping("/getDiscounts")
	 public List<Discounts> getDiscounts() {
	 return service.getDiscounts();
	 }
	
	 @PostMapping("/getPriceBasket")
	 public Output getPriceBasket(@RequestBody Input request) { 
	 return service.getPriceBasket(request);
	 }
	
	
	
}
