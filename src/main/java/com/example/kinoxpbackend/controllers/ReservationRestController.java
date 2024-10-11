package com.example.kinoxpbackend.controllers;
import com.example.kinoxpbackend.models.Reservation;
import com.example.kinoxpbackend.services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationRestController {

    private final ReservationService reservationService;

    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping("/reservations")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> findById(@PathVariable int id) {
        Optional<Reservation> optionalReservation = reservationService.findById(id);
        return optionalReservation.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/reservations/{showingId}")
    public List<Reservation> findByShowingId(@PathVariable int showingId) {
        return reservationService.findAllByShowingId(showingId);
    }
}