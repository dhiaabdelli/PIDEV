/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IAdmin;
import entities.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mrabe
 */
public class AdminService implements IAdmin{
    Connection connexion;
    PreparedStatement ps;

    public AdminService() {
        connexion = MyDB.getinstance().getConnexion();
    } 
    
    @Override
    public boolean ajouterAdmin(Admin a) {
        try {

            String req = "INSERT INTO `admin`(`user`,`mdp`) VALUES (?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setString(1, a.getUser());
            ps.setString(2, a.getMdp());
            
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
    public boolean modifierAdmin(Admin a) {
        try {
            String req = "UPDATE admin SET mdp=? WHERE user=?";
            ps = connexion.prepareStatement(req);
            ps.setString(1, a.getMdp());
            ps.setString(2, a.getUser());
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
    public boolean supprimerAdmin(int user) {
        try {
            String req = " DELETE FROM `admin` WHERE user = " + user + "";
            ps = connexion.prepareStatement(req);
            if(ps.executeUpdate() == 1){
                System.out.println("La supression du admin a été effectuée");
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
    
    }
