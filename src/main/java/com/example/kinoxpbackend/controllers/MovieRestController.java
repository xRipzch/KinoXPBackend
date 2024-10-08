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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MovieRestController {

    private static final Logger logger = LoggerFactory.getLogger(MovieRestController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> findById(@PathVariable int id) {
        Optional<Movie> movie = movieService.findMovieById(id);
        return movie.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/movies")
    public ResponseEntity<Movie> getMovie(@RequestParam String search) {
        System.out.println("Search input: " + search);  // Log the input search query
        try {
            Integer id = Integer.parseInt(search);  // Trying to parse ID
            System.out.println("Searching by ID: " + id);
            Optional<Movie> movie = movieRepository.findById(id);
            if (movie.isPresent()) {
                System.out.println("Movie found by ID: " + movie.get());
                return ResponseEntity.ok(movie.get());
            } else {
                System.out.println("No movie found with ID: " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Searching by title: " + search);
            Optional<Movie> movie = movieRepository.findByTitleIgnoreCase(search);
            if (movie.isPresent()) {
                System.out.println("Movie found by Title: " + movie.get());
                return ResponseEntity.ok(movie.get());
            } else {
                System.out.println("No movie found with Title: " + search);
            }
        }
        System.out.println("Movie not found: " + search);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
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

    @PutMapping("/api/movies/{id}")
    public ResponseEntity<Map<String, Object>> updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        Optional<Movie> existingMovie = movieRepository.findById(id);

        if (existingMovie.isPresent()) {
            Movie updatedMovie = existingMovie.get();
            updatedMovie.setTitle(movie.getTitle());
            updatedMovie.setDescription(movie.getDescription());
            updatedMovie.setDurationInMinutes(movie.getDurationInMinutes());
            updatedMovie.setReleaseDate(movie.getReleaseDate());
            updatedMovie.setIs3d(movie.isIs3d());
            updatedMovie.setImageUrl(movie.getImageUrl());

            movieRepository.save(updatedMovie);  // Save the updated movie

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            return ResponseEntity.ok(response);  // Return JSON response
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Movie not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
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