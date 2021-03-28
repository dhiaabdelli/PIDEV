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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import DataStorage.MyDB;
import java.sql.Connection;
import java.io.File;
import Utils.Utils;
import java.io.IOException;

/**
 *
 * @author dell
 */
public class ExerciceCRUD {

    Connection connexion;
    PreparedStatement pst;

    public ExerciceCRUD() {
        connexion = MyDB.getinstance().getConnexion();
    }

    public void addExercice(Exercice e) throws IOException {
        String requette = "INSERT INTO exercice (id,libelle,description,image)"
                + "VALUES (?,?,?,?)";
        try {
            pst = connexion.prepareStatement(requette);
            pst.setInt(1, e.getId());
            pst.setString(2, e.getLibelle());
            pst.setString(3, e.getDescription());

            File source = new File(e.getImage().replace("%20"," ").substring(6));
            File dest = new File("./src/Presentation/views/resources/images/exercice/" + e.getId() + ".png");

            System.out.println(source);
            System.out.println(dest);
            try {
                Utils.copyFileUsingJava7Files(source, dest);
            } catch (IOException ex) {
                Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
            }
            pst.setString(4, "./src/Presentation/views/resources/images/exercice/" + e.getId() + ".png");

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

    public ObservableList<Exercice> AfficheEx() {
        String req = "select * from exercice";
        ObservableList<Exercice> list = FXCollections.observableArrayList();
        try {
            pst = connexion.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new Exercice(Integer.parseInt(rs.getString("id")), rs.getString("libelle"), rs.getString("description"), rs.getString("image")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ObservableList<String> getExLib() {
        String req = "select libelle from exercice";
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            pst = connexion.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(rs.getString("libelle"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExerciceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ExerciceAssocie getExParLib(String lib) {
        String req = "select * from exerciceAssocie where libelleExercice like ?";
        ExerciceAssocie ex = new ExerciceAssocie();
        try {
            pst = connexion.prepareStatement(req);
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

    public ObservableList<Exercice> SearchEx(String libelle) {
        //ObservableList<Exercice> list = FXCollections.observableArrayList();
        String requete = "select * from exercice where libelle like '%" + libelle + "%'";
        ObservableList<Exercice> list = FXCollections.observableArrayList();
        try {
            pst = connexion.prepareStatement(requete);
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
            pst = connexion.prepareStatement(requette);
            pst.setString(1, e.getLibelle());
            pst.setString(2, e.getDescription());
            File source = new File(e.getImage().replace("%20"," ").substring(6));
            File dest = new File("./src/Presentation/views/resources/images/exercice/" + e.getId() + ".png");
            System.out.println(source);
            System.out.println(dest);
            try {
                File file = new File("./src/Presentation/views/resources/images/exercice/" + e.getId() + ".png");

                if (file.delete()) {
                    System.out.println("File deleted successfully");
                }
                Utils.copyFileUsingJava7Files(source, dest);
            } catch (IOException ex) {
                Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
            }
            pst.setString(3, "./src/Presentation/views/resources/images/exercice/" + e.getId() + ".png");
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
            pst = connexion.prepareStatement(requette);
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
    
    public String getNextId() {
        String nextid = "";
        try {
            String req = "SHOW TABLE STATUS LIKE 'exercice'";
            pst = connexion.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nextid = rs.getString("Auto_increment");
            }
        } catch (SQLException ex) {
            System.out.println("Echec get Next ID ");
        }
        return nextid;
    }

}
