
package Services;

import DataStorage.MyDB;
import Entities.Produitscommand;
import IServices.IProduitscommand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ProduitscommandService implements IProduitscommand{
    Connection connexion;
    PreparedStatement ps;

    public ProduitscommandService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    @Override
    public boolean ajouterProduitscommand(Produitscommand p) {
        try {

            String req = "INSERT INTO `produitscommand`(`id`, `idproduit`, `qt`) VALUES (?,?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setInt(1, p.getId());
            ps.setInt(2, p.getIdproduit());
            ps.setInt(3, p.getQT());
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
    public boolean supprimerProduitscommand(int id) {
        try {
            String req = " DELETE FROM `produitscommand` WHERE id = " + id + "";
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
    public boolean modifierProduitscommand(Produitscommand p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produitscommand> listeProduitscommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNextId() {
        String nextid = "";
        try {
            String req = "SHOW TABLE STATUS LIKE 'produitscommand'";
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
