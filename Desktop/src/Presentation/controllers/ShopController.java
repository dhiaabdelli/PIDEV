/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controllers;

import Presentation.controllers.models.ShopitemController;
import javafx.geometry.Insets;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


import Entities.Produit;
import Entities.Categorie;
import Services.ProduitService;
import Services.CategorieService;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ShopController implements Initializable {
    private ProduitService ps = new ProduitService();
    private List<Produit> listProduit;
	
    @FXML
    private TextField rechinput;
    
    @FXML
    private Label totalresults;
	
    @FXML
    private ChoiceBox<Categorie> categorieData;
    
    @FXML
    private ChoiceBox<String> tridData;
    
    @FXML
    private GridPane shopgrid;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.initTri();
	this.loadCategorie();
	listProduit = ps.listeProduits();
        int minus = 0;
        int column = 0,row = 1;
        try {
            for(int i=0;i < listProduit.size(); i++){
                System.out.println(listProduit.get(i).getQt());
                if(listProduit.get(i).getQt() > 0){
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("../views/models/shopitem.fxml"));
                    AnchorPane anchorPane = loader.load();
                    ShopitemController shopItemController = loader.getController();
                    shopItemController.setData(listProduit.get(i),listProduit.get(i).getId(),listProduit.get(i).getLibelle(),Float.toString(listProduit.get(i).getPrix()),listProduit.get(i).getImg());
                    if(column == 3){
                        column = 0;
                        row++;
                    }
                    shopgrid.add(anchorPane,column++,row);
                    GridPane.setMargin(anchorPane,new Insets(20));
                }else{
                    minus++;
                }
            }
            
        }  
        catch (IOException ex) {
            ex.printStackTrace();
        }
        totalresults.setText(Integer.toString(listProduit.size()-minus)+" results found");
	categorieData.setOnAction(this::categorieAction);
        tridData.setOnAction(this::categorieAction);
        rechinput.setOnKeyPressed(this::strrechfun);
        rechinput.setOnKeyTyped(this::strrechfun);
        rechinput.setOnKeyReleased(this::strrechfun);
    }

    @FXML
    private void categorieAction(ActionEvent event) {
        this.loadProduit();
    }
	
    @FXML
    void strrechfun(KeyEvent event) {
        System.out.println("Rech : "+rechinput.getText());
        this.loadProduit();
    }
    private void loadCategorie(){
       CategorieService cs = new CategorieService();
       List<Categorie> listCategorie;
       listCategorie = cs.listeCategorie();
       System.out.println(listCategorie.size());
       Categorie categorie = new Categorie(-1, "tous les produits");
       categorieData.getItems().add(categorie);
       for (int i = 0; i < listCategorie.size(); i++) {
            categorieData.getItems().add(listCategorie.get(i));
       }
       categorieData.getSelectionModel().selectFirst();
    }
	
    private void loadProduit(){
        shopgrid.getChildren().clear();
        int selectedIndexcategorie = categorieData.getSelectionModel().getSelectedIndex();
        int selectedIndextri = tridData.getSelectionModel().getSelectedIndex();
        Object selectedItemcategorie = categorieData.getSelectionModel().getSelectedItem();
        
        if(selectedIndexcategorie == 0 && selectedIndextri == 0 && rechinput.getText().isEmpty())
            listProduit = ps.listeProduits();
        
        else if(selectedIndexcategorie == 0 && selectedIndextri == 0 && !rechinput.getText().isEmpty())
            listProduit = ps.listeProduitsRech(rechinput.getText());
        
        else if(selectedIndexcategorie == 0 && selectedIndextri > 0 && rechinput.getText().isEmpty())
            listProduit = ps.listeProduitsTrieRech(selectedIndextri,rechinput.getText());
        
        else if(selectedIndexcategorie > 0 && selectedIndextri == 0 && rechinput.getText().isEmpty())
            listProduit = ps.listeProduitsParIdCategorie(((Categorie)selectedItemcategorie).getId());
        
        else if(selectedIndexcategorie > 0 && selectedIndextri == 0 && !rechinput.getText().isEmpty())
            listProduit = ps.listeProduitsParIdCategorieRech(((Categorie)selectedItemcategorie).getId(),rechinput.getText());
        
        else if(selectedIndexcategorie > 0 && selectedIndextri > 0 && rechinput.getText().isEmpty())
            listProduit = ps.listeProduitsParIdCategorieTri(((Categorie)selectedItemcategorie).getId(),selectedIndextri);
        
        else if(selectedIndexcategorie > 0 && selectedIndextri > 0 && !rechinput.getText().isEmpty())
            listProduit = ps.listeProduitsParIdCategorieTriRech(((Categorie)selectedItemcategorie).getId(),selectedIndextri,rechinput.getText());
        
        
        int minus = 0;
        int column = 0,row = 1;
        try {
            for(int i=0;i < listProduit.size(); i++){
                
                if(listProduit.get(i).getQt() > 0){
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("../views/models/shopitem.fxml"));
                    AnchorPane anchorPane = loader.load();
                    ShopitemController shopItemController = loader.getController();
                    shopItemController.setData(listProduit.get(i),listProduit.get(i).getId(),listProduit.get(i).getLibelle(),Float.toString(listProduit.get(i).getPrix()),listProduit.get(i).getImg());
                    if(column == 3){
                        column = 0;
                        row++;
                    }
                    shopgrid.add(anchorPane,column++,row);
                    GridPane.setMargin(anchorPane,new Insets(20));
                }else{
                    minus++;
                }

            }
            
        }  
        catch (IOException ex) {
            ex.printStackTrace();
        }
        totalresults.setText(Integer.toString(listProduit.size()-minus)+" results found");
    }
    private void initTri(){
        tridData.getItems().add("Nom de produit");
        tridData.getItems().add("Prix");
        tridData.getItems().add("Rating");
        tridData.getSelectionModel().selectFirst();
    }
	
}
