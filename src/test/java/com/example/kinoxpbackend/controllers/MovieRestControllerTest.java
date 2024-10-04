package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.Movie;
import com.example.kinoxpbackend.repositories.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class MovieRestControllerTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieRestController movieRestController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(movieRestController).build();
    }
}

    /*@Test
    void testCreateMovie() throws Exception {
        // Prepare a Movie object
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Test Movie");
        movie.setDurationInMinutes(120);

        // Mock the repository save method
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);

        // Convert the movie object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String movieJson = objectMapper.writeValueAsString(movie);

        // Perform POST request to /movies/movie
        mockMvc.perform(post("/movies/movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(movieJson))
                .andExpect(status().isOk())  // Expect 200 OK response
                .andExpect(content().json(movieJson));  // Expect returned JSON to match input
    }
}
*/
