/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import DataStorage.MyDB;
import Entities.Categorie;
import Entities.Produit;
import IServices.ICategorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class CategorieService implements ICategorie{
    Connection connexion;
    PreparedStatement ps;

    public CategorieService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    @Override
    public boolean ajouterCategorie(Categorie c) {
        try {

            String req = "INSERT INTO `categorie`(`id`,`nom`) VALUES (?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getNom());
            
            if(ps.executeUpdate() == 1){
                System.out.println("Ajout effectué");
                return true;
            }else{
                System.out.println("Echec d'ajout");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Echec d'ajout");
            return false;
        }
    }

    @Override
    public boolean modifierCategorie(Categorie c) {
        try {
            String req = "UPDATE categorie SET  nom=? WHERE id=?";
            ps = connexion.prepareStatement(req);
            ps.setString(1, c.getNom());
            ps.setInt(2, c.getId());
            if(ps.executeUpdate() == 1){
                System.out.println("Modification effectué");
                return true;
            }else{
                System.out.println("Echec de Modification");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Echec de modification");
            return false;
        }
    }
    @Override
    public boolean supprimerCategorie(int id) {
        try {
            String req = " DELETE FROM `categorie` WHERE id = " + id + "";
            ps = connexion.prepareStatement(req);
            if(ps.executeUpdate() == 1){
                System.out.println("La supression de la categorie est effectuée");
                return true;
            }else{
                System.out.println("Echec de supression");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Echec de supression");
        }
        return false;
    }
    @Override
    public Categorie chercherCategorieParID(int id) {
        Categorie categorie = null;
        try {
            ResultSet result = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT * FROM produit WHERE id = " + id);
            if (result.first()) {

                categorie = new Categorie(result.getInt("id"), result.getString("nom"));
                return categorie;
            }
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }
        return categorie;
    }   
    
    @Override
    public List<Categorie> listeCategorie() {
        List<Categorie> categories = new ArrayList();
        try {
            String req = "SELECT * FROM categorie";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categorie c = new Categorie();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                categories.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return categories;
    }
    @Override
    public String getNextId() {
        String nextid = "";
        try {
            String req = "1";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nextid = rs.getString("Auto_increment");
            }
        } catch (SQLException ex) {
            System.out.println("Echec get Next ID ");
        }
        return nextid;
    }
}
