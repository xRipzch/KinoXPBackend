package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Seat;
import com.example.kinoxpbackend.models.TempReservedSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TempReservedSeatRepository extends JpaRepository<TempReservedSeat, Integer> {
    List<TempReservedSeat> findAllByShowingId(int showingId);
}
