/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author mrabe
 */
public class Profil {
    private int id;
    private String emailCompte;
    private int sexe;
    private int age;
    private float poids;
    private float taille;
    private int objectif;
    private int nbRepas;
    
    public Profil(){
    }
    
    public Profil(int id,String emailCompte, int sexe, int age, float poids, float taille, int objectif, float bodyfat, int activitePhys, int nbRepas, int nbJrEntrainement){
        this.id = id;
        this.emailCompte = emailCompte;
        this.sexe = sexe;
        this.age = age;
        this.poids = poids;
        this.taille = taille;
        this.objectif = objectif;
        this.nbRepas = nbRepas;
        
    }
    
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getEmailCompte(){
        return this.emailCompte;
    }
    
    public void setEmailCompte(String emailCompte){
        this.emailCompte = emailCompte;
    }
    
    public int getSexe(){
        return this.sexe;
    }
    
    public void setSexe(int sexe){
        this.sexe = sexe;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public float getPoids(){
        return this.poids;
    }
    
    public void setPoids(float poids){
        this.poids = poids;
    }
    
     public float getTaille(){
        return this.taille;
    }
    
    public void setTaille(float taille){
        this.taille = taille;
    }
     public int getObjectif(){
        return this.objectif;
    }
    
    public void setObjectif(int objectif){
        this.objectif = objectif;
    }

     public int getNbRepas(){
        return this.nbRepas;
    }
    
    public void setNbRepas(int nbRepas){
        this.nbRepas = nbRepas;
    }

   @Override
    public String toString() {
     return "\nId: " + this.id +"\nEmail Compte: "+this.emailCompte+"\nSexe: " + this.sexe+ "\nAge: "+this.age+"\nPoids:"+this.poids+"\nTaille: "+this.taille+"\nObjectif: "+this.objectif+"\nNombre repas: "+this.nbRepas+"\n";  
    }
    
}
