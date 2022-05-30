package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.globalHandlr.SuccessResponse;
import com.example.demo.models.FoodItem;
import com.example.demo.services.FoodItemService;

@RestController
@RequestMapping("/com.htm")
public class FoodItemsController {
	
	@Autowired
	private FoodItemService service;
	
	
	@PostMapping("/food-item")
	public ResponseEntity<FoodItem> svaeFoodItem(@RequestBody FoodItem food){
		FoodItem foodItem=service.saveFoodItem(food);
		return new ResponseEntity<FoodItem>(foodItem,HttpStatus.CREATED);
	}
	
	@GetMapping("/food-item")
	public ResponseEntity<List<FoodItem>> getFoodItems(){
		List<FoodItem> foods=service.getFoodItems();
		return new ResponseEntity<List<FoodItem>>(foods,HttpStatus.OK);
	}
	
	@DeleteMapping("/food-item/{id}")
	public ResponseEntity<SuccessResponse> deleteFood(@PathVariable("id") int id){
		service.deleteFoodItem(id);
		SuccessResponse resp=new SuccessResponse();
		resp.setMessage("food item deleted successfully");
		resp.setStatusCode(HttpStatus.OK.value());
		resp.setDate(LocalDate.now());
		return new ResponseEntity<SuccessResponse>(resp,HttpStatus.OK);
	}
	
	
}
