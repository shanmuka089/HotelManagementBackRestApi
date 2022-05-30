package com.example.demo.models;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordToken {
	@NotNull(message = "username not be null")
	private String username;
	@NotNull(message = "password not be null")
	private String password;
}
