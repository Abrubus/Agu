package com.company;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DB {
    private static Connection dbConnect = null;
    private static String url = "jdbc:postgresql://localhost:5432/Aboba";

    public static Connection Connect() throws Exception {
        if (dbConnect == null) {

            Class.forName("org.postgresql.Driver");

            dbConnect = DriverManager.getConnection(url, "postgres", "20020827");
        }
        return dbConnect;
    }

    public static ObservableList<book> getBookList() {
        ObservableList<book> list = FXCollections.observableArrayList();
        Connection dbConnect = null;
        try {
            PreparedStatement statement = DB.Connect().prepareStatement("SELECT \"Id\", \"NameBook\", \"NameReader\", \"Return data\"\n" +
                    "\tFROM public.\"Extradition\";");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new book(Integer.parseInt(rs.getString("Id")), rs.getString("NameBook"), rs.getString("NameReader"), Date.valueOf(String.valueOf(rs.getDate("Return data")))));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public static ObservableList<Book1> getBook1List() {
        ObservableList<Book1> list = FXCollections.observableArrayList();
        Connection dbConnect = null;
        try {
            PreparedStatement statement = DB.Connect().prepareStatement("SELECT \"Name\", \"Author\", \"DateOfPublication\", \"Price\"\n" +
                    "\tFROM public.\"Books\";");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Book1(rs.getString("Name"),rs.getString("Author"),Date.valueOf(String.valueOf(rs.getDate("DateOfPublication"))),Integer.parseInt(rs.getString("Price"))));
            }
        } catch (Exception e) {

        }
        return list;
    }
}


