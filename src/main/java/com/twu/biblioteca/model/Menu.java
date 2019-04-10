package com.twu.biblioteca.model;

import java.io.PrintStream;
import java.util.Scanner;

public class Menu {

    private String menuOne;
    private String menuTwo;
    private String menuThree;
    private String menuFour;
    private String menuFive;
    private String menuSix;
    private String menuZero;
    private Utilitarian utilitarian;


    public Menu(){
        this.menuOne = "(1) List books\n";
        this.menuTwo = "(2) Checkout a book\n";
        this.menuThree = "(3) Return a book\n";
        this.menuFour = "(4) List movies\n";
        this.menuFive = "(5) Checkout a movie\n";
        this.menuSix = "(6) View my information\n";
        this.menuZero = "(0) Quit\n";
        utilitarian = new Utilitarian();
        utilitarian.setScanner(new Scanner(System.in));
        utilitarian.setOut(System.out);
    }

    public String showMenu() {
        return this.menuOne+this.menuTwo+this.menuThree+this.menuFour+this.menuFive+this.menuSix+this.menuZero;
    }


    public String selectOption(int optionMenu, Library library, User user) {
        String selectedOption = "";
        int codeBook;
        int codeMovie;
        switch (optionMenu){
            case 1:
                selectedOption = library.displayAListOfTheSameItems("book");
                break;
            case 2:
                utilitarian.print("Please enter the code of book you want to check out");
                codeBook = Integer.valueOf(utilitarian.read());
                selectedOption = library.checkoutLibraryItem(codeBook, user);
                break;
            case 3:
                utilitarian.print("Please enter the code of book you want to return");
                codeBook = Integer.valueOf(utilitarian.read());
                selectedOption = library.returnBook(codeBook);
                break;
            case 4:
                selectedOption = library.displayAListOfTheSameItems("movie");
                break;
            case 5:
                utilitarian.print("Please enter the code of movie you want to check out");
                codeMovie = Integer.valueOf(utilitarian.read());
                selectedOption = library.checkoutLibraryItem(codeMovie, user);
                break;
            case 6:
                selectedOption = user.showContactInformation();
                break;
            case 0:
                utilitarian.exit();
                break;
            default:
                selectedOption = "Please select a valid option!";
        }
        return selectedOption;
    }

    public void setUtilitarian(Utilitarian utilitarian) {
        this.utilitarian = utilitarian;
    }
}
