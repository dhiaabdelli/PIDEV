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
import IServices.IAliment;
import Entities.aliment;

public class AlimentService implements IAliment{
    
    Connection connexion;
    PreparedStatement ps;
    
    public AlimentService(){
        connexion = MyDB.getinstance().getConnexion();
    }

    @Override
    public boolean ajouterAliment(aliment a){
        try{
            String req = "INSERT INTO `aliment`(`id`, `nom`, `fats`, `carbs`, `proteins`, `calories`, `type`) VALUES(?,?,?,?,?,?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setString(1, a.getId());
            ps.setString(2, a.getNom());
            ps.setInt(3, a.getFats());
            ps.setInt(4, a.getCarbs());
            ps.setInt(5, a.getProteins());
            ps.setInt(6, a.getCalories());
            ps.setInt(7, a.getType());
            ps.executeUpdate();
            System.out.println("Succes : Ajout Aliment");
            return true;
        }catch(SQLException ex){
            Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Ajout Aliment");
            return false;
        }
    }

    @Override
    public boolean modifierAliment(aliment a){
        try{
            String req = "UPDATE aliment SET  nom=? , fats=? , carbs=? , proteins=? , calories=?, type=? WHERE id=?";
            ps = connexion.prepareStatement(req);
            ps.setString(1, a.getNom());
            ps.setInt(2, a.getFats());
            ps.setInt(3, a.getCarbs());
            ps.setInt(4, a.getProteins());
            ps.setInt(5, a.getCalories());
            ps.setInt(6, a.getType());
            ps.setString(7, a.getId());
            ps.executeUpdate();
            System.out.println("Succes : Modification Aliment");
            return true;
        }catch (SQLException ex){
             Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Modification Aliment");
            return false;
        }
    }
    
    @Override
    public boolean supprimerAliment(String id){
        try{
            String req = "DELETE FROM `aliment` WHERE id = " + id;
            ps = connexion.prepareStatement(req);
            ps.executeUpdate();
            System.out.println("Succes : Suppression Aliment");
            return true;
        }catch(SQLException ex){
            System.out.println("Echec : Suppression Aliment");
        }
        return false;
    }

    @Override
    public aliment chercherAlimentParId(String id){
        aliment a = null;
        try{
            ResultSet result = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM aliment WHERE id = " + id);
            if(result.first()){
                a = new aliment(result.getString("id"), result.getString("nom"), result.getInt("fats"), result.getInt("carbs"),result.getInt("proteins"), result.getInt("calories"), result.getInt("type"));
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
            String req = "SHOW TABLE STATUS LIKE 'aliment'";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nextid = rs.getString("Auto_increment");
            }
        }catch(SQLException ex) {
            Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Get Next ID Aliment");
        }
        return nextid;
    }

    @Override
    public List<aliment> listerAliments(){
        List<aliment> aliments = new ArrayList();
        try{
            String req = "SELECT * FROM aliment";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                aliment a = new aliment();
                a.setId(rs.getString("id"));
                a.setNom(rs.getString("nom"));
                a.setFats(rs.getInt("fats"));
                a.setCarbs(rs.getInt("carbs"));
                a.setProteins(rs.getInt("proteins"));
                a.setCalories(rs.getInt("calories"));
                a.setType(rs.getInt("type"));
                aliments.add(a);
            }
        }catch(SQLException ex){
            Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Lister Aliments");
        }
        return aliments;
    }
    
    @Override
    public List<aliment> listerAlimentsTriParCalorie(){
        List<aliment> aliments = new ArrayList();
        try{
            String req = "SELECT * FROM aliment ORDER BY calories ASC";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                aliment a = new aliment();
                a.setId(rs.getString("id"));
                a.setNom(rs.getString("nom"));
                a.setFats(rs.getInt("fats"));
                a.setCarbs(rs.getInt("carbs"));
                a.setProteins(rs.getInt("proteins"));
                a.setCalories(rs.getInt("calories"));
                a.setCalories(rs.getInt("type"));
                aliments.add(a);
            }
        }catch(SQLException ex){
            Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Lister Aliments Tri Par Calories");
        }
        return aliments;
    }
    
    @Override
    public String getMaxId(){
        String maxId = "0";
        try{
            String req = "SELECT MAX(CAST(id as signed)) FROM aliment";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maxId = Integer.toString((rs.getInt("MAX(CAST(id as signed))") + 1));
            }
        }catch(SQLException ex){
            Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Get Max Id");
        }
        return maxId;  
    }
    
}
