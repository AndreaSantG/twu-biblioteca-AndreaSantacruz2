package com.twu.biblioteca.model;

import java.util.Scanner;

public class Utilitarian {

    private Scanner scanner;

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String read(){
        return scanner.next();
    }

    public void print(String text){
        System.out.println(text);
    }

    public void exit(){
        System.exit(0); }

}
