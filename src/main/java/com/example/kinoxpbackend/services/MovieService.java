package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.Movie;
import com.example.kinoxpbackend.repositories.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final RestTemplate restTemplate;

    public MovieService(MovieRepository movieRepository, RestTemplate restTemplate) {
        this.movieRepository = movieRepository;
        this.restTemplate = restTemplate;
    }

    public Movie saveMovie (Movie movie) {
       return movieRepository.save(movie);

    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public void deleteMovie(Movie movie){
        movieRepository.delete(movie);
        // TODO FK-restraints osv.
    }
    

}
