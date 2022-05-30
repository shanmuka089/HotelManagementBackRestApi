package com.example.demo.models;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseToken {

	@NotNull(message = "token not null")
	private String token;
	@NotNull(message = "roles not null")
	private List<String> role;
}
