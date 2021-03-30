/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controllers.models;

import Entities.MyListenerPanier;
import Entities.Panier;
import Services.PanierService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PanieritemController implements Initializable {


    @FXML
    private ImageView img;

    @FXML
    private VBox addToCard;

    @FXML
    private Label title;

    @FXML
    private Label description;

    @FXML
    private Label prix;

    @FXML
    private Label qt;

    private MyListenerPanier myListener;
    private Panier p;
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	addToCard.setVisible(true);
    }
    
    
    
    @FXML
    void addqt(MouseEvent event) {
        PanierService ps = new PanierService();
        p.setQT(p.getQT()+1);
        qt.setText(Integer.toString(p.getQT()));
        ps.modifierProduit(p);
    }

    @FXML
    void minusqt(MouseEvent event) {
        PanierService ps = new PanierService();
        if(p.getQT() > 0){
            p.setQT(p.getQT()-1);
            qt.setText(Integer.toString(p.getQT()));
        }else{
            myListener.onClickListener(p);
        }
        ps.modifierProduit(p);
    }

    @FXML
    void remove(MouseEvent event) {
        System.out.println("clicked remove");
        myListener.onClickListener(p);
    }

    
    public void setData(Panier p, MyListenerPanier myListener){
        this.p = p;
        this.myListener = myListener;
        title.setText(p.getLibelle());
        description.setText(p.getDescription());
        prix.setText(Float.toString(p.getPrix()));
        qt.setText(Integer.toString(p.getQT()));
        
        Image image;
        if(p.getImg().isEmpty()){
            image = new Image(getClass().getResourceAsStream("../../views/resources/images/productNotFound.png"));
        }else{
            image = new Image(getClass().getResourceAsStream(p.getImg()));
        }
        img.setImage(image);
    }
}
