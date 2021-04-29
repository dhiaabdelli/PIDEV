/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cron;

import entities.ExerciceAssocie;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import Services.ExerciceAssocieCRUD;

/**
 *
 * @author dell
 */
public class MailingEx {

    List<ExerciceAssocie> EXassocierParJour = new ArrayList<>();
    List<Integer> Jours = new ArrayList<>();

    public void sendEmails(){
        String Exercices="";
        ExerciceAssocieCRUD eac = new ExerciceAssocieCRUD();
        Jours = eac.getJours();
        for (int jour : Jours) {
            Exercices = "";
            EXassocierParJour = eac.AfficheExAperday(jour);
            for (ExerciceAssocie exA : EXassocierParJour) {

                Exercices += "\n \t+++ " + exA.getLibelleEx() + " : "
                        + exA.getNbSeries() + " serie(s) chacune à "
                        + exA.getNbRepetitions() + " répetition(s)";
            }
            System.out.println("Exilir : Day " + jour + " --->>> Time is " + new Date());
            EmailUtil.sendEmail("agontara6@gmail.com", "Exilir : Day " + jour,
                    "Bojour Mr Ahmed Gontara,\n Aujourdui vous avez :"+Exercices);
        }
    }

}
