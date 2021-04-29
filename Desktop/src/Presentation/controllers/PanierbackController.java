/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controllers;

import Entities.Panier;
import Entities.Produit;
import Services.PanierService;
import Services.ProduitService;
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
public class PanierbackController implements Initializable {
    private static Panier selected = null;
    
     @FXML
    private TableView<Panier> tablepanier;

    @FXML
    private TableColumn<Panier, String> nomprod;

    @FXML
    private TableColumn<Panier, String> email;

    @FXML
    private TableColumn<Panier, Integer> qt;

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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadProduit();
        this.loadPanier(strrech.getText());
        modbtn.setVisible(false);
        supbtn.setVisible(false);
            
        addPane.setVisible(false);
        editPane.setVisible(false);
        
        strrech.setOnKeyPressed(this::strrechfun);
        strrech.setOnKeyTyped(this::strrechfun);
        strrech.setOnKeyReleased(this::strrechfun);
        tablepanier.setOnMouseClicked(this::onitemselect);
    }  
    
    @FXML
    void onitemselect(MouseEvent event) {
        if(tablepanier.getSelectionModel().getSelectedItem() != null){
            selected = tablepanier.getSelectionModel().getSelectedItem();
            inputemailmod.setText(tablepanier.getSelectionModel().getSelectedItem().getEmail());
            inputQtmod.setText(String.valueOf(tablepanier.getSelectionModel().getSelectedItem().getQT()));
            
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
        this.loadPanier(strrech.getText());
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
        
        PanierService ps = new PanierService();
        Panier p = new Panier(((Produit)selectedItem).getId(),inputemailadd.getText(),Integer.parseInt(inputQtadd.getText()));

        if(ps.ajouterPanier(p)){
            this.loadPanier(strrech.getText());
            inputemailadd.setText("");
            inputQtadd.setText("");
            addPane.setVisible(false);
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

            PanierService ps = new PanierService();
            Panier p = new Panier(((Produit)selectedItem).getId(),inputemailmod.getText(),Integer.parseInt(inputQtmod.getText()));

            if(ps.modifierProduitBack(p)){
                this.loadPanier(strrech.getText());
                inputemailmod.setText("");
                inputQtmod.setText("");
                editPane.setVisible(false);
            }
        }
    }

    @FXML
    void removeitembtn(MouseEvent event) {
        System.out.println(selected);
        if(selected != null){
            PanierService cs = new PanierService();
            cs.supprimerPanier(selected.getIdproduit(),selected.getEmail());
            this.loadPanier(strrech.getText());
            addPane.setVisible(false);
            editPane.setVisible(false);
            modbtn.setVisible(false);
            supbtn.setVisible(false);
            selected = null;
        }
    }
    

    private void loadPanier(String rech){
       
       List<Panier> listPanier;
       PanierService cs = new PanierService();
        if(rech.isEmpty())
            listPanier = cs.listePanier();
        else
            listPanier = cs.listePanierRech(rech);
        
        ObservableList<Panier> data = FXCollections.observableArrayList(listPanier);
        nomprod.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));   
        qt.setCellValueFactory(new PropertyValueFactory<>("QT"));
        tablepanier.setItems(data);

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
