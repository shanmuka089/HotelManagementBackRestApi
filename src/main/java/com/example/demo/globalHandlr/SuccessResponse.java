package com.example.demo.globalHandlr;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SuccessResponse {

	private int statusCode;
	private String message;
	private LocalDate date;
}
