package com.example.kinoxpbackend.config;
import com.example.kinoxpbackend.models.*;
import com.example.kinoxpbackend.repositories.MovieRepository;
import com.example.kinoxpbackend.repositories.ShowingRepository;
import com.example.kinoxpbackend.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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


    }
}
