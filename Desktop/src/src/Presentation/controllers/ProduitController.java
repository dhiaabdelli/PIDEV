/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controllers;

import Entities.Categorie;
import Entities.Produit;
import Services.CategorieService;
import Services.ProduitService;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ChoiceBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.jcp.xml.dsig.internal.dom.Utils;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ProduitController implements Initializable {
    private static Produit selected = null;
    private String photoProduitadd = null;
    private String photoProduitmod = null;
    
    @FXML
    private TableView<Produit> tableoprod;

    @FXML
    private TableColumn<Produit, String> nomcat;

    @FXML
    private TableColumn<Produit, String> nom;

    @FXML
    private TableColumn<Produit, String> desc;

    @FXML
    private TableColumn<Produit, Float> prix;

    @FXML
    private TableColumn<Produit, Integer> qt;

    @FXML
    private TableColumn<Produit, String> img;
    
    @FXML
    private TextField strrech;
    
    @FXML
    private HBox addPane;
     
    @FXML
    private HBox editPane;
    
	
    @FXML
    private ChoiceBox<Categorie> inputcatadd;

    @FXML
    private TextField inputnomadd;

    @FXML
    private TextArea inputdescadd;

    @FXML
    private TextField inputprixadd;
    
    @FXML
    private TextField inputQtadd;
	
	
    @FXML
    private ChoiceBox<Categorie> inputcatmod;

    @FXML
    private TextField inputnommod;

    @FXML
    private TextArea inputdescmod;

    @FXML
    private TextField inputprixmod;
    
    @FXML
    private TextField inputQtmod;
	
    
    @FXML
    private AnchorPane modbtn;

    @FXML
    private AnchorPane supbtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadCategorie();
        this.loadProduit(strrech.getText());
        modbtn.setVisible(false);
        supbtn.setVisible(false);
            
        addPane.setVisible(false);
        editPane.setVisible(false);
        
        strrech.setOnKeyPressed(this::strrechfun);
        strrech.setOnKeyTyped(this::strrechfun);
        strrech.setOnKeyReleased(this::strrechfun);
        tableoprod.setOnMouseClicked(this::onitemselect);
    }    
    
    @FXML
    void onitemselect(MouseEvent event) {
        if(tableoprod.getSelectionModel().getSelectedItem() != null){
            selected = tableoprod.getSelectionModel().getSelectedItem();
            inputnommod.setText(tableoprod.getSelectionModel().getSelectedItem().getLibelle());
            inputdescmod.setText(tableoprod.getSelectionModel().getSelectedItem().getDescription());
            inputprixmod.setText(String.valueOf(tableoprod.getSelectionModel().getSelectedItem().getPrix()));
            inputQtmod.setText(String.valueOf(tableoprod.getSelectionModel().getSelectedItem().getQt()));
            
            for(int i = 0;i < inputcatmod.getItems().size();i++){
                if(inputcatmod.getItems().get(i).getId() == selected.getIdCategorie()){
                     inputcatmod.getSelectionModel().select(i);
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
        this.loadProduit(strrech.getText());
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
            ProduitService cs = new ProduitService();
            cs.supprimerProduit(selected.getId());
            this.loadProduit(strrech.getText());
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
	int selectedIndex = inputcatadd.getSelectionModel().getSelectedIndex();
        Object selectedItem = inputcatadd.getSelectionModel().getSelectedItem();
        
        ProduitService ps = new ProduitService();
        Produit p;
        if(photoProduitadd != null)
            p = new Produit(Integer.parseInt(ps.getNextId()),((Categorie)selectedItem).getId(),inputnomadd.getText(),Float.parseFloat(inputprixadd.getText()),inputdescadd.getText(), Integer.parseInt(inputQtadd.getText()),photoProduitadd);

        else
            p = new Produit(Integer.parseInt(ps.getNextId()),((Categorie)selectedItem).getId(),inputnomadd.getText(),Float.parseFloat(inputprixadd.getText()),inputdescadd.getText(), Integer.parseInt(inputQtadd.getText()),"");

        if(ps.ajouterProduit(p)){
            this.loadProduit(strrech.getText());
            inputnomadd.setText("");
            inputdescadd.setText("");
            inputprixadd.setText("");
            inputQtadd.setText("");
            addPane.setVisible(false);
        }
    }

    @FXML
    void modifierdb(MouseEvent event) {
        if(selected != null){
            int selectedIndex = inputcatmod.getSelectionModel().getSelectedIndex();
            Object selectedItem = inputcatmod.getSelectionModel().getSelectedItem();

            ProduitService ps = new ProduitService();
            Produit p;
            if(photoProduitmod != null)
                p = new Produit(selected.getId(),((Categorie)selectedItem).getId(),inputnommod.getText(),Float.parseFloat(inputprixmod.getText()),inputdescmod.getText(), Integer.parseInt(inputQtmod.getText()),photoProduitmod);
            else
                p = new Produit(selected.getId(),((Categorie)selectedItem).getId(),inputnommod.getText(),Float.parseFloat(inputprixmod.getText()),inputdescmod.getText(), Integer.parseInt(inputQtmod.getText()),selected.getImg(),true);

            if(ps.modifierProduit(p)){
                this.loadProduit(strrech.getText());
                inputnommod.setText("");
                inputdescmod.setText("");
                inputprixmod.setText("");
                inputQtmod.setText("");
                editPane.setVisible(false);
            }
        }
    }
	
    private void loadProduit(String rech){
       
       List<Produit> listProduit;
       ProduitService cs = new ProduitService();
        if(rech.isEmpty())
            listProduit = cs.listeProduitsBack();
        else
            listProduit = cs.listeProduitsRechBack(rech);
        
        System.out.println(listProduit.size());

        ObservableList<Produit> data = FXCollections.observableArrayList(listProduit);
        nomcat.setCellValueFactory(new PropertyValueFactory<>("nomcategorie"));
        nom.setCellValueFactory(new PropertyValueFactory<>("libelle"));   
        desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        qt.setCellValueFactory(new PropertyValueFactory<>("qt"));
        img.setCellValueFactory(new PropertyValueFactory<>("img"));
        tableoprod.setItems(data);

    }
    
    private void loadCategorie(){
       
        List<Categorie> listCategorie;
        CategorieService cs = new CategorieService();
        listCategorie = cs.listeCategorie();
        for (int i = 0; i < listCategorie.size(); i++) {
            inputcatadd.getItems().add(listCategorie.get(i));
            inputcatmod.getItems().add(listCategorie.get(i));
        }
        inputcatadd.getSelectionModel().selectFirst();
    }
    
    @FXML
    void uploadPhotoadd(MouseEvent event) {
    FileChooser file = new FileChooser(); //pour choisir la photo
        file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png", "*.bmp"));
        file.setTitle("Choisir une photo du produit");
        final Stage stage;
        stage = new Stage();
        stage.setTitle("File Chooser Sample");
        File selected_photo = file.showOpenDialog(stage);

        if (selected_photo != null) {
            if ((selected_photo.length() / 1024) / 1024 < 2.0) {
                photoProduitadd = selected_photo.getAbsolutePath();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Taile trop grande !");
                alert.setContentText("Veuillez choisir une photo de profil avec une taille < 2 Mo");
                alert.showAndWait();

            }
        }
    }
    @FXML
    void uploadPhotomod(MouseEvent event) {
    FileChooser file = new FileChooser(); //pour choisir la photo
        file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png", "*.bmp"));
        file.setTitle("Choisir une photo du produit");
        final Stage stage;
        stage = new Stage();
        stage.setTitle("File Chooser Sample");
        File selected_photo = file.showOpenDialog(stage);

        if (selected_photo != null) {
            if ((selected_photo.length() / 1024) / 1024 < 2.0) {
                photoProduitmod = selected_photo.getAbsolutePath();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Taile trop grande !");
                alert.setContentText("Veuillez choisir une photo de profil avec une taille < 2 Mo");
                alert.showAndWait();

            }
        }
    }
}
