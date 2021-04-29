package Presentation.controllers;


import Presentation.FxmlLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ElixirAppControllerback implements Initializable {

    double x, y;
    
    @FXML
    private BorderPane mainPane;

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
    
    @FXML
    void close(MouseEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        stage.close();
    }
    
    @FXML
    void max(MouseEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        stage.setFullScreenExitHint("");
        stage.setFullScreen(!stage.isFullScreen());
    }

    @FXML
    void min(MouseEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        stage.setIconified(true);
    }
    
	
	
	@FXML
    void pressedcategorie(MouseEvent event) {
		FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("./views/Categorie");
        mainPane.setCenter(view);
    }

    @FXML
    void pressedproduit(MouseEvent event) {
		FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("./views/Produit");
        mainPane.setCenter(view);
    }
	
	@FXML
    void pressedeval(MouseEvent event) {
		FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("./views/Evaluation");
        mainPane.setCenter(view);
    }
	
    @FXML
    void pressedex(MouseEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("./views/Exercice");
        mainPane.setCenter(view);
    }

    @FXML
    void pressedcommande(MouseEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("./views/CommandeBack");
        mainPane.setCenter(view);
    }
    
     @FXML
    void pressedPanier(MouseEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("./views/Panierback");
        mainPane.setCenter(view);
    }
    
    @FXML
    void pressedfood(MouseEvent event) {

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("./views/Produit");
        mainPane.setCenter(view);
    }    

    
}
