package com.christianjaena.domain;

public class Passenger {

    private Long id;

    private String name;

    private SeatAssignment seatAssignment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SeatAssignment getSeatAssignment() {
        return seatAssignment;
    }

    public void setSeatAssignment(SeatAssignment seatAssignment) {
        this.seatAssignment = seatAssignment;
    }
}
