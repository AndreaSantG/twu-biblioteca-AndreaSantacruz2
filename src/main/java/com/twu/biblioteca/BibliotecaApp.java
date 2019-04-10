package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LogApp;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.model.User;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Scanner reader = new Scanner ( System.in ) ;
        Library library = new Library();
        LogApp logApp = new LogApp();
        Menu menu = new Menu();
        System.out.println(library.showWelcomeMessage());
        System.out.println("Please login");
        System.out.println("Username");
        String username = reader.next();
        System.out.println("PassWord");
        String password = reader.next();
        User loggedUser = logApp.login(library.getUserList(), username, password);
        if(loggedUser != null){
            System.out.println(menu.showMenu());
            int optionMenu = -1;
            do{
                System.out.println("***Please select an option");
                optionMenu = Integer.valueOf(reader.next());
                System.out.println(menu.selectOption(optionMenu, library, loggedUser));
            }while (optionMenu != 0);
        }
        else {
            System.out.println("Your username or passwors is incorrect");
        }


    }
}
