package com.example.kinoxpbackend.controllers;


import com.example.kinoxpbackend.models.TempReservedSeat;
import com.example.kinoxpbackend.services.TempReservedSeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;


@RestController
public class TempReservedSeatRestController {
    private final TempReservedSeatService tempReservedSeatService;

    public TempReservedSeatRestController(TempReservedSeatService tempReservedSeatService) {
        this.tempReservedSeatService = tempReservedSeatService;
    }

    @GetMapping("/temp-reserved-seats/{showingId}")
    List<TempReservedSeat> findAllByShowingId(@PathVariable int showingId) {
        return tempReservedSeatService.findAllByShowingId(showingId);
    }

    @GetMapping("/temp-reserved-seat/{id}")
    public ResponseEntity<TempReservedSeat> findById(@PathVariable int id) {
        Optional<TempReservedSeat> seat = tempReservedSeatService.findSeatById(id);
        return seat.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}

