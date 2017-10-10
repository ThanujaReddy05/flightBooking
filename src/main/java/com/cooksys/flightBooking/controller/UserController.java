package com.cooksys.flightBooking.controller;

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
import com.cooksys.flightBooking.entity.FlightUser;
import com.cooksys.flightBooking.model.UserModel;
import com.cooksys.flightBooking.service.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {

	
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
	this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public UserModel postUser(@RequestBody FlightUser user ){
		return userService.postUser(user);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<UserModel> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "{username}", method = RequestMethod.GET)
	public FlightUser getUser(@PathVariable String username){
		return userService.getUser(username);
	}	
	
	@RequestMapping(value = "{username}/itinerary", method = RequestMethod.GET)
	public List<Itinerary> getItinerary(@PathVariable String username){
		return userService.getItinerary(username);
	}
	
	@RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
	public UserModel deleteUser(@PathVariable Integer userId){
		return userService.deleteUser(userId);
	}
}
