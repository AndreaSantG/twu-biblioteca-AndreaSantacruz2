package com.twu.biblioteca.model;

public class User {

    private String username;
    private String password;
    private String name;
    private String mail;
    private String phoneNumber;

    public User(String username, String password, String name, String mail, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String showContactInformation() {
        return "Your contact information is: "+this.name+"|"+this.mail+"|"+this.phoneNumber;
    }
}
