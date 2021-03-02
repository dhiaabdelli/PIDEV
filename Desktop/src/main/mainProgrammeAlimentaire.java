package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import Entities.programmeAlimentaire;
import Services.ProgrammeAlimentaireService;

public class mainProgrammeAlimentaire{
    
    static Connection connexion;
    static Statement state;
    final static String url = "jdbc:mysql://localhost:3306/elixir";
    final static String user = "root";
    final static String password = "";

    public static void main(String[] args) throws IOException{
        programmeAlimentaire p = new programmeAlimentaire("idProfile", 2500, 1, 2, 3, 4);
        ProgrammeAlimentaireService ps = new ProgrammeAlimentaireService();
        ps.ajouterProgrammeAlimentaire(p);  
    }
}