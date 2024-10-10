package com.example.kinoxpbackend.config;
import com.example.kinoxpbackend.models.*;
import com.example.kinoxpbackend.repositories.MovieRepository;
import com.example.kinoxpbackend.repositories.ShowingRepository;
import com.example.kinoxpbackend.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
/*
@Component
public class InitData implements CommandLineRunner {



    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowingRepository showingRepository;
    @Override
    public void run(String... args) throws Exception {
        Movie movie1 = new Movie();
        movie1.setTitle("Saw X");
        movie1.setDescription("Lots of gore");
        movie1.setDurationInMinutes(118);
        movie1.setReleaseDate(LocalDate.of(2023, 7, 7));
        movie1.setImageUrl("https://i0.wp.com/bloody-disgusting.com/wp-content/uploads/2023/07/saw-x-poster.jpg?resize=740%2C925&ssl=1");
        movieRepository.save(movie1);
        Showing showing = new Showing();
        showing.setMovie(movie1);
        showing.setTheater(theaterRepository.findById(1).get());
        showing.setStartTime(LocalDate.of(2023, 7, 7).atTime(12, 0));
        showingRepository.save(showing);



    }
}
*/