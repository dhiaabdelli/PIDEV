/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controllers;

import Entities.Commande;
import Entities.Produitscommand;

import Entities.Produit;
import Services.CommandeService;
import Services.PanierService;
import Services.ProduitService;
import Services.ProduitscommandService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CommandebackController implements Initializable {
    private static Commande selected = null;
    
    @FXML
    private TableView<Commande> tablecommande;

    @FXML
    private TableColumn<Commande, Integer> numcommand;

    @FXML
    private TableColumn<Commande, String> nomprod;

    @FXML
    private TableColumn<Commande, Integer> qt;

    @FXML
    private TableColumn<Commande, String> email;

    @FXML
    private TableColumn<Commande, Integer> traite;

    @FXML
    private AnchorPane modbtn;

    @FXML
    private AnchorPane supbtn;

    @FXML
    private TextField strrech;

    @FXML
    private HBox addPane;

    @FXML
    private ChoiceBox<Produit> inputprdouitadd;

    @FXML
    private TextField inputemailadd;

    @FXML
    private TextField inputQtadd;

    @FXML
    private HBox editPane;

    @FXML
    private ChoiceBox<Produit> inputproduitmod;

    @FXML
    private TextField inputemailmod;

    @FXML
    private TextField inputQtmod;

    @FXML
    private TextField inputetatmod;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadProduit();
        this.loadCommande(strrech.getText());
        modbtn.setVisible(false);
        supbtn.setVisible(false);
            
        addPane.setVisible(false);
        editPane.setVisible(false);
        
        strrech.setOnKeyPressed(this::strrechfun);
        strrech.setOnKeyTyped(this::strrechfun);
        strrech.setOnKeyReleased(this::strrechfun);
        tablecommande.setOnMouseClicked(this::onitemselect);
    }  
    
    @FXML
    void onitemselect(MouseEvent event) {
        if(tablecommande.getSelectionModel().getSelectedItem() != null){
            selected = tablecommande.getSelectionModel().getSelectedItem();
            inputemailmod.setText(tablecommande.getSelectionModel().getSelectedItem().getEmail());
            inputQtmod.setText(String.valueOf(tablecommande.getSelectionModel().getSelectedItem().getQT()));
            inputetatmod.setText(String.valueOf(tablecommande.getSelectionModel().getSelectedItem().getTraite()));
            for(int i = 0;i < inputproduitmod.getItems().size();i++){
                if(inputproduitmod.getItems().get(i).getId() == selected.getIdproduit()){
                     inputproduitmod.getSelectionModel().select(i);
                     break;
                }
            }
            modbtn.setVisible(true);
            supbtn.setVisible(true);
        }
    }
    
    @FXML
    void strrechfun(KeyEvent event) {
        System.out.println("Rech : "+strrech.getText());
        this.loadCommande(strrech.getText());
    }
    
   @FXML
    void additembtn(MouseEvent event) {
        addPane.setVisible(true);
        editPane.setVisible(false);
    }

    @FXML
    void ajouterdb(MouseEvent event) {
        int selectedIndex = inputprdouitadd.getSelectionModel().getSelectedIndex();
        Object selectedItem = inputprdouitadd.getSelectionModel().getSelectedItem();
        
        CommandeService cs = new CommandeService();
        ProduitscommandService pcs = new ProduitscommandService();
                
        Produitscommand pc = new Produitscommand(Integer.parseInt(pcs.getNextId()),((Produit)selectedItem).getId(),Integer.parseInt(inputQtadd.getText()));
        Commande c = new Commande(Integer.parseInt(cs.getNextId()),Integer.parseInt(pcs.getNextId()),inputemailadd.getText(),0);

        if(pcs.ajouterProduitscommand(pc)){
            if(cs.ajouterCommande(c)){
                this.loadCommande(strrech.getText());
                inputemailadd.setText("");
                inputQtadd.setText("");
                addPane.setVisible(false);
            }
        }
        
       
    }

    @FXML
    void edititembtn(MouseEvent event) {
        addPane.setVisible(false);
        editPane.setVisible(true);
    }
    
    @FXML
    void backBtn(MouseEvent event) {
        addPane.setVisible(false);
        editPane.setVisible(false);
    }

    @FXML
    void modifierdb(MouseEvent event) {
       if(selected != null){
            int selectedIndex = inputproduitmod.getSelectionModel().getSelectedIndex();
            Object selectedItem = inputproduitmod.getSelectionModel().getSelectedItem();

            CommandeService ps = new CommandeService();
            Commande c = new Commande(selected.getId(),selected.getIdpanier(),inputemailmod.getText(),Integer.parseInt(inputetatmod.getText()));

            if(ps.modifierCommande(c)){
                this.loadCommande(strrech.getText());
                inputemailmod.setText("");
                inputQtmod.setText("");
                inputetatmod.setText("");
                editPane.setVisible(false);
            }
        }
    }

    @FXML
    void removeitembtn(MouseEvent event) {
        System.out.println(selected);
        if(selected != null){
            ProduitscommandService pcs = new ProduitscommandService();
            CommandeService cs = new CommandeService();
            pcs.supprimerProduitscommand(selected.getIdpanier());
            cs.supprimerCommande(selected.getId());
            
            this.loadCommande(strrech.getText());
            addPane.setVisible(false);
            editPane.setVisible(false);
            modbtn.setVisible(false);
            supbtn.setVisible(false);
            selected = null;
        }
    }
    

    private void loadCommande(String rech){
       
       List<Commande> listCommande;
       CommandeService cs = new CommandeService();
        if(rech.isEmpty())
            listCommande = cs.listeCommande();
        else
            listCommande = cs.listeCommandeRech(rech);
        
        ObservableList<Commande> data = FXCollections.observableArrayList(listCommande);
        numcommand.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomprod.setCellValueFactory(new PropertyValueFactory<>("NomProduit"));   
        qt.setCellValueFactory(new PropertyValueFactory<>("QT"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        traite.setCellValueFactory(new PropertyValueFactory<>("traite"));   
        tablecommande.setItems(data);

    }
    
    private void loadProduit(){
       
        List<Produit> listProduit;
        ProduitService cs = new ProduitService();
        listProduit = cs.listeProduits();
        for (int i = 0; i < listProduit.size(); i++) {
            inputprdouitadd.getItems().add(listProduit.get(i));
            inputproduitmod.getItems().add(listProduit.get(i));
        }
        inputprdouitadd.getSelectionModel().selectFirst();
    }
}
