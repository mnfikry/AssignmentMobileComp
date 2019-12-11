package com.example.assignmentmobilecomp;

import com.google.firebase.Timestamp;

public class Movie {
    String description,imageLocation,title;
    private com.google.firebase.Timestamp releaseDate;

    public Movie() {
    }

    public Movie(String description, String imageLocation, String title, Timestamp releaseDate) {
        this.description = description;
        this.imageLocation = imageLocation;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }
}
