package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
