package com.twu.biblioteca.model;

public class Movie implements ILibraryItem{

    private String title;
    private String author;
    private int yearPublished;
    private int status;
    private int code;
    private int rating;
    private String type;

    public Movie(String title, String author, int yearPublished, int status, int code, int rating) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.status = status;
        this.code = code;
        this.rating = rating;
        this.type = "movie";
    }

    public String getTitle() { return this.title; }
    public String getAuthor() {
        return author;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public int getStatus() { return this.status; }
    public int getCode() { return this.code; }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getRating() {
        return this.rating;
    }
    public String getType() {
        return this.type;
    }


}
