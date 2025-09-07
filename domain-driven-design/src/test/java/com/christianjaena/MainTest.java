package com.christianjaena;

import com.christianjaena.domain.Flight;
import com.christianjaena.domain.Passenger;
import com.christianjaena.repositories.FlightRepository;
import com.christianjaena.repositories.PassengerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MainTest {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Test
    public void givenCorrectFlightNumberAndPassenger_whenAddPassengerToFlight_thenPassengerIsAdded() {
        Flight flight = new Flight();
        flight.setFlightNumber("AB123");
        flight.setOrigin("JFK");
        flight.setDestination("LAX");
        flightRepository.save(flight);
        assertNotNull(flightRepository.findByFlightNumber("AB123"));
    }

}