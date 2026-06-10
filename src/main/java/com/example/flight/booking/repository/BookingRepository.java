package com.example.flight.booking.repository;

import com.example.flight.booking.model.Booking;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookingRepository {
    private final Map<String, Booking> bookings = new HashMap<>();

    public Booking save(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
        return booking;
    }

}
