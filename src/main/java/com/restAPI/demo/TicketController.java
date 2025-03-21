package com.restAPI.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
class TicketController {

    private final TicketRepository ticketRepo;
    private final FlightRepository flightRepo;

    TicketController(TicketRepository ticketRepo, FlightRepository flightRepo) {
        this.ticketRepo = ticketRepo;
        this.flightRepo = flightRepo;
    }

    @PostMapping
    Ticket createTicket(@RequestBody Ticket ticket) {
        if (!flightRepo.existsById(ticket.getFlightId())) {
            throw new RuntimeException("Flight does not exist");
        }
        return ticketRepo.save(ticket);
    }

    @GetMapping("/{id}")
    Ticket getTicket(@PathVariable Long id) {
        return ticketRepo.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    @DeleteMapping("/{id}")
    void deleteTicket(@PathVariable Long id) {
        ticketRepo.deleteById(id);
    }
}
