package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.ReservedSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservedSeatRepository extends JpaRepository<ReservedSeat, Integer> {
    List<ReservedSeat> findAllByReservationId(int reservationId);
}
