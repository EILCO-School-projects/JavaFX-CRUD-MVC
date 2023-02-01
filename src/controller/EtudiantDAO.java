package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Etudiant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EtudiantDAO {


    public static void supprimer(String id) {
        String query = "DELETE FROM etudiant_db WHERE ID=" + id + "";
        executeQuery(query);
    }

    public static void modifier(String nom, String id) {
        String query = "UPDATE etudiant_db SET nom='" + nom + "' WHERE ID=" + id + "";
        executeQuery(query);
    }

    public static void ajouter(String nom, String id) {
        String query = "insert into etudiant_db values(" + nom + ", '" + id + "')";
        executeQuery(query);
    }

    private static Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants", "root", "zakaria123");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static ObservableList<Etudiant> getEtudiant() {
        ObservableList<Etudiant> studentList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM etudiant_db ";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Etudiant etudiant;
            while (rs.next()) {
                etudiant = new Etudiant(rs.getInt("Id"), rs.getString("Nom"));
                studentList.add(etudiant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }




}
