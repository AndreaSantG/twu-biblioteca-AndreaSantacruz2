package com.twu.biblioteca.model;

import java.io.PrintStream;
import java.util.Scanner;

public class Utilitarian {

    private Scanner scanner;
    private PrintStream out;

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String read(){
        return scanner.next();
    }

    public void print(String text){
        out.println(text);
    }

    public void exit(){
        System.exit(0); }

    public void setOut(PrintStream out) {
        this.out = out;
    }
}
