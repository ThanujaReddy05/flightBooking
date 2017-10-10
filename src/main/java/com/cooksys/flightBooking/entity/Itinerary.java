package com.cooksys.flightBooking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Itinerary {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	private FlightUser user;

	@OneToMany(mappedBy = "itinerary")
	private List<SavedFlight> savedFlights;

	public Itinerary() {

	}

	public Itinerary(FlightUser user) {
		this.user = user;

	}

	public Itinerary(Integer id, FlightUser user, List<SavedFlight> savedFlights) {

		this.id = id;
		this.user = user;
		this.savedFlights = savedFlights;
	}

	public Itinerary(Integer id, List<SavedFlight> savedFlights) {

		this.id = id;
		this.savedFlights = savedFlights;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FlightUser getUser() {
		return user;
	}

	public void setUser(FlightUser user) {
		this.user = user;
	}

	public List<SavedFlight> getFlights() {
		return savedFlights;
	}

	public void setFlights(List<SavedFlight> savedFlights) {
		this.savedFlights = savedFlights;
	}



}
