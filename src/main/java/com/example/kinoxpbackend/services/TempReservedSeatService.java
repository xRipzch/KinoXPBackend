package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.Seat;
import com.example.kinoxpbackend.models.TempReservedSeat;
import com.example.kinoxpbackend.repositories.TempReservedSeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TempReservedSeatService {

    private final TempReservedSeatRepository tempReservedSeatRepository;

    public TempReservedSeatService(TempReservedSeatRepository tempReservedSeatRepository) {
        this.tempReservedSeatRepository = tempReservedSeatRepository;
    }

    public List<TempReservedSeat> findAllByShowingId(int showingId) {
        return tempReservedSeatRepository.findAllByShowingId(showingId);
    }

    public Optional<TempReservedSeat> findSeatById(int id) {
        return tempReservedSeatRepository.findById(id);
    }
}
