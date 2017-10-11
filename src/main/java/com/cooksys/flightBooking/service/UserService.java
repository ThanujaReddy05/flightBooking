package com.cooksys.flightBooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.flightBooking.entity.Itinerary;
import com.cooksys.flightBooking.entity.FlightUser;
import com.cooksys.flightBooking.model.UserModel;
import com.cooksys.flightBooking.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	UserRepository userRepo;
	
//	UserRepository userRepo;
//	
//	public UserService(UserRepository userRepo) {
//		this.userRepo = userRepo;
//	}
	
	

	public UserModel postUser(FlightUser user) {
		return UserModel.createUserModel(this.userRepo.save(user));
	}
	
	
	public List<UserModel> getAllUsers() {
		return UserModel.createUserModels(this.userRepo.findAll());
	}

	public FlightUser getUser(String username) {
		for (FlightUser u : userRepo.findAll()) {
			if (u.getUsername().equals(username)) {
				return u;
			}
		}
		return null;
	}

	public List<Itinerary> getItinerary(String username) {
		for (FlightUser u : userRepo.findAll()) {
			if (u.getUsername().equals(username)) {
				return u.getItinerary();
			}
		}
		return null;
	}
	
	

	public UserModel deleteUser(Integer userId) {
		UserModel result = UserModel.createUserModel(userRepo.findOne(userId));
		userRepo.delete(userId);
		return result;
	}


	public boolean login(String username, String password) {		
			FlightUser user = userRepo.findByUsername(username);
			
			if((user.getUsername().equals(username)) && (user.getPassword().equals(password))){
				return true;
			}
			
			return false;
		}
	
}