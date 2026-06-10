package com.example.flight.booking.controller;

import com.example.flight.booking.dto.BookingResponse;
import com.example.flight.booking.dto.CreateBookingRequest;
import com.example.flight.booking.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights/{flightNumber}/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(
            @PathVariable String flightNumber,
            @RequestBody CreateBookingRequest request
    ) {
        BookingResponse response = bookingService.createBooking(flightNumber, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}