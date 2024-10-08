package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.Showing;
import com.example.kinoxpbackend.services.ShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShowingRestController {

    @Autowired
    ShowingService showingService;

    @GetMapping("/showings")
    public List<Showing> findAll() {
        return showingService.findAll();
    }

    @GetMapping("/showing/{id}")
    public ResponseEntity<Showing> findById(@PathVariable int id) {
        Optional<Showing> optionalShowing = showingService.findById(id);
        return optionalShowing.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/showing/{id}")
    public ResponseEntity<Showing> updateShowing (@PathVariable Integer id, @RequestBody Showing showing) {
        Optional<Showing> existingShowing = showingService.findById(id);
        if (existingShowing.isPresent()) {
            Showing updatedShowing = existingShowing.get();
            updatedShowing.setMovie(showing.getMovie());
            updatedShowing.setTheater(showing.getTheater());
            updatedShowing.setStartTime(showing.getStartTime());
            showingService.save(updatedShowing);
            return ResponseEntity.ok(updatedShowing);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(showing);
        }
    }

    @PostMapping("/showing")
    public ResponseEntity<Showing> createShowing(@RequestBody Showing showing) {
        try {
            Showing savedShowing = showingService.save(showing);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedShowing);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @DeleteMapping("showing/{id}")
    public ResponseEntity<String> deleteShowing(@PathVariable int id) {
        Optional<Showing> optionalShowing = showingService.findById(id);

        if (optionalShowing.isPresent()) {
            showingService.delete(optionalShowing.get());
            return ResponseEntity.ok("Showing successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Showing not found");
        }
    }
}
