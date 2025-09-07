package com.christianjaena.services;

import com.christianjaena.domain.Flight;
import com.christianjaena.domain.Passenger;
import com.christianjaena.repositories.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void addPassengerToFlight(String flightNumber, Passenger passenger) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber);

        boolean seatTaken = flight.getPassengers()
                .stream()
                .anyMatch(p -> p.getSeatAssignment().equals(passenger.getSeatAssignment()));

        if (seatTaken) {
            throw new IllegalArgumentException("Seat already assigned");
        }

        flight.addPassenger(passenger);

        flightRepository.save(flight);
    }
}
