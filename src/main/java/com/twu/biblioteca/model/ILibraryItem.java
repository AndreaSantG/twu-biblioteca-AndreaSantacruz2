package com.twu.biblioteca.model;

public interface ILibraryItem {


    public String getTitle();
    public String getAuthor();
    public int getYearPublished();
    public int getStatus();
    public int getCode();
    public void setStatus(int status);
    public String getType();
    public String showInformation( );


}
