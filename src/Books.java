import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import com.company.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Books {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NameBOOK;

    @FXML
    private TextField AuthorBOOK;

    @FXML
    private DatePicker DataBOOk;

    @FXML
    private TextField PriceBOOK;

    @FXML
    private Button Back;

    @FXML
    private Button Action;

    @FXML
    void Exit(ActionEvent event) throws IOException {
        Stage stage = (Stage) Back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Bibliya.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void GiveBook(ActionEvent event) throws Exception {

        PreparedStatement statement = DB.Connect().prepareStatement("INSERT INTO public.\"Books\"(\n" +
                "\"Name\", \"Author\", \"DateOfPublication\", \"Price\")\n" +
                "VALUES (?, ?, ?, ?);");

        statement.setString(1, NameBOOK.getText());
        statement.setString(2, AuthorBOOK.getText());
        statement.setDate(3, Date.valueOf(String.valueOf(DataBOOk.getValue())));
        statement.setInt(4, Integer.parseInt(PriceBOOK.getText()));

        statement.execute();


        try {

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }




    @FXML
    void initialize() {
        assert NameBOOK != null : "fx:id=\"NameBOOK\" was not injected: check your FXML file 'Books.fxml'.";
        assert AuthorBOOK != null : "fx:id=\"AuthorBOOK\" was not injected: check your FXML file 'Books.fxml'.";
        assert DataBOOk != null : "fx:id=\"DateBOOK\" was not injected: check your FXML file 'Books.fxml'.";
        assert PriceBOOK != null : "fx:id=\"PriceBOOK\" was not injected: check your FXML file 'Books.fxml'.";
        assert Action != null : "fx:id=\"Action\" was not injected: check your FXML file 'Books.fxml'.";

    }
}

