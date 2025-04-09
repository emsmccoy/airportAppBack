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
            String departureAirport,
            String arrivalAirport,
            String plane
    ) {
        return (Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            Join<Airport, Flight> departureAirportJoin = root.join("departureAirport", JoinType.INNER);
            Join<Flight, Airport> arrivalAirportJoin = root.join("arrivalAirport", JoinType.INNER);
            Join<Flight, Plane> planeJoin = root.join("plane", JoinType.INNER);

            if (departureAirport != null) {
                root.join("departureAirport", JoinType.INNER);
            }
            if (arrivalAirport != null) {
                root.join("arrivalAirport", JoinType.INNER);
            }
            if (plane != null) {
                root.join("plane", JoinType.INNER);
            }

            if (flightNumber != null && !flightNumber.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("flightNumber"), flightNumber));
            }

            if (departureTime != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("departureTime"), departureTime));
            }

            if (arrivalTime != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("arrivalTime"), arrivalTime));
            }

            if (status != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("flightStatus"), status));
            }

            if (departureAirport != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(departureAirportJoin.get("name"), departureAirport));
            }

            if (arrivalAirport != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(arrivalAirportJoin.get("name"), arrivalAirport));
            }

            if (plane != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(planeJoin.get("model"), plane));
            }

            return predicate;
        };
    }
}
