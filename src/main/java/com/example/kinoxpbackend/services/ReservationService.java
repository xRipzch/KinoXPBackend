package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.Reservation;
import com.example.kinoxpbackend.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;


    public List<Reservation> findAll() {
        return   reservationRepository.findAll();
    }
    public Optional<Reservation> findById(int id) {
        return reservationRepository.findById(id);
    }

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findAllByShowingId(int showingId) {
        return reservationRepository.findAllByShowingId(showingId);
    }
}
