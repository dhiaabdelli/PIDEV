/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class Categorie {
    protected int id;
    protected String nom;
    protected List<Produit> listProduit;
    public Categorie(){
    }
    
    public Categorie(int id){
        this.id = id;
    }
    
    public Categorie(String nom){
        this.nom = nom;
    }
    
    public Categorie(int id,String nom){
        this.id = id;
        this.nom = nom;
    }
   
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public List<Produit> getListProduit(){
        return listProduit;
    }
    
    public void setListProduit(List <Produit> listProduit){
        this.listProduit = listProduit;
    }
    
    @Override
    public String toString(){
        return "Les information de Categorie sont : " + "L'id est " + this.id +" ,le nom de la Categorie est ,"+this.nom+" , list produits = \n"+listProduit;
    }
    
    public void ajouterProduit(Produit p){
        listProduit.add(p);
    }
    
    public void supprimerProduit(Produit p){
        listProduit.remove(p);
    }
}
