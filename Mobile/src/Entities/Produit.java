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
    protected String nomcategorie;
    protected String libelle;
    protected float prix;
    protected String description;
    protected int qt;
    protected String img;
    protected boolean testimg;
    protected int rating;
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
    
    public Produit(int id,int idCategorie,String libelle,float prix,String description,int qt,String img){
        this.id = id;
        this.idCategorie = idCategorie;
        this.libelle = libelle;
        this.prix = prix;
        this.description = description;
        this.qt = qt;
        this.img = img;
    }
    
    public Produit(int id,int idCategorie,String libelle,float prix,String description,int qt,String img,boolean testimg){
        this.id = id;
        this.idCategorie = idCategorie;
        this.libelle = libelle;
        this.prix = prix;
        this.description = description;
        this.qt = qt;
        this.img = img;
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
    
    public String getNomcategorie(){
        return this.nomcategorie;
    }
    
    public void setnomCategorie(String nomcategorie){
        this.nomcategorie = nomcategorie;
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
    
    public int getQt(){
        return this.qt;
    }
    
    public void setQt(int qt){
        this.qt = qt;
    }
    
    public String getImg(){
        return this.img;
    }
    
    public void setImg(String img){
        this.img = img;
    }
    
    public boolean getTestimg(){
        return this.testimg;
    }
    
    public int getRating(){
        return this.rating;
    }
    
    public void setRating(int rating){
        this.rating = rating;
    }
    
   /* @Override
    public String toString(){
        return "\nId: " + this.id +"\nId Categorie: "+this.idCategorie+"\nLibelle: " + this.libelle+ "\nPrix: "+this.prix+"\ndescription:"+this.description+"\n";
    }
    */
    @Override
    public String toString(){
        return String.valueOf(this.id);
    }
}
