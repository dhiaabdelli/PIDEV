/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controllers;

import Presentation.controllers.models.ItemController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import entities.Exercice;
import entities.MyListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Services.ExerciceCRUD;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ExerciceController implements Initializable {

    double x, y;
    @FXML
    private TextField tflibelle;
    @FXML
    private TextField tfdescription;
    @FXML
    private FontAwesomeIcon btnajouterEx;
    @FXML
    private FontAwesomeIcon btnmodifierEx;
    @FXML
    private FontAwesomeIcon btnsupprimerEx;
    @FXML
    private TextField searchbar;
    @FXML
    private FontAwesomeIcon choose;
    @FXML
    private ImageView img;
    private String imageString;
    @FXML
    private ImageView imgchosen;
    @FXML
    private Label libchosen;
    @FXML
    private Label descchosen;
    @FXML
    private GridPane gridpane;

    private MyListener myListener;
    List<Exercice> EXs = new ArrayList<>();
    private int chosenid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Show();
    }

    public void hez_ghadi(Exercice ex) {
        chosenid = ex.getId();
        libchosen.setText(ex.getLibelle());
        descchosen.setText(ex.getDescription());
        System.out.println("////////////////////////////////");
        System.out.println(ex.getImage());
        System.out.println("////////////////////////////////");
        Image image = new Image(new File(ex.getImage()).toURI().toString());
        System.out.println(new File(ex.getImage()).toURI().toString());
        imgchosen.setImage(image);
        //////////
        tflibelle.setText(ex.getLibelle());
        tfdescription.setText(ex.getDescription());
        img.setImage(image);
        imageString = ex.getImage();
    }

    public void Show() {
        ExerciceCRUD ec = new ExerciceCRUD();
        gridpane.getChildren().clear();
        EXs = ec.AfficheEx();
        if (EXs.size() > 0) {
            hez_ghadi(EXs.stream().findFirst().get());
            myListener = new MyListener() {
                @Override
                public void onClickListener(Exercice ex) {
                    hez_ghadi(ex);
                }
            };
        }
        int column = 0;
        int row = 0;

        try {
            for (Exercice ex : EXs) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/models/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(ex, myListener);

                if (column == 3) {
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

                GridPane.setMargin(anchorPane, new Insets(30));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @FXML
    private void ajouterExercice(MouseEvent event) throws IOException {
        //1- SAVE PERSON IN DATABASE
        String rlibelle = tflibelle.getText();
        String rdescrption = tfdescription.getText();
        ExerciceCRUD ecd = new ExerciceCRUD();
        Exercice e = new Exercice(Integer.parseInt(ecd.getNextId()), rlibelle, rdescrption, imageString);
        ecd.addExercice(e);
        Show();

//        initEx();
    }

    @FXML
    private void searchEx(KeyEvent event) {
        ExerciceCRUD ec = new ExerciceCRUD();
        System.out.println("recherche");
        gridpane.getChildren().clear();
        if (searchbar.getText().equals("")) {
            EXs = ec.AfficheEx();
        } else {
            EXs = ec.SearchEx(searchbar.getText());
        }
        if (EXs.size() > 0) {
            hez_ghadi(EXs.stream().findFirst().get());
            myListener = new MyListener() {
                @Override
                public void onClickListener(Exercice ex) {
                    hez_ghadi(ex);
                }
            };
        }
        int column = 0;
        int row = 0;

        try {
            for (Exercice ex : EXs) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/models/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(ex, myListener);

                if (column == 3) {
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

                GridPane.setMargin(anchorPane, new Insets(30));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void modifierExercice(MouseEvent event) {
        String rlibelle = tflibelle.getText();
        String rdescrption = tfdescription.getText();
        Exercice e = new Exercice(chosenid, rlibelle, rdescrption, imageString);
        ExerciceCRUD ecd = new ExerciceCRUD();
        ecd.modifierExercice(e);
        Show();
    }

    @FXML
    private void SupprimerExercice(MouseEvent event) {
        ExerciceCRUD ecd = new ExerciceCRUD();
        ecd.supprimerExercice(chosenid);
        Show();
    }

    @FXML
    private void AjouterPhoto(MouseEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.bmp", "*.png", "*.jpg", "*.gif"));
        File file = chooser.showOpenDialog(new Stage());
        if (file != null) {
            String imagepath;
            try {
                imagepath = file.toURI().toURL().toString();

                System.out.println("file:" + imagepath);
                Image image = new Image(imagepath);
                System.out.println("height:" + image.getHeight() + "\nWidth:" + image.getWidth());
                img.setImage(image);
                imageString = imagepath;
                System.out.println(imageString);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ElixirAppController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Please Select a File");
            /*alert.setContentText("You didn't select a file!");*/
            alert.showAndWait();
        }
    }

    private void rafreche(MouseEvent event) {
        Show();
    }

}
