package com.cooksys.flightBooking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class FlightUser {

	@Id
	@GeneratedValue
	private Integer id;
	 
	private String username;
	private String password;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Itinerary> itinerary;
	
	public FlightUser() {
		
	}

	
	public FlightUser(Integer id, String username, String password, String name, List<Itinerary> itenary) {
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.itinerary = itenary;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(List<Itinerary> itenary) {
		this.itinerary = itenary;
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
		FlightUser other = (FlightUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	

	
	
}
