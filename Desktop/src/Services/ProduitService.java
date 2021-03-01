/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import DataStorage.MyDB;
import Entities.Produit;
import IServices.IProduit;

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
public class ProduitService implements IProduit {
    Connection connexion;
    PreparedStatement ps;

    public ProduitService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
     @Override
    public boolean ajouterProduit(Produit p) {
        try {

            String req = "INSERT INTO `produit`(`id`,`idCategorie`, `libelle`, `prix`, `description`) VALUES ( ?,?,?,?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setInt(1, p.getId());
            ps.setInt(2, p.getIdCategorie());
            ps.setString(3, p.getLibelle());
            ps.setFloat(4, p.getPrix());
            ps.setString(5, p.getDescription());

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
    public boolean modifierProduit(Produit p) {
        try {
            String req = "UPDATE produit SET  idCategorie=? , libelle=? , prix=? , description=? WHERE id=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, p.getIdCategorie());
            ps.setString(2, p.getLibelle());
            ps.setFloat(3, p.getPrix());
            ps.setString(4, p.getDescription());
            ps.setInt(5, p.getId());
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
    public boolean supprimerProduit(int id) {
        try {
            String req = " DELETE FROM `produit` WHERE id = " + id + "";
            ps = connexion.prepareStatement(req);
            if(ps.executeUpdate() == 1){
                System.out.println("La supression du produit est effectuée");
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
    public Produit chercherProduitParID(int id) {
        Produit produit = null;
        try {
            ResultSet result = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT * FROM produit WHERE id = " + id);
            if (result.first()) {

                produit = new Produit(result.getInt("id"), result.getInt("idCategorie"), result.getString("libelle"),result.getFloat("prix"), result.getString("description"));
                return produit;
            }
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }
        return produit;
    }
    @Override
    public List<Produit> listeProduits() {
        List<Produit> produits = new ArrayList();
        try {
            String req = "SELECT * FROM produit";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setIdCategorie(rs.getInt("idCategorie"));
                p.setLibelle(rs.getString("libelle"));
                p.setPrix(rs.getFloat("prix"));
                p.setDescription(rs.getString("description"));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return produits;
    }
    
    @Override
    public String getNextId() {
        String nextid = "";
        try {
            String req = "SHOW TABLE STATUS LIKE 'produit'";
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
