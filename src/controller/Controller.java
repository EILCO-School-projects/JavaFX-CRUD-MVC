package controller;

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


public class Controller implements Initializable {

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
        EtudiantDAO.ajouter(idField.getText(), titleField.getText());
        afficherEtudiant();
    }


    @FXML
    private void updateButton() {
        EtudiantDAO.modifier(titleField.getText(), idField.getText());
        afficherEtudiant();
    }

    @FXML
    private void deleteButton() {
        EtudiantDAO.supprimer(idField.getText());
        afficherEtudiant();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        afficherEtudiant();
    }

    public void afficherEtudiant() {
        ObservableList<Etudiant> list = EtudiantDAO.getEtudiant();

        idColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("nom"));

        TableView.setItems(list);
    }


}
