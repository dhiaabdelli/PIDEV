/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controllers;

import Entities.Categorie;
import Services.CategorieService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CategorieController implements Initializable {
    private static Categorie selected = null;
    @FXML
    private TableView<Categorie> tablecat;

    @FXML
    private TableColumn<Categorie, String> nom;

    @FXML
    private TableColumn<Categorie, String> desc;
	
    @FXML
    private TextField strrech;
    
    @FXML
    private HBox addPane;
     
    @FXML
    private HBox editPane;
    
	
	@FXML
    private TextField inputnomadd;

    @FXML
    private TextArea inputdescadd;
	
	
	@FXML
    private TextField inputnommod;

    @FXML
    private TextArea inputdescmod;
	
    
    @FXML
    private AnchorPane modbtn;

    @FXML
    private AnchorPane supbtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadCategorie(strrech.getText());
        modbtn.setVisible(false);
        supbtn.setVisible(false);
            
        addPane.setVisible(false);
        editPane.setVisible(false);
        strrech.setOnKeyPressed(this::strrechfun);
        strrech.setOnKeyTyped(this::strrechfun);
        strrech.setOnKeyReleased(this::strrechfun);
        tablecat.setOnMouseClicked(this::onitemselect);
    }    
    
    @FXML
    void onitemselect(MouseEvent event) {
        
        if(tablecat.getSelectionModel().getSelectedItem() != null){
            selected = tablecat.getSelectionModel().getSelectedItem();
            inputnommod.setText(tablecat.getSelectionModel().getSelectedItem().getNom());
            inputdescmod.setText(tablecat.getSelectionModel().getSelectedItem().getDesc());
            modbtn.setVisible(true);
            supbtn.setVisible(true);
        }
    }
    
    @FXML
    void strrechfun(KeyEvent event) {
        System.out.println("Rech : "+strrech.getText());
        this.loadCategorie(strrech.getText());
    }
    
    @FXML
    void additembtn(MouseEvent event) {
        addPane.setVisible(true);
        editPane.setVisible(false);
    }

    @FXML
    void removeitembtn(MouseEvent event) {
        System.out.println(selected);
        if(selected != null){
            CategorieService cs = new CategorieService();
            cs.supprimerCategorie(selected.getId());
            this.loadCategorie(strrech.getText());
            addPane.setVisible(false);
            editPane.setVisible(false);
            modbtn.setVisible(false);
            supbtn.setVisible(false);
            selected = null;
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
    void ajouterdb(MouseEvent event) {
		CategorieService cs = new CategorieService();
        Categorie c = new Categorie(Integer.parseInt(cs.getNextId()),inputnomadd.getText(),inputdescadd.getText());
        if(cs.ajouterCategorie(c)){
            this.loadCategorie(strrech.getText());
			inputnomadd.setText("");
			inputdescadd.setText("");
			addPane.setVisible(false);
        }
    }

    @FXML
    void modifierdb(MouseEvent event) {
        System.out.println(selected);
        if(selected != null){
            CategorieService cs = new CategorieService();
        
            Categorie c = new Categorie(selected.getId(),inputnommod.getText(),inputdescmod.getText());
            if(cs.modifierCategorie(c)){
                this.loadCategorie(strrech.getText());
                inputnommod.setText("");
		inputdescmod.setText("");
                editPane.setVisible(false);
                modbtn.setVisible(false);
                supbtn.setVisible(false);
            }
        }
    }
	
    private void loadCategorie(String rech){
       
       List<Categorie> listCategorie;
       CategorieService cs = new CategorieService();
        if(rech.isEmpty())
            listCategorie = cs.listeCategorie();
        else
            listCategorie = cs.listeCategorieRech(rech);
        
        System.out.println(listCategorie.size());

		for(int i = 0; i < listCategorie.size();i++){
			System.out.println(listCategorie.get(i).getDesc());
		}
        ObservableList<Categorie> data = FXCollections.observableArrayList(listCategorie);
		nom.setCellValueFactory(new PropertyValueFactory<>("nom"));   
		desc.setCellValueFactory(new PropertyValueFactory<>("desc"));		
        tablecat.setItems(data);

    }
}
