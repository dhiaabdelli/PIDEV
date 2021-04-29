/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.itextpdf.text.Paragraph;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;
import java.util.Map;

/**
 *
 * @author dorra
 */
public class Livreur {
    private int id;
    private String Nom;
    private String Prenom;
    private int Num;
    private String image;

    public Livreur() {
    }

    
    public Livreur(int id, String Nom, String Prenom, int Num, String image) {
        this.id = id;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Num = Num;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setNum(int Num) {
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
     @Override
    public String toString() {
        return "Livreur{" + "id=" + id + ", nom=" + Nom + ", prenom=" + Prenom + ", num=" + Num + '}';
    }

    
}
