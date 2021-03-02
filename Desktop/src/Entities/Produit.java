/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author ASUS
 */
public class Produit {
    protected int id;
    protected int idCategorie;
    protected String libelle;
    protected float prix;
    protected String description;
    
    public Produit(){
    }
    
    public Produit(int id,int idCategorie){
        this.id = id;
        this.idCategorie = idCategorie;
    }
    
    public Produit(String libelle,float prix,String description){
        this.libelle = libelle;
        this.prix = prix;
        this.description = description;
    }
    
    public Produit(int id,int idCategorie,String libelle,float prix,String description){
        this.id = id;
        this.idCategorie = idCategorie;
        this.libelle = libelle;
        this.prix = prix;
        this.description = description;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getIdCategorie(){
        return this.idCategorie;
    }
    
    public void setIdCategorie(int idCategorie){
        this.idCategorie = idCategorie;
    }
    
    public String getLibelle(){
        return this.libelle;
    }
    
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    
    public float getPrix(){
        return this.prix;
    }
    
    public void setPrix(float prix){
        this.prix = prix;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    
    @Override
    public String toString(){
        return "Les information du produit sont : " + "L'id est " + this.id +" ,l'id de la Categorie est ,"+this.idCategorie+" ,libelle est " + this.libelle+ " , le prix est "+this.prix+" , la description est "+this.description+"\n";
    }
}
