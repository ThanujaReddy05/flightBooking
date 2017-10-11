package com.cooksys.flightBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.flightBooking.entity.FlightUser;
import com.cooksys.flightBooking.entity.Itinerary;
import com.cooksys.flightBooking.entity.SavedFlight;
import com.cooksys.flightBooking.service.ItineraryService;
import com.cooksys.flightBooking.service.UserService;

@RestController
@RequestMapping("itinerary")
@CrossOrigin(origins="*")
public class ItineraryController {

	private final ItineraryService itineraryService;	
	private final UserService userService;
	
	@Autowired
	public ItineraryController(ItineraryService itineraryService, UserService userService) {		
		this.itineraryService = itineraryService;
		this.userService = userService;
	}

	@GetMapping("/{itineraryId}")
	public Itinerary getItinerary(@PathVariable Integer itineraryId) {
		return itineraryService.getUser(itineraryId);
	}
	
	@PostMapping
	public Itinerary create(@RequestBody Itinerary itinerary) {
		if (itinerary == null) {
			return null;
		}
		return itineraryService.create(itinerary );	
	}
}