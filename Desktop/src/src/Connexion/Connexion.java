/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import tools.MyConnexion;

/**
 *
 * @author dorra
 */
public class Connexion {

    public static Connection conn;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        MyConnexion conn = new MyConnexion();
    }
}