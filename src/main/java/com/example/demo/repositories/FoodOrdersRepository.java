package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.FoodOrederedItems;

@Repository
public interface FoodOrdersRepository extends JpaRepository<FoodOrederedItems, Integer>{
	
	List<FoodOrederedItems> findByusername(String name);

}
