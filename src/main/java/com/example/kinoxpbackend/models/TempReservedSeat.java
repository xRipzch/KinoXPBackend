package com.example.kinoxpbackend.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class TempReservedSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne // Foreign key to id in showing. Not null.
    @JoinColumn(name = "showing_id", referencedColumnName = "id", nullable = false)
    private Showing showing;

    @ManyToOne // Foreign key to id in seat. Not null.
    @JoinColumn(name = "seat_id", referencedColumnName = "id", nullable = false)
    private Seat seat;

    public TempReservedSeat(int id, Showing showing, Seat seat) {
        this.id = id;
        this.showing = showing;
        this.seat = seat;
    }

    public TempReservedSeat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
