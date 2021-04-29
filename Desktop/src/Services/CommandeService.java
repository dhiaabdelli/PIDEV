/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Commande;
import IServices.ICommande;
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
public class CommandeService implements ICommande{

    Connection connexion;
    PreparedStatement ps;

    public CommandeService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    @Override
    public boolean ajouterCommande(Commande c) {
        System.out.println(c.getId() +" "+ c.getIdpanier()+ " " +c.getEmail()+" "+c.getTraite());
        try {
            String req = "INSERT INTO `commande`(`id`, `idPanier`, `email`, `traite`) VALUES ( ?,?,?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setInt(1, c.getId());
            ps.setInt(2, c.getIdpanier());
            ps.setString(3, c.getEmail());
            ps.setInt(4, c.getTraite());
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
    public boolean supprimerCommande(int id) {
        try {
            String req = " DELETE FROM `commande` WHERE id = " + id + "";
            System.out.println(req);
            ps = connexion.prepareStatement(req);
            if(ps.executeUpdate() == 1){
                System.out.println("La supression du commande est effectuée");
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
    public boolean annulerCommande(Commande c) {
         try {
            String req = "UPDATE commande SET  traite=? WHERE id=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, 1);
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
    public boolean modifierCommande(Commande c) {
         try {
            String req = "UPDATE commande SET  email=? ,traite=? WHERE id=?";
            ps = connexion.prepareStatement(req);
            ps.setString(1, c.getEmail());
            ps.setInt(2, c.getTraite());
            ps.setInt(3, c.getId());
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
    public List<Commande> listeCommande() {
         List<Commande> commandes = new ArrayList();
        try {
            String req = "SELECT commande.* , produitscommand.id as 'idPanier', produitscommand.idproduit as 'idproduit' , produitscommand.qt as 'qt', produit.libelle as 'libelle' , produit.prix as 'prix' FROM commande,produit,produitscommand WHERE commande.idPanier = produitscommand.id AND produit.id = produitscommand.idproduit";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Commande c = new Commande();
                c.setId(rs.getInt("id"));
                c.setIdproduit(rs.getInt("idproduit"));
                c.setIdpanier(rs.getInt("idPanier"));
                c.setEmail(rs.getString("email"));
                c.setTraite(rs.getInt("traite"));
		c.setQT(rs.getInt("qt"));
                
                c.setNomProduit(rs.getString("libelle"));
		c.setPrix(rs.getFloat("prix"));
                commandes.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return commandes;
    }
    
    
    @Override
    public List<Commande> listeCommandeRech(String str) {
         List<Commande> commandes = new ArrayList();
        try {
            String req = "SELECT commande.* , produitscommand.id as 'idPanier', produitscommand.idproduit as 'idproduit' , produitscommand.qt as 'qt', produit.libelle as 'libelle' , produit.prix as 'prix' FROM commande,produit,produitscommand WHERE commande.idPanier = produitscommand.id AND produit.id = produitscommand.idproduit AND ( commande.email like '%"+str+"%'  OR produit.libelle like '%"+str+"%' OR commande.id like '%"+str+"%')";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Commande c = new Commande();
                c.setId(rs.getInt("id"));
                c.setIdproduit(rs.getInt("idproduit"));
                c.setIdpanier(rs.getInt("idPanier"));
                c.setEmail(rs.getString("email"));
                c.setTraite(rs.getInt("traite"));
		c.setQT(rs.getInt("qt"));
                
                c.setNomProduit(rs.getString("libelle"));
		c.setPrix(rs.getFloat("prix"));
                commandes.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return commandes;
    }
    
    @Override
    public String getNextId() {
        String nextid = "";
        try {
            String req = "SHOW TABLE STATUS LIKE 'commande'";
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
