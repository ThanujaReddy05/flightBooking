package com.cooksys.flightBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.flightBooking.entity.Itinerary;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Integer> {

}
