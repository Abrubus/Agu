package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) { launch();}


    @Override
    public void start (Stage stage) throws Exception {

        Class.forName("org.postgresql.Driver");



        Button button = new Button("Abzzz");
        button.setLayoutX(20);
        button.setLayoutY(20);
        TextField textField = new TextField("asd");
        Group group = new Group(button,textField);

        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl= getClass().getResource("/Bibliya.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();
        stage.setScene(new Scene(root));

        stage.setTitle("Program");

        stage.show();
    }

}
