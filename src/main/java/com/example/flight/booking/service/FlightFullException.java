package com.example.flight.booking.service;

public class FlightFullException extends RuntimeException {
    public FlightFullException(String message) {
        super(message);
    }
}
