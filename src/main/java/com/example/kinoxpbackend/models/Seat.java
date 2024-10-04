package com.example.kinoxpbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table (name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private int id;

    @ManyToOne // Foreign key to id in theater. Not null.
    @JoinColumn(name = "theater_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Theater theater;

    @ManyToOne // Foreign key to id in seatType. Not null.
    @JoinColumn(name = "seat_type_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private SeatType seatType;

    @Column(nullable = false)
    private int rowNum;

    @Column(nullable = false)
    private int seatNum;

    public Seat() {
    }

    public Seat(int id, Theater theater, SeatType seatType, int rowNum, int seatNum) {
        this.id = id;
        this.theater = theater;
        this.seatType = seatType;
        this.rowNum = rowNum;
        this.seatNum = seatNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }
}