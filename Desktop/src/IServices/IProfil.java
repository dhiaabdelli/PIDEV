/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import entities.Profil;
import entities.Compte;
import java.util.List;




/**
 *
 * @author mrabe
 */
public interface IProfil {
     public boolean ajouterProfil(Profil p);
    public boolean supprimerProfil(int id);
    public boolean modifierProfil(Profil p);
    public List<Profil> listeProfil();
    public List<Profil> listeProfilParEmail(String email);
}
