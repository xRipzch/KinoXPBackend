package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.Movie;
import com.example.kinoxpbackend.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> findAll() {
        return StreamSupport.stream(movieRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
        // TODO FK-restraints osv.
    }
}