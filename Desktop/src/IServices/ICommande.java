/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Commande;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ICommande {
    public boolean ajouterCommande(Commande c);
    public boolean supprimerCommande(int id);
    public boolean annulerCommande(Commande c);
    public boolean modifierCommande(Commande c);
    public List<Commande> listeCommande();
    public List<Commande> listeCommandeRech(String str);
    public String getNextId();
}
