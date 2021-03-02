package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import Entities.alimentAssocie;
import Services.AlimentAssocieService;

public class mainAlimentAssocie{
    
    static Connection connexion;
    static Statement state;
    final static String url = "jdbc:mysql://localhost:3306/elixir";
    final static String user = "root";
    final static String password = "";

    public static void main(String[] args) throws IOException{
        alimentAssocie a = new alimentAssocie("idAliment", "idProfile", 1, 1);
        AlimentAssocieService as = new AlimentAssocieService();
        as.ajouterAlimentAssocie(a);  
    }
}