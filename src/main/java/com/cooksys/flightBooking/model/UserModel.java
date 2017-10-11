package com.cooksys.flightBooking.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.flightBooking.entity.Itinerary;
import com.cooksys.flightBooking.entity.FlightUser;

public class UserModel {

	private Integer id;	
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
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

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(List<Itinerary> itinerary) {
		this.itinerary = itinerary;
	}

	public UserModel(FlightUser u) {
		
		this.id = u.getId();
		this.firstName = u.getFirstName();
		this.lastName = u.getFirstName();
		this.username = u.getUsername();
		this.email = u.getEmail();
		this.phone = u.getPhone();
		this.itinerary = u.getItinerary();
	}
}