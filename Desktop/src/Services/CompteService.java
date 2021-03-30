/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import entities.Compte;
import IServices.ICompte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class CompteService implements ICompte{
    Connection connexion;
    PreparedStatement ps;

    public CompteService() {
        connexion = MyDB.getinstance().getConnexion();
    } 
    
    @Override
    public boolean ajouterCompte(Compte c) {
        try {

            String req = "INSERT INTO `compte`(`email`,`mdp`,`nom`,`prenom`) VALUES (?,?,?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setString(1, c.getEmail());
            ps.setString(2, c.getMdp());
            ps.setString(3, c.getNom());
            ps.setString(4, c.getPrenom());
            
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
    public boolean modifierCompte(Compte c) {
        try {
            String req = "UPDATE compte SET mdp=?, nom=?, prenom=? WHERE email=?";
            ps = connexion.prepareStatement(req);
            ps.setString(1, c.getMdp());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getPrenom());
            ps.setString(4, c.getEmail());
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
    public boolean supprimerCompte(int email) {
        try {
            String req = " DELETE FROM `compte` WHERE email = " + email + "";
            ps = connexion.prepareStatement(req);
            if(ps.executeUpdate() == 1){
                System.out.println("La supression du compte a été effectuée");
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
    
    public List<Compte> listeCompte() {
        List<Compte> comptes = new ArrayList();
        try {
            String req = "SELECT * FROM `compte`";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Compte c = new Compte();
                c.setEmail(rs.getString("email"));
                c.setMdp(rs.getString("mdp"));
                 c.setNom(rs.getString("nom"));
                  c.setPrenom(rs.getString("prenom"));
                comptes.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return comptes;
    }
    
    public Compte chercherCompte(String email){
        Compte c = null;
        try{
            ResultSet result = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM compte WHERE email = '" + email + "'");
            if(result.first()){
                c = new Compte(result.getString("email"), result.getString("mdp"), result.getString("nom"), result.getString("prenom"));
                return c;
            }
        }catch(SQLException ex){
            Logger.getLogger(CompteService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur" + ex.getMessage());
        }
        return c;
    }

}
