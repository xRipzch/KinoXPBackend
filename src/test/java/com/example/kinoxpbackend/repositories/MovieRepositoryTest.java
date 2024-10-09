package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MovieRepositoryTest {
  @Autowired
  private   MovieRepository movieRepository;

  @Test
  void testAtLeastOneMovie() {
      List<Movie> allMovies = (List<Movie>) movieRepository.findAll();
      assertTrue(allMovies.size() > 0);
  }

}