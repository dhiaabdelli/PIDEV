package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DataStorage.MyDB;
import static java.lang.Math.round;
import IServices.IAlimentAssocie;
import Entities.alimentAssocie;


public class AlimentAssocieService implements IAlimentAssocie{
        
    Connection connexion;
    PreparedStatement ps;
    
    public AlimentAssocieService(){
        connexion = MyDB.getinstance().getConnexion();
    }

    @Override
    public boolean ajouterAlimentAssocie(alimentAssocie a){
        try{
            String req = "INSERT INTO `alimentAssocie`(`idAliment`, `idProfile`, `qte`, `num`) VALUES(?,?,?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setString(1, a.getIdAliment());
            ps.setString(2, a.getIdProfile());
            ps.setInt(3, a.getQte());
            ps.setInt(4, a.getNum());
            ps.executeUpdate();
            System.out.println("Succes : Ajout AlimentAssocie");
            return true;
        }catch(SQLException ex){
            Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Ajout AlimentAssocie");
            return false;
        }
    }

    @Override
    public boolean modifierAlimentAssocie(alimentAssocie a){
        try{
            String req = "UPDATE alimentAssocie SET qte=?, num=? WHERE idAliment=? AND idProfile=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, a.getQte());
            ps.setInt(2, a.getNum());
            ps.setString(3, a.getIdAliment());
            ps.setString(4, a.getIdProfile());
            ps.executeUpdate();
            System.out.println("Succes : Modification AlimentAssocie");
            return true;
        }catch (SQLException ex){
             Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Modification AlimentAssocie");
            return false;
        }
    }
    
    @Override
    public boolean supprimerAlimentAssocie(String idAliment, String idProfile){
        try{
            String req = "DELETE FROM `alimentAssocie` WHERE idAliment = " + idAliment + " AND idProfile = " + idProfile;
            ps = connexion.prepareStatement(req);
            ps.executeUpdate();
            System.out.println("Succes : Suppression AlimentAssocie");
            return true;
        }catch(SQLException ex){
            System.out.println("Echec : Suppression AlimentAssocie");
        }
        return false;
    }

    @Override
    public alimentAssocie chercherAlimentAssocieParId(String idAliment, String idProfile){
        alimentAssocie a = null;
        try{
            ResultSet result = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM alimentAssocie WHERE idAliment = " + idAliment + " AND idProfile = " + idProfile);
            if(result.first()){
                a = new alimentAssocie(result.getString("idAliment"), result.getString("idProfile"), result.getInt("qte"), result.getInt("num"));
                return a;
            }
        }catch(SQLException ex){
            Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur" + ex.getMessage());
        }
        return a;
    }

    @Override
    public String getNextId(){
        String nextid = "";
        try{
            String req = "SHOW TABLE STATUS LIKE 'alimentAssocie'";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nextid = rs.getString("Auto_increment");
            }
        }catch(SQLException ex){
            Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Get Next ID AlimentAssocie");
        }
        return nextid;
    }

    @Override
    public List<alimentAssocie> listerAlimentsAssocies(){
        List<alimentAssocie> alimentsassocies = new ArrayList();
        try{
            String req = "SELECT * FROM alimentAssocie";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                alimentAssocie a = new alimentAssocie();
                a.setIdAliment(rs.getString("idAliment"));
                a.setIdProfile(rs.getString("idProfile"));
                a.setQte(rs.getInt("qte"));
                a.setNum(rs.getInt("num"));
                alimentsassocies.add(a);
            }
        }catch(SQLException ex){
            Logger.getLogger(AlimentAssocieService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Lister AlimentsAssocies");
        }
        return alimentsassocies;
    }
    
    @Override
    public void associerAliments(String idProfile){
        try{
            String req = "SELECT * FROM programmeAlimentaire WHERE idProfile = " + idProfile;
            ps = connexion.prepareStatement(req);
            ResultSet prog = ps.executeQuery();
            while(prog.next()){
                req = "SELECT * FROM aliment";
                ps = connexion.prepareStatement(req);
                ResultSet aliment = ps.executeQuery();
                while(aliment.next()){
                    /*if(aliment.getInt("calories")){
                        
                    }*/
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(AlimentAssocieService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Lister AlimentsAssocies");
        }
    }
    
}
