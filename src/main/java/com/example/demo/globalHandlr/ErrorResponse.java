package com.example.demo.globalHandlr;

import java.time.LocalDate;

import com.example.demo.models.UserResponseToken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@AllArgsConstructor@NoArgsConstructor
public class ErrorResponse extends UserResponseToken{

	private String message;
	private int statusCode;
	private LocalDate date;
}
