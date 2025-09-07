package com.christianjaena.factories;

import com.christianjaena.domain.Flight;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FlightFactory {

    public Flight createFlight(String flightNumber,
                               String origin,
                               String destination,
                               LocalDateTime departure,
                               LocalDateTime arrival) {
        Flight flight = new Flight();
        flight.setFlightNumber(flightNumber);
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setScheduledDeparture(departure);
        flight.setScheduledArrival(arrival);
        return flight;
    }

}
