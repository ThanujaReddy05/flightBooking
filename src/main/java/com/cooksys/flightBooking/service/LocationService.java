package com.cooksys.flightBooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.flightBooking.entity.Location;
import com.cooksys.flightBooking.repository.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	LocationRepository repo;
		
	public List<Location> getAll()
	{
		return repo.findAll();
	}

	public Location get(long id) {
		return repo.findById(id);
	}
	
	public Location get(String name) {
		return repo.findByCity(name);
	}
}
