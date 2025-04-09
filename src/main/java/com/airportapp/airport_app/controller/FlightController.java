package com.airportapp.airport_app.controller;


import com.airportapp.airport_app.model.Airport;
import com.airportapp.airport_app.model.Flight;
import com.airportapp.airport_app.model.FlightStatus;
import com.airportapp.airport_app.model.Plane;
import com.airportapp.airport_app.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
@CrossOrigin(origins = "http://localhost:5173")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<Page<Flight>> getAllFlights(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Flight> flightPage = flightService.findAll(pageable);

        return ResponseEntity.ok(flightPage);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        return flightService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.save(flight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        return flightService.findById(id)
                .map(existingFlight -> {
                    flight.setId(id);
                    return ResponseEntity.ok(flightService.save(flight));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        return flightService.findById(id)
                .map(flight -> {
                    flightService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/filter")
    public List<Flight> getFilteredFlights(
            @RequestParam(required = false) String flightNumber,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureTime,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalTime,
            @RequestParam(required = false) FlightStatus status,
            @RequestParam(required = false) String departureAirport,
            @RequestParam(required = false) String arrivalAirport,
            @RequestParam(required = false) String plane
    ){
        return flightService.getFilteredFlights(
                flightNumber,
                departureTime,
                arrivalTime,
                status,
                departureAirport,
                arrivalAirport,
                plane
        );
    }

}

