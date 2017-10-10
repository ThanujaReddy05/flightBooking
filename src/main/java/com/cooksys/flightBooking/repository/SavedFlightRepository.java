package com.cooksys.flightBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.flightBooking.entity.SavedFlight;

@Repository
public interface SavedFlightRepository extends JpaRepository<SavedFlight, Integer> { 

}
