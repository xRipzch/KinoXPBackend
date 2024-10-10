package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {


    List<Seat> findAllByTheaterId(int theaterId);
}
