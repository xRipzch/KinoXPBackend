package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Reservation;
import com.example.kinoxpbackend.models.ReservedSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findAllByShowingId(int showingId);

}
