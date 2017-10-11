package com.cooksys.flightBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@CrossOrigin(origins="*")
public class UserController {

	
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
	this.userService = userService;
	}
	
	
	@GetMapping("{username}/{password}")
	public boolean login(@PathVariable String username, @PathVariable String password ) {
		
		 return userService.login(username, password);
		
	}
	@PostMapping
	public UserModel postUser(@RequestBody FlightUser user ){
		return userService.postUser(user);
	}
	
	@GetMapping
	public List<UserModel> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{username}")
	public FlightUser getUser(@PathVariable String username){
		return userService.getUser(username);
	}	
	
	@GetMapping("{username}/itinerary")
	public List<Itinerary> getItinerary(@PathVariable String username){
		return userService.getItinerary(username);
	}
	
	@DeleteMapping("/{userId}")
	public UserModel deleteUser(@PathVariable Integer userId){
		return userService.deleteUser(userId);
	}
}
