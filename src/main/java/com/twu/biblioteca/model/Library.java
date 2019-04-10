package com.twu.biblioteca.model;

import java.util.*;

public class Library {

    private Map<Integer, Book> bookHashMap;
    private Map<Integer, Movie> movieHashMap;
    private List<User>  userList;
    private Map<Integer, User> ckeckedoutBookList;

    public Library(){
        bookHashMap = new LinkedHashMap<>();
        Book book1 = new Book("El amor en tiempos de Colera", "Gabriel Garcia Marquez", 1985, 0, 30);
        Book book2 = new Book("Los primeros tres minutos del universo", "Steven Weinberg", 1977, 0, 40);
        Book book3 = new Book("The Science of Interstellar", "Kip Thorne", 2014, 0, 50);
        Book book4 = new Book("The 4 hour workweek", "Tim Ferriss",2007, 0, 60);
        bookHashMap.put(30, book1);
        bookHashMap.put(40, book2);
        bookHashMap.put(50, book3);
        bookHashMap.put(60, book4);

        movieHashMap = new LinkedHashMap<>();
        Movie movie1 = new Movie("Titanic", 1997, "James Cameron", 9, 0, 300);
        Movie movie2 = new Movie("El Rey Leon", 1994, "Rob Minkoff, Roger Allers", 10, 0, 400);
        Movie movie3 = new Movie("Avatar", 2009, "James Cameron", 0, 0, 500);
        Movie movie4 = new Movie("The night knight", 2008, "Christopher Nolan", 8, 0, 600);
        movieHashMap.put(300, movie1);
        movieHashMap.put(400, movie2);
        movieHashMap.put(500, movie3);
        movieHashMap.put(600, movie4);

        userList = new ArrayList<>();
        User user1 = new User("000-1234","pass1","Carlos","carlos@gmail.com","33434343");
        User user2 = new User("000-5678","pass2","Andres","andres@gmail.com","090909090");
        userList.add(user1);
        userList.add(user2);

        ckeckedoutBookList = new LinkedHashMap<>();
    }

    public Map<Integer, Book> getBookList() {
        return this.bookHashMap;
    }

    public Map<Integer, Movie> getMovieList() {
        return this.movieHashMap;
    }

    public List<User> getUserList() {
        return this.userList;
    }

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one stop-shop for great book titles in Bangalore!";
    }

    public String displayBookList() {
        String displayAllBooks = "";
        for(Book book : bookHashMap.values()){
            if(book.getStatus() == 0){
             displayAllBooks += formatBookList(book);
            }
        }
        return displayAllBooks;
    }


    private String formatBookList(Book book){
        return book.getTitle()+"|"+book.getAuthor()+"|"+book.getYearPublished() + "\n";
    }


    public String checkoutBook(int codeBook, User user) {
        for(Book book : bookHashMap.values()){
            if(book.getCode() == codeBook && book.getStatus() == 0){
                book.setStatus(1);
                this.ckeckedoutBookList.put(book.getCode(), user);
                return "Thank you! Enjoy the book";
            } else if(book.getCode() == codeBook && book.getStatus() != 0){
                return "Sorry, that book is not available"; }
            }

        return "That is not a valid book to check out";

    }


    public String returnBook(int codeBook) {
        for(Book book : bookHashMap.values()){
            if(book.getCode() == codeBook){
                book.setStatus(0);
                return "Thank you for returning the book";
            }
        }
        return "That is not a valid book to return";
    }


    public String displayMovieList() {
        String displayAllMovie = "";
        for(Movie movie : movieHashMap.values()){
            if(movie.getStatus() == 0){
                displayAllMovie += formatMovieList(movie);
            }
        }
        return displayAllMovie;
    }


    private String formatMovieList(Movie movie){
        return movie.getName()+"|"+movie.getYearMovie()+"|"+movie.getDirector()+"|"+movie.getRating()+"\n";
    }


    public String checkoutMovie(int codeMovie) {
        for(Movie movie : movieHashMap.values()){
            if(movie.getCode() == codeMovie && movie.getStatus() == 0){
                movie.setStatus(1);
                return "Thank you! Enjoy the movie";
            } else if(movie.getCode() == codeMovie && movie.getStatus() != 0){
                return "Sorry, that movie is not available"; }
        }

        return "That is not a valid movie to check out";
    }

    public String queryWhoHasTheBook(int codeBook) {
        return ckeckedoutBookList.get(codeBook).getUsername();
    }
}
