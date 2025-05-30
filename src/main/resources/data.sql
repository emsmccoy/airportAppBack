-- Inserting mock data
INSERT INTO airport (id, name, code, city, country) VALUES
(1, 'Los Angeles International Airport', 'LAX', 'Los Angeles', 'USA'),
(2, 'John F. Kennedy International Airport', 'JFK', 'New York', 'USA'),
(3, 'Heathrow Airport', 'LHR', 'London', 'UK'),
(4, 'Charles de Gaulle Airport', 'CDG', 'Paris', 'France'),
(5, 'Tokyo Haneda Airport', 'HND', 'Tokyo', 'Japan'),
(6, 'Dubai International Airport', 'DXB', 'Dubai', 'UAE'),
(7, 'Frankfurt Airport', 'FRA', 'Frankfurt', 'Germany'),
(8, 'Singapore Changi Airport', 'SIN', 'Singapore', 'Singapore'),
(9, 'Sydney Kingsford Smith Airport', 'SYD', 'Sydney', 'Australia'),
(10, 'Toronto Pearson International Airport', 'YYZ', 'Toronto', 'Canada');
INSERT INTO plane (id, model, airline, manufacturer, capacity) VALUES
(1, 'Boeing 737', 'Delta Airlines', 'Boeing', 180),
(2, 'Airbus A320', 'American Airlines', 'Airbus', 150),
(3, 'Boeing 747', 'United Airlines', 'Boeing', 366),
(4, 'Airbus A380', 'Emirates', 'Airbus', 853),
(5, 'Cessna 172', 'Private', 'Cessna', 4),
(6, 'Boeing 777', 'Qatar Airways', 'Boeing', 396),
(7, 'Airbus A330', 'Lufthansa', 'Airbus', 277),
(8, 'Boeing 787', 'British Airways', 'Boeing', 242),
(9, 'Bombardier CRJ200', 'Air Canada', 'Bombardier', 50),
(10, 'Embraer E190', 'JetBlue', 'Embraer', 100);
INSERT INTO flight (id, flight_number, departure_time, arrival_time, flight_status, departure_airport_id, arrival_airport_id, plane_id) VALUES
(1, 'FL001', '2025-03-24 08:00:00', '2025-03-24 20:00:00', 0, 3, 7, 4),
(2, 'FL002', '2025-03-26 04:00:00', '2025-03-26 07:00:00', 5, 7, 5, 6),
(3, 'FL003', '2025-03-24 08:00:00', '2025-03-24 20:00:00', 0, 9, 8, 1),
(4, 'FL004', '2025-03-24 16:00:00', '2025-03-25 01:00:00', 1, 2, 5, 10),
(5, 'FL005', '2025-03-24 18:00:00', '2025-03-25 02:00:00', 2, 4, 6, 6),
(6, 'FL006', '2025-03-25 10:00:00', '2025-03-25 15:00:00', 0, 3, 6, 4),
(7, 'FL007', '2025-03-25 11:00:00', '2025-03-25 15:00:00', 0, 6, 5, 4),
(8, 'FL008', '2025-03-24 22:00:00', '2025-03-25 09:00:00', 1, 6, 7, 1),
(9, 'FL009', '2025-03-25 00:00:00', '2025-03-25 09:00:00', 3, 4, 9, 5),
(10, 'FL010', '2025-03-25 00:00:00', '2025-03-25 01:00:00', 0, 1, 10, 3),
(11, 'FL011', '2025-03-24 22:00:00', '2025-03-25 06:00:00', 4, 6, 7, 2),
(12, 'FL012', '2025-03-25 09:00:00', '2025-03-25 19:00:00', 5, 9, 2, 8),
(13, 'FL013', '2025-03-26 07:00:00', '2025-03-26 11:00:00', 1, 5, 2, 1),
(14, 'FL014', '2025-03-24 13:00:00', '2025-03-24 19:00:00', 3, 1, 4, 5),
(15, 'FL015', '2025-03-25 01:00:00', '2025-03-25 06:00:00', 3, 5, 9, 9),
(16, 'FL016', '2025-03-25 19:00:00', '2025-03-25 20:00:00', 0, 2, 1, 2),
(17, 'FL017', '2025-03-24 21:00:00', '2025-03-25 05:00:00', 3, 9, 10, 9),
(18, 'FL018', '2025-03-26 03:00:00', '2025-03-26 13:00:00', 0, 7, 10, 10),
(19, 'FL019', '2025-03-26 03:00:00', '2025-03-26 06:00:00', 1, 8, 1, 2),
(20, 'FL020', '2025-03-24 18:00:00', '2025-03-25 00:00:00', 5, 2, 4, 8);
