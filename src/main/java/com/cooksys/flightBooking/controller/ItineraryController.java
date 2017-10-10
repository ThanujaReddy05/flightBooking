package com.cooksys.flightBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.flightBooking.entity.Itinerary;
import com.cooksys.flightBooking.service.ItineraryService;
import com.cooksys.flightBooking.service.UserService;

@RestController
@RequestMapping("itinerary")
@CrossOrigin
public class ItineraryController {

	private final ItineraryService itineraryService;	
	private final UserService userService;
	
	@Autowired
	public ItineraryController(ItineraryService itineraryService, UserService userService) {		
		this.itineraryService = itineraryService;
		this.userService = userService;
	}

	@RequestMapping(value="{itineraryId}", method=RequestMethod.GET)
	public Itinerary getItinerary(@PathVariable Integer itineraryId) {
		return this.itineraryService.getUser(itineraryId);
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.POST)
	public Itinerary create(@PathVariable String username) {
		return this.itineraryService.create(username);	
	}
}