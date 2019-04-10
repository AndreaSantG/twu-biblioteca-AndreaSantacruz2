package com.twu.biblioteca.model;

import java.util.*;

public class Library {

    private Map<Integer, Book> bookHashMap;
    /*private Map<Integer, Movie> movieHashMap;*/
    private List<User>  userList;
    private Map<Integer, User> ckeckedoutBookList;
    private Map<Integer, ILibraryItem> libraryItemHashMap;

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

        /*movieHashMap = new LinkedHashMap<>();*/
        Movie movie1 = new Movie("Titanic",  "James Cameron", 1997,0, 300,9);
        Movie movie2 = new Movie("El Rey Leon",  "Rob Minkoff, Roger Allers", 1994,0, 400, 10);
        Movie movie3 = new Movie("Avatar",  "James Cameron", 2009,0, 500, 0);
        Movie movie4 = new Movie("The night knight",  "Christopher Nolan", 2008,0, 600, 8);
       /* movieHashMap.put(300, movie1);
        movieHashMap.put(400, movie2);
        movieHashMap.put(500, movie3);
        movieHashMap.put(600, movie4);*/

        userList = new ArrayList<>();
        User user1 = new User("000-1234","pass1","Carlos","carlos@gmail.com","33434343");
        User user2 = new User("000-5678","pass2","Andres","andres@gmail.com","090909090");
        userList.add(user1);
        userList.add(user2);

        ckeckedoutBookList = new LinkedHashMap<>();

        libraryItemHashMap = new LinkedHashMap<>();
        libraryItemHashMap.put(30, book1);
        libraryItemHashMap.put(40, book2);
        libraryItemHashMap.put(50, book3);
        libraryItemHashMap.put(60, book4);
        libraryItemHashMap.put(300, movie1);
        libraryItemHashMap.put(400, movie2);
        libraryItemHashMap.put(500, movie3);
        libraryItemHashMap.put(600, movie4);
    }

    public Map<Integer, Book> getBookList() {
        return this.bookHashMap;
    }

    public Map<Integer, ILibraryItem> getLibraryItemList() {
        return this.libraryItemHashMap;
    }

    public List<User> getUserList() {
        return this.userList;
    }

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one stop-shop for great book titles in Bangalore!";
    }


    public String displayAListOfTheSameItems(String type) {
        String displayAllList = "";
        for(ILibraryItem libraryItem : libraryItemHashMap.values())
            displayAllList += showATypeOfLibraryItems(libraryItem, type );
        return displayAllList;
    }


    private String showATypeOfLibraryItems(ILibraryItem libraryItem, String type){
        String displayAllList = "";
        if(libraryItem.getStatus() == 0 && libraryItem.getType().equals(type)){
            displayAllList += libraryItem.showInformation();
        }
        return displayAllList;
    }


    public String checkoutLibraryItem(int codeLibraryItem, User user) {
        for(ILibraryItem libraryItem : libraryItemHashMap.values()){
            if(libraryItem.getCode() == codeLibraryItem && libraryItem.getStatus() == 0){
                libraryItem.setStatus(1);
                this.ckeckedoutBookList.put(libraryItem.getCode(), user);
                return "Thank you! Enjoy the "+libraryItem.getType();
            } else if(libraryItem.getCode() == codeLibraryItem && libraryItem.getStatus() != 0){
                return "Sorry, that "+libraryItem.getType() +" is not available"; }
            }

        return "That is not a valid item to check out";

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

    public String queryWhoHasTheBook(int codeBook) {
        return ckeckedoutBookList.get(codeBook).getUsername();
    }
}
