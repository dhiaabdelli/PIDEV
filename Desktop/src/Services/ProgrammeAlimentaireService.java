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
import IServices.IProgrammeAlimentaire;
import Entities.programmeAlimentaire;
import static java.lang.Math.round;

public class ProgrammeAlimentaireService implements IProgrammeAlimentaire{
    
    Connection connexion;
    PreparedStatement ps;
    
    public ProgrammeAlimentaireService(){
        connexion = MyDB.getinstance().getConnexion();
    }

    @Override
    public boolean ajouterProgrammeAlimentaire(programmeAlimentaire p){
        try{
            String req = "INSERT INTO `programmeAlimentaire`(`idProfile`, `bmr`, `calRequis`, `fatsRequis`, `carbsRequis`, `proteinsRequis`) VALUES(?,?,?,?,?,?)";
            ps = connexion.prepareStatement(req);
            ps.setString(1, p.getIdProfile());
            ps.setInt(2, p.getBmr());
            ps.setInt(3, p.getCalRequis());
            ps.setInt(4, p.getFatsRequis());
            ps.setInt(5, p.getCarbsRequis());
            ps.setInt(6, p.getProteinsRequis());
            ps.executeUpdate();
            System.out.println("Succes : Ajout Programme Alimentaire");
            return true;
        }catch(SQLException ex){
            Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Ajout Programme Alimentaire");
            return false;
        }
    }

    @Override
    public boolean modifierProgrammeAlimentaire(programmeAlimentaire p){
        try{
            String req = "UPDATE programmeAlimentaire SET  bmr=? , calRequis=? , fatsRequis=? , carbsRequis=? , proteinsRequis=? WHERE idProfile=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, p.getBmr());
            ps.setInt(2, p.getCalRequis());
            ps.setInt(3, p.getFatsRequis());
            ps.setInt(4, p.getCarbsRequis());
            ps.setInt(5, p.getProteinsRequis());
            ps.setString(6, p.getIdProfile());
            ps.executeUpdate();
            System.out.println("Succes : Modification Programme Alimentaire");
            return true;
        }catch (SQLException ex){
             Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Modification Programme Alimentaire");
            return false;
        }
    }
    
    @Override
    public boolean supprimerProgrammeAlimentaire(String idProfile){
        try{
            String req = "DELETE FROM `programmeAlimentaire` WHERE idProfile = " + idProfile;
            ps = connexion.prepareStatement(req);
            ps.executeUpdate();
            System.out.println("Succes : Suppression Programme Alimentaire");
            return true;
        }catch(SQLException ex){
            System.out.println("Echec : Suppression Programme Alimentaire");
        }
        return false;
    }

    @Override
    public programmeAlimentaire chercherProgrammeAlimentaireParId(String idProfile){
        programmeAlimentaire p = null;
        try{
            ResultSet result = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM programmeAlimentaire WHERE idProfile = " + idProfile);
            if(result.first()){
                p = new programmeAlimentaire(result.getString("idProfile"), result.getInt("bmr"), result.getInt("calRequis"), result.getInt("fatsRequis"),result.getInt("carbsRequis"), result.getInt("proteinsRequis"));
                return p;
            }
        }catch(SQLException ex){
            Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur" + ex.getMessage());
        }
        return p;
    }

    @Override
    public String getNextId(){
        String nextid = "";
        try{
            String req = "SHOW TABLE STATUS LIKE 'programmeAlimentaire'";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nextid = rs.getString("Auto_increment");
            }
        }catch(SQLException ex){
            Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Get Next ID Programme Alimentaire");
        }
        return nextid;
    }

    @Override
    public List<programmeAlimentaire> listerProgrammesAlimentaires(){
        List<programmeAlimentaire> programmesAlimentaires = new ArrayList();
        try{
            String req = "SELECT * FROM programmeAlimentaire";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                programmeAlimentaire p = new programmeAlimentaire();
                p.setIdProfile(rs.getString("idProfile"));
                p.setBmr(rs.getInt("bmr"));
                p.setCalRequis(rs.getInt("calRequis"));
                p.setFatsRequis(rs.getInt("fatsRequis"));
                p.setCarbsRequis(rs.getInt("carbsRequis"));
                p.setProteinsRequis(rs.getInt("proteinsRequis"));
                programmesAlimentaires.add(p);
            }
        }catch(SQLException ex){
            Logger.getLogger(AlimentService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Lister Aliments");
        }
        return programmesAlimentaires;
    }
    
    @Override
    public void calculerProgrammeAlimentaire(String email, String idProfile){
        programmeAlimentaire pa = new programmeAlimentaire();
        try{
            String req = "SELECT * FROM profile WHERE emailCompte = '" + email + "' AND id = " + idProfile;
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("sexe") == 0){
                    pa.setBmr((int) round((13.397 * rs.getInt("poids") + 4.799  * rs.getInt("taille") - 5.677 * rs.getInt("age") + 88.362)));
                }
                if(rs.getInt("sexe") == 1){
                    pa.setBmr((int) round((9.247 * rs.getInt("poids") + 3.098  * rs.getInt("taille") - 4.330 * rs.getInt("age") + 447.593)));
                }
                if(rs.getInt("objectif") == 0){
                    pa.setCalRequis(pa.getBmr() - 500);
                    pa.setCarbsRequis(pa.getCalRequis() / 2 / 4);   
                    pa.setFatsRequis(pa.getCalRequis() * 20 / 100 / 9);  
                    pa.setProteinsRequis(pa.getCalRequis() * 30 / 100 / 4);  
                }
                if(rs.getInt("objectif") == 1){
                    pa.setCalRequis(pa.getBmr() + 500);
                    pa.setCarbsRequis(pa.getCalRequis() * 40 / 100 / 4);   
                    pa.setFatsRequis(pa.getCalRequis() * 20 / 100 / 9);  
                    pa.setProteinsRequis(pa.getCalRequis() * 40 / 100 / 4);  
                }
                pa.setIdProfile(idProfile);
                ajouterProgrammeAlimentaire(pa);
                System.out.println("Succes : Calcul Programme Alimentaire");
            }
        }catch(SQLException ex){
            Logger.getLogger(AlimentAssocieService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec : Calcul Programme Alimentaire");
        }
    }
    
}
