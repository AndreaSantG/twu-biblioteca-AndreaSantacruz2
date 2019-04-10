package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserTest {

    @Test
    public void givenUserIsLoggedWhenQueryMyInformationThenAShowNameMailPhoneNumber(){
        User user = new User("000'1234","1234","Andrea","andy@gmail.com","0998171515");
        String resultInformationUser = "Your contact information is: Andrea|andy@gmail.com|0998171515";

        String informationUser = user.showContactInformation();

        assertThat(informationUser, is(resultInformationUser));
    }

}
