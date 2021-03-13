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
public class Evaluation {
    protected int id;
    protected int id_produit;
    protected int id_user;
    protected String nomProduit;
    protected int note;
    
    public Evaluation(){
    }
    
    public Evaluation(int id,int id_produit,int id_user,int note){
        this.id = id;
        this.id_produit = id_produit;
        this.id_user = id_user;
        this.note = note;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId_Produit(){
        return this.id_produit;
    }
    
    public void setId_Produit(int id_produit){
        this.id_produit = id_produit;
    }
    
    public int getId_User(){
        return this.id_user;
    }
    
    public void setId_User(int id_user){
        this.id_user = id_user;
    }
    
    public int getNote(){
        return this.note;
    }
    
    public void setNote(int note){
        this.note = note;
    }
    
    public String getNomProduit(){
        return this.nomProduit;
    }
    
    public void setNomProduit(String nomProduit){
        this.nomProduit = nomProduit;
    }
    
    @Override
    public String toString(){
        return "\nEvaluation : " + "id=" + this.id +" ,id_produit = "+this.id_produit+" ,id_user= " + this.id_user+ " , note "+this.note;
    }
}
