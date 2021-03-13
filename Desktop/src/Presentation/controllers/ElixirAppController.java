package Presentation.controllers;

import Presentation.FxmlLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ElixirAppController implements Initializable {
    
    double x, y;
    @FXML
    private BorderPane mainPane;

    @FXML
    private HBox shopbtn;
    
    @FXML
    private HBox homebtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      shopbtn.requestFocus();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("./views/Shop");
        mainPane.setCenter(view);
    } 
    
    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        stage.close();
    }
    
    @FXML
    void max(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        stage.setFullScreenExitHint("");
        stage.setFullScreen(!stage.isFullScreen());
    }

    @FXML
    void min(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        stage.setIconified(true);
    }
    
    @FXML
    void dragged(MouseEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }
    @FXML
    void pressed(MouseEvent event){
        x = event.getSceneX();
        y = event.getSceneY();
    }
    
    
    //Pages Navigation
    @FXML
    void pressedhome(MouseEvent event) {
        homebtn.requestFocus();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("./views/Categorie");
        mainPane.setCenter(view);
    }
    
    @FXML
    void pressedshop(MouseEvent event) {
        shopbtn.requestFocus();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("./views/Shop");
        mainPane.setCenter(view);
    }
    
    @FXML
    void pressedex(MouseEvent event) {
        shopbtn.requestFocus();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("./views/Produit");
        mainPane.setCenter(view);
    }
    
    @FXML
    void pressedfood(MouseEvent event) {
        shopbtn.requestFocus();
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("./views/Evaluation");
        mainPane.setCenter(view);
    }
}
