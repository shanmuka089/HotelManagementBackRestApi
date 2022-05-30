package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "foodOrders")
public class FoodOrederedItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "username not null")
	private String username;
	@NotNull(message = "foodItems not null")
	private String[] foodItems;
	private int totalQuantity;
	private double totalPrice;
	@NotNull(message = "credit card nuber not null")
	private String creditCardNumber;
	@NotNull(message = "ifsc code not null")
	private String ifscCode;

}
