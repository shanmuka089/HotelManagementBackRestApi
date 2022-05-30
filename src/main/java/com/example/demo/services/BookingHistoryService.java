package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.BookingHistoryModel;
import com.example.demo.repositories.BookingHistoryRepository;

@Service
public class BookingHistoryService {
	
	@Autowired
	private BookingHistoryRepository repo;

	public BookingHistoryModel saveBooking(BookingHistoryModel model) {
		return repo.save(model);
	}
	
	public List<BookingHistoryModel> getBookingsByName(String name) {
		return repo.bookingsByName(name);
	}
	
	public List<BookingHistoryModel> getBookins(){
		return repo.findAll();
	}
	
	public List<BookingHistoryModel> getPresentBooking(String name) {
		
		List<BookingHistoryModel> bookLists=repo.bookingsByName(name);
		int currentDate=Integer.parseInt(LocalDate.now().toString().substring(8, 10));
		System.out.println(currentDate);
		List<BookingHistoryModel> bookList=bookLists.stream().filter(model->{
			
			int checkInDate=Integer.parseInt(model.getCheckInDate().substring(8,10));
			System.out.println(checkInDate);
			
			if(checkInDate>currentDate) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		return bookList;
	}

}
