package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LogApp;
import com.twu.biblioteca.model.User;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class LoginTest {


    @Test
    public void whenLoginWithCorrectUsernameAndPasswordThenShowsSuccessfulMessage(){
        LogApp logApp = new LogApp();
        Library library = new Library();
        String username = "000-1234";
        String password = "pass1";

        User resultUser = logApp.login(library.getUserList(), username, password);

        assertThat(resultUser instanceof User, is(true));
    }


    @Test
    public void whenLoginWithIncorrectUsernameThenReturnNull(){
        LogApp logApp = new LogApp();
        Library library = new Library();
        String username = "use-123";
        String password = "pass1";

        User resultUser = logApp.login(library.getUserList(), username, password);

        assertThat(null, is(resultUser));
    }
}
