package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.Movie;
import com.example.kinoxpbackend.models.Seat;
import com.example.kinoxpbackend.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SeatRestController {

    private SeatService seatService;

    @Autowired
    public SeatRestController(SeatService seatService) {
        this.seatService = seatService;

    }
    @GetMapping("/seats")
    List<Seat> findAllByTheaterId(int theaterId) {
        return seatService.findAllByTheaterId(theaterId);
    }

    @GetMapping("/seat/{id}")
    public ResponseEntity<Seat> findById(@PathVariable int id) {
        Optional<Seat> seat = seatService.findSeatById(id);
        return seat.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


}
