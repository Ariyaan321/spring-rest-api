package com.restAPI.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(FlightRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Flight("AI101", "Delhi", "Mumbai")));
            log.info("Preloading " + repository.save(new Flight("AI202", "Mumbai", "Bangalore")));
        };
    }
}
