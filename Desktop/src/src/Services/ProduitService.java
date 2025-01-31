/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import DataStorage.MyDB;
import Entities.Produit;
import IServices.IProduit;
import Utils.Utils;

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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProduitService implements IProduit {
    Connection connexion;
    PreparedStatement ps;

    public ProduitService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
     @Override
    public boolean ajouterProduit(Produit p) {
        try {

            String req = "INSERT INTO `produit`(`id`,`idCategorie`, `libelle`, `prix`, `description`, `qt`, `img`) VALUES ( ?,?,?,?,?,?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setInt(1, p.getId());
            ps.setInt(2, p.getIdCategorie());
            ps.setString(3, p.getLibelle());
            ps.setFloat(4, p.getPrix());
            ps.setString(5, p.getDescription());
            ps.setInt(6, p.getQt());
            
            if(!p.getImg().isEmpty()){

                File source = new File(p.getImg());
                File dest = new File("./src/Presentation/views/resources/images/products/"+p.getId()+".png");

                System.out.println(source);
                System.out.println(dest);
                try{
                    Utils.copyFileUsingJava7Files(source,dest);
                } catch (IOException ex) {
                    Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
                }
                ps.setString(7, "../../views/resources/images/products/"+p.getId()+".png");
            }else{
                ps.setString(7, "");
            }
            
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
    public boolean modifierProduit(Produit p) {
        try {
            String req = "UPDATE produit SET  idCategorie=? , libelle=? , prix=? , description=? , qt=?, img=? WHERE id=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, p.getIdCategorie());
            ps.setString(2, p.getLibelle());
            ps.setFloat(3, p.getPrix());
            ps.setString(4, p.getDescription());
            ps.setInt(5, p.getQt());
            ps.setInt(7, p.getId());
            
            
            if(!p.getImg().isEmpty()){
                File source = new File(p.getImg());
                File dest = new File("./src/Presentation/views/resources/images/products/"+p.getId()+".png");

                
                try{
                    if(!p.getTestimg()){
                        File file = new File("./src/Presentation/views/resources/images/products/"+p.getId()+".png"); 

                        if(file.delete()) 
                        { 
                            System.out.println("File deleted successfully"); 
                        } 
                        Utils.copyFileUsingJava7Files(source,dest);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
                }
                ps.setString(6, "../../views/resources/images/products/"+p.getId()+".png");
            }else{
                ps.setString(6, "");
            }
            if(ps.executeUpdate() == 1){
                System.out.println("Modification effectué");
                return true;
            }else{
                System.out.println("Echec de Modification");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Echec de modification");
            ex.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean supprimerProduit(int id) {
        try {
            String req = " DELETE FROM `produit` WHERE id = " + id + "";
            ps = connexion.prepareStatement(req);
            if(ps.executeUpdate() == 1){
                System.out.println("La supression du produit est effectuée");
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
    public Produit chercherProduitParID(int id) {
        Produit produit = null;
        try {
            ResultSet result = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT * FROM produit WHERE id = " + id);
            if (result.first()) {

                produit = new Produit(result.getInt("id"), result.getInt("idCategorie"), result.getString("libelle"),result.getFloat("prix"), result.getString("description"));
                return produit;
            }
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }
        return produit;
    }
    @Override
    public List<Produit> listeProduits() {
        List<Produit> produits = new ArrayList();
        try {
            String req = "SELECT * FROM produit order by libelle;";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setIdCategorie(rs.getInt("idCategorie"));
                p.setLibelle(rs.getString("libelle"));
                p.setPrix(rs.getFloat("prix"));
                p.setDescription(rs.getString("description"));
                p.setQt(rs.getInt("qt"));
                p.setImg(rs.getString("img"));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return produits;
    }
    
    @Override
    public List<Produit> listeProduitsParIdCategorie(int id) {
        List<Produit> produits = new ArrayList();
        try {
            String req = "SELECT * FROM produit WHERE idCategorie = '"+id+"' order by libelle;";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setIdCategorie(rs.getInt("idCategorie"));
                p.setLibelle(rs.getString("libelle"));
                p.setPrix(rs.getFloat("prix"));
                p.setDescription(rs.getString("description"));
                p.setQt(rs.getInt("qt"));
                p.setImg(rs.getString("img"));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return produits;
    }
    
	@Override
    public List<Produit> listeProduitsBack() {
        List<Produit> produits = new ArrayList();
        try {
            String req = "SELECT produit.*, categorie.nom AS 'nomCategorie' FROM produit, categorie WHERE produit.idCategorie = categorie.id";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setIdCategorie(rs.getInt("idCategorie"));
                p.setLibelle(rs.getString("libelle"));
                p.setPrix(rs.getFloat("prix"));
                p.setDescription(rs.getString("description"));
                p.setnomCategorie(rs.getString("nomCategorie"));
                p.setQt(rs.getInt("qt"));
                p.setImg(rs.getString("img"));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return produits;
    }
	
	@Override
    public List<Produit> listeProduitsRechBack(String str) {
        List<Produit> produits = new ArrayList();
        try {
            String req = "SELECT produit.*, categorie.nom AS 'nomCategorie' FROM produit, categorie where produit.idCategorie = categorie.id and (produit.libelle like '%"+str+"%' or produit.prix like '%"+str+"%' or produit.description like '%"+str+"%' or produit.qt like '%"+str+"%' or produit.img like '%"+str+"%' or categorie.nom like '%"+str+"%');";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setIdCategorie(rs.getInt("idCategorie"));
                p.setLibelle(rs.getString("libelle"));
                p.setPrix(rs.getFloat("prix"));
                p.setDescription(rs.getString("description"));
                p.setnomCategorie(rs.getString("nomCategorie"));
                p.setQt(rs.getInt("qt"));
                p.setImg(rs.getString("img"));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return produits;
    }
	
	
    @Override
    public List<Produit> listeProduitsRech(String str) {
        List<Produit> produits = new ArrayList();
        try {
            String req = "SELECT * FROM produit where libelle like '%"+str+"%' order by libelle;";
            
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setIdCategorie(rs.getInt("idCategorie"));
                p.setLibelle(rs.getString("libelle"));
                p.setPrix(rs.getFloat("prix"));
                p.setDescription(rs.getString("description"));
                p.setQt(rs.getInt("qt"));
                p.setImg(rs.getString("img"));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return produits;
    }
    
    @Override
    public List<Produit> listeProduitsTrieRech(int tri,String str) {
        List<Produit> produits = new ArrayList();
        try {
            String req;
            switch (tri) {
                case 0:
                    req = "SELECT * FROM produit where libelle like '%"+str+"%' order by libelle;";
                    break;
                case 1:
                    req = "SELECT * FROM produit where libelle like '%"+str+"%' order by prix;";
                    break;
                default:
                    req = "SELECT * FROM produit where libelle like '%"+str+"%' order by prix;";
                    break;
            }
            
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setIdCategorie(rs.getInt("idCategorie"));
                p.setLibelle(rs.getString("libelle"));
                p.setPrix(rs.getFloat("prix"));
                p.setDescription(rs.getString("description"));
                p.setQt(rs.getInt("qt"));
                p.setImg(rs.getString("img"));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return produits;
    }
    
    @Override
    public List<Produit> listeProduitsTrie(int tri) {
        List<Produit> produits = new ArrayList();
        try {
            String req;
            switch (tri) {
                case 0:
                    req = "SELECT * FROM produit order by libelle;";
                    break;
                case 1:
                    req = "SELECT * FROM produit order by prix;";
                    break;
                default:
                    req = "SELECT * FROM produit order by prix;";
                    break;
            }
            
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setIdCategorie(rs.getInt("idCategorie"));
                p.setLibelle(rs.getString("libelle"));
                p.setPrix(rs.getFloat("prix"));
                p.setDescription(rs.getString("description"));
                p.setQt(rs.getInt("qt"));
                p.setImg(rs.getString("img"));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return produits;
    }
    
    @Override
    public List<Produit> listeProduitsParIdCategorieTri(int id,int tri) {
        List<Produit> produits = new ArrayList();
        try {
            String req;
            switch (tri) {
                case 0:
                    req = "SELECT * FROM produit WHERE idCategorie = '"+id+"' order by libelle;";
                    break;
                case 1:
                    req = "SELECT * FROM produit WHERE idCategorie = '"+id+"' order by prix;";
                    break;
                default:
                    req = "SELECT * FROM produit WHERE idCategorie = '"+id+"' order by prix;";
                    break;
            }

            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setIdCategorie(rs.getInt("idCategorie"));
                p.setLibelle(rs.getString("libelle"));
                p.setPrix(rs.getFloat("prix"));
                p.setDescription(rs.getString("description"));
                p.setQt(rs.getInt("qt"));
                p.setImg(rs.getString("img"));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return produits;
    }
    
    @Override
    public List<Produit> listeProduitsParIdCategorieRech(int id,String str) {
        List<Produit> produits = new ArrayList();
        try {
            String req = "SELECT * FROM produit WHERE idCategorie = '"+id+"' and libelle like '"+str+"%' order by libelle;";

            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setIdCategorie(rs.getInt("idCategorie"));
                p.setLibelle(rs.getString("libelle"));
                p.setPrix(rs.getFloat("prix"));
                p.setDescription(rs.getString("description"));
                p.setQt(rs.getInt("qt"));
                p.setImg(rs.getString("img"));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return produits;
    }
    
    @Override
    public List<Produit> listeProduitsParIdCategorieRechTri(int id,String str) {
        List<Produit> produits = new ArrayList();
        try {
            String req;
            if(str.isEmpty())
                req = "SELECT * FROM produit WHERE idCategorie = '"+id+"';";
            else
                req = "SELECT * FROM produit WHERE idCategorie = '"+id+"' and (libelle like '"+str+"%' or prix like '"+str+"%' or description like '"+str+"%') order by prix;";

            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setIdCategorie(rs.getInt("idCategorie"));
                p.setLibelle(rs.getString("libelle"));
                p.setPrix(rs.getFloat("prix"));
                p.setDescription(rs.getString("description"));
                p.setQt(rs.getInt("qt"));
                p.setImg(rs.getString("img"));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return produits;
    }
    
     @Override
    public List<Produit> listeProduitsParIdCategorieTriRech(int id, int tri, String str) {
       List<Produit> produits = new ArrayList();
        try {
            String req;
            switch (tri) {
                case 0:
                    req = "SELECT * FROM produit WHERE idCategorie = '"+id+"' and libelle like '"+str+"%' order by libelle;";
                    break;
                case 1:
                    req = "SELECT * FROM produit WHERE idCategorie = '"+id+"' and libelle like '"+str+"%' order by prix;";
                    break;
                default:
                    req = "SELECT * FROM produit WHERE idCategorie = '"+id+"' and libelle like '"+str+"%' order by prix;";
                    break;
            }
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setIdCategorie(rs.getInt("idCategorie"));
                p.setLibelle(rs.getString("libelle"));
                p.setPrix(rs.getFloat("prix"));
                p.setDescription(rs.getString("description"));
                p.setQt(rs.getInt("qt"));
                p.setImg(rs.getString("img"));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return produits;
    }
    
    @Override
    public String getNextId() {
        String nextid = "";
        try {
            String req = "SHOW TABLE STATUS LIKE 'produit'";
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
