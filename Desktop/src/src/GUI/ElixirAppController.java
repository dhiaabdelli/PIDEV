/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class ElixirAppController implements Initializable {
        double x, y;
    @FXML
    private BorderPane mainPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void min(MouseEvent event) {
               Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        stage.setIconified(true);
    }

    @FXML
    private void max(MouseEvent event) {
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        stage.setFullScreenExitHint("");
        stage.setFullScreen(!stage.isFullScreen());
    }

    @FXML
    private void close(MouseEvent event) {
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        stage.close();
    }

    @FXML
    private void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void pressed(MouseEvent event) {
           x = event.getSceneX();
        y = event.getSceneY();
    }


    @FXML
    private void livreurclicked(MouseEvent event) {
                System.out.println("You clicked button Livreur!");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("livreurbackend1");
        mainPane.setCenter(view);
    }

    @FXML
    private void clickedL(MouseEvent event) {
        
        System.out.println("You clicked button Livraison!");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("livraisonbackend");
        mainPane.setCenter(view);
    

    }



}
