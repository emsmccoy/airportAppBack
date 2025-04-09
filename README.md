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

## Frontend Part

| Task                       | Estimated Time | Actual Time | Impediments | New Concepts |
| -------------------------- | -------------- | ----------- | ----------- | ------------ |
| Set up React project       | 1 hour         |             |             |              |
| Install dependencies       | 30 minutes     |             |             |              |
| Organize project structure | 1 hour         |             |             |              |
| Implement ApiContext       | 2 hours        |             |             |              |
| Develop custom hooks       | 3 hours        |             |             |              |
| Create layout components   | 2 hours        |             |             |              |
| Set up routing             | 1 hour         |             |             |              |
| **Total**                  | **11 hours**   |             |             |              |

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

## Future Improvements
