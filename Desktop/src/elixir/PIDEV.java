/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elixir;
import Entities.Produit;
import Services.ProduitService;
import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class PIDEV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Scanner myInput = new Scanner(System.in);
        int menu = 0;
        boolean arret = false;
        while(!arret){
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("1) Gestion de Categorie");
            System.out.println("2) Gestion de produits");
            System.out.println("0) Quitter");
            menu = myInput.nextInt();
            switch(menu){
                case 0:arret = true; break;
                case 1:{
                    int sousmenu = 0;
                    System.out.println("1) Gestion de Categorie");
                    System.out.println("2) Gestion de produits");
                    System.out.println("0) Quitter");
                } break;
                case 2:{} break;
                default : System.out.println("entrez un choix enter 1 et 2"); break;
            }
        }*/
        // TODO code application logic here
        Produit p = new Produit(4,2,"ttttt", 2.5f, "ttt");

    
        ProduitService ps = new ProduitService();
        if(ps.ajouterProduit(p))
        {
            
        }
        
    }
    
}
