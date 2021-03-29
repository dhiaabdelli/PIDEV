/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Exercice;
import entities.ExerciceAssocie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import tools.MyConnexion;

/**
 *
 * @author dell
 */
public class ExerciceCRUD {

    public void addExercice(Exercice e) {
        String requette = "INSERT INTO exercice (id,libelle,description,image)"
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(requette);
            pst.setInt(1, e.getId());
            pst.setString(2, e.getLibelle());
            pst.setString(3, e.getDescription());
            pst.setString(4, e.getImage());
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Exercice Ajouté!");
            alert.showAndWait();

            System.out.println("Exercice Ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ObservableList<Exercice> AfficheEx() {
        String req = "select * from exercice";
        ObservableList<Exercice> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new Exercice(Integer.parseInt(rs.getString("id")), rs.getString("libelle"), rs.getString("description"), rs.getString("image")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ObservableList<String> getExLib() {
        String req = "select libelle from exercice";
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(rs.getString("libelle"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ExerciceAssocie getExParLib(String lib) {
        String req = "select * from exerciceAssocie where libelleExercice like ?";
        ExerciceAssocie ex = new ExerciceAssocie();
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(req);
            pst.setString(1, lib);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ex = new ExerciceAssocie(rs.getInt("idExAssocier"), rs.getInt("idProfile"), rs.getString("libelleExercice"), rs.getInt("nbSeries"), rs.getInt("nbRepetitions"), rs.getInt("jour"));
            }

        } catch (SQLException e) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, e);
        }
        return ex;
    }

    public static ObservableList<Exercice> SearchEx(String libelle) {
        //ObservableList<Exercice> list = FXCollections.observableArrayList();
        String requete = "select * from exercice where libelle like '%" + libelle + "%'";
        ObservableList<Exercice> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new Exercice(Integer.parseInt(rs.getString("id")), rs.getString("libelle"), rs.getString("description"), rs.getString("image")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void modifierExercice(Exercice e) {
        String requette = "update exercice set  libelle = ? , description = ? , image = ? where id = ? ";
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(requette);
            pst.setString(1, e.getLibelle());
            pst.setString(2, e.getDescription());
            pst.setString(3, e.getImage());
            pst.setInt(4, e.getId());
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Exercice Modifié!");
            alert.showAndWait();
            System.out.println("Exercice Modifié!");
        } catch (SQLException ex) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimerExercice(int id) {
        String requette = "delete from exercice where id = ? ";
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(requette);
            pst.setInt(1, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Exercice Supprimé!");
            alert.showAndWait();
            System.out.println("Exercice Supprimé!");
        } catch (SQLException ex) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
