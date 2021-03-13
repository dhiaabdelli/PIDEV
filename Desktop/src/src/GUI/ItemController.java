/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import entities.Exercice;
import entities.MyListener;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ItemController implements Initializable {

    @FXML
    private Label contlibelle;
    @FXML
    private Label contdescription;
    @FXML
    private ImageView img;
    private String lib, desc, image;
    private MyListener myListener;
    private Exercice ex;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void click(MouseEvent event) {
        myListener.onClickListener(ex);
    }

    public void setData(Exercice ex, MyListener myListener) {
        this.ex = ex;
        this.myListener = myListener;
        contlibelle.setText(ex.getLibelle());
        contdescription.setText(ex.getDescription());
        try {
            Image image = new Image(ex.getImage());
            img.setImage(image);
        } catch (NullPointerException e) {
            System.out.println("Image Link Invalid");
        }
    }

}
