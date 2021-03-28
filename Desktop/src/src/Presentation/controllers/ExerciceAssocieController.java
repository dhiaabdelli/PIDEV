/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controllers;

import Presentation.controllers.models.ItemController;
import Presentation.controllers.models.JouritemController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import entities.Exercice;
import entities.ExerciceAssocie;
import entities.MyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import Services.ExerciceAssocieCRUD;
import Services.ExerciceCRUD;


/**
 * FXML Controller class
 *
 * @author dell
 */
public class ExerciceAssocieController implements Initializable {

    double x, y;
    @FXML
    private FontAwesomeIcon choose;
    @FXML
    private FontAwesomeIcon btnajouterEx;
    @FXML
    private FontAwesomeIcon btnmodifierEx;
    @FXML
    private FontAwesomeIcon btnsupprimerEx;
    @FXML
    private TextField searchbar;
    @FXML
    private ImageView imgchosen;
    @FXML
    private Label libchosen;
    @FXML
    private Label descchosen;
    @FXML
    private GridPane gridpane;
    @FXML
    private Label contnbseries;
    @FXML
    private Label contnbrepetition;
    @FXML
    private Label contjour;
    @FXML
    private ComboBox<String> tfcombobox;
    @FXML
    private TextField tfNbSeries;
    @FXML
    private TextField tfnbrepetition;
    @FXML
    private TextField tfjour;
    ObservableList<String> Libs = FXCollections.observableArrayList();
    List<ExerciceAssocie> EXassocierParJour = new ArrayList<>();
    List<Integer> Jours = new ArrayList<>();
    private MyListener myListener;
    int chosenid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setComboBox();
        Show();
    }

    private void min(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    private void max(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreenExitHint("");
        stage.setFullScreen(!stage.isFullScreen());
    }

    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    private void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    private void setComboBox() {
        ExerciceCRUD ec = new ExerciceCRUD();
        Libs = ec.getExLib();
        tfcombobox.setItems(Libs);
    }

    public void hez_ghadi(Exercice ex) {
        ExerciceCRUD ec = new ExerciceCRUD();
        //Exercice ex = ExerciceAssocieCRUD.getExParLib(exAssocier.getLibelleEx());
        ExerciceAssocie exA = ec.getExParLib(ex.getLibelle());
        chosenid = exA.getId();
        libchosen.setText(ex.getLibelle());
        contnbseries.setText(String.valueOf(exA.getNbSeries()));
        contnbrepetition.setText(String.valueOf(exA.getNbRepetitions()));
        contjour.setText(String.valueOf(exA.getJour()));
        descchosen.setText(ex.getDescription());
        Image image = new Image(ex.getImage());
        imgchosen.setImage(image);
        ////////////////////////////
        tfcombobox.setValue(ex.getLibelle());
        tfNbSeries.setText(String.valueOf(exA.getNbSeries()));
        tfnbrepetition.setText(String.valueOf(exA.getNbRepetitions()));
        tfjour.setText(String.valueOf(exA.getJour()));

    }

    public void Show() {
        ExerciceAssocieCRUD ea = new ExerciceAssocieCRUD();
        gridpane.getChildren().clear();
        myListener = new MyListener() {
            @Override
            public void onClickListener(Exercice ex) {
                hez_ghadi(ex);
            }
        };
        Jours = ea.getJours();
        int column = 0;
        int row = 0;

        try {
            for (int jour : Jours) {
                row++;
                column = 0;
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/models/jouritem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                JouritemController jourController = fxmlLoader.getController();
                jourController.setData(String.valueOf(jour));

                if (column == 1) {
                    column = 0;
                    row++;
                }

                gridpane.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                gridpane.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridpane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridpane.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridpane.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridpane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridpane.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(0));
                ////////////////////////////
                row++;
                column = 0;
                EXassocierParJour = ea.AfficheExAperday(jour);
                try {
                    for (ExerciceAssocie exA : EXassocierParJour) {
                        FXMLLoader fxmlLoader2 = new FXMLLoader();
                        fxmlLoader2.setLocation(getClass().getResource("../views/models/item.fxml"));
                        AnchorPane anchorPane2 = fxmlLoader2.load();

                        ItemController itemController = fxmlLoader2.getController();
                        itemController.setData(ea.getExParLib(exA.getLibelleEx()), myListener);

                        if (column == 3) {
                            column = 0;
                            row++;
                        }

                        gridpane.add(anchorPane2, column++, row); //(child,column,row)
                        //set grid width
                        gridpane.setMinWidth(Region.USE_COMPUTED_SIZE);
                        gridpane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                        gridpane.setMaxWidth(Region.USE_PREF_SIZE);

                        //set grid height
                        gridpane.setMinHeight(Region.USE_COMPUTED_SIZE);
                        gridpane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                        gridpane.setMaxHeight(Region.USE_PREF_SIZE);

                        GridPane.setMargin(anchorPane2, new Insets(30));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void ajouterExerciceAssocie(MouseEvent event) {
        String rlibelleEx = tfcombobox.getValue();
        String rnbseries = tfNbSeries.getText();
        String rnbrepetition = tfnbrepetition.getText();
        String rjour = tfjour.getText();
        ExerciceAssocie ea = new ExerciceAssocie(5, 5, rlibelleEx, Integer.parseInt(rnbseries), Integer.parseInt(rnbrepetition), Integer.parseInt(rjour));
        ExerciceAssocieCRUD eacd = new ExerciceAssocieCRUD();
        eacd.addExerciceAssocie(ea);
        Show();
    }

    @FXML
    private void modifierExerciceAssocie(MouseEvent event) {
        String rlibelleEx = tfcombobox.getValue();
        String rnbseries = tfNbSeries.getText();
        String rnbrepetition = tfnbrepetition.getText();
        String rjour = tfjour.getText();
        ExerciceAssocie ea = new ExerciceAssocie(chosenid, 5, rlibelleEx, Integer.parseInt(rnbseries), Integer.parseInt(rnbrepetition), Integer.parseInt(rjour));
        ExerciceAssocieCRUD eacd = new ExerciceAssocieCRUD();
        eacd.modifierExerciceAssocie(ea);
        Show();
    }

    @FXML
    private void SupprimerExerciceAssocie(MouseEvent event) {
        ExerciceAssocieCRUD eacd = new ExerciceAssocieCRUD();
        eacd.supprimerExerciceAssocie(chosenid);
        Show();
    }

    @FXML
    private void AjouterExercice(MouseEvent event) {
    }

    @FXML
    private void searchEx(KeyEvent event) {
    }
}


 