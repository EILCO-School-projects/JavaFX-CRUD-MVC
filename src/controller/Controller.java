package controller;

import dao.EtudiantDao;
import model.Etudiant;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;


import java.util.ResourceBundle;


public class MainController implements Initializable {

    Connection conn;

    @FXML
    private TextField idField;

    @FXML
    private TextField titleField;


    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Etudiant> TableView;

    @FXML
    private TableColumn<Etudiant, Integer> idColumn;

    @FXML
    private TableColumn<Etudiant, String> titleColumn;


    @FXML
    private void insertButton() {
        EtudiantDao.insert(idField.getText(), titleField.getText());
        showBooks();
    }


    @FXML
    private void updateButton() {
        EtudiantDao.update(titleField.getText(), idField.getText());
        showBooks();
    }

    @FXML
    private void deleteButton() {
        EtudiantDao.delete(idField.getText());
        showBooks();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showBooks();
    }


    public void showBooks() {
        ObservableList<Etudiant> list = EtudiantDao.getStudentsList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("nom"));

        TableView.setItems(list);
    }


}
