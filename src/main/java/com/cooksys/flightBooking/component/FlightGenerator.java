package com.cooksys.flightBooking.component;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.cooksys.flightBooking.entity.SavedFlight;
import com.cooksys.flightBooking.pojo.Cities;
import com.cooksys.flightBooking.pojo.Flight;

@Component
public class FlightGenerator {

	public ArrayList<SavedFlight> generateNewFlightList() {
		
		ArrayList<SavedFlight> result = new ArrayList<>();

		for (int i = 0; i < 5; i++) {

			int originIndex = ThreadLocalRandom.current().nextInt(0, 4);

			int destinationIndex = ThreadLocalRandom.current().nextInt(0, 4);

			while (destinationIndex == originIndex)
				destinationIndex = ThreadLocalRandom.current().nextInt(0, 4);

			String origin = Cities.values()[originIndex].getName();
			String destination = Cities.values()[destinationIndex].getName();
			int flightTime = ThreadLocalRandom.current().nextInt(1, 4);
			int offset = ThreadLocalRandom.current().nextInt(0, 10);

			SavedFlight f = new SavedFlight(origin, destination, flightTime, offset);

			result.add(f);
		}
		return result;
	}

}
