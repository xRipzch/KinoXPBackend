package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.Showing;
import com.example.kinoxpbackend.repositories.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShowingService {
    private final ShowingRepository showingRepository;


    public ShowingService(ShowingRepository showingRepository) {
        this.showingRepository = showingRepository;
    }

    public List<Showing> findAll() {
      return   showingRepository.findAll();
    }
    public Optional<Showing> findById(int id) {
        return showingRepository.findById(id);
    }

    public void delete(Showing showing) {
        showingRepository.delete(showing);
    }
    public Showing save(Showing showing) {
        return showingRepository.save(showing);
    }
    public Showing update(Showing showing) {
        return showingRepository.save(showing);
    }

    public List<Showing> findAllByDate(LocalDate date) {
        return showingRepository.findAllByDate(date);
    }
}
