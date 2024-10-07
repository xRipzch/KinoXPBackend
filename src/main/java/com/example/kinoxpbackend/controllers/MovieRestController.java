package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.Movie;
import com.example.kinoxpbackend.repositories.MovieRepository;
import com.example.kinoxpbackend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieRestController {

    private static final Logger logger = LoggerFactory.getLogger(MovieRestController.class);

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> findById(@PathVariable int id) {
        Optional<Movie> movie = movieService.findMovieById(id);
        return movie.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/movie", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        logger.info("Received movie: {}", movie);
        try {
            if (movie.getImageUrl() == null || movie.getImageUrl().isEmpty()) {
                logger.error("Validation failed: imageUrl is null or empty");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            Movie savedMovie = movieService.saveMovie(movie);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
        } catch (Exception e) {
            logger.error("Error creating movie", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(value = "/movie", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Movie> createMovieFromForm(@ModelAttribute Movie movie) {
        logger.info("Received movie from form: {}", movie);
        try {
            if (movie.getImageUrl() == null || movie.getImageUrl().isEmpty()) {
                logger.error("Validation failed: imageUrl is null or empty");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            Movie savedMovie = movieService.saveMovie(movie);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
        } catch (Exception e) {
            logger.error("Error creating movie from form", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie movie) {
        Optional<Movie> optionalMovie = movieService.findMovieById(id);
        if(optionalMovie.isPresent()) {
            movieService.saveMovie(movie);
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id) {
        Optional<Movie> optionalMovie = movieService.findMovieById(id);

        if (optionalMovie.isPresent()) {
            movieService.deleteMovie(optionalMovie.get());
            return ResponseEntity.ok("Movie deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
    }
}