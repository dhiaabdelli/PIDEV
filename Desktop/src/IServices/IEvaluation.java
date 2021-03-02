/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Evaluation;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IEvaluation {
    public boolean ajouterEvaluation(Evaluation e);
    public boolean supprimerEvaluation(int id);
    public boolean modifierEvaluation(Evaluation e);
    public Evaluation chercherEvaluationParID(int id);
    public Evaluation chercherEvaluationParIDUser(int id_user);
    public Evaluation chercherEvaluationParIDProduit(int id_produit);
    public List<Evaluation> listeEvaluation();
    public List<Evaluation> listeEvaluationParIdProduit(int id_produit);
    public List<Evaluation> listeEvaluationParIdUser(int id_user);
    public String getNextId();
}
