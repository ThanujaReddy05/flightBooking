package com.cooksys.flightBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.flightBooking.entity.SavedFlight;
import com.cooksys.flightBooking.entity.FlightUser;

@Repository
public interface UserRepository extends JpaRepository<FlightUser, Integer> {
	
//	User getUserById(Long id);
//
//	SavedFlight findBySavedItinerariesId(Long id);

}
