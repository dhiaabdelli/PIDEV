package Presentation.controllers;

import Entities.Commande;
import Presentation.controllers.models.PanieritemController;
import Entities.Panier;
import Entities.MyListenerPanier;
import Entities.Produitscommand;
import Services.CommandeService;
import Services.PanierService;
import Services.ProduitscommandService;
import com.teknikindustries.bulksms.SMS;
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
public class PanierController implements Initializable {

    
    @FXML
    private GridPane paniergrid;
    
    @FXML
    private Label vid;
    
    @FXML
    private Button btncomm;
    
    private MyListenerPanier myListener;
    private final PanierService ps = new PanierService();
    private List<Panier> listPanier = null;
    public void remove(Panier p) {
        System.out.println("remove");
        ps.supprimerPanier(p.getIdproduit(),p.getEmail());
        this.loadPanier();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paniergrid.setVisible(false);
        vid.setVisible(false);
        btncomm.setVisible(false);
        
        myListener = new MyListenerPanier() {
                @Override
                public void onClickListener(Panier p) {
                    remove(p);
                }
            };

        this.loadPanier();
    }
    
    @FXML
    void btncommande(MouseEvent event) {
        CommandeService cs = new CommandeService();
        ProduitscommandService pcs = new ProduitscommandService();
        System.out.println(cs.getNextId());
        for (int i = 0; i < listPanier.size(); i++) {
            Produitscommand pc = new Produitscommand(Integer.parseInt(pcs.getNextId()),listPanier.get(i).getIdproduit(),listPanier.get(i).getQT());
            pcs.ajouterProduitscommand(pc);
            ps.supprimerPanier(listPanier.get(i).getIdproduit(),listPanier.get(i).getEmail());
        }
        
        Commande c = new Commande(Integer.parseInt(cs.getNextId()),Integer.parseInt(pcs.getNextId())-1,"ddfgdfgdfg",0);
        
        cs.ajouterCommande(c);
        this.sms();
         this.loadPanier();
    }
    
    private void loadPanier() {
        paniergrid.getChildren().clear();
        listPanier = ps.listePanier();
        System.out.println(listPanier.size());
        if(listPanier.size() == 0){
            vid.setVisible(true);
            paniergrid.setVisible(false);
            btncomm.setVisible(false);
        }else{
            vid.setVisible(false);
            paniergrid.setVisible(true);
            btncomm.setVisible(true);
        }
        int column = 0, row = 1;
        try {
            for (int i = 0; i < listPanier.size(); i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../views/models/panieritem.fxml"));
                AnchorPane anchorPane = loader.load();
                PanieritemController panieritemController = loader.getController();
                panieritemController.setData(listPanier.get(i), myListener);
                if (column == 1) {
                    column = 0;
                    row++;
                }
                paniergrid.add(anchorPane, column++, row);
                //set grid width
                paniergrid.setMinWidth(Region.USE_COMPUTED_SIZE);
                paniergrid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                paniergrid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                paniergrid.setMinHeight(Region.USE_COMPUTED_SIZE);
                paniergrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                paniergrid.setMaxHeight(Region.USE_PREF_SIZE);
                
                GridPane.setMargin(anchorPane, new Insets(20));

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
    public void sms(){  
        SMS s = new SMS();
        
        s.SendSMS("mohamed1_23456789","Mohamed+23","Commande Confirmée ","21654451627","https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
    }


}
