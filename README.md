# Flight Booking API

A simple Spring Boot REST API for booking flight tickets.

## Assumptions

* Client already knows the flight number.
* Flights are preloaded in memory.
* No authentication or authorization.
* No database; data is stored in memory only.
* A flight cannot be overbooked.

## Technologies

* Java
* Spring Boot
* Maven

## Running the Application

```bash
./mvnw spring-boot:run
```

The application starts on:

```text
http://localhost:8080
```

## API

### Create Booking

**Request**

```http
POST /flights/AI101/bookings
Content-Type: application/json
```

```json
{
  "passengerName": "Omkar Borkar"
}
```

**Success Response**

```http
201 Created
```

```json
{
  "bookingId": "generated-id",
  "flightNumber": "AI101",
  "passengerName": "Omkar Borkar",
  "status": "CONFIRMED"
}
```

### Error Responses

#### Flight Not Found

```http
404 Not Found
```

#### Flight Fully Booked

```http
409 Conflict
```

#### Invalid Request

```http
400 Bad Request
```

## Preloaded Flights

| Flight Number | Capacity |
| ------------- | -------- |
| AI101         | 2        |
| BA202         | 100      |

## Project Structure

```text
controller  -> REST endpoints
service     -> business logic
repository  -> in-memory storage
model       -> domain objects
dto         -> request/response objects
```

## Future Improvements

* Persist data in a database
* Add unit and integration tests
* Add request validation annotations
* Add booking retrieval APIs
* Improve concurrency handling for high-volume booking scenarios
* Add flight management APIs
