/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import entities.Compte;


/**
 *
 * @author mrabe
 */
public interface ICompte {
   public boolean ajouterCompte(Compte c);
   public boolean supprimerCompte(int email);
   public boolean modifierCompte(Compte c);
   public Compte chercherCompte(String email);
    
}
