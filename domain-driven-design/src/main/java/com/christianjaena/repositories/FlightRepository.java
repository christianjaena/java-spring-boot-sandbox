package com.christianjaena.repositories;

import com.christianjaena.domain.Flight;

public interface FlightRepository {
    Flight findByFlightNumber(String flightNumber);

    void save(Flight flight);
}
