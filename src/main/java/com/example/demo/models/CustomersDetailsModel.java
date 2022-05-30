package com.example.demo.models;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomersDetailsModel {
	
	private int userId;
	@NotNull(message = "username not be null")
	private String username;
	@NotNull(message = "mail not be null")
	private String mail;
	@NotNull(message = "selected roles not be null")
	private String[] selectedRoles;

}
