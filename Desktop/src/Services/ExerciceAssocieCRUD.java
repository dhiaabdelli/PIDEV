/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.Exercice;
import entities.ExerciceAssocie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import DataStorage.MyDB;
import java.sql.Connection;

/**
 *
 * @author dell
 */
public class ExerciceAssocieCRUD {
    
    Connection connexion;
    PreparedStatement pst;
    
    public ExerciceAssocieCRUD(){
        connexion = MyDB.getinstance().getConnexion();
    }
    public void addExerciceAssocie(ExerciceAssocie ea) {
        String requette = "INSERT INTO exerciceassocie (idProfile,libelleExercice,nbSeries,nbRepetitions,jour)"
                + "VALUES (?,?,?,?,?)";
        try {
            pst = connexion.prepareStatement(requette);
            pst.setInt(1, ea.getIdProfile());
            pst.setString(2, ea.getLibelleEx());
            pst.setInt(3, ea.getNbSeries());
            pst.setInt(4, ea.getNbRepetitions());
            pst.setInt(5, ea.getJour());
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("ExerciceAssocie Ajouté!");
            alert.showAndWait();
            System.out.println("ExerciceAssocie Ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(ExerciceAssocieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<ExerciceAssocie> AfficheExA() {
        String req = "select * from exerciceassocie";
        ObservableList<ExerciceAssocie> list = FXCollections.observableArrayList();
        try {
            pst = connexion.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new ExerciceAssocie(rs.getInt("id"), rs.getInt("idProfile"), rs.getString("libelleExercice"), rs.getInt("nbSeries"), rs.getInt("nbRepetitions"), rs.getInt("jour")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ObservableList<Integer> getJours() {
        String req = "select jour from exerciceassocie group by jour order by jour";
        ObservableList<Integer> list = FXCollections.observableArrayList();
        try {
            pst = connexion.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(rs.getInt("jour"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Exercice getExParLib(String lib) {
        String req = "select * from exercice where libelle like ?";
        Exercice ex = new Exercice();
        try {
            pst = connexion.prepareStatement(req);
            pst.setString(1, lib);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ex = new Exercice(rs.getInt("id"), rs.getString("libelle"), rs.getString("description"), rs.getString("image"));
            }

        } catch (SQLException e) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, e);
        }
        return ex;
    }
    

    public ObservableList<ExerciceAssocie> AfficheExAperday(int jour) {
        String req = "select * from exerciceassocie where jour = ?";
        ObservableList<ExerciceAssocie> list = FXCollections.observableArrayList();
        try {
            pst = connexion.prepareStatement(req);
            pst.setInt(1, jour);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new ExerciceAssocie(rs.getInt("idExAssocier"), rs.getInt("idProfile"), rs.getString("libelleExercice"), rs.getInt("nbSeries"), rs.getInt("nbRepetitions"), rs.getInt("jour")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void modifierExerciceAssocie(ExerciceAssocie ea) {
        String requette = "update exerciceassocie set  idProfile = ?, libelleExercice = ? , nbSeries = ? , nbRepetitions = ? , jour = ? where idExAssocier = ? ";
        try {
            pst = connexion.prepareStatement(requette);
            pst.setInt(1, ea.getIdProfile());
            pst.setString(2, ea.getLibelleEx());
            pst.setInt(3, ea.getNbSeries());
            pst.setInt(4, ea.getNbRepetitions());
            pst.setInt(5, ea.getJour());
            pst.setInt(6, ea.getId());
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("ExerciceAssocie Modifié!");
            alert.showAndWait();
            System.out.println("ExerciceAssocie Modifié!");
        } catch (SQLException ex) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimerExerciceAssocie(int idExercice) {
        String requette = "delete from exerciceassocie where idExAssocier = ? ";
        try {
           pst = connexion.prepareStatement(requette);
            pst.setInt(1, idExercice);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("ExerciceAssocie Supprimé!");
            alert.showAndWait();
            System.out.println("ExerciceAssocie Supprimé!");
        } catch (SQLException ex) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
