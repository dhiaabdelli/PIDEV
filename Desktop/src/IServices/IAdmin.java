/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import entities.Admin;

/**
 *
 * @author mrabe
 */
public interface IAdmin {
   public boolean ajouterAdmin(Admin a);
   public boolean supprimerAdmin(int user);
   public boolean modifierAdmin(Admin a);
}
