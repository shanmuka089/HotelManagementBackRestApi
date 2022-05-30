package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.RoomAdding;
import com.example.demo.services.RoomsServices;

@RestController
@RequestMapping("/com.htm")
public class RoomController {
	
	static Logger log=LogManager.getLogger();
	
	@Autowired
	private RoomsServices service;
	
	@PostMapping("/room")
	public ResponseEntity<RoomAdding> saveRoom(@Valid @RequestBody RoomAdding room){
		log.info("save the room "+room.getRoomId());
		RoomAdding add=service.saveRoom(room);
		return new ResponseEntity<RoomAdding>(add,HttpStatus.OK);
	}
	
	@GetMapping("/room")
	public ResponseEntity<List<RoomAdding>> getRooms(){
		List<RoomAdding> rooms=service.getRooms();
		log.info("getting the list of rooms");
		return new ResponseEntity<List<RoomAdding>>(rooms,HttpStatus.OK);
	}
	
	@GetMapping("/room/{id}")
	public ResponseEntity<RoomAdding> getRoomById(@PathVariable("id") int id){
		log.info("getting the room using these id "+id);
		RoomAdding rooms=service.getRoomById(id);
		return new ResponseEntity<RoomAdding>(rooms,HttpStatus.OK);
	}
	
	@PutMapping("/room/{id}")
	public ResponseEntity<RoomAdding> updateRoomById(@PathVariable("id") int id,@RequestBody RoomAdding room){
		log.info("update the room where room id is "+id);
		RoomAdding rooms=service.updateRoom(id,room);
		return new ResponseEntity<RoomAdding>(rooms,HttpStatus.OK);
	}
	
	@DeleteMapping("/room/{id}")
	public ResponseEntity<String> deleteRoomById(@PathVariable("id") int id){
		log.info("delete the room where room id is "+id);
		service.deleteRoom(id);
		return new ResponseEntity<String>("room deleted successfully",HttpStatus.OK);
	}
	

}
