package Presentation.controllers.models;

import entities.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class QuizController implements Initializable {

    final Profil p = new Profil();
    boolean ageTypedValue = false;
    boolean poidsTypedValue = false;
    boolean tailleTypedValue = false;
    
    @FXML
    private Button sexeSuivant;
    @FXML
    private StackPane paneSexe;
    @FXML
    private TextField age;
    @FXML
    private TextField poids;
    @FXML
    private TextField taille;
    @FXML
    private Button aptSuivant;
    @FXML
    private Pane obj0box;
    @FXML
    private Pane obj1box;
    @FXML
    private StackPane paneApt;
    @FXML
    private StackPane paneObj;
    @FXML
    private Button objSuivant;
    @FXML
    private Pane maleBox;
    @FXML
    private Pane femaleBox;
    @FXML
    private StackPane paneNbR;
    @FXML
    private Pane r1;
    @FXML
    private Pane r2;
    @FXML
    private Pane r3;
    @FXML
    private Pane r4;
    @FXML
    private Pane r5;
    @FXML
    private StackPane r1k;
    @FXML
    private StackPane r1n;
    @FXML
    private StackPane r2k;
    @FXML
    private StackPane r2n;
    @FXML
    private StackPane r3k;
    @FXML
    private StackPane r3n;
    @FXML
    private StackPane r4k;
    @FXML
    private StackPane r4n;
    @FXML
    private StackPane r5k;
    @FXML
    private StackPane r5n;
    @FXML
    private Button nbrSuivant;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        maleBox.getStyleClass().clear();
        maleBox.getStyleClass().add("objBox");
        femaleBox.getStyleClass().clear();
        femaleBox.getStyleClass().add("objBox");
        obj0box.getStyleClass().clear();
        obj0box.getStyleClass().add("objBox");
        obj1box.getStyleClass().clear();
        obj1box.getStyleClass().add("objBox"); 
        r1.getStyleClass().clear();
        r2.getStyleClass().clear();
        r3.getStyleClass().clear();
        r4.getStyleClass().clear();
        r5.getStyleClass().clear();
        r1n.getStyleClass().clear();
        r2n.getStyleClass().clear();
        r3n.getStyleClass().clear();
        r4n.getStyleClass().clear();
        r5n.getStyleClass().clear();
        r1k.getStyleClass().clear();
        r2k.getStyleClass().clear();
        r3k.getStyleClass().clear();
        r4k.getStyleClass().clear();
        r5k.getStyleClass().clear();      
        r1.getStyleClass().add("nbrboxDisabled");
        r2.getStyleClass().add("nbrboxDisabled");
        r3.getStyleClass().add("nbrboxDisabled");
        r4.getStyleClass().add("nbrboxDisabled");
        r5.getStyleClass().add("nbrboxDisabled");
        r1n.getStyleClass().add("numberBoxDisabled");
        r2n.getStyleClass().add("numberBoxDisabled");
        r3n.getStyleClass().add("numberBoxDisabled");
        r4n.getStyleClass().add("numberBoxDisabled");
        r5n.getStyleClass().add("numberBoxDisabled");
        r1k.getStyleClass().add("numberBoxDisabled");
        r2k.getStyleClass().add("numberBoxDisabled");
        r3k.getStyleClass().add("numberBoxDisabled");
        r4k.getStyleClass().add("numberBoxDisabled");
        r5k.getStyleClass().add("numberBoxDisabled");
    }    

    @FXML
    private void maleSelected(MouseEvent event){
        sexeSuivant.setDisable(false);
        maleBox.getStyleClass().clear();
        maleBox.getStyleClass().add("boxSelected");
        femaleBox.getStyleClass().clear();
        femaleBox.getStyleClass().add("objBox");
        p.setSexe(0);
    }

    @FXML
    private void femaleSelected(MouseEvent event){
        sexeSuivant.setDisable(false);
        femaleBox.getStyleClass().clear();
        femaleBox.getStyleClass().add("boxSelected");
        maleBox.getStyleClass().clear();
        maleBox.getStyleClass().add("objBox");
        p.setSexe(1);
    }

    @FXML
    private void pressedSexeSuivant(MouseEvent event){
        paneSexe.setVisible(false);
        paneApt.setVisible(true);   
    }

    @FXML
    private void pressedAptSuivant(MouseEvent event) {
        paneApt.setVisible(false); 
        paneObj.setVisible(true);
        p.setAge(Integer.parseInt(age.getText()));
        p.setPoids(Integer.parseInt(poids.getText()));
        p.setTaille(Integer.parseInt(taille.getText()));
    }

    @FXML
    private void ageTyped(KeyEvent event) {
        ageTypedValue = true;
        if(age.getText().isEmpty() || Integer.parseInt(age.getText()) == 0){
            ageTypedValue = false;
        }
        if(poidsTypedValue && tailleTypedValue && ageTypedValue){
            aptSuivant.setDisable(false);
        }else{
            aptSuivant.setDisable(true);
        }
    }

    @FXML
    private void poidsTyped(KeyEvent event) {
        poidsTypedValue = true;
        if(poids.getText().isEmpty() || Integer.parseInt(poids.getText()) == 0){
            poidsTypedValue = false;
        }
        if(tailleTypedValue && ageTypedValue && poidsTypedValue){
            aptSuivant.setDisable(false);
        }else{
            aptSuivant.setDisable(true);
        }
    }

    @FXML
    private void tailleTyped(KeyEvent event) {
        tailleTypedValue = true;
        if(taille.getText().isEmpty() || Integer.parseInt(taille.getText()) == 0){
            tailleTypedValue = false;
        }
        if(poidsTypedValue && ageTypedValue && tailleTypedValue){
            aptSuivant.setDisable(false);
        }else{
            aptSuivant.setDisable(true);
        }
    }

    @FXML
    private void pressedObj0(MouseEvent event){
        objSuivant.setDisable(false);
        obj0box.getStyleClass().clear();
        obj0box.getStyleClass().add("boxSelected");
        obj1box.getStyleClass().clear();
        obj1box.getStyleClass().add("objBox");
        p.setObjectif(0);
    }

    @FXML
    private void pressedObj1(MouseEvent event){
        objSuivant.setDisable(false);
        obj0box.getStyleClass().clear();
        obj0box.getStyleClass().add("objBox");
        obj1box.getStyleClass().clear();
        obj1box.getStyleClass().add("boxSelected");
        p.setObjectif(1);
    }
    
    @FXML
    private void pressedObjSuivant(MouseEvent event){ 
        paneObj.setVisible(false);
        paneNbR.setVisible(true);
    }

    @FXML
    private void r1pressed(MouseEvent event){
        r1.getStyleClass().clear();
        r2.getStyleClass().clear();
        r3.getStyleClass().clear();
        r4.getStyleClass().clear();
        r5.getStyleClass().clear();
        r1n.getStyleClass().clear();
        r2n.getStyleClass().clear();
        r3n.getStyleClass().clear();
        r4n.getStyleClass().clear();
        r5n.getStyleClass().clear();
        r1k.getStyleClass().clear();
        r2k.getStyleClass().clear();
        r3k.getStyleClass().clear();
        r4k.getStyleClass().clear();
        r5k.getStyleClass().clear();      
        r1.getStyleClass().add("nbrbox");
        r2.getStyleClass().add("nbrboxDisabled");
        r3.getStyleClass().add("nbrboxDisabled");
        r4.getStyleClass().add("nbrboxDisabled");
        r5.getStyleClass().add("nbrboxDisabled");
        r1n.getStyleClass().add("numberBox");
        r2n.getStyleClass().add("numberBoxDisabled");
        r3n.getStyleClass().add("numberBoxDisabled");
        r4n.getStyleClass().add("numberBoxDisabled");
        r5n.getStyleClass().add("numberBoxDisabled");
        r1k.getStyleClass().add("numberBox");
        r2k.getStyleClass().add("numberBoxDisabled");
        r3k.getStyleClass().add("numberBoxDisabled");
        r4k.getStyleClass().add("numberBoxDisabled");
        r5k.getStyleClass().add("numberBoxDisabled");
        p.setNbRepas(1);
        nbrSuivant.setDisable(false);
    }

    @FXML
    private void r2pressed(MouseEvent event){
        r1.getStyleClass().clear();
        r2.getStyleClass().clear();
        r3.getStyleClass().clear();
        r4.getStyleClass().clear();
        r5.getStyleClass().clear();
        r1n.getStyleClass().clear();
        r2n.getStyleClass().clear();
        r3n.getStyleClass().clear();
        r4n.getStyleClass().clear();
        r5n.getStyleClass().clear();
        r1k.getStyleClass().clear();
        r2k.getStyleClass().clear();
        r3k.getStyleClass().clear();
        r4k.getStyleClass().clear();
        r5k.getStyleClass().clear();      
        r1.getStyleClass().add("nbrbox");
        r2.getStyleClass().add("nbrbox");
        r3.getStyleClass().add("nbrboxDisabled");
        r4.getStyleClass().add("nbrboxDisabled");
        r5.getStyleClass().add("nbrboxDisabled");
        r1n.getStyleClass().add("numberBox");
        r2n.getStyleClass().add("numberBox");
        r3n.getStyleClass().add("numberBoxDisabled");
        r4n.getStyleClass().add("numberBoxDisabled");
        r5n.getStyleClass().add("numberBoxDisabled");
        r1k.getStyleClass().add("numberBox");
        r2k.getStyleClass().add("numberBox");
        r3k.getStyleClass().add("numberBoxDisabled");
        r4k.getStyleClass().add("numberBoxDisabled");
        r5k.getStyleClass().add("numberBoxDisabled");
        p.setNbRepas(2);
        nbrSuivant.setDisable(false);
    }

    @FXML
    private void r3pressed(MouseEvent event){
        r1.getStyleClass().clear();
        r2.getStyleClass().clear();
        r3.getStyleClass().clear();
        r4.getStyleClass().clear();
        r5.getStyleClass().clear();
        r1n.getStyleClass().clear();
        r2n.getStyleClass().clear();
        r3n.getStyleClass().clear();
        r4n.getStyleClass().clear();
        r5n.getStyleClass().clear();
        r1k.getStyleClass().clear();
        r2k.getStyleClass().clear();
        r3k.getStyleClass().clear();
        r4k.getStyleClass().clear();
        r5k.getStyleClass().clear();      
        r1.getStyleClass().add("nbrbox");
        r2.getStyleClass().add("nbrbox");
        r3.getStyleClass().add("nbrbox");
        r4.getStyleClass().add("nbrboxDisabled");
        r5.getStyleClass().add("nbrboxDisabled");
        r1n.getStyleClass().add("numberBox");
        r2n.getStyleClass().add("numberBox");
        r3n.getStyleClass().add("numberBox");
        r4n.getStyleClass().add("numberBoxDisabled");
        r5n.getStyleClass().add("numberBoxDisabled");
        r1k.getStyleClass().add("numberBox");
        r2k.getStyleClass().add("numberBox");
        r3k.getStyleClass().add("numberBox");
        r4k.getStyleClass().add("numberBoxDisabled");
        r5k.getStyleClass().add("numberBoxDisabled");
        p.setNbRepas(3);
        nbrSuivant.setDisable(false);
    }

    @FXML
    private void r4pressed(MouseEvent event){
        r1.getStyleClass().clear();
        r2.getStyleClass().clear();
        r3.getStyleClass().clear();
        r4.getStyleClass().clear();
        r5.getStyleClass().clear();
        r1n.getStyleClass().clear();
        r2n.getStyleClass().clear();
        r3n.getStyleClass().clear();
        r4n.getStyleClass().clear();
        r5n.getStyleClass().clear();
        r1k.getStyleClass().clear();
        r2k.getStyleClass().clear();
        r3k.getStyleClass().clear();
        r4k.getStyleClass().clear();
        r5k.getStyleClass().clear();      
        r1.getStyleClass().add("nbrbox");
        r2.getStyleClass().add("nbrbox");
        r3.getStyleClass().add("nbrbox");
        r4.getStyleClass().add("nbrbox");
        r5.getStyleClass().add("nbrboxDisabled");
        r1n.getStyleClass().add("numberBox");
        r2n.getStyleClass().add("numberBox");
        r3n.getStyleClass().add("numberBox");
        r4n.getStyleClass().add("numberBox");
        r5n.getStyleClass().add("numberBoxDisabled");
        r1k.getStyleClass().add("numberBox");
        r2k.getStyleClass().add("numberBox");
        r3k.getStyleClass().add("numberBox");
        r4k.getStyleClass().add("numberBox");
        r5k.getStyleClass().add("numberBoxDisabled");
        p.setNbRepas(4);
        nbrSuivant.setDisable(false);
    }

    @FXML
    private void r5pressed(MouseEvent event){
        r1.getStyleClass().clear();
        r2.getStyleClass().clear();
        r3.getStyleClass().clear();
        r4.getStyleClass().clear();
        r5.getStyleClass().clear();
        r1n.getStyleClass().clear();
        r2n.getStyleClass().clear();
        r3n.getStyleClass().clear();
        r4n.getStyleClass().clear();
        r5n.getStyleClass().clear();
        r1k.getStyleClass().clear();
        r2k.getStyleClass().clear();
        r3k.getStyleClass().clear();
        r4k.getStyleClass().clear();
        r5k.getStyleClass().clear();      
        r1.getStyleClass().add("nbrbox");
        r2.getStyleClass().add("nbrbox");
        r3.getStyleClass().add("nbrbox");
        r4.getStyleClass().add("nbrbox");
        r5.getStyleClass().add("nbrbox");
        r1n.getStyleClass().add("numberBox");
        r2n.getStyleClass().add("numberBox");
        r3n.getStyleClass().add("numberBox");
        r4n.getStyleClass().add("numberBox");
        r5n.getStyleClass().add("numberBox");
        r1k.getStyleClass().add("numberBox");
        r2k.getStyleClass().add("numberBox");
        r3k.getStyleClass().add("numberBox");
        r4k.getStyleClass().add("numberBox");
        r5k.getStyleClass().add("numberBox");
        p.setNbRepas(5);
        nbrSuivant.setDisable(false);
    }

    @FXML
    private void pressedNbrSuivant(MouseEvent event){
        paneNbR.setVisible(false);
        //appel fonctionnet metiers mtaa hbib
        //Retour vers page Compte (elli heya page accueil)
    }
    
}
