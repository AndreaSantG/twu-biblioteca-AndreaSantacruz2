package com.twu.biblioteca.model;

public class Book {
    private String title;
    private String author;
    private int yearPublished;
    private int status;
    private int code;

    public Book(String title, String author, int yearPublished, int status, int code) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.status = status;
        this.code = code;
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
}
