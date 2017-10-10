package com.cooksys.flightBooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SavedFlight")
public class SavedFlight {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String origin;
	private String destination;
	private int flightTime;
	private int offset;
	private int layover;
	private int totalTime;
	
	@ManyToOne
	@JsonIgnore
	private Itinerary itinerary;
	
	
	public SavedFlight() {
		
	}
	
	
	public SavedFlight(String origin, String destination, int flightTime, int offset) {
		
		this.origin = origin;
		this.destination = destination;
		this.flightTime = flightTime;
		this.offset = offset;
		this.layover = 0;
		this.totalTime = flightTime;
		
	}
	
	
	
	public SavedFlight(Integer id, String origin, String destination, int flightTime, int offset) {
		
		this.id = id;
		this.origin = origin;
		this.destination = destination;
		this.flightTime = flightTime;
		this.offset = offset;
		this.layover = 0;
		this.totalTime = flightTime;
	}


	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public int getFlightTime() {
		return flightTime;
	}


	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}


	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}


	public int getLayover() {
		return layover;
	}


	public void setLayover(int layover) {
		this.layover = layover;
	}


	public int getTotalTime() {
		return totalTime;
	}


	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}


	public Itinerary getItinerary() {
		return itinerary;
	}


	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SavedFlight other = (SavedFlight) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	


	
	
	
	
	
}
