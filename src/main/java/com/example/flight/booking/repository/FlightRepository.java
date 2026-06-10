package com.example.flight.booking.repository;
import com.example.flight.booking.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class FlightRepository {
    private final Map<String, Flight> flights = new HashMap<>();

    public FlightRepository() {
        flights.put("AI101", new Flight("AI101", 2));
        flights.put("BA202", new Flight("BA202", 100));
    }

    public Optional<Flight> findByFlightNumber(String flightNumber) {
        return Optional.ofNullable(flights.get(flightNumber));
    }
}
