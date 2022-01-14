import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;

import com.company.Book1;
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
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;

public class DeleteBooks {

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
    private TableView<Book1> TableBook;

    @FXML
    private TableColumn<Book1, String> col_name;

    @FXML
    private TableColumn<Book1, String> col_author;

    @FXML
    private TableColumn<Book1, Date> col_data;

    @FXML
    private TableColumn<Book1, Integer> col_price;

    @FXML
    private Button Listok;

    ObservableList<Book1> List;


    int index = -1;
    Connection dbConnect = null;
    ResultSet rs = null;
    PreparedStatement statement = null;


    @FXML
    void CheckList(ActionEvent event) {

        col_name.setCellValueFactory(new PropertyValueFactory<Book1,String>("Name"));
        col_author.setCellValueFactory(new PropertyValueFactory<Book1,String>("Author"));
        col_data.setCellValueFactory(new PropertyValueFactory<Book1,Date>("Data"));
        col_price.setCellValueFactory(new PropertyValueFactory<Book1,Integer>("Price"));
        List = DB.getBook1List();
        TableBook.setItems(List);
    }

    @FXML
    void GetSelected(MouseEvent event) {
        index = TableBook.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        DelBookNAME.setText(col_name.getCellData(index).toString());
    }

    @FXML
    void Action(ActionEvent event) throws Exception {

        PreparedStatement statement = DB.Connect().prepareStatement("DELETE FROM public.\"Books\"\n" +
                "\tWHERE \"Books\".\"Name\" = ? ");

        statement.setString(1, DelBookNAME.getText());

        statement.execute();


        try {

        } catch (
                Exception e) {
            e.printStackTrace();
        }
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
        assert DelBookNAME != null : "fx:id=\"DelBookNAME\" was not injected: check your FXML file 'DeleteBooks.fxml'.";
        assert Enter != null : "fx:id=\"Enter\" was not injected: check your FXML file 'DeleteBooks.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'DeleteBooks.fxml'.";

    }
}
