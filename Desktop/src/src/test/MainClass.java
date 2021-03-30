/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Livreur;
import services.LivreurCRUD;
import tools.MyConnexion;

/**
 *
 * @author dorra
 */
public class MainClass {
     public static void main(String[] args) {
        MyConnexion mc = new MyConnexion();
        LivreurCRUD lcd = new LivreurCRUD();
        Livreur l1 = new Livreur(0, "Nom", "Prenom", 0,"image");
        lcd.addLivreurs(l1);
        
    }
}
