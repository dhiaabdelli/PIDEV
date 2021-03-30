/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controllers.models;

import Entities.Panier;
import Entities.Produit;
import Services.EvaluationService;
import Services.PanierService;
import com.sun.speech.freetts.Voice;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import com.sun.speech.freetts.VoiceManager;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import Utils.Utils;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ShopitemController implements Initializable {

    @FXML
    private VBox addToCard;
    @FXML
    private Button btnaj;

    @FXML
    private VBox ItemInfo;

    @FXML
    private ImageView img;

    @FXML
    private Label title;

    @FXML
    private Label prix;

    @FXML
    private Label note;

    @FXML
    private Label title1;

    @FXML
    private TextField desc;

    @FXML
    private Label prix1;

    @FXML
    private Button back;

    @FXML
    private Label note1;

    private Produit pr;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addToCard.setVisible(true);
        ItemInfo.setVisible(false);
        btnaj.setVisible(true);

    }

    @FXML
    void backToCard(MouseEvent event) {
        addToCard.setVisible(true);
        ItemInfo.setVisible(false);
        System.out.println("testtttttttt");
    }

    @FXML
    void ajouterp(MouseEvent event) {
        PanierService ps = new PanierService();
        Panier p = new Panier(pr.getId(), "dfgfgdfgdfg", 1);

        if (ps.ajouterPanier(p)) {
            btnaj.setVisible(false);
            Utils.showTrayNotification(NotificationType.SUCCESS, "Informations", null, "Produit ajouter avec suc",null, 6000);
            Voice v;
            VoiceManager vm = VoiceManager.getInstance();
            v = vm.getVoice("kevin16");
            v.allocate();
            v.speak(p.getLibelle() + "added succefully");
        }
    }

    @FXML
    void iteminfo(MouseEvent event) {
        addToCard.setVisible(false);
        ItemInfo.setVisible(true);
    }

    public void setData(Produit pr, int id, String titletext, String prixtext, String imgurl) {
        this.pr = pr;
        title.setText(titletext);
        title1.setText(titletext);
        desc.setText(titletext);

        prix.setText(prixtext + " DT");
        prix1.setText(prixtext + " DT");
        Image image;
        if (imgurl.isEmpty()) {
            image = new Image(getClass().getResourceAsStream("../../views/resources/images/productNotFound.png"));
        } else if (getClass().getResourceAsStream(imgurl) == null) {
            image = new Image(getClass().getResourceAsStream("../../views/resources/images/productNotFound.png"));
        } else {
            image = new Image(getClass().getResourceAsStream(imgurl));
        }
        img.setImage(image);
        EvaluationService es = new EvaluationService();
        note.setText(Float.toString(es.NoteEvaluationParIdProduit(id)));
        note1.setText(Float.toString(es.NoteEvaluationParIdProduit(id)));
    }
}
