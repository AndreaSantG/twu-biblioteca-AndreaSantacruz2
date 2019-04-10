package com.twu.biblioteca;

import com.twu.biblioteca.model.Utilitarian;
import org.junit.Test;
import java.io.PrintStream;
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
        PrintStream outMock = mock(PrintStream.class);
        utilitarian.setOut(outMock);
        String message = "hola";

        utilitarian.print(message);

        verify(outMock, times(1)).println(message);
    }

}
