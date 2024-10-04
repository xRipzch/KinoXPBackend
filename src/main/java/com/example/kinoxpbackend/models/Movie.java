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
    private LocalDate releaseYear;

    @Column (nullable = false, length = 1000) // Long varchar because yes.
    private String description;

    @Column (nullable = false, length = 2000) // Long varchar
    private String imageUrl;

    @Column (nullable = false)
    private boolean is3d;

    public Movie() {
    }

    public Movie(int id, String title, int durationInMinutes, LocalDate releaseYear, String description, String imageUrl, boolean is3d) {
        this.id = id;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
        this.releaseYear = releaseYear;
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

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDate releaseYear) {
        this.releaseYear = releaseYear;
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
