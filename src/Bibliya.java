import com.company.DB;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Bibliya {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button DelBook;

    @FXML
    private Button SetBook;

    @FXML
    private Button Givebook;

    @FXML
    private Button RegReader;

    @FXML
    private Button BackBook;

    @FXML
    void EnterGive(ActionEvent event) throws IOException {
        Stage stage = (Stage) SetBook.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Books.fxml"));
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    void EnterReader(ActionEvent event) throws IOException {
        Stage stage = (Stage) RegReader.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Reader.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void EnterSet(ActionEvent event) throws IOException {
        Stage stage = (Stage) Givebook.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Extradition.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void EnterDel(ActionEvent event) throws IOException {
        Stage stage = (Stage) Givebook.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DeleteBooks.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void EnterBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) Givebook.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BackBook.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void initialize() {
        assert SetBook != null : "fx:id=\"SetBook\" was not injected: check your FXML file 'Untitled'.";
        assert Givebook != null : "fx:id=\"Givebook\" was not injected: check your FXML file 'Untitled'.";
        assert RegReader != null : "fx:id=\"RegReader\" was not injected: check your FXML file 'Untitled'.";
        assert DelBook != null : "fx:id=\"DelBook\" was not injected: check your FXML file 'Bibliya.fxml'.";
        assert BackBook != null : "fx:id=\"BackBook\" was not injected: check your FXML file 'Bibliya.fxml'.";

    }
}


