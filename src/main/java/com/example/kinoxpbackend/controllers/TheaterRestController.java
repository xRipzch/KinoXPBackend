package com.example.kinoxpbackend.controllers;
import com.example.kinoxpbackend.models.Movie;
import com.example.kinoxpbackend.models.Showing;
import com.example.kinoxpbackend.models.Theater;
import com.example.kinoxpbackend.services.ShowingService;
import com.example.kinoxpbackend.services.TheaterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TheaterRestController {

    private final TheaterService theaterService;

    public TheaterRestController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }


    @GetMapping("/theaters")
    public List<Theater> findAll() {
        return theaterService.findAll();
    }

    @GetMapping("/theater/{id}")
    public ResponseEntity<Theater> findById(@PathVariable int id) {
        Optional<Theater> optionalTheater = theaterService.findById(id);
        return optionalTheater.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/theater/{id}")
    public ResponseEntity<Theater> updateTheater(@PathVariable Integer id, @RequestBody Theater theater) {
        Optional<Theater> existingTheater = theaterService.findById(id);

        if (existingTheater.isPresent()) {
            Theater updatedTheater = existingTheater.get();
            updatedTheater.setName(theater.getName());

            theaterService.save(updatedTheater);
            return ResponseEntity.ok(theater);  // Return JSON response
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(theater);
        }
    }

    @PostMapping("/theater")
    public ResponseEntity<Theater> createShowing(@RequestBody Theater theater) {
        try {
            Theater savedTheater = theaterService.save(theater);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTheater);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @DeleteMapping("theater/{id}")
    public ResponseEntity<String> deleteTheater(@PathVariable int id) {
        Optional<Theater> optionalTheater = theaterService.findById(id);

        if (optionalTheater.isPresent()) {
            theaterService.delete(optionalTheater.get());
            return ResponseEntity.ok("Theater successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Theater not found");
        }
    }
}


