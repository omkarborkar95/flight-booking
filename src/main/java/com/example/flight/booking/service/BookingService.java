package com.example.flight.booking.service;

import com.example.flight.booking.dto.BookingResponse;
import com.example.flight.booking.dto.CreateBookingRequest;
import com.example.flight.booking.model.Booking;
import com.example.flight.booking.model.Flight;
import com.example.flight.booking.repository.BookingRepository;
import com.example.flight.booking.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService {
    private final FlightRepository flightRepository;
    private final BookingRepository bookingRepository;

    public BookingService(FlightRepository flightRepository, BookingRepository bookingRepository) {
        this.flightRepository = flightRepository;
        this.bookingRepository = bookingRepository;
    }

    public synchronized BookingResponse createBooking(String flightNumber, CreateBookingRequest request) {
        if (request.getPassengerName() == null || request.getPassengerName().isBlank()) {
            throw new IllegalArgumentException("Passenger name is required");
        }

        Flight flight = flightRepository.findByFlightNumber(flightNumber)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));

        if (!flight.hasAvailableSeat()) {
            throw new FlightFullException("Flight is fully booked");
        }

        flight.bookSeat();

        Booking booking = new Booking(
                UUID.randomUUID().toString(),
                flightNumber,
                request.getPassengerName()
        );

        bookingRepository.save(booking);

        return new BookingResponse(
                booking.getBookingId(),
                booking.getFlightNumber(),
                booking.getPassengerName(),
                "CONFIRMED"
        );
    }
}
