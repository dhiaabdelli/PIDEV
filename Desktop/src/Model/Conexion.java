/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.collections.ObservableList;

/**
 *
 * @author dorra
 */
public class Conexion {
        public static Connection getConnection(){
       Connection connection ;
     try {
         connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/elixir","root", "");
         return connection;
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    public static ObservableList<Livraison> getLivraisonList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Object createStatement(int TYPE_SCROLL_INSENSITIVE, int CONCUR_READ_ONLY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
