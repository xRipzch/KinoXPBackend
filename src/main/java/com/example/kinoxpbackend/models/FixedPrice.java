package com.example.kinoxpbackend.models;

import jakarta.persistence.*;

@Entity
public class FixedPrice {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true) // Unique and not null.
    private String type;

    @Column(nullable = false)
    private double price;

    public FixedPrice(int id, String type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public FixedPrice() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
