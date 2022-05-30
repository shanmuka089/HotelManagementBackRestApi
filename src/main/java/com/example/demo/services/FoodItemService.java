package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.FoodItem;
import com.example.demo.repositories.FoodItemRepository;

@Service
public class FoodItemService {
	
	@Autowired
	private FoodItemRepository foodItemsRepo;
	
	
	public FoodItem saveFoodItem(FoodItem food) {
		return foodItemsRepo.save(food);
	}
	
	public void deleteFoodItem(int id) {
		foodItemsRepo.deleteById(id);
	}
	
	public List<FoodItem> getFoodItems(){
		return foodItemsRepo.findAll();
	}
	
	public FoodItem getFoodItem(int id) {
		return foodItemsRepo.findById(id).get();
	}

}
