package com.twu.biblioteca.model;

import java.util.List;

public class LogApp {

    public User login(List<User> userList, String username, String password) {
        for (User user: userList) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user; }
        }
        return null;
    }
}
