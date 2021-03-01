package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import Entities.aliment;
import Services.AlimentService;

public class mainAliment{
    
    static Connection connexion;
    static Statement state;
    final static String url = "jdbc:mysql://localhost:3306/elixir";
    final static String user = "root";
    final static String password = "";

    public static void main(String[] args) throws IOException{
        aliment a = new aliment("id", "nom", 1, 2, 3, 4);
        AlimentService as = new AlimentService();
        as.ajouterAliment(a);  
    }
}