package com.restAPI.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ticket {

    private @Id @GeneratedValue Long id;
    private String passengerName;
    private Long flightId;

    Ticket() {
    }

    public Ticket(String passengerName, Long flightId) {
        this.passengerName = passengerName;
        this.flightId = flightId;
    }

    public Long getId() {
        return id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
