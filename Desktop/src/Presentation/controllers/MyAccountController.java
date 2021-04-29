package Presentation.controllers;

import Presentation.controllers.models.ProfileInfosController;
import Services.CompteService;
import Services.ProfilService;
import entities.Compte;
import entities.Profil;
import javafx.geometry.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MyAccountController implements Initializable {
    
    static Compte c = new Compte();
    CompteService cs = new CompteService();
    ProfilService ps = new ProfilService();
    
    @FXML
    private StackPane paneName;
    @FXML
    private Text nomprenom;
    @FXML
    private StackPane paneEditName;
    @FXML
    private TextField prenomSaisie;
    @FXML
    private TextField nomSaisie;
    @FXML
    private Text mail;
    @FXML
    private TextField newPassword;
    @FXML
    private Text password;
    @FXML
    private StackPane paneEditPassword;
    @FXML
    private StackPane panePassword;
    @FXML
    private GridPane gridProf;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String emailCompte = "aziz.mrabet@esprit.tn";
        c = cs.chercherCompte(emailCompte);
        nomprenom.setText((c.getPrenom() + " " + c.getNom()).toUpperCase());
        mail.setText(c.getEmail());
        String mdp = "";
        for(int i = 0; i < c.getMdp().length(); i++){
            mdp += '•';
        }
        password.setText(mdp);
        List<Profil> lp = ps.listeProfilParEmail(emailCompte); 
        System.out.println("size : " + lp.size());
        int column = 0,row = 1;
        try{
            for(int i=0; i < lp.size(); i++){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../views/models/profileInfos.fxml"));
                AnchorPane anchorPane = loader.load();
                ProfileInfosController PIController = loader.getController();
                PIController.setData(lp.get(i).getAge(), lp.get(i).getPoids(), lp.get(i).getTaille(), lp.get(i).getObjectif(), lp.get(i).getNbRepas(), i+1, lp.get(i).getSexe());
                if(column == 5){
                    column = 0;
                    row++;
                }
                gridProf.add(anchorPane, column++, row);
            }  
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }    

    @FXML
    private void pressedEditName(MouseEvent event){
        paneName.setVisible(false);
        paneEditName.setVisible(true);
        nomSaisie.setText(c.getNom());
        prenomSaisie.setText(c.getPrenom());
    }

    @FXML
    private void pressedApplyName(MouseEvent event){
        c.setNom(nomSaisie.getText());
        c.setPrenom(prenomSaisie.getText());
        cs.modifierCompte(c);
        nomprenom.setText((c.getPrenom() + " " + c.getNom()).toUpperCase());
        mail.setText(c.getEmail());
        paneName.setVisible(true);
        paneEditName.setVisible(false);  
    }

    @FXML
    private void pressedApplyPassword(MouseEvent event){
        c.setMdp(newPassword.getText());
        cs.modifierCompte(c);
        String mdp = "";
        for(int i = 0; i < c.getMdp().length(); i++){
            mdp += '•';
        }
        password.setText(mdp);
        panePassword.setVisible(true);
        paneEditPassword.setVisible(false);
    }

    @FXML
    private void pressedEditPassword(MouseEvent event){
        panePassword.setVisible(false);
        paneEditPassword.setVisible(true);
    }

    @FXML
    private void pressedHidePassword(MouseEvent event){
        String mdp = "";
        for(int i = 0; i < c.getMdp().length(); i++){
            mdp += '•';
        }
        password.setText(mdp);
    }

    @FXML
    private void pressedShowPassword(MouseEvent event){
        password.setText(c.getMdp());
    }

    @FXML
    private void pressedAddProfile(MouseEvent event){
        //Ouvrir la page Quiz.fxml
    }
    
}
