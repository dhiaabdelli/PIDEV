/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import Entities.*;
import Services.*;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author ASUS
 */
public class mainProduit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner myInput = new Scanner(System.in);
        Scanner myInputStr = new Scanner(System.in);
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
                    boolean arretsous = false;
                    CategorieService cs = new CategorieService();
                    while(!arretsous){
                        System.out.println("1) Ajouter Categorie");
                        System.out.println("2) Supprimer Categorie");
                        System.out.println("3) Modifier Categorie");
                        System.out.println("4) Chercher Categorie");
                        System.out.println("5) Afficher les Categories");
                        System.out.println("0) Meuu principale");
                        sousmenu = myInput.nextInt();
                        switch(sousmenu){
                            case 0:arretsous = true; break;
                            case 1:{
                                System.out.print("Entrer un nom: ");
                                String nom = myInputStr.nextLine();
                                Categorie c = new Categorie(Integer.parseInt(cs.getNextId()),nom);

                                if(cs.ajouterCategorie(c)){}

                            } break;
                            case 2:{
                                System.out.print("Entrer l'id de Categorie: ");
                                int id = myInput.nextInt();
                                if(cs.supprimerCategorie(id)){}


                            } break;
                            case 3:{
                                System.out.print("Entrer l'id de Categorie: ");
                                int id = myInput.nextInt();
                                System.out.print("Entrer un nouveau nom: ");
                                String nom = myInputStr.nextLine();
                                Categorie c = new Categorie(id,nom);
                                if(cs.modifierCategorie(c)){}
                            } break;
                            case 4:{
                                System.out.print("Entrer l'id de Categorie a trouver: ");
                                int id = myInput.nextInt();
                                Categorie c = cs.chercherCategorieParID(id);
                                if(c == null){
                                    System.out.println("Categorie untrouvable");
                                }else{
                                    System.out.println(c);
                                }
                            } break;
                            case 5:{
                                List<Categorie> listCategorie;
                                listCategorie = cs.listeCategorie();
                                if(listCategorie == null){
                                    System.out.println("Aucune Categorie trouve");
                                }else{
                                    System.out.println(listCategorie);
                                }
                            } break;
                            default : System.out.println("entrez un choix enter 1 et 5"); break;
                        }
                    }
                } break;
                case 2:{
                    int sousmenu = 0;
                    boolean arretsous = false;
                    ProduitService ps = new ProduitService();
                    while(!arretsous){
                        System.out.println("1) Ajouter Produit");
                        System.out.println("2) Supprimer Produit");
                        System.out.println("3) Modifier Produit");
                        System.out.println("4) Chercher Produit");
                        System.out.println("5) Afficher les Produit de Categorie");
                        System.out.println("0) Meuu principale");
                        sousmenu = myInput.nextInt();
                        switch(sousmenu){
                            case 0:arretsous = true; break;
                            case 1:{
                                
                                System.out.print("Entrer un idCategorie: ");
                                int idCategorie = myInput.nextInt();
                                System.out.print("Entrer un libelle: ");
                                String libelle = myInputStr.nextLine();
                                System.out.print("Entrer un prix: ");
                                float prix = myInput.nextFloat();
                                System.out.print("Entrer un description: ");
                                String description = myInputStr.nextLine();
                                Produit p = new Produit(Integer.parseInt(ps.getNextId()),idCategorie,libelle,prix,description);

                                if(ps.ajouterProduit(p)){}

                            } break;
                            case 2:{
                                System.out.print("Entrer l'id de produit: ");
                                int id = myInput.nextInt();
                                if(ps.supprimerProduit(id)){}

                            } break;
                            case 3:{
                                System.out.print("Entrer l'id du produit: ");
                                int id = myInput.nextInt();
                                System.out.print("Entrer un nouveau idCategorie: ");
                                int idCategorie = myInput.nextInt();
                                System.out.print("Entrer un nouveau libelle: ");
                                String libelle = myInputStr.nextLine();
                                System.out.print("Entrer un nouveau prix: ");
                                float prix = myInput.nextFloat();
                                System.out.print("Entrer une nouvelle description: ");
                                String description = myInputStr.nextLine();
                                Produit p = new Produit(id,idCategorie,libelle,prix,description);
                                if(ps.modifierProduit(p)){}
                            } break;
                            case 4:{
                                System.out.print("Entrer l'id du produit a trouver: ");
                                int id = myInput.nextInt();
                                Produit p = ps.chercherProduitParID(id);
                                if(p == null){
                                    System.out.println("Produit untrouvable");
                                }else{
                                    System.out.println(p);
                                }
                            } break;
                            case 5:{
                                List<Produit> listProduit;
                                System.out.print("Entrer idCategorie: ");
                                int idCategorie = myInput.nextInt();
                                listProduit = ps.listeProduitsParIdCategorie(idCategorie);
                                if(listProduit == null){
                                    System.out.println("Aucune Produit trouve");
                                }else{
                                    System.out.println(listProduit);
                                }
                            } break;
                            default : System.out.println("entrez un choix enter 1 et 5"); break;
                        }
                    }
                } break;
                default : System.out.println("entrez un choix enter 1 et 2"); break;
            }
        }
        
        /*Produit p = new Produit(4,5,"ttttt", 2.5f, "ttt");

       
       
        
        ProduitService ps = new ProduitService();
        if(ps.ajouterProduit(p))
        {
            
        }
        listCategorie = cs.listeCategorie();
        System.out.println(listCategorie);
        */
    }
    
}
