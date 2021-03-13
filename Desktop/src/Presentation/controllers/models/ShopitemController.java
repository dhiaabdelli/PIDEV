/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controllers.models;

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
public class ShopitemController implements Initializable {


	@FXML
    private VBox addToCard;

	@FXML
    private VBox ItemInfo;
	
    @FXML
    private ImageView img;

    @FXML
    private Label title;

    @FXML
    private Label prix;

    @FXML
    private Label note;


    @FXML
    private Label title1;

    @FXML
    private TextField desc;

    @FXML
    private Label prix1;

    @FXML
    private Button back;

    @FXML
    private Label note1;

	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	addToCard.setVisible(true);
        ItemInfo.setVisible(false);
    }
    
    
    @FXML
    void backToCard(MouseEvent event) {
        addToCard.setVisible(true);
        ItemInfo.setVisible(false);
        System.out.println("testtttttttt");
    }
    
    @FXML
    void iteminfo(MouseEvent event) {
	addToCard.setVisible(false);
        ItemInfo.setVisible(true);
    }
	
    public void setData(String titletext,String prixtext,String imgurl){
        title.setText(titletext);
		title1.setText(titletext);
		desc.setText(titletext);
		
        prix.setText(prixtext+" DT");
		prix1.setText(prixtext+" DT");
                Image image;
        //System.out.println(getClass().getResourceAsStream("../../views/resources/images/productNotFound.png"));        
        if(imgurl.isEmpty()){
            image = new Image(getClass().getResourceAsStream("../../views/resources/images/productNotFound.png"));
        }else{
            image = new Image(getClass().getResourceAsStream(imgurl));
        }
        //Image image = new Image(getClass().getResourceAsStream("/images/cards/As.png"));
        //Image image = new Image("https://www.tunisianet.com.tn/175587-home/tablette-lenovo-tab-m10-tb-x505x-101-4g-noir-sim-orange-40-go-offert.jpg");

        img.setImage(image);
    }
}
