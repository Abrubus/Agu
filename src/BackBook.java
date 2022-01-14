

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;

import com.company.DB;
import com.company.book;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BackBook {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField DelBookNAME;

    @FXML
    private Button Enter;

    @FXML
    private Button Back;

    @FXML
    private TableView<book> TableBook;

    @FXML
    private TableColumn<book, Integer> col_id;

    @FXML
    private TableColumn<book, String> col_name;

    @FXML
    private TableColumn<book, String> col_reader;

    @FXML
    private Button Listok;

    @FXML
    private TableColumn<book, Date> col_data;

    ObservableList<book> List;


    int index = -1;
    Connection dbConnect = null;
    ResultSet rs = null;
    PreparedStatement statement = null;


    @FXML
    void CheckList(ActionEvent event) {
col_id.setCellValueFactory(new PropertyValueFactory<book,Integer>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<book,String>("nameBook"));
        col_reader.setCellValueFactory(new PropertyValueFactory<book,String>("readerName"));
        col_data.setCellValueFactory(new PropertyValueFactory<book,Date>("data"));
        List = DB.getBookList();
        TableBook.setItems(List);

    }

    @FXML
    void GetSelected(MouseEvent event) {
        index = TableBook.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        DelBookNAME.setText(col_id.getCellData(index).toString());
    }

    @FXML
    void Action(ActionEvent event) throws Exception {

        PreparedStatement statement = DB.Connect().prepareStatement("DELETE FROM public.\"Extradition\"\n" +
                "\tWHERE \"Extradition\".\"Id\" = ? ");

        statement.setInt(1, Integer.parseInt(DelBookNAME.getText()));

        statement.execute();


    }

    @FXML
    void Exit(ActionEvent event) throws IOException {
        Stage stage = (Stage) Back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Bibliya.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void initialize() {
        assert DelBookNAME != null : "fx:id=\"DelBookNAME\" was not injected: check your FXML file 'BackBook.fxml'.";
        assert Enter != null : "fx:id=\"Enter\" was not injected: check your FXML file 'BackBook.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'BackBook.fxml'.";
        assert col_id != null : "fx:id=\"col_id\" was not injected: check your FXML file 'BackBook.fxml'.";
        assert col_name != null : "fx:id=\"col_name\" was not injected: check your FXML file 'BackBook.fxml'.";
        assert col_reader != null : "fx:id=\"col_reader\" was not injected: check your FXML file 'BackBook.fxml'.";
        assert col_data != null : "fx:id=\"col_data\" was not injected: check your FXML file 'BackBook.fxml'.";
        assert Listok != null : "fx:id=\"Listok\" was not injected: check your FXML file 'BackBook.fxml'.";
        assert TableBook != null : "fx:id=\"TableBook\" was not injected: check your FXML file 'BackBook.fxml'.";
    }


    }


