package com.example.kinoxpbackend.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ReservedSeat {
    @Id
    @GeneratedValue ( strategy =  GenerationType.IDENTITY)
    private int id;

    @ManyToOne // Foreign key to id in reservation. Not null.
    @JoinColumn(name = "reservation_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Reservation reservation;

    @ManyToOne // Foreign key to id in seat. Not null.
    @JoinColumn (name = "seat_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Seat seat;

    public ReservedSeat(int id, Reservation reservation, Seat seat) {
        this.id = id;
        this.reservation = reservation;
        this.seat = seat;
    }

    public ReservedSeat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
