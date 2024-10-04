package com.example.kinoxpbackend.models;

import jakarta.persistence.*;

@Entity
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private int id;

    @Column (nullable = false, unique = true) // Unique and not null.
    private String type;

    public SeatType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public SeatType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
