package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.ReservedSeat;
import com.example.kinoxpbackend.services.ReservedSeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ReservedSeatRestController {
    private final ReservedSeatService reservedSeatService;

    public ReservedSeatRestController(ReservedSeatService reservedSeatService) {
        this.reservedSeatService = reservedSeatService;
    }

    @GetMapping("/reserved-seats/{reservationId}")
    public List<ReservedSeat> findAllByReservationId(@PathVariable int reservationId) {
        return reservedSeatService.findAllByShowingId(reservationId);
    }
}
