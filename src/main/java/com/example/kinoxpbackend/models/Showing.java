package com.example.kinoxpbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Showing {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // Auto increment
    private int id;

    @ManyToOne // Foreign key to id in movie. Not null.
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Movie movie;

    @ManyToOne // Foreign key to id in theater. Not null.
    @JoinColumn(name = "theater_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Theater theater;

    @Column (nullable = false)
    private LocalDateTime startTime;

    public Showing() {
    }

    public Showing(int id, Movie movie, Theater theater, LocalDateTime startTime) {
        this.id = id;
        this.movie = movie;
        this.theater = theater;
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

}
