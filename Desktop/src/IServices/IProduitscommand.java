/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Produitscommand;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IProduitscommand {
    public boolean ajouterProduitscommand(Produitscommand p);
    public boolean supprimerProduitscommand(int id);
    public boolean modifierProduitscommand(Produitscommand p);
    public List<Produitscommand> listeProduitscommand();
    public String getNextId();
}
