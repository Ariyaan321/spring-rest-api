package com.restAPI.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
class FlightController {

    private final FlightRepository repository;

    FlightController(FlightRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Flight> getAllFlights(@RequestParam(required = false, defaultValue = "asc") String sort) {
        List<Flight> flights = repository.findAll();
        return sort.equals("desc")
                ? flights.stream().sorted((f1, f2) -> f2.getId().compareTo(f1.getId())).collect(Collectors.toList())
                : flights.stream().sorted((f1, f2) -> f1.getId().compareTo(f2.getId())).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    Flight getFlightById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
    }
}
