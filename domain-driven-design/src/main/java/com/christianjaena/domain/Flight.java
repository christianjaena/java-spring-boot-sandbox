package com.christianjaena.domain;

import jakarta.persistence.Transient;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Flight {

    private String flightNumber;

    private String origin;

    private String destination;

    private LocalDateTime scheduledDeparture;

    private LocalDateTime scheduledArrival;

    private List<Passenger> passengers = new ArrayList<>();

    @Transient
    private Collection<Object> events;

    @DomainEvents
    Collection<Object> domainEvents() {
        return events;
    }

    @AfterDomainEventPublication
    void clearDomainEvents() {
        domainEvents().clear();;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(LocalDateTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public LocalDateTime getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(LocalDateTime scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Collection<Object> getEvents() {
        return events;
    }

    public void setEvents(Collection<Object> events) {
        this.events = events;
    }
}
