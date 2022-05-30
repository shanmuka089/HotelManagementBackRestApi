package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.BookingHistoryModel;

@Repository
public interface BookingHistoryRepository extends JpaRepository<BookingHistoryModel, Integer>{

	@Query(value = "select * from booking_model b where b.username=:name",nativeQuery = true)
	List<BookingHistoryModel> bookingsByName(String name);
}
