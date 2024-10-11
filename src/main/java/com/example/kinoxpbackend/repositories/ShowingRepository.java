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

    @Query("SELECT s FROM Showing s WHERE s.theater.id = :theaterId AND DATE(s.startTime) = :date")
    List<Showing> findByTheaterAndDate(@Param("theaterId") Long theaterId, @Param("date") LocalDate date);

    @Query("SELECT s from Showing s WHERE s.movie.id = :movieId AND DATE(s.startTime) = :date")
    List<Showing> findByMovieAndDate(@Param("movieId") int movieId, @Param("date") LocalDate date);
}


