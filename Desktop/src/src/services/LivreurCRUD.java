/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import javafx.scene.control.Alert;
import entities.Livreur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * @author dorra
 */
public class LivreurCRUD {

             
     public void addLivreurs(Livreur l) {
        
         String requette = "INSERT INTO livreur (nom,prenom,num,image)"
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(requette);
            
            pst.setString(1, l.getNom());
            pst.setString(2, l.getPrenom());
            pst.setInt(3, l.getNum());
            pst.setString(4, l.getImage()); 
            pst.executeUpdate();
            
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Livreur Ajouté!");
            alert.showAndWait();
            
            System.out.println("Livreur Ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(LivreurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
         public static ObservableList<Livreur> AfficheLivreurs() {
        String req = "select * from livreur";
        ObservableList<Livreur> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new Livreur(Integer.parseInt(rs.getString("id")), rs.getString("nom"), rs.getString("prenom"), rs.getInt("num"),rs.getString("image")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivreurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
 
     
    public void updateLivreurs(Livreur l){
        String requette = "update livreur set  nom = ? , prenom = ? , num = ? ,image = ? where id = ? ";
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(requette);
            pst.setString(1, l.getNom());
            pst.setString(2, l.getPrenom());
            pst.setInt(3, l.getNum());
            pst.setString(4, l.getImage());
            pst.setInt(5, l.getId());
            pst.executeUpdate();
            
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Exercice Modifié!");
            alert.showAndWait();
            System.out.println("Exercice Modifié!");
        } catch (SQLException ex) {
            Logger.getLogger(LivreurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteLivreurs(int id){
         String requette = "delete from Livreur where id = ? ";
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(requette);
            pst.setInt(1, id);
            pst.executeUpdate();
            
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Livreur Supprimé!");
            alert.showAndWait();
            System.out.println("Livreur Supprimé!");
        } catch (SQLException ex) {
            Logger.getLogger(LivreurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static ObservableList<Livreur> rechLivreur(String nom) {
        ObservableList<Livreur> list = FXCollections.observableArrayList();
        String requete = "select * from livreur where nom like '%" + nom + "%'";

        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(requete);
            //.setString(1, nom);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Livreur(Integer.parseInt(rs.getString("id")), rs.getString("nom"), rs.getString("prenom"), Integer.parseInt(rs.getString("num")),rs.getString("image")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     

}
