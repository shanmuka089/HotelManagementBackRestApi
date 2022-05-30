package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.RomNotFoundException;
import com.example.demo.exceptions.RoomAlreadyExistException;
import com.example.demo.models.RoomAdding;
import com.example.demo.repositories.RoomsRepository;

@Service
public class RoomsServices {
	
	@Autowired
	RoomsRepository roomRepo;
	
	public RoomAdding saveRoom(RoomAdding room) {
		if(roomRepo.existsById(room.getRoomId())) {
			throw new RoomAlreadyExistException("room alreay exists");
		}
		System.out.println(room);
		return roomRepo.save(room);
	}
	
	public RoomAdding updateRoom(int id,RoomAdding room) {
		if(!roomRepo.existsById(id)) {
			throw new RomNotFoundException("room not found");
		}
		return roomRepo.save(room);
	}
	
	public RoomAdding getRoomById(int id) {
		if(!roomRepo.existsById(id)) {
			throw new RomNotFoundException("room not found");
		}
		return roomRepo.findById(id).get();
	}
	public void deleteRoom(int id) {
		if(!roomRepo.existsById(id)) {
			throw new RomNotFoundException("room not found");
		}
		roomRepo.deleteById(id);
	}
	
	public List<RoomAdding> getRooms() {
		return roomRepo.findAll();
	}

}
