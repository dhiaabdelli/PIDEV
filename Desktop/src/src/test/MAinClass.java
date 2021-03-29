/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Exercice;
import services.ExerciceCRUD;
import tools.MyConnexion;

/**
 *
 * @author dell
 */
public class MAinClass {
    public static void main(String[] args) {
        MyConnexion mc = new MyConnexion();
        ExerciceCRUD ecd = new ExerciceCRUD();
        Exercice e1 = new Exercice(10, "push-up","Poitrine","image1");
        ecd.addExercice(e1);
        
    }
 
}
