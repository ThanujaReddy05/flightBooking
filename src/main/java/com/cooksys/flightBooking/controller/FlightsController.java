package com.cooksys.flightBooking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.flightBooking.entity.Itinerary;
import com.cooksys.flightBooking.entity.SavedFlight;
import com.cooksys.flightBooking.pojo.Flight;
import com.cooksys.flightBooking.service.FlightService;
import com.cooksys.flightBooking.service.LocationService;

@RestController
@RequestMapping("flights")
@CrossOrigin
public class FlightsController {
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	FlightService flightService;
	
//	private LocationService locationService;	
//	private FlightService flightService;
//	
//	public FlightsController(LocationService locationService, FlightService flightService ) {
//		this.locationService = locationService;
//		this.flightService = flightService;
//	}
	
	@RequestMapping
	public ArrayList<SavedFlight> getFlightList()
	{
		return flightService.getDailyFlightList();
	}
	
	@RequestMapping(value = "groupflights")
	public List<List<SavedFlight>> getShortestPath(){
		return flightService.groupFlightsByOrigin();		
	}

	@RequestMapping(value = "{origin}/{destination}")
	public List<List<SavedFlight>> findPaths(@PathVariable String origin, @PathVariable String destination){
		return flightService.findPaths(origin,destination);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public SavedFlight create(@RequestBody SavedFlight savedFlight){
		return flightService.create(savedFlight);
	}
	
	@RequestMapping(value = "/{flightId}", method = RequestMethod.PUT)
	public Itinerary addItinerary(@PathVariable Integer flightId, @RequestBody Itinerary itinerary){
		return flightService.addItinerary(flightId, itinerary);
	}
}