/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.Conexion.getConnection;
//import com.mysql.cj.conf.int;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

/**
 *
 * @author dorra
 */
public class Livraison {
    private int idLivraison;
    private int idPanier;
    private int id;
    private int etat;
    private String nomClient;

    public Livraison(int idLivraison, int idPanier, int id, int etat, String nomClient) {
        this.idLivraison = idLivraison;
        this.idPanier = idPanier;
        this.id = id;
        this.etat = etat;
        this.nomClient = nomClient;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }


    
    
    public int getIdLivraison() {
        return idLivraison;
    }

    public void setIdLivraison(int idLivraison) {
        this.idLivraison = idLivraison;
    }

    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    
    

    
    public static void GetId(Connection connection, ObservableList<Integer> id){
    
        try{
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT id FROM livreur"
            );
            while(res.next()){
                id.add(
                        new Integer(res.getInt("id"))
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
/*     public static void  GetIdLivraison(Connection connection, ObservableList<Integer> idLivraison){
               try{
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT idLivraison FROM livraison"
            );
            while(res.next()){
                idLivraison.add(
                        new Integer(res.getInt("idLivraison"))
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    */
}
    
    
