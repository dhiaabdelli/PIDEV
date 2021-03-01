/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Categorie;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ICategorie {
   public boolean ajouterCategorie(Categorie c);
   public boolean supprimerCategorie(int id);
   public boolean modifierCategorie(Categorie c);
   public Categorie chercherCategorieParID(int id);
   public List<Categorie> listeCategorie();
   public String getNextId();

}
