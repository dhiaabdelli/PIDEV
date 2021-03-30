/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import entities.Profil;
import IServices.IProfil;

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
 * @author mrabe
 */
public class ProfilService implements IProfil{
    Connection connexion;
    PreparedStatement ps;

    public ProfilService() {
        connexion = MyDB.getinstance().getConnexion();
    } 
    
    @Override
    public boolean ajouterProfil(Profil p) {
        try {

            String req = "INSERT INTO `profil`(`id`,`emailCompte`,`sexe`,`age`,`poids`,`taille`,`objectif`,`nbRepas`) VALUES (?,?,?,?,?,?,?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getEmailCompte());
            ps.setInt(3, p.getSexe());
            ps.setInt(4, p.getAge());
            ps.setFloat(5, p.getPoids());
            ps.setFloat(6, p.getTaille());
            ps.setInt(7, p.getObjectif());
            ps.setInt(8, p.getNbRepas());
            
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
    public boolean modifierProfil(Profil p) {
        try {
            String req = "UPDATE profil SET  sexe=? , age=? , poids=? , taille=? , objectif=? , nbRepas=?  WHERE id=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, p.getId());
            ps.setInt(2, p.getSexe());
            ps.setInt(3, p.getAge());
            ps.setFloat(4, p.getPoids());
            ps.setFloat(5, p.getTaille());
            ps.setInt(6, p.getObjectif());
            ps.setInt(8, p.getNbRepas());
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
    public boolean supprimerProfil(int id) {
        try {
            String req = " DELETE FROM `profil` WHERE id = " + id + "";
            ps = connexion.prepareStatement(req);
            if(ps.executeUpdate() == 1){
                System.out.println("La supression du profil a été effectuée");
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
    
    /**
     *
     * @return
     */
    @Override
    public List<Profil> listeProfil() {
        List<Profil> profils = new ArrayList();
        try{
            String req = "SELECT * FROM profil";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Profil p = new Profil();
                p.setId(rs.getInt("id"));
                p.setEmailCompte(rs.getString("emailCompte"));
                p.setSexe(rs.getInt("sexe"));
                p.setAge(rs.getInt("age"));
                p.setPoids(rs.getFloat("poids"));
                p.setTaille(rs.getFloat("taille"));
                p.setObjectif(rs.getInt("objectif"));
                profils.add(p);
            }
        }catch(SQLException ex){
            Logger.getLogger(ProfilService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Lister Profils par Email");
        }
        return profils;
    }
    
    @Override
    public List<Profil> listeProfilParEmail(String email){
        List<Profil> profils = new ArrayList();
        try{
            String req = "SELECT * FROM profile WHERE emailCompte = '" + email + "'";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Profil p = new Profil();
                p.setId(rs.getInt("id"));
                p.setEmailCompte(rs.getString("emailCompte"));
                p.setSexe(rs.getInt("sexe"));
                p.setAge(rs.getInt("age"));
                p.setPoids(rs.getFloat("poids"));
                p.setTaille(rs.getFloat("taille"));
                p.setObjectif(rs.getInt("objectif"));
                p.setNbRepas(rs.getInt("nbRepas"));
                profils.add(p);
            }
        }catch(SQLException ex){
            Logger.getLogger(ProfilService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Lister Profils par Email");
        }
        return profils;
    }

}
