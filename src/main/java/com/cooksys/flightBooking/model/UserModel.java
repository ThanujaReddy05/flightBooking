package com.cooksys.flightBooking.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.flightBooking.entity.Itinerary;
import com.cooksys.flightBooking.entity.FlightUser;

public class UserModel {

	private Integer id;
	
	private String name;
	
	private String username;
	
	private List<Itinerary> itinerary;
	
	public static UserModel createUserModel(FlightUser u) {
		return new UserModel(u);
	}
	
	public static List<UserModel> createUserModels(List<FlightUser> list) {
		ArrayList<UserModel> result = new ArrayList<>();
		for (FlightUser u : list) {
			result.add(createUserModel(u));
		}
		return result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(List<Itinerary> itinerary) {
		this.itinerary = itinerary;
	}

	public UserModel(FlightUser u) {
		super();
		this.id = u.getId();
		this.name = u.getName();
		this.username = u.getUsername();
		this.itinerary = u.getItinerary();
	}
}