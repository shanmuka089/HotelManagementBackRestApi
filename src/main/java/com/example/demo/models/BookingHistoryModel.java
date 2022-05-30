package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bookingModel")
public class BookingHistoryModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	@NotNull(message = "username not be null")
	private String username;
	@NotNull(message = "first name not be null")
	private String userFirstName;
	@NotNull(message = "last name not be null")
	private String userLastName;
	@NotNull(message = "usermail not be null")
	private String userMail;
	private int noPersons;
	@NotNull(message = "gender not be null")
	private String userGender;
	@NotNull(message = "city not be null")
	private String userCity;
	@NotNull(message = "check in date not be null")
	private String checkInDate;
	@NotNull(message = "check out date not be null")
	private String checkOutDate;
}
