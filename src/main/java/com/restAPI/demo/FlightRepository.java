package com.restAPI.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface FlightRepository extends JpaRepository<Flight, Long> {
}
