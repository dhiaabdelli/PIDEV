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
public class Categorie {
    protected int id;
    protected String nom;
    
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
    
    
    @Override
    public String toString(){
        return "Les information de Categorie sont : " + "L'id est " + this.id +" ,le nom de la Categorie est ,"+this.nom;
    }
}
