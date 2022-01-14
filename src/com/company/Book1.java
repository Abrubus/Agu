package com.company;

import java.util.Date;

public class Book1 {
    int Price;
    String Name, Author;
    Date Data;


    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public Book1( String name, String author, Date data, int price) {
        this.Price = price;
        this.Name = name;
        this.Author = author;
        this.Data = data;
    }
}



