package com.company;

import java.util.Date;

public class book {
    int id;
    String NameBook,ReaderName;
    Date Data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameBook(String nameBook) {
        NameBook = nameBook;
    }
    public String getNameBook() {
        return NameBook;
    }
    public void setReaderName(String readerName) {
        ReaderName = readerName;
    }
    public String getReaderName() {
        return ReaderName;
    }
    public void setData(Date data) {
        Data = data;
    }

    public Date getData() {
        return Data;
    }

    public book(int id, String nameBook, String readerName, Date data) {
        this.id = id;
        this. NameBook = nameBook;
        this.ReaderName = readerName;
        this.Data = data;
    }
}

