package com.airportapp.airport_app.repository;

import com.airportapp.airport_app.model.Airport;
import com.airportapp.airport_app.model.Flight;
import com.airportapp.airport_app.model.FlightStatus;
import com.airportapp.airport_app.model.Plane;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class FlightSpecification {
    public static Specification<Flight> findByParameters(
        String flightNumber,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime,
        FlightStatus status,
        Airport departureAirport,
        Airport arrivalAirport,
        Plane plane
    ){
       return (Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
          Predicate predicate = criteriaBuilder.conjunction();
            Join<Airport, Flight> departureAirportJoin = root.join("departureAirport", JoinType.INNER);
            Join<Flight, Airport> arrivalAirportJoin = root.join("arrivalAirport", JoinType.INNER);
            Join<Flight, Plane> planeJoin = root.join("plane", JoinType.INNER);
            if (flightNumber != null && !flightNumber.isEmpty()){
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("flightNumber"), flightNumber));
            }
            // the rest of conditions for predicate
            return predicate;
        };
    }
}
