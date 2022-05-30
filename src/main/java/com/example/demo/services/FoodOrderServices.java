package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.FoodOrederedItems;
import com.example.demo.repositories.FoodOrdersRepository;

@Service
public class FoodOrderServices {
	
	@Autowired
	private FoodOrdersRepository repo;
	
	public FoodOrederedItems saveFoodOrders(FoodOrederedItems item) {
		return repo.save(item);
	}
	
	public List<FoodOrederedItems> getAllFoodOrederedItems(){
		return repo.findAll();
	}
	
	public List<FoodOrederedItems> getFoodOredersByName(String name){
		return repo.findByusername(name);
	}

}
