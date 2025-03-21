package com.restAPI.demo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
class FlightController {

    private final FlightRepository repository;
    private final FlightScheduleRepository scheduleRepository;

    FlightController(FlightRepository repository, FlightScheduleRepository scheduleRepository) {
        this.repository = repository;
        this.scheduleRepository = scheduleRepository;
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

    @GetMapping("/{id}/schedules")
    List<FlightSchedule> getFlightSchedules(@PathVariable Long id, @RequestParam String dates) {
        LocalDate date = LocalDate.parse(dates);
        return scheduleRepository.findByFlightIdAndDate(id, date);
    }
}
