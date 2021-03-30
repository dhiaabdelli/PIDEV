/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dorra
 */
public class MyConnexion {
    public String url="jdbc:mysql://localhost:3306/elixir";
    public String login="root";
    public String pwd="";
    public Connection cn;

    public MyConnexion() {
        try {
           cn = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établir!");
        } catch (SQLException ex) {
            System.out.println("Erreur de Connexion");
            System.out.println(ex.getMessage());
        }
    }
}
