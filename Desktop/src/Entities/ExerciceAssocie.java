/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author dell
 */
public class ExerciceAssocie {
    private int id;
    private int idProfile;
    //private int idExercice;
    private String libelleEx;
    private int nbSeries;
    private int nbRepetitions;
    private int jour;

    public ExerciceAssocie() {
    }

    
    
    public ExerciceAssocie(int id, int idProfile/*, int idExercice,*/, String libelleEx, int nbSeries, int nbRepetitions, int jour) {
        this.id = id;
        this.idProfile = idProfile;
        //this.idExercice = idExercice;
        this.libelleEx = libelleEx;
        this.nbSeries = nbSeries;
        this.nbRepetitions = nbRepetitions;
        this.jour = jour;
    }


    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

//    public int getIdExercice() {
//        return idExercice;
//    }
//
//    public void setIdExercice(int idExercice) {
//        this.idExercice = idExercice;
//    }

    public int getNbSeries() {
        return nbSeries;
    }

    public void setNbSeries(int nbSeries) {
        this.nbSeries = nbSeries;
    }

    public int getNbRepetitions() {
        return nbRepetitions;
    }

    public void setNbRepetitions(int nbRepetitions) {
        this.nbRepetitions = nbRepetitions;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelleEx() {
        return libelleEx;
    }

    public void setLibelleEx(String libelleEx) {
        this.libelleEx = libelleEx;
    }
    
    

    @Override
    public String toString() {
        return "ExerciceAssocie{" + "idProfile=" + idProfile + ", nbSeries=" + nbSeries + ", nbRepetitions=" + nbRepetitions + ", jour=" + jour + '}';
    }
    
    
}
