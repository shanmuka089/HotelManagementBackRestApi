package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.BookingHistoryModel;
import com.example.demo.services.BookingHistoryService;

@RestController
@RequestMapping("/com.htm")
public class BookingController {
		
	static org.apache.logging.log4j.Logger log=LogManager.getLogger(AuthenticationController.class);
	
	@Autowired
	private BookingHistoryService service;
	
	@PostMapping("/booking")
	public ResponseEntity<BookingHistoryModel> saveBooking(@Valid @RequestBody BookingHistoryModel history){
		log.info("save booking history into booking history data");
			BookingHistoryModel book=service.saveBooking(history);	
		return new ResponseEntity<BookingHistoryModel>(book,HttpStatus.OK);
	}
	
	@GetMapping("/booking")
	public ResponseEntity<List<BookingHistoryModel>> getAllBookings(){
	 List<BookingHistoryModel>	books=service.getBookins();
	 log.info("get all the booking histories");
	 return new ResponseEntity<List<BookingHistoryModel>>(books,HttpStatus.OK);
	}
	
	@GetMapping("/booking/{name}")
	public ResponseEntity<List<BookingHistoryModel>> getBookingsByName(@PathVariable("name") String name){
		List<BookingHistoryModel> books=service.getBookingsByName(name);
		log.info("get all booking history data by name "+name);
		return new ResponseEntity<List<BookingHistoryModel>>(books,HttpStatus.OK);
	}
	
	@GetMapping("/my-booking/{name}")
	public ResponseEntity<List<BookingHistoryModel>> getBookingHistory(@PathVariable("name") String name){
		List<BookingHistoryModel> bookList=service.getPresentBooking(name);
		log.info("get recent bookings by name");
		return new ResponseEntity<List<BookingHistoryModel>>(bookList,HttpStatus.OK);
	}
	

}
