package com.cooksys.flightBooking.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cooksys.flightBooking.component.FlightGenerator;
import com.cooksys.flightBooking.entity.Itinerary;
import com.cooksys.flightBooking.entity.SavedFlight;
import com.cooksys.flightBooking.repository.ItineraryRepository;
import com.cooksys.flightBooking.repository.SavedFlightRepository;

@Service
public class FlightService {

	
	@Autowired
	FlightGenerator generator;
	
	@Autowired
	SavedFlightRepository savedFlightRepo;

	@Autowired
	ItineraryRepository itineraryRepo;
	
	private ArrayList<SavedFlight> flightList = new ArrayList<>();
	
//	private FlightGenerator generator;	
//	private SavedFlightRepository savedFlightRepo;	
//	private ItineraryRepository itineraryRepo;
//	private ArrayList<SavedFlight> flightList = new ArrayList<>();
//
//	
//	public FlightService(FlightGenerator generator, SavedFlightRepository savedFlightRepo, ItineraryRepository itineraryRepo ) {
//		this.generator = generator;
//		this.savedFlightRepo = savedFlightRepo;
//		this.itineraryRepo = itineraryRepo;
//	}
	
	
	public ArrayList<SavedFlight> getDailyFlightList() {
		return flightList;
	}

	// The fixedDelay parameter determines how often a new day is generated as
	// expressed in milliseconds
	@Scheduled(fixedDelay = 5000)
	private void refreshFlights() {
		flightList = generator.generateNewFlightList();
		System.out.println(flightList);
		
	}

	
	
	public List<List<SavedFlight>> groupFlightsByOrigin() {
		List<List<SavedFlight>> outerList = new ArrayList<>();
		List<SavedFlight> innerListMemphis = new ArrayList<>();
		List<SavedFlight> innerListKnoxville = new ArrayList<>();
		List<SavedFlight> innerListChattanooga = new ArrayList<>();
		List<SavedFlight> innerListNashville = new ArrayList<>();
		
		
		System.out.println(flightList);
		
		for (SavedFlight flight : flightList) {
			String origin = flight.getOrigin();

			if (origin.equals("Memphis")) {
				innerListMemphis.add(flight);
			} else if (origin.equals("Knoxville")) {
				innerListKnoxville.add(flight);
			} else if (origin.equals("Chattanooga")) {
				innerListChattanooga.add(flight);
			} else if (origin.equals("Nashville")) {
				innerListNashville.add(flight);
			} 
		}

		if (!innerListMemphis.isEmpty()) {
			outerList.add(innerListMemphis);
		}
		if (!innerListKnoxville.isEmpty()) {
			outerList.add(innerListKnoxville);
		}
		if (!innerListChattanooga.isEmpty()) {
			outerList.add(innerListChattanooga);
		}
		if (!innerListNashville.isEmpty()) {
			outerList.add(innerListNashville);
		}
//		System.out.println(outerList);
		return outerList;
	}

	public List<List<SavedFlight>> findPaths(String origin, String destination) {
		
		List<List<SavedFlight>> result = new ArrayList<>();
		LinkedList<String> visited = new LinkedList<>();
		List<SavedFlight> path = new ArrayList<>();
		List<SavedFlight> flights = new ArrayList<>();
		
		visited.add(origin);
//		System.out.println(visited);
		
		for (List<SavedFlight> list : groupFlightsByOrigin()) {
//			System.out.println(list);
			if (list.get(0).getOrigin().equals(origin)) {
				flights = list;
				break;
			}
		}
		System.out.println(flights);
		for (SavedFlight flight : flights) {
			if (visited.contains(flight.getDestination())) {
				continue;
			}
			if (flight.getDestination().equals(destination)) {
				path.add(flight);
				result.add(new ArrayList<SavedFlight>(path));
				path.clear();
			} else {
				visited.addLast(flight.getDestination());
				path.add(flight);
				result.addAll(getLayovers(visited, path, flight.getFlightTime(), flight.getOffset(), flight.getTotalTime(), destination));
				path.remove(flight);
				visited.removeLast();
			}
		}
		System.out.println(result);
		return result;
		
	}
	
	private List<List<SavedFlight>> getLayovers(LinkedList<String> visited, List<SavedFlight> path, Integer previousFlightTime,
			Integer previousOffset, Integer previousTotalTime, String destination) {
		
		List<List<SavedFlight>> result = new ArrayList<>();
		List<SavedFlight> flights = new ArrayList<>();
		
		for (List<SavedFlight> list : groupFlightsByOrigin()) {
			if (list.get(0).getOrigin().equals(visited.getLast())) {
				flights = list;
				break;
			}
		}
		
		for (SavedFlight flight : flights) {
			flight.setLayover(flight.getOffset() - (previousFlightTime + previousOffset));
			if (flight.getLayover() > 0) {
				if (visited.contains(flight.getDestination())) {
					continue;
				}
				if (flight.getDestination().equals(destination)) {
					flight.setTotalTime(previousTotalTime + flight.getFlightTime() + flight.getLayover());
					path.add(flight);
					result.add(new ArrayList<SavedFlight>(path));
					path.remove(flight);
				} else {
					flight.setTotalTime(previousTotalTime + flight.getFlightTime() + flight.getLayover());
					visited.addLast(flight.getDestination());
					path.add(flight);
					result.addAll(getLayovers(visited, path, flight.getFlightTime(), flight.getOffset(), flight.getTotalTime(), destination));
					path.remove(flight);
					visited.removeLast();
				}
			}
		}
		return result;
	}
	
	public SavedFlight create(SavedFlight savedFlight) {
		return this.savedFlightRepo.save(savedFlight);
	}

	public Itinerary addItinerary (Integer flightId, Itinerary itinerary) {
		
		SavedFlight savedFlight = new SavedFlight();
		
		for (SavedFlight sf : this.savedFlightRepo.findAll()) {
			if (sf.getId() == flightId) {
				savedFlight = sf;
			}
		}
		
		savedFlight.setItinerary(this.itineraryRepo.findOne(itinerary.getId()));
		this.savedFlightRepo.save(savedFlight);
		return new Itinerary(savedFlight.getItinerary().getId(), savedFlight.getItinerary().getFlights());
	}
}
