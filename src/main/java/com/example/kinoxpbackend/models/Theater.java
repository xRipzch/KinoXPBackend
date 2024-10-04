package com.example.kinoxpbackend.models;

import jakarta.persistence.*;

@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private int id;

    @Column(nullable = false)
    private String name;

    public Theater() {
    }

    public Theater(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
