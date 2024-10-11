package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.Seat;
import com.example.kinoxpbackend.repositories.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> findAllByTheaterId(int theaterId) {
        return seatRepository.findAllByTheaterId(theaterId);
    }

    public Optional<Seat> findSeatById(int id) {
        return seatRepository.findById(id);
    }
}
