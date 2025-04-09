package com.airportapp.airport_app.service;

import com.airportapp.airport_app.model.Airport;
import com.airportapp.airport_app.model.Flight;
import com.airportapp.airport_app.model.FlightStatus;
import com.airportapp.airport_app.model.Plane;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    Page<Flight> findAll(Pageable pageable);
    Optional<Flight> findById(Long id);
    Flight save(Flight flight);
    void deleteById(Long id);
    List<Flight> getFilteredFlights(
            String flightNumber,
            LocalDateTime departureTime,
            LocalDateTime arrivalTime,
            FlightStatus status,
            String departureAirport,
            String arrivalAirport,
            String plane
    );
}
