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
import org.apache.log4j.BasicConfigurator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
    private static final Log log = LogFactory.getLog(ProduitService.class);

    public CategorieService() {
        BasicConfigurator.configure();
        connexion = MyDB.getinstance().getConnexion();
    }
    
    @Override
    public boolean ajouterCategorie(Categorie c) {
        try {

            String req = "INSERT INTO `categorie`(`id`,`nom`,`description`) VALUES (?,?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getDesc());
            if(ps.executeUpdate() == 1){
                System.out.println("Ajout effectué");
                log.info("Ajout effectué");
                return true;
            }else{
                System.out.println("Echec d'ajout");
                log.error("Echec d'ajout");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Echec d'ajout");
            log.error("Echec d'ajout");

            return false;
        }
    }

    @Override
    public boolean modifierCategorie(Categorie c) {
        try {
            String req = "UPDATE categorie SET  nom=?,description=? WHERE id=?";
            ps = connexion.prepareStatement(req);
            ps.setString(1, c.getNom());
            ps.setInt(3, c.getId());
            ps.setString(2, c.getDesc());
            if(ps.executeUpdate() == 1){
                System.out.println("Modification effectué");
                log.info("Modification effectué");
                return true;
            }else{
                System.out.println("Echec de Modification");
                log.error("Echec de modification");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Echec de modification");
            log.error("Echec de modification");
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
                log.error("Echec de supression");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Echec de supression");
            log.error("Echec de supression");

        }
        return false;
    }
    @Override
    public Categorie chercherCategorieParID(int id) {
        Categorie categorie = null;
        try {
            ResultSet result = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT * FROM categorie WHERE id = " + id);
            if (result.first()) {

                categorie = new Categorie(result.getInt("id"), result.getString("nom"));
                return categorie;
            }
        } catch (SQLException ex) {
            log.error("erreur" + ex.getMessage());
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
				c.setDesc(rs.getString("description"));
                categories.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
            log.error("Echec");

        }
        return categories;
    }
    @Override
    public List<Categorie> listeCategorieRech(String str) {
        List<Categorie> categories = new ArrayList();
        try {
            String req = "SELECT * FROM categorie where nom Like '%"+str+"%' or description like '%"+str+"%';";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categorie c = new Categorie();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
		c.setDesc(rs.getString("description"));
                categories.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
            log.error("Echec");

        }
        return categories;
    }
    @Override
    public String getNextId() {
        String nextid = "";
        try {
            String req = "SHOW TABLE STATUS LIKE 'categorie'";
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
