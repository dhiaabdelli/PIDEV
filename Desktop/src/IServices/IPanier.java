/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Panier;
import java.util.List;

public interface IPanier {
    public boolean ajouterPanier(Panier p);
    public boolean supprimerPanier(int id,String email);
    public boolean modifierProduit(Panier p);
    public boolean modifierProduitBack(Panier p);
    public Panier chercherPanierParIDEmail(int id,int email);
    public List<Panier> listePanier();
    public List<Panier> listePanierRech(String str);
    public List<Panier> listePanierTrie(int tri);
    public List<Panier> listePanierTrieRech(int tri,String str);
    public String getNextId();
}
