package com.example.kinoxpbackend.config;
import com.example.kinoxpbackend.models.*;
import com.example.kinoxpbackend.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitData implements CommandLineRunner {



    @Autowired
    MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        Movie movie1 = new Movie();
        movie1.setTitle("Saw CCCCCCCC ASD ASD");
        movie1.setDescription("Lots of gore Lots of goSAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAE AWEAWE AWE AWE AWE AWE AWE AWE AWE AWE AWE AWE AWE AWE ADSD AWEAreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of gore");
        movie1.setDurationInMinutes(1181);
        movie1.setReleaseYear(LocalDate.of(2025, 7, 7));
        movie1.setImageUrl("https://i0.wp.com/bloody-disgusting.com/wp-content/uploads/2023/07/saw-x-poster.jpg?resize=740%2C925&ssl=1");
        movieRepository.save(movie1);

    }
}
