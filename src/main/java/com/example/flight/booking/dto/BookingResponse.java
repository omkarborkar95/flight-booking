package com.example.flight.booking.dto;

public class BookingResponse {
    private String bookingId;
    private String flightNumber;
    private String passengerName;
    private String status;

    public BookingResponse(String bookingId, String flightNumber, String passengerName, String status) {
        this.bookingId = bookingId;
        this.flightNumber = flightNumber;
        this.passengerName = passengerName;
        this.status = status;
    }

    public String getBookingId() { return bookingId; }
    public String getFlightNumber() { return flightNumber; }
    public String getPassengerName() { return passengerName; }
    public String getStatus() { return status; }
}
