package com.twu.biblioteca;

import com.twu.biblioteca.model.Utilitarian;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import java.util.Scanner;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;


public class UtilitarianTest {

   @Test
    public void whenCallReadMethodThenReturnTheStringInConsole() {
       Scanner scanner = mock(Scanner.class);
       Utilitarian utilitarian =  new Utilitarian();
       utilitarian.setScanner(scanner);
       String message = "Hola";
       when(scanner.next()).thenReturn(message);
       assertThat(message, is(utilitarian.read()));
    }


    @Test
    public void givenWantToShowIAMessagenConsoleWhenCallPrintMethodThenShowAMessageInConsole(){
        Utilitarian utilitarian = new Utilitarian();
        PowerMockito.mockStatic(System.out.getClass());
        String message = "hola";
        doNothing().when(System.out).println(message);

        verify(System.out, times(1)).println();
    }



    @Test
    public void givenWantToExitWhenTypeZeroThenExitFromApp(){
        mock(System.class);
        Utilitarian utilitarian = new Utilitarian();

        verify(utilitarian, times(1)).exit();
    }
}
