/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controllers.models;

import Entities.MyListenerCommande;
import Entities.Commande;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
/**
 *
 * @author ASUS
 */
public class CommandeitemController implements Initializable{
    
    private MyListenerCommande myListener;
    private Commande c;
    
    @FXML
    private VBox addToCard;

    @FXML
    private Label title;

    @FXML
    private VBox addToCard1;

    @FXML
    private Label qt;

    @FXML
    private Label etat;
    
    @FXML
    private HBox btnannu;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	addToCard.setVisible(true);
        btnannu.setVisible(false);
    }
    
    @FXML
    void annuler(MouseEvent event) {
        System.out.println("clicked remove");
        myListener.onClickListener(c);
    }

    
    public void setData(Commande c, MyListenerCommande myListener){
        this.c = c;
        this.myListener = myListener;
        title.setText(c.getNomProduit());
        qt.setText(Integer.toString(c.getTraite()));
        switch (c.getTraite()) {
            case 0:
                etat.setText("En cour");
                etat.setTextFill(Color.color(1, 1, 1));
                btnannu.setVisible(true);
                break;
            case 1:
                etat.setText("Annule");
                etat.setTextFill(Color.color(1, 0, 0));
                break;
            case 2:
                etat.setText("LIVRÉE");
                etat.setTextFill(Color.color(0, 1, 0));
                break;
            default:
                break;
        }
       ;
    }
}
