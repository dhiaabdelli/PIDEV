/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javafx.collections.ObservableList;

/**
 *idLivraison	reference	dateLivraison	nomLivreur	etat	nomClient
 * @author dorra
 */
public class Livraison {
  private  int  idLivraison;
  private  int  reference;
  private String  dateLivraison;
  private String  nomLivreur;
  private String  etat;
  private String  nomClient;

    public Livraison() {
    }

    public Livraison(int idLivraison, int reference, String dateLivraison, String nomLivreur, String etat, String nomClient) {
        this.idLivraison = idLivraison;
        this.reference = reference;
        this.dateLivraison = dateLivraison;
        this.nomLivreur = nomLivreur;
        this.etat = etat;
        this.nomClient = nomClient;
    }


  
    public int getIdLivraison() {
        return idLivraison;
    }

    public void setIdLivraison(int idLivraison) {
        this.idLivraison = idLivraison;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getNomLivreur() {
        return nomLivreur;
    }

    public void setNomLivreur(String nomLivreur) {
        this.nomLivreur = nomLivreur;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

  
                         
}
