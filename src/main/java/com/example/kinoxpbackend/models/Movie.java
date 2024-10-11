package com.example.kinoxpbackend.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    @Column (nullable = false)
    private int id;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false)
    private int durationInMinutes;

    @Column (nullable = false)
    private LocalDate releaseDate; //

    @Column (nullable = false, length = 1000) // Long varchar because yes.
    private String description;

    @Column (nullable = false, length = 2000) // Long varchar. TODO Needs to be not null?
    private String imageUrl;

    @Column (nullable = false)
    private boolean is3d;

    public Movie() {
    }

    public Movie(int id, String title, int durationInMinutes, LocalDate releaseDate, String description, String imageUrl, boolean is3d) {
        this.id = id;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
        this.releaseDate = releaseDate;
        this.description = description;
        this.imageUrl = imageUrl;
        this.is3d = is3d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isIs3d() {
        return is3d;
    }

    public void setIs3d(boolean is3d) {
        this.is3d = is3d;
    }
}
