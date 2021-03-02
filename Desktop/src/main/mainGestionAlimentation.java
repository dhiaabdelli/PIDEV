package main;
import Entities.*;
import Services.*;
import java.util.List;
import java.util.Scanner;

public class mainGestionAlimentation{

    public static void main(String[] args){
        
        Scanner myInput = new Scanner(System.in);
        Scanner myInputStr = new Scanner(System.in);
        int menu = 0;
        boolean arret = false;
        while(!arret){ 
            System.out.flush();  
            System.out.println("[1] Gestion : Aliments");
            System.out.println("[2] Gestion : Aliment Associe");
            System.out.println("[3] Gestion : Programme Alimentaire");
            System.out.println("\n[0] Quitter");
            menu = myInput.nextInt();
            switch(menu){
                case 0:{ 
                    arret = true; 
                    break;
                }
                case 1:{
                    int sousmenu = 0;
                    boolean arretsous = false;
                    AlimentService as = new AlimentService();
                    while(!arretsous){
                        System.out.println("[1] Ajouter Aliment");
                        System.out.println("[2] Supprimer Aliment");
                        System.out.println("[3] Modifier Aliment");
                        System.out.println("[4] Chercher Aliment");
                        System.out.println("[5] Afficher liste des Aliments");
                        System.out.println("[6] Afficher liste des Aliments Tries");     
                        System.out.println("\n[0] Retour Menu Principal");
                        sousmenu = myInput.nextInt();
                        switch(sousmenu){
                            case 0:{
                                arretsous = true;
                                break;
                            }   
                            case 1:{
                                System.out.print("Id : ");
                                String id = myInputStr.nextLine();
                                System.out.print("Nom : ");
                                String nom = myInputStr.nextLine();
                                System.out.print("Fats : ");
                                int fats = myInput.nextInt();
                                System.out.print("Carbs : ");
                                int carbs = myInput.nextInt();
                                System.out.print("Proteins : ");
                                int proteins = myInput.nextInt();
                                System.out.print("Calories : ");
                                int calories = myInput.nextInt();
                                aliment a = new aliment(id, nom, fats, carbs, proteins, calories);
                                as.ajouterAliment(a);
                            } break;
                            case 2:{
                                System.out.print("Id a supprimer : ");
                                String id = myInputStr.nextLine();
                                as.supprimerAliment(id);
                            } break;
                            case 3:{
                                System.out.print("Id a modifier : ");
                                String id = myInputStr.nextLine();
                                System.out.print("Nom : ");
                                String nom = myInputStr.nextLine();
                                System.out.print("Fats : ");
                                int fats = myInput.nextInt();
                                System.out.print("Carbs : ");
                                int carbs = myInput.nextInt();
                                System.out.print("Proteins : ");
                                int proteins = myInput.nextInt();
                                System.out.print("Calories : ");
                                int calories = myInput.nextInt();
                                aliment a = new aliment(id, nom, fats, carbs, proteins, calories);
                                as.modifierAliment(a);
                            } break;
                            case 4:{
                                System.out.print("Id Aliment a Chercher : ");
                                String id = myInputStr.nextLine();
                                aliment a = as.chercherAlimentParId(id);
                                if(a == null){
                                    System.out.println("Aliment Introuvable");
                                }else{
                                    System.out.println(a);
                                }
                            } break;
                            case 5:{
                                List<aliment> listeAliments;
                                listeAliments = as.listerAliments();
                                if(listeAliments == null){
                                    System.out.println("Aucun Aliment Trouve");
                                }else{
                                    System.out.println(listeAliments);
                                }
                            } break;
                            case 6:{
                                List<aliment> listeAliments;
                                listeAliments = as.listerAlimentsTriParCalorie();
                                if(listeAliments == null){
                                    System.out.println("Aucun Aliment Trouve");
                                }else{
                                    System.out.println(listeAliments);
                                }
                            } break;
                            default : 
                                System.out.println("Entrer un choix entre [0] et [6]"); 
                                break;
                        }
                    }
                } break;
                case 2:{
                    int sousmenu = 0;
                    boolean arretsous = false;
                    AlimentAssocieService as = new AlimentAssocieService();
                    while(!arretsous){
                        System.out.println("[1] Ajouter Aliment Associe");
                        System.out.println("[2] Supprimer Aliment Associe");
                        System.out.println("[3] Modifier Aliment Associe");
                        System.out.println("[4] Chercher Aliment Associe");
                        System.out.println("[5] Afficher liste des Aliments Associes");
                        System.out.println("\n[0] Retour Menu Principal");
                        sousmenu = myInput.nextInt();
                        switch(sousmenu){
                            case 0:{
                                arretsous = true;
                                break;
                            }   
                            case 1:{
                                System.out.print("IdAliment : ");
                                String idAliment = myInputStr.nextLine();
                                System.out.print("IdProfile : ");
                                String idProfile = myInputStr.nextLine();
                                System.out.print("Qte : ");
                                int qte = myInput.nextInt();
                                System.out.print("Num : ");
                                int num = myInput.nextInt();
                                alimentAssocie a = new alimentAssocie(idAliment, idProfile, qte, num);
                                as.ajouterAlimentAssocie(a);
                            } break;
                            case 2:{
                                System.out.print("IdAliment a supprimer : ");
                                String idAliment = myInputStr.nextLine();
                                System.out.print("IdProfile a supprimer : ");
                                String idProfile = myInputStr.nextLine();
                                as.supprimerAlimentAssocie(idAliment, idProfile);
                            } break;
                            case 3:{
                                System.out.print("IdAliment a modifer : ");
                                String idAliment = myInputStr.nextLine();
                                System.out.print("IdProfile a modifier : ");
                                String idProfile = myInputStr.nextLine();
                                System.out.print("Qte : ");
                                int qte = myInput.nextInt();
                                System.out.print("Num : ");
                                int num = myInput.nextInt();
                                alimentAssocie a = new alimentAssocie(idAliment, idProfile, qte, num);
                                as.modifierAlimentAssocie(a);
                            } break;
                            case 4:{
                                System.out.print("IdAliment a Chercher : ");
                                String idAliment = myInputStr.nextLine();
                                System.out.print("IdProfile a Chercher : ");
                                String idProfile = myInputStr.nextLine();
                                alimentAssocie a = as.chercherAlimentAssocieParId(idAliment, idProfile);
                                if(a == null){
                                    System.out.println("Aliment Associe Introuvable");
                                }else{
                                    System.out.println(a);
                                }
                            } break;
                            case 5:{
                                List<alimentAssocie> listeAlimentsAssocies;
                                listeAlimentsAssocies = as.listerAlimentsAssocies();
                                if(listeAlimentsAssocies == null){
                                    System.out.println("Aucun Aliment Associe Trouve");
                                }else{
                                    System.out.println(listeAlimentsAssocies);
                                }
                            } break;
                            default : 
                                System.out.println("Entrer un choix entre [0] et [5]"); 
                                break;
                        }
                    }
                } break;
                case 3:{
                    int sousmenu = 0;
                    boolean arretsous = false;
                    ProgrammeAlimentaireService ps = new ProgrammeAlimentaireService();
                    while(!arretsous){
                        System.out.println("[1] Ajouter Programme Alimentaire");
                        System.out.println("[2] Supprimer Programme Alimentaire");
                        System.out.println("[3] Modifier Programme Alimentaire");
                        System.out.println("[4] Chercher Programme Alimentaire");
                        System.out.println("[5] Afficher liste des Programmes Alimentaires");
                        System.out.println("[6] Calculer Programme Alimentaire");
                        System.out.println("\n[0] Retour Menu Principal");
                        sousmenu = myInput.nextInt();
                        switch(sousmenu){
                            case 0:{
                                arretsous = true;
                                break;
                            }   
                            case 1:{
                                System.out.print("IdProfile : ");
                                String idProfile = myInputStr.nextLine();
                                System.out.print("BMR : ");
                                int bmr = myInput.nextInt();
                                System.out.print("CalRequis : ");
                                int calRequis = myInput.nextInt();
                                System.out.print("FatsRequis : ");
                                int fatsRequis = myInput.nextInt();
                                System.out.print("CarbsRequis : ");
                                int carbsRequis = myInput.nextInt();
                                System.out.print("ProteinsRequis : ");
                                int proteinsRequis = myInput.nextInt();
                                programmeAlimentaire p = new programmeAlimentaire(idProfile, bmr, calRequis, fatsRequis, carbsRequis, proteinsRequis);
                                ps.ajouterProgrammeAlimentaire(p);
                            } break;
                            case 2:{
                                System.out.print("IdProfile a supprimer : ");
                                String idProfile = myInputStr.nextLine();
                                ps.supprimerProgrammeAlimentaire(idProfile);
                            } break;
                            case 3:{
                                System.out.print("IdProfile a modifier : ");
                                String idProfile = myInputStr.nextLine();
                                System.out.print("BMR : ");
                                int bmr = myInput.nextInt();
                                System.out.print("CalRequis : ");
                                int calRequis = myInput.nextInt();
                                System.out.print("FatsRequis : ");
                                int fatsRequis = myInput.nextInt();
                                System.out.print("CarbsRequis : ");
                                int carbsRequis = myInput.nextInt();
                                System.out.print("ProteinsRequis : ");
                                int proteinsRequis = myInput.nextInt();
                                programmeAlimentaire p = new programmeAlimentaire(idProfile, bmr, calRequis, fatsRequis, carbsRequis, proteinsRequis);
                                ps.modifierProgrammeAlimentaire(p);
                            } break;
                            case 4:{
                                System.out.print("IdProfile a Chercher : ");
                                String idProfile = myInputStr.nextLine();
                                programmeAlimentaire p = ps.chercherProgrammeAlimentaireParId(idProfile);
                                if(p == null){
                                    System.out.println("Programme Alimentaire Introuvable");
                                }else{
                                    System.out.println(p);
                                }
                            } break;
                            case 5:{
                                List<programmeAlimentaire> listeProgrammesAlimentaires;
                                listeProgrammesAlimentaires = ps.listerProgrammesAlimentaires();
                                if(listeProgrammesAlimentaires == null){
                                    System.out.println("Aucun Programme Alimentaire Trouve");
                                }else{
                                    System.out.println(listeProgrammesAlimentaires);
                                }
                            } break;
                            case 6:{
                                System.out.print("EMail Compte Actuel : ");
                                String email = myInputStr.nextLine();
                                System.out.print("IdProfile : ");
                                String idProfile = myInputStr.nextLine();
                                ps.calculerProgrammeAlimentaire(email, idProfile);
                            } break;
                            default : 
                                System.out.println("Entrer un choix entre [0] et [6]"); 
                                break;
                        }
                    }
                } break;
                default : 
                    System.out.println("Entrer un choix entre [0] et [3]"); 
                    break;
            }
        } 
    } 
}
