package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
    Optional<Movie> findByTitleIgnoreCase(String title);
}