package com.example.flight.booking.model;

public class Flight {
    private String flightNumber;
    private int capacity;
    private int bookedSeats;

    public Flight(String flightNumber, int capacity) {
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.bookedSeats = 0;
    }

    public String getFlightNumber() { return flightNumber; }
    public int getCapacity() { return capacity; }
    public int getBookedSeats() { return bookedSeats; }

    public boolean hasAvailableSeat() {
        return bookedSeats < capacity;
    }

    public void bookSeat() {
        bookedSeats++;
    }
}
