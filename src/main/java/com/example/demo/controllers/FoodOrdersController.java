package com.example.demo.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.FoodOrederedItems;
import com.example.demo.services.FoodOrderServices;

@RestController
@RequestMapping("/com.htm")
public class FoodOrdersController {
	
	static Logger log=LogManager.getLogger(FoodOrdersController.class);
	
	@Autowired
	private FoodOrderServices service;
	
	@PostMapping("/food-orders")
	public ResponseEntity<FoodOrederedItems> saveFoodOrder(@RequestBody FoodOrederedItems item){
		log.info("save the food oreders of names "+item.getFoodItems());
		FoodOrederedItems item2=service.saveFoodOrders(item);
		return new ResponseEntity<FoodOrederedItems>(item2,HttpStatus.OK);
	}
	
	@GetMapping("/food-orders")
	public ResponseEntity<List<FoodOrederedItems>> getFoodOrders(){
		List<FoodOrederedItems> orders=service.getAllFoodOrederedItems();
		log.info("getting all users oredered food items "+orders);
		return new ResponseEntity<List<FoodOrederedItems>>(orders,HttpStatus.OK);
	}
	
	@GetMapping("/food-orders/{name}")
	public ResponseEntity<List<FoodOrederedItems>> getFoodOrdersByName(@PathVariable("name") String name){
		log.info("get the food items ordered by respective user "+name);
		List<FoodOrederedItems> items=service.getFoodOredersByName(name);
		return new ResponseEntity<List<FoodOrederedItems>>(items,HttpStatus.OK);
	}

}
