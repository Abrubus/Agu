import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.company.DB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

class Book {
    String NameBOOK;
    @Override
    public String toString(){
        return  NameBOOK;
    }
}

class Readers {
    String ReaderNAME;

    @Override
    public String toString() {
        return ReaderNAME;
    }

    }


public class Extradition {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ExtraID;

    @FXML
    private Button Enter;

    @FXML
    private Button Back;

    @FXML
    private DatePicker ExtraDATA1;

    @FXML
    private ComboBox<Book> ExtraBOOK;


    @FXML
    private ComboBox<Readers> ExtraREADER;



    @FXML
    private DatePicker ExtraDATA;

    @FXML
    void Exit(ActionEvent event) throws IOException {
        Stage stage = (Stage) Back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Bibliya.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }


    @FXML
    void Action(ActionEvent event) throws Exception {

        PreparedStatement statement = DB.Connect().prepareStatement("INSERT INTO public.\"Extradition\"(\n" +
                "\t\"Id\", \"NameBook\", \"NameReader\", \"Date of Issue\", \"Return data\")\n" +
                "\tVALUES (?, ?, ?, ?, ?);");
        statement.setInt(1, Integer.parseInt(ExtraID.getText()));
        statement.setString(2, ExtraBOOK.getSelectionModel().getSelectedItem().NameBOOK);
        statement.setString(3, ExtraREADER.getSelectionModel().getSelectedItem().ReaderNAME);
        statement.setDate(4, Date.valueOf(ExtraDATA1.getValue()));
        statement.setDate(5, Date.valueOf(ExtraDATA.getValue()));

        statement.execute();


        try {

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }





    @FXML
    void initialize() {

        assert ExtraID != null : "fx:id=\"ExtraID\" was not injected: check your FXML file 'Extradition.fxml'.";
        assert Enter != null : "fx:id=\"Enter\" was not injected: check your FXML file 'Extradition.fxml'.";
        assert ExtraBOOK != null : "fx:id=\"ExtraBOOK\" was not injected: check your FXML file 'Extradition.fxml'.";
        assert ExtraREADER != null : "fx:id=\"ExtraREADER\" was not injected: check your FXML file 'Extradition.fxml'.";
        assert ExtraDATA != null : "fx:id=\"ExtraDATA\" was not injected: check your FXML file 'Extradition.fxml'.";
        assert ExtraDATA1 != null : "fx:id=\"ExtraDATA\" was not injected: check your FXML file 'Extradition.fxml'.";

        try {
            Statement statement = DB.Connect().createStatement();
            ResultSet res = statement.executeQuery("SELECT \"Name\" FROM Public.\"Books\";");
            List<Book> list = new ArrayList<>();
            while (res.next()) {
                Book es = new Book();
                es.NameBOOK = res.getString(1);
                list.add(es);

            }
            ExtraBOOK.setItems(FXCollections.observableList(list));


        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Statement statement = DB.Connect().createStatement();
            ResultSet res = statement.executeQuery("SELECT \"Name\" FROM Public.\"Reader\";");
            List<Readers> list = new ArrayList<>();
            while (res.next()) {
                Readers es = new Readers();
                es.ReaderNAME = res.getString(1);
                list.add(es);

            }
            ExtraREADER.setItems(FXCollections.observableList(list));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}