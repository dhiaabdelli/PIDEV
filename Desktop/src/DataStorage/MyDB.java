package DataStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDB{

    Connection connexion;
    final String url = "jdbc:mysql://localhost:3306/elixirDB?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8";
    final String user = "root";
    final String password = "";
    private static MyDB instance = null;

    private MyDB(){
        try{
            connexion = DriverManager.getConnection(url, user, password);
            System.out.println("*****************************\nConnexion Etablie");
        }catch(SQLException ex){
            Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\nEchec de Connexion");
        }
    }

    public static MyDB getinstance(){
        if (instance == null){
            instance = new MyDB();
        }
        return instance;
    }

    public Connection getConnexion(){
        return connexion;
    }
}