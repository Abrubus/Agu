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

public class Reader {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ReaderNAME;

    @FXML
    private TextField ReaderADDRESS;

    @FXML
    private TextField ReaderPHONE;

    @FXML
    private DatePicker ReaderDATA;

    @FXML
    private Button Back;

    @FXML
    private Button Enter;



    @FXML
    void Exit(ActionEvent event) throws IOException {
        Stage stage = (Stage) Back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Bibliya.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void Action(ActionEvent event) throws Exception {

        PreparedStatement statement = DB.Connect().prepareStatement("INSERT INTO public.\"Reader\"(\n" +
                "\t\"Name\", \"date of birth\", \"Address\", \"Phone\")\n" +
                "\tVALUES (?, ?, ?, ?);");

        statement.setString(1, ReaderNAME.getText());
        statement.setDate(2, Date.valueOf(ReaderDATA.getValue()));
        statement.setString(3, ReaderADDRESS.getText());
        statement.setString(4, ReaderPHONE.getText());


        statement.execute();


        try {

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    void initialize() {
        assert ReaderNAME != null : "fx:id=\"ReaderNAME\" was not injected: check your FXML file 'Reader.fxml'.";
        assert ReaderADDRESS != null : "fx:id=\"ReaderADDRESS\" was not injected: check your FXML file 'Reader.fxml'.";
        assert ReaderPHONE != null : "fx:id=\"ReaderPHONE\" was not injected: check your FXML file 'Reader.fxml'.";
        assert ReaderDATA != null : "fx:id=\"ReaderDATA\" was not injected: check your FXML file 'Reader.fxml'.";
        assert Enter != null : "fx:id=\"Enter\" was not injected: check your FXML file 'Reader.fxml'.";

    }
}
