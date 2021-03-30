/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Livraison;
import entities.Livreur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class LivraisonCRUD {


               
     public void addLivraisons(Livraison l) {
        
         String requette = "INSERT INTO livraison (reference,dateLivraison,nomLivreur,etat,nomClient)"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(requette);
            
            pst.setInt(1, l.getReference());
            pst.setString(2, l.getDateLivraison());
            pst.setString(3, l.getNomLivreur());
            pst.setString(4, l.getEtat());
            pst.setString(5, l.getNomClient());
            pst.executeUpdate();
            
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Livraison Ajouté!");
            alert.showAndWait();
            
            System.out.println("Livraison Ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(LivraisonCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
         public static ObservableList<Livraison> AfficheLivraisons() {
        String req = "select * from livraison";
        ObservableList<Livraison> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new Livraison(Integer.parseInt(rs.getString("idLivraison")),Integer.parseInt(rs.getString("reference")), rs.getString("dateLivraison"), rs.getString("nomLivreur"), rs.getString("etat"), rs.getString("nomClient")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivraisonCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
 
     
    public void updateLivraisons(Livraison l){
        String requette = "update livraison set  reference = ? , dateLivraison = ? , nomLivreur = ?, etat = ?, nomClient = ? where idLivraison = ? ";
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(requette);
             pst.setInt(1, l.getReference());
            pst.setString(2, l.getDateLivraison());
            pst.setString(3, l.getNomLivreur());
            pst.setString(4, l.getEtat());
            pst.setString(5, l.getNomClient());
              pst.setInt(6, l.getIdLivraison());
            pst.executeUpdate();
            
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Livraison Modifié!");
            alert.showAndWait();
            System.out.println("LIvraison Modifié!");
        } catch (SQLException ex) {
            Logger.getLogger(LivraisonCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteLivraisons(int id){
         String requette = "delete from livraison where idLivraison = ? ";
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(requette);
            pst.setInt(1, id);
            pst.executeUpdate();
            
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Livraison Supprimé!");
            alert.showAndWait();
            System.out.println("Livraison Supprimé!");
        } catch (SQLException ex) {
            Logger.getLogger(LivraisonCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static ObservableList<Livraison> rechLivraison(String nom) {
        ObservableList<Livraison> list = FXCollections.observableArrayList();
        String requete = "select * from livraison where nom like '%" + nom + "%'";

        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(requete);
            //.setString(1, nom);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Livraison(Integer.parseInt(rs.getString("idLivraison")),Integer.parseInt(rs.getString("reference")), rs.getString("dateLivraison"), rs.getString("nomLivreur"), rs.getString("etat"), rs.getString("nomClient")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivraisonCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
 public static ObservableList GetNom(String nom) {
        String req = "select * from livraison where nom like ?";
        Livraison nm = new Livraison();
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(req);
            pst.setString(1, nom);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                nm = new Livraison(Integer.parseInt(rs.getString("idLivraison")),Integer.parseInt(rs.getString("reference")), rs.getString("dateLivraison"), rs.getString("nomLivreur"), rs.getString("etat"), rs.getString("nomClient"));
            }

        } catch (SQLException e) {
            Logger.getLogger(LivreurCRUD.class.getName()).log(Level.SEVERE, null, e);
        }
      return (ObservableList) nm;
 
    }
 
 public static ObservableList<String> getLivNom() {
        String req = "select nom from livreur";
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(rs.getString("nom"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivreurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
 
 public static Livraison getLivParNom(String nom) {
        String req = "select * from livraison where nomLivreur like ?";
        Livraison l = new Livraison();
        try {
            PreparedStatement pst
                    = new MyConnexion().cn.prepareStatement(req);
            pst.setString(1, nom);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                l = new Livraison(Integer.parseInt(rs.getString("idLivraison")),Integer.parseInt(rs.getString("reference")), rs.getString("dateLivraison"), rs.getString("nomLivreur"), rs.getString("etat"), rs.getString("nomClient"));
            }

        } catch (SQLException e) {
            Logger.getLogger(LivraisonCRUD.class.getName()).log(Level.SEVERE, null, e);
        }
        return l;
    }
 }

