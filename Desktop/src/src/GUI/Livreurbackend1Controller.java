/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import com.github.plushaze.traynotification.notification.Notification;
import com.github.plushaze.traynotification.notification.Notifications;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import entities.Livreur;
import entities.MyListener;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.not;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
import javax.swing.text.Document;
import services.JavaMailUtil;
import services.LivreurCRUD;
import static services.LivreurCRUD.AfficheLivreurs;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class Livreurbackend1Controller implements Initializable {
    
    
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfNum;
    @FXML
    private FontAwesomeIcon btnInsert;
    @FXML
    private FontAwesomeIcon btnUpdate;
    @FXML
    private FontAwesomeIcon btnDelete;
    @FXML
    private TableView<Livreur> tvLivreur;
    @FXML
    private TableColumn<Livreur, String> colNom;
    @FXML
    private TableColumn<Livreur, String> colPrenom;
    @FXML
    private TableColumn<Livreur, Integer> colNum;
    
       private MyListener myListener;
       ObservableList<Livreur> ListLiv;
       
    List<Livreur> Livrs = new ArrayList<>();
    private int chosenid;
    @FXML
    private TextField searchbar;
  
    private String imageString;
    @FXML
    private ImageView img;
    @FXML
    private Button notif;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showLivreur();
        }   
    

    private void handleButtonAction(ActionEvent event) throws Exception {
               if(event.getSource()== btnInsert ){
        addLivreur();
       }else if (event.getSource() == btnUpdate){
         updateLivreur();
        }else if(event.getSource() == btnDelete){
            deleteLivreur();
        }
        
    }
    
    
       public void showLivreur(){
  ObservableList<Livreur> list = AfficheLivreurs();
 
//     colId.setCellValueFactory(new PropertyValueFactory<Livreur, Integer>("id"));
     colNom.setCellValueFactory(new PropertyValueFactory<Livreur, String>("Nom"));
     colPrenom.setCellValueFactory(new PropertyValueFactory<Livreur, String>("Prenom"));
     colNum.setCellValueFactory(new PropertyValueFactory<Livreur, Integer>("Num"));

     tvLivreur.setItems(list);
  

    }

        
        @FXML
    private void addLivreur() throws Exception {
                //1- SAVE PERSON IN DATABASE
        String rnom = tfNom.getText();
        String rprenom = tfPrenom.getText();
        String rnum = tfNum.getText();
        
        Livreur l = new Livreur(0, rnom, rprenom, Integer.parseInt(rnum),imageString);
        LivreurCRUD lcd = new LivreurCRUD();
        lcd.addLivreurs(l);
        showLivreur();

//        initEx();
    JavaMailUtil.sendMail("dorra.bouchaddekh@esprit.tn");
    

    }
    

    private void rafreche(MouseEvent event) {
        showLivreur();
    }


    @FXML
    private void updateLivreur() {
        String rnom = tfNom.getText();
        String rprenom = tfPrenom.getText();
        String rnum = tfNum.getText();
   
        Livreur l = new Livreur(tvLivreur.getSelectionModel().getSelectedItem().getId(), rnom, rprenom, Integer.parseInt(rnum),imageString);
        LivreurCRUD lcd = new LivreurCRUD();
        lcd.updateLivreurs(l);
        showLivreur();
    }

    @FXML
    private void deleteLivreur() {
        LivreurCRUD lcd = new LivreurCRUD();
        lcd.deleteLivreurs(tvLivreur.getSelectionModel().getSelectedItem().getId());
        showLivreur();
    }
       

 
    private void handleMouseAction(MouseEvent event) {
       Livreur livr =   tvLivreur.getSelectionModel().getSelectedItem();
       tfNom.setText(livr.getNom());
       tfPrenom.setText(livr.getPrenom());
       tfNum.setText("" +livr.getNum());
    }

    @FXML
    private void searchLi(KeyEvent event) {
        if (searchbar.getText().equals("")) {
            ListLiv = LivreurCRUD.AfficheLivreurs();
        } else {
            ListLiv = LivreurCRUD.rechLivreur(searchbar.getText());
        }
        
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colNum.setCellValueFactory(new PropertyValueFactory<>("num"));
 
        tvLivreur.setItems(ListLiv);
    }

    @FXML
    private void AjouterPhoto(ActionEvent event) {
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
    
    public Image generateImg(){
        Image img = new Image(tvLivreur.getSelectionModel().getSelectedItem().getImage());

        if (tvLivreur.getSelectionModel().getSelectedItem().getImage().equals(""))
            img.cancel();
        return img;
    }

    @FXML
    private void hez_lghadi(MouseEvent event) {
      

        tfNom.setText(tvLivreur.getSelectionModel().getSelectedItem().getNom());
        tfPrenom.setText(tvLivreur.getSelectionModel().getSelectedItem().getPrenom());
        tfNum.setText(String.valueOf(tvLivreur.getSelectionModel().getSelectedItem().getNum()));
        img.setImage(generateImg());
        imageString = tvLivreur.getSelectionModel().getSelectedItem().getImage();
    
    }
    /* @FXML
        
    private void exportPDF(ActionEvent event) {
        try {
            String file_name = ("Livreur.pdf");
            Document document = new Document() {};
            
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            
            document.open();
            
            
            
            Paragraph paraHeader1 = new Paragraph("TEST");
            document.add(paraHeader1);
            
            
            
            document.close();
            Desktop.getDesktop().open(new File(file_name));
        } catch (IOException ex) {
            Logger.getLogger(Livreurbackend1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/


 /*
  public void notification(String text) {
        Image img = new Image("images/tick_icon.png");
        Notification not = Notification
                .create()
                .title("Notification")
                .text("         " + text)
                .graphic(new ImageView(img))
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_LEFT);
        not.darkStyle();
        not.show();
        System.out.println(text);
    }*/
    @FXML
    private void notifbtn(ActionEvent event) {
    //    notification("Congratulation You delivred you package so well!");
    }

    



}
