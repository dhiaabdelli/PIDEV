/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xemacscode.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

/**
 *
 * @author dorra
 */
public class Livreur {
    private int id;
    private String Nom;
    private String Prenom;
    private int Num;

    public Livreur(int id, String Nom, String Prenom, int Num) {
        this.id = id;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Num = Num;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public int getNum() {
        return Num;
    }
    
               public static void GetIds (Connection conn,ObservableList<Integer> id){
               try {
               Statement statement = conn.createStatement();
                   ResultSet res = statement.executeQuery(
                           "Select id FROM livreur"
                   );
                   while (res.next()){
                       id.add(
                               new Integer(
                                       res.getInt("id")
                               )
                       );
                   }
               }catch(SQLException e){
                   e.printStackTrace();
               }
                 
    }
    
}
