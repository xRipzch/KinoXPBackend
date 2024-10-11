package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.Movie;
import com.example.kinoxpbackend.services.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DeleteMappingTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieRestController movieRestController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(movieRestController).build();
    }

    @Test
    void testDeleteMovie() throws Exception {
        // Prepare a Movie object
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Test Movie");

        // Mock the service findMovieById method
        when(movieService.findMovieById(1)).thenReturn(Optional.of(movie));

        // Perform DELETE request to /movie/1
        mockMvc.perform(delete("/movie/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Verify that the service deleteMovie method was called
        verify(movieService, times(1)).deleteMovie(movie);
    }

    @Test
    void testDeleteMovieNotFound() throws Exception {
        // Mock the service findMovieById method to return empty
        when(movieService.findMovieById(1)).thenReturn(Optional.empty());

        // Perform DELETE request to /movie/1
        mockMvc.perform(delete("/movie/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        // Verify that the service deleteMovie method was not called
        verify(movieService, times(0)).deleteMovie(any(Movie.class));
    }
}