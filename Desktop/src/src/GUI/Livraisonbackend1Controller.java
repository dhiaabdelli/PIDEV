/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import com.jfoenix.controls.JFXComboBox;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import entities.Livraison;
import entities.Livreur;
import entities.MyListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.LivreurCRUD;
import static services.LivreurCRUD.AfficheLivreurs;
import services.LivraisonCRUD;
import static services.LivraisonCRUD.AfficheLivraisons;
/**
 * FXML Controller class
 *
 * @author dorra
 */
public class Livraisonbackend1Controller implements Initializable {
    
    ObservableList<String> Libs = FXCollections.observableArrayList();
    
    @FXML
    private JFXComboBox cbNomLivreur;
    ObservableList<String> NomLivreur;
    ObservableList<String> Nom;
    ObservableList<Livraison> dataList;
    private TextField tfetat;
    private TextField tfNC;
    @FXML
    private TextField tfDate;

      private void setComboBox() {
        Libs = LivraisonCRUD.getLivNom();
        cbNomLivreur.setItems(Libs);
        
    }
    
    

    @FXML
    private TableColumn<Livraison, Integer> colidLivraison;
    @FXML
    private TableColumn<Livraison, Integer> colidLivreur;
    @FXML
    private TableColumn<Livraison, Integer> colidPanier;
    @FXML
    private TextField searchbar;
    @FXML
    private FontAwesomeIcon btnInsert;
    @FXML
    private FontAwesomeIcon btnUpdate;
    @FXML
    private FontAwesomeIcon btnDelete;
    @FXML
    private TableView<Livraison> tvLivraison;
    @FXML
    private TableColumn<Livraison, Integer> colreference;
    @FXML
    private TableColumn<Livraison, String> colDL;
    @FXML
    private TableColumn<Livraison, String> colNomLivreur;
    @FXML
    private TableColumn<Livraison, String> colEtat;
    @FXML
    private TableColumn<Livraison, String> colNC;
    @FXML
    private TextField tfreference;
    
    private MyListener myListener;
    ObservableList<Livreur> ListLiv;
       
    List<Livreur> Livrs = new ArrayList<>();

    @FXML
    private JFXComboBox cbEtat;
    @FXML
    private JFXComboBox cbNomClient;

    @FXML
    private DatePicker datebirthS;
    

        private void handleButtonAction(ActionEvent event) {
        if(event.getSource()== btnInsert ){
     addLivraison();
    }else if (event.getSource() == btnUpdate){
            updateLivraison();
    }else if(event.getSource() == btnDelete){
            deleteLivraison();
    }
    }


    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setComboBox();
        showLivraison();
    }    

    
       
       public void showLivraison(){
  ObservableList<Livraison> list = AfficheLivraisons();
 
//     colId.setCellValueFactory(new PropertyValueFactory<Livreur, Integer>("id"));
     colreference.setCellValueFactory(new PropertyValueFactory<Livraison, Integer>("reference"));
     colDL.setCellValueFactory(new PropertyValueFactory<Livraison, String>("dateLivraison"));
     colNomLivreur.setCellValueFactory(new PropertyValueFactory<Livraison, String>("nomLivreur"));
     colEtat.setCellValueFactory(new PropertyValueFactory<Livraison, String>("etat"));
     colNC.setCellValueFactory(new PropertyValueFactory<Livraison, String>("nomClient"));

     tvLivraison.setItems(list);
  

    }
       
         
        
    
    
    @FXML
    private void handleMouseAction(MouseEvent event) {
       Livraison livr =   tvLivraison.getSelectionModel().getSelectedItem();
       tfreference.setText("" +livr.getReference());
      
    }

    @FXML
    private void searchLivraison(KeyEvent event) {
    }

    @FXML
    private void addLivraison() {
      

        //1- SAVE PERSON IN DATABASE
        String rreference = tfreference.getText();
        String rdateLivraison = datebirthS.getValue().format(DateTimeFormatter.ISO_DATE);
        String rnomLivreur = (String) cbNomLivreur.getSelectionModel().getSelectedItem();
        String retat = tfetat.getText();
        String rnomClient = tfNC.getText();
        Livraison l = new Livraison(0,Integer.parseInt(rreference), rdateLivraison, rnomLivreur,retat,rnomClient);
        LivraisonCRUD lcd = new LivraisonCRUD();
        lcd.addLivraisons(l);
        showLivraison();
       

//        initEx();
    }

    @FXML
    private void updateLivraison() {
String rreference = tfreference.getText();
        String rdateLivraison = datebirthS.getValue().format(DateTimeFormatter.ISO_DATE);
        String rnomLivreur = (String) cbNomLivreur.getSelectionModel().getSelectedItem();
        String retat = tfetat.getText();
        String rnomClient = tfNC.getText();
        System.out.println(rdateLivraison);
        Livraison l = new Livraison(tvLivraison.getSelectionModel().getSelectedItem().getIdLivraison(),Integer.parseInt(rreference), rdateLivraison , rnomLivreur, retat, rnomClient);
        LivraisonCRUD lcd = new LivraisonCRUD();
        lcd.updateLivraisons(l);
        showLivraison();
    }

    @FXML
    private void deleteLivraison() {
           LivraisonCRUD lcd = new LivraisonCRUD();
        lcd.deleteLivraisons(tvLivraison.getSelectionModel().getSelectedItem().getIdLivraison());
        showLivraison();
    }


    
}
