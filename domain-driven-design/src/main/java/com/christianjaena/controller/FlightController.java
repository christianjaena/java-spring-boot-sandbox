package com.christianjaena.controller;

import com.christianjaena.domain.Flight;
import com.christianjaena.domain.Passenger;
import com.christianjaena.factories.FlightFactory;
import com.christianjaena.repositories.FlightRepository;
import com.christianjaena.services.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FlightController {

    private final FlightService flightService;
    private final FlightFactory flightFactory;
    private final FlightRepository flightRepository;

    public FlightController(FlightService flightService,
                            FlightFactory flightFactory,
                            FlightRepository flightRepository) {
        this.flightService = flightService;
        this.flightFactory = flightFactory;
        this.flightRepository = flightRepository;
    }

    @PostMapping("/flights")
    public ResponseEntity<Flight> createFlight(@RequestBody FlightRequest flightRequest) {
        Flight flight = flightFactory.createFlight(
                flightRequest.getFlightNumber(),
                flightRequest.getOrigin(),
                flightRequest.getDestination(),
                flightRequest.getScheduledDeparture(),
                flightRequest.getScheduledArrival()
        );

        flightRepository.save(flight);
        return ResponseEntity.ok(flight);
    }

    @PostMapping("/flights/{flightNumber}/passengers")
    public ResponseEntity<String> addPassenger(@PathVariable String flightNumber,
                                               @RequestBody Passenger passenger) {
        flightService.addPassengerToFlight(flightNumber, passenger);
        return ResponseEntity.ok("Passenger added");
    }
}
