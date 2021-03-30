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
public class Compte {
    
    private String email;
    private String mdp;
    private String nom;
    private String prenom;
    


public Compte() {
    }

public Compte(String email, String mdp, String nom, String prenom) {
        this.email = email;
        this.mdp = mdp;
        this.nom= nom;
        this.prenom = prenom;
    }

 public String getEmail() {
        return email;
    }

public void setEmail(String email) {
        this.email = email;
    }    

public String getMdp() {
        return mdp;
    }

public void setMdp(String mdp) {
        this.mdp = mdp;
    }    
public String getNom() {
        return nom;
    }

public void setNom(String nom) {
        this.nom = nom;
    }   
    
public String getPrenom() {
        return prenom;
    }

public void setPrenom(String prenom) {
        this.prenom = prenom;
    }    

   
    @Override
    public String toString() {
        return email;
    }
}