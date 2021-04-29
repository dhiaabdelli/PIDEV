/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controllers;

import Entities.Categorie;
import Entities.Evaluation;
import Entities.Produit;
import Services.CategorieService;
import Services.EvaluationService;
import Services.ProduitService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
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
public class EvaluationController implements Initializable {
    private static Evaluation selected = null;
    @FXML
    private TableView<Evaluation> tableeval;	
    
    @FXML
    private TableColumn<Evaluation, String> nomproduit;

    @FXML
    private TableColumn<Evaluation, String> nomcompte;

    @FXML
    private TableColumn<Evaluation, Integer> note;
    
   @FXML
    private AnchorPane modbtn;

    @FXML
    private AnchorPane supbtn;

    @FXML
    private TextField strrech;

    @FXML
    private HBox addPane;

    @FXML
    private ChoiceBox<Produit> inputproduitadd;

    @FXML
    private TextField inputnoteadd;

    @FXML
    private ChoiceBox<?> inputcompteadd;

    @FXML
    private HBox editPane;

    @FXML
    private ChoiceBox<Produit> inputproduitmod;

    @FXML
    private TextField inputnotemod;

    @FXML
    private ChoiceBox<?> inputcomptemod;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadProduit();
        this.loadEvaluation(strrech.getText());
        modbtn.setVisible(false);
        supbtn.setVisible(false);
            
        addPane.setVisible(false);
        editPane.setVisible(false);
        strrech.setOnKeyPressed(this::strrechfun);
        strrech.setOnKeyTyped(this::strrechfun);
        strrech.setOnKeyReleased(this::strrechfun);
        tableeval.setOnMouseClicked(this::onitemselect);
    }    
    
    @FXML
    void onitemselect(MouseEvent event) {
        
        if(tableeval.getSelectionModel().getSelectedItem() != null){
            selected = tableeval.getSelectionModel().getSelectedItem();
            inputnotemod.setText(String.valueOf(tableeval.getSelectionModel().getSelectedItem().getNote()));
            
            for(int i = 0;i < inputproduitmod.getItems().size();i++){
                if(inputproduitmod.getItems().get(i).getId() == selected.getId_Produit()){
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
        this.loadEvaluation(strrech.getText());
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
            EvaluationService cs = new EvaluationService();
            cs.supprimerEvaluation(selected.getId());
            this.loadEvaluation(strrech.getText());
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
	int selectedIndex = inputproduitadd.getSelectionModel().getSelectedIndex();
        Object selectedItem = inputproduitadd.getSelectionModel().getSelectedItem();
        
        EvaluationService es = new EvaluationService();
        Evaluation e = new Evaluation(Integer.parseInt(es.getNextId()),((Produit)selectedItem).getId(),0,Integer.parseInt(inputnoteadd.getText()));

        if(es.ajouterEvaluation(e)){
            this.loadEvaluation(strrech.getText());
            inputnoteadd.setText("");
            addPane.setVisible(false);
        }
        
    }

    @FXML
    void modifierdb(MouseEvent event) {
        //System.out.println(selected);
        if(selected != null){
           
            int selectedIndex = inputproduitmod.getSelectionModel().getSelectedIndex();
            Object selectedItem = inputproduitmod.getSelectionModel().getSelectedItem();
                    System.out.println(((Produit)selectedItem).getId());

            EvaluationService es = new EvaluationService();
            Evaluation e = new Evaluation(selected.getId(),((Produit)selectedItem).getId(),0,Integer.parseInt(inputnotemod.getText()));            
            System.out.println(e);
            if(es.modifierEvaluationBack(e)){
                this.loadEvaluation(strrech.getText());
                inputnotemod.setText("");
                editPane.setVisible(false);
            }
        }
    }
    
    private void loadEvaluation(String rech){
       
       List<Evaluation> listEvaluation;
       EvaluationService cs = new EvaluationService();
        if(rech.isEmpty())
            listEvaluation = cs.listeEvaluation();
        else
            listEvaluation = cs.listeEvaluationRech(rech);
        
        System.out.println(listEvaluation.size());

        ObservableList<Evaluation> data = FXCollections.observableArrayList(listEvaluation);
	nomproduit.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));   
	note.setCellValueFactory(new PropertyValueFactory<>("note"));
        tableeval.setItems(data);

    }
    
    private void loadProduit(){
       
       List<Produit> listProduit;
       ProduitService cs = new ProduitService();
        listProduit = cs.listeProduits();

        for (int i = 0; i < listProduit.size(); i++) {
            inputproduitadd.getItems().add(listProduit.get(i));
            inputproduitmod.getItems().add(listProduit.get(i));
        }
        inputproduitadd.getSelectionModel().selectFirst();
    }
}
