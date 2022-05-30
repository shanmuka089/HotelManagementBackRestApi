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
import lombok.ToString;

@Setter
@Getter
@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Table(name = "rooms")
public class RoomAdding {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;
	
	@NotNull(message = "please select room comfort")
	private String roomComfort;
	private int noOfBeds;
	private double roomRent;
	@NotNull(message = "please select room condition")
	private String roomCondition;
	private boolean roomUse;
	

}
