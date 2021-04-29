
package Services;

import DataStorage.MyDB;
import Entities.Panier;
import IServices.IPanier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PanierService implements IPanier{
    
    Connection connexion;
    PreparedStatement ps;

    public PanierService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    @Override
    public boolean ajouterPanier(Panier p) {
       try {

            String req = "INSERT INTO `panier`(`idproduit`,`email`,`qt`) VALUES (?,?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setInt(1, p.getIdproduit());
            ps.setString(2, p.getEmail());
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
    public boolean supprimerPanier(int id, String email) {
        try {
            String req = " DELETE FROM `panier` WHERE idproduit = " + id + " AND email = '" + email + "'";
            System.out.println(req);
            ps = connexion.prepareStatement(req);
            if(ps.executeUpdate() == 1){
                System.out.println("La supression du Panier est effectuée");
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
    public boolean modifierProduit(Panier p) {
        try {
            String req = "UPDATE panier SET  qt=? WHERE idproduit=? AND email=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, p.getQT());
            ps.setInt(2, p.getIdproduit());
            ps.setString(3, p.getEmail());
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
    public boolean modifierProduitBack(Panier p) {
        try {
            String req = "UPDATE panier SET qt=? , idproduit=? , email=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, p.getQT());
            ps.setInt(2, p.getIdproduit());
            ps.setString(3, p.getEmail());
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
    public Panier chercherPanierParIDEmail(int id, int email) {
        Panier panier = null;
        try {
            ResultSet result = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT panier.*, produit.libelle as 'libelle' , produit.description as 'description', produit.prix as 'prix' , produit.img as 'img' FROM panier, produit WHERE panier.idproduit = produit.id AND panier.idproduit = " + id+" AND email = "+email);
            if (result.first()) {

                panier = new Panier(result.getInt("idproduit"), result.getString("email"), result.getInt("qt"), result.getString("libelle"), result.getString("description"),result.getFloat("prix"), result.getString("img"));
                return panier;
            }
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }
        return panier;
    }

    @Override
    public List<Panier> listePanier() {
        List<Panier> paniers = new ArrayList();
        try {
            String req = "SELECT panier.*, produit.libelle as 'libelle' , produit.description as 'description', produit.prix as 'prix' , produit.img as 'img' FROM panier, produit WHERE panier.idproduit = produit.id";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Panier p = new Panier();
                p.setIdproduit(rs.getInt("idproduit"));
                p.setEmail(rs.getString("email"));
		p.setQT(rs.getInt("qt"));
                
                p.setLibelle(rs.getString("libelle"));
                p.setDescription(rs.getString("description"));
		p.setPrix(rs.getFloat("prix"));
                p.setImg(rs.getString("img"));
                paniers.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return paniers;
    }
    
    @Override
    public List<Panier> listePanierRech(String str) {
       List<Panier> paniers = new ArrayList();
        try {
            String req = "SELECT panier.*, produit.libelle as 'libelle' , produit.description as 'description', produit.prix as 'prix' , produit.img as 'img' FROM panier, produit WHERE panier.idproduit = produit.id AND ( produit.libelle like '%"+str+"%'  OR panier.email like '%"+str+"%')";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Panier p = new Panier();
                p.setIdproduit(rs.getInt("idproduit"));
                p.setEmail(rs.getString("email"));
		p.setQT(rs.getInt("qt"));
                
                p.setLibelle(rs.getString("libelle"));
                p.setDescription(rs.getString("description"));
		p.setPrix(rs.getFloat("prix"));
                p.setImg(rs.getString("img"));
                paniers.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return paniers;
    }

    @Override
    public List<Panier> listePanierTrie(int tri) {
        List<Panier> paniers = new ArrayList();
        try {
            String req;
            switch (tri) {
                case 0:
                    req = "SELECT panier.*, produit.libelle as 'libelle' , produit.description as 'description', produit.prix as 'prix' , produit.img as 'img' FROM panier, produit WHERE panier.idproduit = produit.id order by panier.qt";
                    break;
                case 1:
                    req = "SELECT panier.*, produit.libelle as 'libelle' , produit.description as 'description', produit.prix as 'prix' , produit.img as 'img' FROM panier, produit WHERE panier.idproduit = produit.id order by produit.prix";
                    break;
                default:
                    req = "SELECT panier.*, produit.libelle as 'libelle' , produit.description as 'description', produit.prix as 'prix' , produit.img as 'img' FROM panier, produit WHERE panier.idproduit = produit.id order by panier.qt";
                    break;
            }
            
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Panier p = new Panier();
                p.setIdproduit(rs.getInt("idproduit"));
                p.setEmail(rs.getString("email"));
		p.setQT(rs.getInt("qt"));
                
                p.setLibelle(rs.getString("libelle"));
                p.setDescription(rs.getString("description"));
		p.setPrix(rs.getFloat("prix"));
                p.setImg(rs.getString("img"));
                paniers.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return paniers;
    }

    @Override
    public List<Panier> listePanierTrieRech(int tri, String str) {
        List<Panier> paniers = new ArrayList();
        try {
            String req;
            switch (tri) {
                case 0:
                    req = "SELECT panier.*, produit.libelle as 'libelle' , produit.description as 'description', produit.prix as 'prix' , produit.img as 'img' FROM panier, produit WHERE panier.idproduit = produit.id AND produit.libelle like '%"+str+"%' order by panier.qt";
                    break;
                case 1:
                    req = "SELECT panier.*, produit.libelle as 'libelle' , produit.description as 'description', produit.prix as 'prix' , produit.img as 'img' FROM panier, produit WHERE panier.idproduit = produit.id AND produit.libelle like '%"+str+"%' order by produit.prix";
                    break;
                default:
                    req = "SELECT panier.*, produit.libelle as 'libelle' , produit.description as 'description', produit.prix as 'prix' , produit.img as 'img' FROM panier, produit WHERE panier.idproduit = produit.id AND produit.libelle like '%"+str+"%' order by panier.qt";
                    break;
            }
            
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Panier p = new Panier();
                p.setIdproduit(rs.getInt("idproduit"));
                p.setEmail(rs.getString("email"));
		p.setQT(rs.getInt("qt"));
                
                p.setLibelle(rs.getString("libelle"));
                p.setDescription(rs.getString("description"));
		p.setPrix(rs.getFloat("prix"));
                p.setImg(rs.getString("img"));
                paniers.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return paniers;
    }
    
    @Override
    public String getNextId() {
        String nextid = "";
        try {
            String req = "SHOW TABLE STATUS LIKE 'panier'";
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
