package com.airportapp.airport_app.service;

import com.airportapp.airport_app.model.Airport;
import com.airportapp.airport_app.model.Flight;
import com.airportapp.airport_app.model.FlightStatus;
import com.airportapp.airport_app.model.Plane;
import com.airportapp.airport_app.repository.AirportRepository;
import com.airportapp.airport_app.repository.FlightRepository;
import com.airportapp.airport_app.repository.FlightSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService{

    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    @Override
    public Page<Flight> findAll(Pageable pageable){
        return flightRepository.findAll(pageable);
    }

    @Override
    public Optional<Flight> findById(Long id){
        return flightRepository.findById(id);
    }

    @Override
    public Flight save(Flight flight){
        return flightRepository.save(flight);
    }

    @Override
    public void deleteById(Long id){
        flightRepository.deleteById(id);
    }

    @Override
    public List<Flight> getFilteredFlights(String flightNumber, LocalDateTime departureTime, LocalDateTime arrivalTime, FlightStatus status, String departureAirport, String arrivalAirport, String plane){
        return flightRepository.findAll(FlightSpecification.findByParameters(
                flightNumber,
                departureTime,
                arrivalTime,
                status,
                departureAirport,
                arrivalAirport,
                plane
        )
        );
    }
}
