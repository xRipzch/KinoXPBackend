package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.models.Showing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ShowingRepository extends JpaRepository<Showing, Integer>{
      @Query("SELECT s FROM Showing s WHERE DATE(s.startTime) = :date")
      List<Showing> findAllByDate(@Param("date") LocalDate date);

    List<Showing> findByTheaterAndDate(Long theaterId, LocalDate date);
}


