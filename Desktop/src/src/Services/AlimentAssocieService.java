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
            String req = "INSERT INTO `alimentAssocie`(`idAliment`, `idProfile`, `qte`, `repas`) VALUES(?,?,?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setString(1, a.getIdAliment());
            ps.setString(2, a.getIdProfile());
            ps.setInt(3, a.getQte());
            ps.setInt(4, a.getRepas());
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
            String req = "UPDATE alimentAssocie SET qte=?, repas=? WHERE idAliment=? AND idProfile=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, a.getQte());
            ps.setInt(2, a.getRepas());
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
                a = new alimentAssocie(result.getString("idAliment"), result.getString("idProfile"), result.getInt("qte"), result.getInt("repas"));
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
                a.setRepas(rs.getInt("repas"));
                alimentsassocies.add(a);
            }
        }catch(SQLException ex){
            Logger.getLogger(AlimentAssocieService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Lister AlimentsAssocies");
        }
        return alimentsassocies;
    }
    
    @Override
    public List<alimentAssocie> listerAlimentsAssociesParId(String idProfile){
        List<alimentAssocie> alimentsassocies = new ArrayList();
        try{
            String req = "SELECT * FROM alimentAssocie WHERE idProfile = " + idProfile + " ORDER BY repas ASC";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                alimentAssocie a = new alimentAssocie();
                a.setIdAliment(rs.getString("idAliment"));
                a.setIdProfile(rs.getString("idProfile"));
                a.setQte(rs.getInt("qte"));
                a.setRepas(rs.getInt("repas"));
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
            req = "SELECT nbRepas FROM profile WHERE id = " + idProfile;
            ps = connexion.prepareStatement(req);
            ResultSet nbRepas = ps.executeQuery();
            while(nbRepas.next()){ 
                while(prog.next()){
                    int calParRepas = prog.getInt("calRequis") / nbRepas.getInt("nbRepas");
                    int proteinsParRepas = prog.getInt("proteinsRequis") / nbRepas.getInt("nbRepas");
                    int fatsParRepas = prog.getInt("fatsRequis") / nbRepas.getInt("nbRepas");
                    int carbsParRepas = prog.getInt("carbsRequis") / nbRepas.getInt("nbRepas");
                    for(int i = 1; i <= nbRepas.getInt("nbRepas"); i++){
                        int type0set = 0;
                        int type1set = 0;
                        int type2set = 0;
                        for(int j = 0; j < 3; j++){
                            alimentAssocie AA = new alimentAssocie();
                            AA.setIdProfile(idProfile);
                            AA.setRepas(i);
                            req = "SELECT * FROM aliment";
                            ps = connexion.prepareStatement(req);
                            ResultSet aliment = ps.executeQuery();
                            while(aliment.next()){
                                req = "SELECT * FROM alimentAssocie WHERE idAliment = " + aliment.getInt("id") + " AND idProfile = " + idProfile;
                                ps = connexion.prepareStatement(req);
                                ResultSet alimentDejaAssocie = ps.executeQuery();
                                if(alimentDejaAssocie.next() == false){
                                    if(aliment.getInt("type") == 0 && type0set == 0 && j == 0){
                                        AA.setIdAliment(aliment.getString("id"));
                                        AA.setQte(proteinsParRepas * 100 / aliment.getInt("proteins"));
                                        type0set = 1;  
                                    }
                                    if(aliment.getInt("type") == 1 && type1set == 0 && j == 1){               
                                        AA.setIdAliment(aliment.getString("id"));
                                        AA.setQte(carbsParRepas * 100 / aliment.getInt("carbs"));
                                        type1set = 1;  
                                    }
                                    if(aliment.getInt("type") == 2 && type2set == 0 && j == 2){ 
                                        AA.setIdAliment(aliment.getString("id"));
                                        AA.setQte(fatsParRepas * 100 / aliment.getInt("fats"));
                                        type2set = 1;  
                                    }
                                }
                            }
                            ajouterAlimentAssocie(AA);
                        }
                    }  
                }
            }     
        }catch(SQLException ex){
            Logger.getLogger(AlimentAssocieService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : AssocierAliments");
        }
    }

}
