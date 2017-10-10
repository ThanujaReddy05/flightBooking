package com.cooksys.flightBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.flightBooking.entity.Itinerary;
import com.cooksys.flightBooking.entity.FlightUser;
import com.cooksys.flightBooking.repository.ItineraryRepository;
import com.cooksys.flightBooking.repository.UserRepository;

@Service
public class ItineraryService {

	private final ItineraryRepository itineraryRepo;
	private final UserRepository userRepo;
	
	@Autowired
	public ItineraryService(ItineraryRepository itineraryRepo, UserRepository userRepo) {		
		this.itineraryRepo = itineraryRepo;
		this.userRepo = userRepo;
	}
	
	

	public Itinerary create(String username) {
		FlightUser user = new FlightUser();
		
		for (FlightUser u : userRepo.findAll()) {
			if (u.getUsername().equals(username)) {
				user = u;
			}
		}
		
		Itinerary itinerary = new Itinerary(user);
		this.itineraryRepo.save(itinerary);
		return itinerary;
	}
	
	
	
	public Itinerary getUser(Integer itineraryId) {
		return this.itineraryRepo.findOne(itineraryId);
	}
	
	
}
