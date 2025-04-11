# Airport App

## Overview

This document serves as a guide and log for the full-stack development of the **Airport App** project. It outlines the tasks completed, testing performed, estimated and actual time spent on tasks, impediments encountered, and new concepts learned.

## PR Submission Checklist

## **Completed Tasks**:

### Backend

- [x]  Set up the Spring Boot project using Spring Initializr.

- [x]  Create entity classes (`Airport`, `Flight`, `Plane`) with JPA annotations.

- [x]  Implement repository interfaces (`AirportRepository`, `FlightRepository`, `PlaneRepository`).

- [x]  Develop service classes (`AirportService`, `FlightService`, `PlaneService`) for business logic.

- [x]  Implement controllers for RESTful API endpoints.
  
  ### Frontend

- [ ]  Set up the React project using `create-react-app`.

- [ ]  Install necessary dependencies like Material UI, Axios, and React Router DOM.

- [ ]  Organize the project structure into folders like `components`, `pages`, `context`, `hooks`, and `services`.

- [ ]  Implement an `ApiContext` to manage API requests, loading states, and errors.

- [ ]  Develop custom hooks like `useAirports`, `useFlights`, and `usePlanes`.

- [ ]  Create layout components like `Header`, `Sidebar`, and `Footer` using Material UI.

- [ ]  Set up routing using React Router DOM.

## **Testing**:

- [ ]  Unit testing for backend services.

- [ ]  Integration testing for API interactions.

- [ ]  UI testing for frontend components.

## Estimated Time for Tasks

## Backend Part

| Task                            | Estimated Time | Actual Time        | Impediments                                                                         | New Concepts |
| ------------------------------- | -------------- | ------------------ | ----------------------------------------------------------------------------------- | ------------ |
| Set up Spring Boot project      | 1 hour         | 15 min             |                                                                                     |              |
| Create entity classes           | 2 hours        | 2 hours            | Not able to load data through data.sql or create tables automatically from entities |              |
| Implement repository interfaces | 1 hour         | 10 min             |                                                                                     |              |
| Develop service classes         | 2 hours        | 1 hour             |                                                                                     |              |
| Implement controllers           | 2 hours        | 1 hour             |                                                                                     |              |
| **Total**                       | **8 hours**    | **4 hours 25 min** |                                                                                     |              |

### Optional tasks

| Task                                                                           | Estimated Time | Actual Time | Impediments | New Concepts                        |
| ------------------------------------------------------------------------------ | -------------- | ----------- | ----------- | ----------------------------------- |
| Add pagination to Flight class and FlightList component (backend and frontend) | 2 hours        | 3 hours     |             | Page, Pageable, DTO, PageRequest.of |
| Add flight filter                                                              | 2 hours        | 3 hours     |             | Specification, date-time parsing    |
|                                                                                |                |             |             |                                     |
|                                                                                |                |             |             |                                     |
| **Total**                                                                      | **4 hours**    | **6 hours** |             |                                     |

## Endpoint Documentation

## **Airport Controller**

## **Base URL**: `/api/v1/airports`

## **Endpoints**

**1. Get All Airports**

- **URL**: `/`

- **Method**: `GET`

- **Parameters**:
  
  - `page` (optional, default: 0) - Page number for pagination
  
  - `size` (optional, default: 10) - Number of items per page

- **Response**: `Page<Airport>` - A paginated list of airports

- **Description**: Retrieves a paginated list of all airports.

**2. Get Airport by ID**

- **URL**: `/{id}`

- **Method**: `GET`

- **Parameters**:
  
  - `id` (path) - The ID of the airport to retrieve

- **Response**: `ResponseEntity<Airport>` - The airport with the given ID or 404 if not found

- **Description**: Retrieves a specific airport by its ID.

**3. Create Airport**

- **URL**: `/`

- **Method**: `POST`

- **Request Body**: `Airport` - The airport object to be created

- **Response**: `Airport` - The created airport object

- **Description**: Creates a new airport entry.

**4. Update Airport**

- **URL**: `/{id}`

- **Method**: `PUT`

- **Parameters**:
  
  - `id` (path) - The ID of the airport to update

- **Request Body**: `Airport` - The updated airport object

- **Response**: `ResponseEntity<Airport>` - The updated airport or 404 if not found

- **Description**: Updates an existing airport by its ID.

**5. Delete Airport**

- **URL**: `/{id}`

- **Method**: `DELETE`

- **Parameters**:
  
  - `id` (path) - The ID of the airport to delete

- **Response**: `ResponseEntity<Void>` - 200 OK if deleted, 404 if not found

- **Description**: Deletes an airport by its ID.

**6. Get Departures**

- **URL**: `/{id}/departures`

- **Method**: `GET`

- **Parameters**:
  
  - `id` (path) - The ID of the airport to get departures from

- **Response**: `ResponseEntity<List<Flight>>` - List of flights departing from the airport

- **Description**: Retrieves all flights departing from a specific airport.

**7. Get Arrivals**

- **URL**: `/{id}/arrivals`

- **Method**: `GET`

- **Parameters**:
  
  - `id` (path) - The ID of the airport to get arrivals for

- **Response**: `ResponseEntity<List<Flight>>` - List of flights arriving at the airport

- **Description**: Retrieves all flights arriving at a specific airport.

## **Flight Controller**

## **Base URL**: `/api/v1/flights`

## **Endpoints**

**1. Get All Flights**

- **URL**: `/`

- **Method**: `GET`

- **Parameters**:
  
  - `page` (optional, default: 0) - Page number for pagination
  
  - `size` (optional, default: 5) - Number of items per page

- **Response**: `ResponseEntity<Page<Flight>>` - A paginated list of flights

- **Description**: Retrieves a paginated list of all flights.

**2. Get Flight by ID**

- **URL**: `/{id}`

- **Method**: `GET`

- **Parameters**:
  
  - `id` (path) - The ID of the flight to retrieve

- **Response**: `ResponseEntity<Flight>` - The flight with the given ID or 404 if not found

- **Description**: Retrieves a specific flight by its ID.

**3. Create Flight**

- **URL**: `/`

- **Method**: `POST`

- **Request Body**: `Flight` - The flight object to be created

- **Response**: `Flight` - The created flight object

- **Description**: Creates a new flight entry.

**4. Update Flight**

- **URL**: `/{id}`

- **Method**: `PUT`

- **Parameters**:
  
  - `id` (path) - The ID of the flight to update

- **Request Body**: `Flight` - The updated flight object

- **Response**: `ResponseEntity<Flight>` - The updated flight or 404 if not found

- **Description**: Updates an existing flight by its ID.

**5. Delete Flight**

- **URL**: `/{id}`

- **Method**: `DELETE`

- **Parameters**:
  
  - `id` (path) - The ID of the flight to delete

- **Response**: `ResponseEntity<Void>` - 200 OK if deleted, 404 if not found

- **Description**: Deletes a flight by its ID.

**6. Filter Flights**

- **URL**: `/filter`

- **Method**: `GET`

- **Parameters**:
  
  - `flightNumber` (optional) - Filter by flight number
  
  - `departureTime` (optional) - Filter by departure time (ISO 8601 format)
  
  - `arrivalTime` (optional) - Filter by arrival time (ISO 8601 format)
  
  - `status` (optional) - Filter by flight status (e.g., ON_TIME, DELAYED)
  
  - `departureAirport` (optional) - Filter by departure airport code
  
  - `arrivalAirport` (optional) - Filter by arrival airport code
  
  - `plane` (optional) - Filter by plane model or ID

- **Response**: `List<Flight>` - A list of flights matching the filter criteria

- **Description**: Retrieves flights based on various filter criteria.

## **Plane Controller**

## **Base URL**: `/api/v1/planes`

## **Endpoints**

**1. Get All Planes**

- **URL**: `/`

- **Method**: `GET`

- **Parameters**:
  
  - `page` (optional, default: 0) - Page number for pagination
  
  - `size` (optional, default: 10) - Number of items per page

- **Response**: `ResponseEntity<Page<Plane>>` - A paginated list of planes

- **Description**: Retrieves a paginated list of all planes.

**2. Get Plane by ID**

- **URL**: `/{id}`

- **Method**: `GET`

- **Parameters**:
  
  - `id` (path) - The ID of the plane to retrieve

- **Response**: `ResponseEntity<Plane>` - The plane with the given ID or 404 if not found

- **Description**: Retrieves a specific plane by its ID.

**3. Create Plane**

- **URL**: `/`

- **Method**: `POST`

- **Request Body**: `Plane` - The plane object to be created

- **Response**: `ResponseEntity<Plane>` - The created plane object with 201 Created status

- **Description**: Creates a new plane entry.

**4. Update Plane**

- **URL**: `/{id}`

- **Method**: `PUT`

- **Parameters**:
  
  - `id` (path) - The ID of the plane to update

- **Request Body**: `Plane` - The updated plane object

- **Response**: `ResponseEntity<Plane>` - The updated plane or 404 if not found

- **Description**: Updates an existing plane by its ID.

**5. Delete Plane**

- **URL**: `/{id}`

- **Method**: `DELETE`

- **Parameters**:
  
  - `id` (path) - The ID of the plane to delete

- **Response**: `ResponseEntity<Void>` - 204 No Content if deleted, 404 if not found

- **Description**: Deletes a plane by its ID.

## **Notes**

- **Pagination**: All endpoints that return lists support pagination through `page` and `size` parameters.

- **Sorting**: Sorting can be applied to paginated results by adding `sort` parameters (e.g., `?sort=departureTime,asc`).

- **Cross-Origin**: All endpoints allow cross-origin requests from `http://localhost:5173`.

- **Error Handling**: Standard HTTP status codes are used for error responses (e.g., 404 for not found, 400 for bad requests).

- **Security**: Ensure that appropriate security measures are in place, especially for endpoints that modify data (POST, PUT, DELETE).

## Error Documentation and Solutions

### Error: Table Creation Error due to Folder Structure

**Corresponding Task:** Create entity classes

**Description:** The application fails to create H2 database tables because Spring Data JPA doesn't detect repositories and entities due to incorrect package structure.

**Error Trace:**

- **Component:** Spring Data JPA

- **File:** AirportAppApplication.java

- **Line:** No explicit error line (package-level issue)

- **Log Evidence:**  
  `Finished Spring Data repository scanning in 13 ms. Found 0 JPA repository interfaces`

**Explanation:** components were not under `com.airportapp.airport_app`

---

## 
