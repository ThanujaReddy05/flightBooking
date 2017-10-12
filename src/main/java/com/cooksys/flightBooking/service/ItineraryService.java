package com.cooksys.flightBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.flightBooking.entity.Itinerary;
import com.cooksys.flightBooking.entity.SavedFlight;
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
	
	

	public Itinerary create(Itinerary itinerary) {
		
//		System.out.println(itinerary);
		FlightUser user = new FlightUser();
//		Itinerary itineraryToAdd = new Itinerary(itinerary);
		
		for (FlightUser u : userRepo.findAll()) {
			if(u != null){
				if (u.getUsername().equals(user.getUsername())) {
				user = u;
//				user.getItinerary().add(flight);
				}
			}
		}
		
		Itinerary itinerary1 = new Itinerary(user);
		itineraryRepo.saveAndFlush(itinerary);
//		userRepo.saveAndFlush(user);
		System.out.println(itinerary);
//		System.out.println(itinerary1);
		return itinerary;
	}
	
	
	
	public Itinerary getUser(Integer itineraryId) {
		return this.itineraryRepo.findOne(itineraryId);
	}
	
	
}
