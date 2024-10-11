package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.ReservedSeat;
import com.example.kinoxpbackend.repositories.ReservedSeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservedSeatService {
    private final ReservedSeatRepository reservedSeatRepository;

    public ReservedSeatService(ReservedSeatRepository reservedSeatRepository) {
        this.reservedSeatRepository = reservedSeatRepository;
    }
    public List<ReservedSeat> findAllByShowingId(int reservationId) {
        return reservedSeatRepository.findAllByReservationId(reservationId);
    }
}
