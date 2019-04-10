package com.twu.biblioteca.model;

public class Movie {

    private String name;
    private int year;
    private String director;
    private int rating;
    private int status;
    private int code;

    public Movie(String name, int year, String director, int rating, int status, int code) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.status = status;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public int getYearMovie() {
        return this.year;
    }

    public String getDirector() {
        return this.director;
    }

    public int getRating() {
        return this.rating;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return this.code;
    }
}
