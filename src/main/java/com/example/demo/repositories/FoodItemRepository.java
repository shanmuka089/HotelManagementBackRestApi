package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>{

}
