package com.christianjaena.repositories;

import com.christianjaena.domain.Passenger;

public interface PassengerRepository {

    Passenger findById(Long id);

    void save(Passenger passenger);
}
