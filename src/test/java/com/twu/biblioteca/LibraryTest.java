package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LibraryTest {
    Library library;

    @Before
    public void setUp(){
        library = new Library();
    }

    @Test
    public void whenOpenAppThenShouldShowWelcomeMessage(){
        String expectedWelcomeMessage = "Welcome to Biblioteca. Your one stop-shop for great book titles in Bangalore!";

        String resultWelcomeMessage = library.showWelcomeMessage();

        assertThat(expectedWelcomeMessage, is(resultWelcomeMessage));
    }


    @Test
    public void whenOpenAppThenCreateABookList(){
        int sizeBookList = 4;

        int resultSizeBookList = library.getBookList().size();

        assertThat(sizeBookList, is(resultSizeBookList));
    }


    @Test
    public void whenOpenAppThenShouldListTitleAuthorAndYearPublishedA(){
        String titleBook1 = "El amor en tiempos de Colera";
        String authorBook1 = "Gabriel Garcia Marquez";
        int yearPublishedBook1 = 1985;
        int statusBook1 = 1;
        int idBook1 = 30;
        String titleBook2 = "Los primeros tres minutos del universo";
        String authorBook2 = "Steven Weinberg";
        int yearPublishedBook2 = 1977;
        int statusBook2 = 0;
        int idBook2 = 40;
        String titleBook3 = "The Science of Interstellar";
        String authorBook3 = "Kip Thorne";
        int yearPublishedBook3 = 2014;
        int statusBook3 = 1;
        int idBook3 = 50;
        String titleBook4 = "The 4 hour workweek";
        String authorBook4 = "Tim Ferriss";
        int yearPublishedBook4 = 2007;
        int statusBook4 = 0;
        int idBook4 = 60;
        Book book1 = new Book(titleBook1, authorBook1, yearPublishedBook1, statusBook1, idBook1);
        Book book2 = new Book(titleBook2, authorBook2, yearPublishedBook2, statusBook2, idBook2);
        Book book3 = new Book(titleBook3, authorBook3, yearPublishedBook3, statusBook3, idBook3);
        Book book4 = new Book(titleBook4, authorBook4, yearPublishedBook4, statusBook4, idBook4);
        List<Book> bookList = new ArrayList<>(Arrays.asList(book1, book2, book3, book4));

        String resultBookList = library.displayAListOfTheSameItems("book");

        assertThat(bookList.get(0).getTitle()+"|" +bookList.get(0).getAuthor()+"|"+bookList.get(0).getYearPublished()+"\n"+bookList.get(1).getTitle()+"|" +bookList.get(1).getAuthor()+"|"+bookList.get(1).getYearPublished()+"\n"+bookList.get(2).getTitle()+"|" +bookList.get(2).getAuthor()+"|"+bookList.get(2).getYearPublished()+"\n"+bookList.get(3).getTitle()+"|" +bookList.get(3).getAuthor()+"|"+bookList.get(3).getYearPublished()+"\n", is(resultBookList));
    }


    @Test
    public void givenAVailableBookWhenCheckoutTheBookThenShowSuccessfulMessage(){
        int codeBook = 30;
        String messageCheckedoutBook = "Thank you! Enjoy the book";
        User user = library.getUserList().get(0);

        String resultMessageCheckedoutBook = library.checkoutLibraryItem(codeBook, user);

        assertThat(messageCheckedoutBook, is(resultMessageCheckedoutBook));
    }


    @Test
    public void givenThereAreCheckedoutBooksWhenDisplayBooksThenShouldListOnlyAvailableBook(){
        String titleBook2 = "Los primeros tres minutos del universo";
        String authorBook2 = "Steven Weinberg";
        int yearPublishedBook2 = 1977;
        int statusBook2 = 1;
        int idBook2 = 40;
        String titleBook4 = "The 4 hour workweek";
        String authorBook4 = "Tim Ferriss";
        int yearPublishedBook4 = 2007;
        int statusBook4 = 1;
        int idBook4 = 60;
        Book book2 = new Book(titleBook2, authorBook2, yearPublishedBook2, statusBook2, idBook2);
        Book book4 = new Book(titleBook4, authorBook4, yearPublishedBook4, statusBook4, idBook4);
        List<Book> bookList = new ArrayList<>(Arrays.asList(book2, book4));
        int codeCheckedOutBook1 = 30;
        int codeCheckedOutBook2 = 50;
        int statusCheckedOut = 1;
        library.getBookList().get(codeCheckedOutBook1).setStatus(statusCheckedOut);
        library.getBookList().get(codeCheckedOutBook2).setStatus(statusCheckedOut);

        String resultBookList = library.displayAListOfTheSameItems("book");

        assertThat(bookList.get(0).getTitle()+"|" +bookList.get(0).getAuthor()+"|"+bookList.get(0).getYearPublished()+"\n"+bookList.get(1).getTitle()+"|" +bookList.get(1).getAuthor()+"|"+bookList.get(1).getYearPublished()+"\n", is(resultBookList));
    }


    @Test
    public void givenAnUnavailableBookWhenCheckoutTheBookThenShowUnsuccessfulMessage(){
        int codeCheckedOutBook = 30;
        int statusCheckedOut = 1;
        int codeBook = library.getBookList().get(codeCheckedOutBook).getCode();
        library.getBookList().get(codeCheckedOutBook).setStatus(statusCheckedOut);
        String messageCheckedoutUnavailableBook = "Sorry, that book is not available";
        User user = library.getUserList().get(0);

        String resultMessageCheckedoutUnavailableBook = library.checkoutLibraryItem(codeBook, user);

        assertThat(messageCheckedoutUnavailableBook, is(resultMessageCheckedoutUnavailableBook));
    }


    @Test
    public void givenAValidBookWhenReturnTheBookThenShowSuccessfulMessage(){
        int codeCheckedOutBook = 30;
        int statusCheckedOut = 1;
        library.getBookList().get(codeCheckedOutBook).setStatus(statusCheckedOut);
        int codeBook = library.getBookList().get(codeCheckedOutBook).getCode();
        String messageReturnBookSuccessfully = "Thank you for returning the book";

        String expectedMessageReturnBookSuccessfully = library.returnBook(codeBook);

        assertThat(expectedMessageReturnBookSuccessfully, is(messageReturnBookSuccessfully));
    }


    @Test
    public void givenAnInvalidBookWhenReturnTheBookThenShowSuccessfulMessage(){
        int codeBookForReturning = 90;
        String messageReturnBookSuccessfully = "That is not a valid book to return";

        String expectedMessageReturnBookSuccessfully = library.returnBook(codeBookForReturning);

        assertThat(expectedMessageReturnBookSuccessfully, is(messageReturnBookSuccessfully));
    }


    @Test
    public void givenBookDoNotBelongToLibraryWhenReturnTheBookThenShowSuccessfulMessage(){
        int codeBook = 68;
        String expectedMessageOptionCheckoutBook = "That is not a valid item to check out";
        User user = library.getUserList().get(0);

        String resultMessageCheckedoutBook = library.checkoutLibraryItem(codeBook, user);

        assertThat(expectedMessageOptionCheckoutBook, is(resultMessageCheckedoutBook));
    }


    @Test
    public void givenThereAreCheckedoutMoviesWhenDisplayMoviesThenShouldListOnlyAvailableMovies(){
        String nameMovie1 = "Titanic";
        int yearMovie1 = 1997;
        String directorMovie1 = "James Cameron";
        int ratingMovie1 = 9;
        int statusMovie1 = 0;
        int codeMovie1 = 300;
        Movie movie1 = new Movie(nameMovie1, directorMovie1, yearMovie1, statusMovie1, codeMovie1, ratingMovie1);
        String nameMovie2 = "El Rey Leon";
        int yearMovie2 = 1994;
        String directorMovie2 = "Rob Minkoff, Roger Allers";
        int ratingMovie2 = 10;
        int statusMovie2 = 0;
        int codeMovie2 = 400;
        Movie movie2 = new Movie(nameMovie2, directorMovie2, yearMovie2, statusMovie2, codeMovie2, ratingMovie2);
        List<Movie> movieList = new ArrayList<>(Arrays.asList(movie1, movie2));
        int codeCheckedOutMovie1 = 500;
        int codeCheckedOutMovie2 = 600;
        int statusCheckedOut = 1;
        library.getLibraryItemList().get(codeCheckedOutMovie1).setStatus(statusCheckedOut);
        library.getLibraryItemList().get(codeCheckedOutMovie2).setStatus(statusCheckedOut);

        String resultBookList = library.displayAListOfTheSameItems("movie");

        assertThat(resultBookList, is(movieList.get(0).getTitle()+"|"+movieList.get(0).getYearPublished()+"|"+movieList.get(0).getAuthor()+"|"+movieList.get(0).getRating()+"\n"+movieList.get(1).getTitle()+"|"+movieList.get(1).getYearPublished()+"|"+movieList.get(1).getAuthor()+"|"+movieList.get(1).getRating()+"\n"));
    }


    @Test
    public void givenAVailableMovieWhenCheckoutTheMovieThenShowSuccessfulMessage(){
        int codeCheckedOutMovie = 300;
        int statusAvailable = 0;
        library.getLibraryItemList().get(codeCheckedOutMovie).setStatus(statusAvailable);
        int codeMovie = library.getLibraryItemList().get(codeCheckedOutMovie).getCode();
        String messageCheckedoutBook = "Thank you! Enjoy the movie";

        String resultMessageCheckedoutMovie = library.checkoutLibraryItem(codeMovie, library.getUserList().get(0));

        assertThat(messageCheckedoutBook, is(resultMessageCheckedoutMovie));
    }


    @Test
    public void givenAnUnavailableMovieWhenCheckoutTheMovieThenShowUnsuccessfulMessage(){
        int codeCheckedOutMovie = 300;
        int statusCheckedOut = 1;
        int codeMovie = library.getLibraryItemList().get(codeCheckedOutMovie).getCode();
        library.getLibraryItemList().get(codeCheckedOutMovie).setStatus(statusCheckedOut);
        String messageCheckedoutUnavailableMovie= "Sorry, that movie is not available";

        String resultMessageCheckedoutUnavailableMovie = library.checkoutLibraryItem(codeMovie, library.getUserList().get(0));

        assertThat(messageCheckedoutUnavailableMovie, is(resultMessageCheckedoutUnavailableMovie));
    }


    @Test
    public void givenMovieDoNotBelongToLibraryWhenCheckoutTheMovieTheShowUnsuccessfulMessage(){
        int codeMovie = 990;
        String messageCheckedoutUnavailableMovie= "That is not a valid item to check out";

        String resultMessageCheckedoutUnavailableMovie = library.checkoutLibraryItem(codeMovie, library.getUserList().get(0));

        assertThat(messageCheckedoutUnavailableMovie, is(resultMessageCheckedoutUnavailableMovie));
    }


    @Test
    public void whenAppStartsThenCreateADefaultUserList(){
        int expectedSizeList = 2;

        int sizeList = library.getUserList().size();

        assertThat(expectedSizeList, is(sizeList));
    }


    @Test
    public void givenAnAvailableBookWhenSendValidBookCodeAndValidUserThenCheckoutTheBook(){
        int codeCheckedOutBook = 30;
        int statusCheckedOut = 0;
        int bookCode = library.getBookList().get(codeCheckedOutBook).getCode();
        User user = library.getUserList().get(statusCheckedOut);
        String messageCheckedOutBook = "Thank you! Enjoy the book";

        String resultMessageCheckedoutBook = library.checkoutLibraryItem(bookCode, user);

        assertThat(messageCheckedOutBook, is(resultMessageCheckedoutBook));
    }


    @Test
    public void givenAnAvailableBookWhenCheckoutTheBookThenAssocciateBookWithCustomer(){
        int codeCheckedOutBook = 30;
        int statusCheckedOut = 0;
        library.getBookList().get(codeCheckedOutBook).setStatus(statusCheckedOut);
        int codeBook = library.getBookList().get(codeCheckedOutBook).getCode();
        User user = library.getUserList().get(0);

        library.checkoutLibraryItem(codeBook, user);

        assertThat(user.getUsername(), is(library.queryWhoHasTheBook(codeBook)));
    }

}
