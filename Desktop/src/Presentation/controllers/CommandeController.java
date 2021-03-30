package Presentation.controllers;

import Entities.Commande;
import Presentation.controllers.models.PanieritemController;
import Entities.Panier;
import Entities.MyListenerCommande;
import Entities.Produitscommand;
import Presentation.controllers.models.CommandeitemController;
import Services.CommandeService;
import Services.PanierService;
import Services.ProduitscommandService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

public class CommandeController implements Initializable {

    
    @FXML
    private GridPane commandegrid;

    @FXML
    private Label vid;
    
    private MyListenerCommande myListener;
    private final CommandeService cs = new CommandeService();
    private List<Commande> listCcommande = null;
    
    public void annuler(Commande c) {
        System.out.println("remove");
        cs.annulerCommande(c);
        this.loadCommande();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        commandegrid.setVisible(false);
        vid.setVisible(false);
        
        myListener = new MyListenerCommande() {
                @Override
                public void onClickListener(Commande c) {
                    annuler(c);
                }
            };

        this.loadCommande();
    }
    
    private void loadCommande() {
        commandegrid.getChildren().clear();
        listCcommande = cs.listeCommande();
        System.out.println(listCcommande.size());
        if(listCcommande.size() == 0){
            vid.setVisible(true);
            commandegrid.setVisible(false);
        }else{
            vid.setVisible(false);
            commandegrid.setVisible(true);
        }
        int column = 0, row = 1;
        try {
            for (int i = 0; i < listCcommande.size(); i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../views/models/commandeitem.fxml"));
                AnchorPane anchorPane = loader.load();
                CommandeitemController commandeitemController = loader.getController();
                commandeitemController.setData(listCcommande.get(i), myListener);
                if (column == 1) {
                    column = 0;
                    row++;
                }
                commandegrid.add(anchorPane, column++, row);
                //set grid width
                commandegrid.setMinWidth(Region.USE_COMPUTED_SIZE);
                commandegrid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                commandegrid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                commandegrid.setMinHeight(Region.USE_COMPUTED_SIZE);
                commandegrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                commandegrid.setMaxHeight(Region.USE_PREF_SIZE);
                
                GridPane.setMargin(anchorPane, new Insets(20));

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
