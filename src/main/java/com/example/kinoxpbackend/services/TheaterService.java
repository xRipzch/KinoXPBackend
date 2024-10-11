package com.example.kinoxpbackend.services;
import com.example.kinoxpbackend.models.Showing;
import com.example.kinoxpbackend.models.Theater;
import com.example.kinoxpbackend.repositories.ShowingRepository;
import com.example.kinoxpbackend.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> findAll() {
        return theaterRepository.findAll();
    }
    public Optional<Theater> findById(int id) {
        return theaterRepository.findById(id);
    }

    public void delete(Theater theater) {
        theaterRepository.delete(theater);
    }
    public Theater save(Theater theater) {
        return theaterRepository.save(theater);
    }
}
