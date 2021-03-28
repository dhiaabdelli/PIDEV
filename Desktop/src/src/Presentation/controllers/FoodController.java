package Presentation.controllers;

import Entities.alimentAssocie;
import Services.ProgrammeAlimentaireService;
import Entities.programmeAlimentaire;
import Services.AlimentAssocieService;
import Services.AlimentService;
import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tooltip;
import static javafx.scene.control.Tooltip.install;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class FoodController implements Initializable {

    @FXML
    private Text bmr;
    @FXML
    private Text calrequis;
    @FXML
    private Text protrequis;
    @FXML
    private Text carbrequis;
    @FXML
    private Text fatrequis;
    @FXML
    private Pane r1;
    @FXML
    private Text r1a1;
    @FXML
    private Text r1a1g;
    @FXML
    private Text r1a2;
    @FXML
    private Text r1a2g;
    @FXML
    private Text r1a3;
    @FXML
    private Text r1a3g;
    @FXML
    private Pane r2;
    @FXML
    private Text r2a1;
    @FXML
    private Text r2a1g;
    @FXML
    private Text r2a2;
    @FXML
    private Text r2a2g;
    @FXML
    private Text r2a3;
    @FXML
    private Text r2a3g;
    @FXML
    private Pane r3;
    @FXML
    private Text r3a1;
    @FXML
    private Text r3a1g;
    @FXML
    private Text r3a2;
    @FXML
    private Text r3a2g;
    @FXML
    private Text r3a3;
    @FXML
    private Text r3a3g;
    @FXML
    private Pane r4;
    @FXML
    private Text r4a1;
    @FXML
    private Text r4a1g;
    @FXML
    private Text r4a2;
    @FXML
    private Text r4a2g;
    @FXML
    private Text r4a3;
    @FXML
    private Text r4a3g;
    @FXML
    private Pane r5;
    @FXML
    private Text r5a1;
    @FXML
    private Text r5a1g;
    @FXML
    private Text r5a2;
    @FXML
    private Text r5a2g;
    @FXML
    private Text r5a3;
    @FXML
    private Text r5a3g;
    @FXML
    private Text n1;
    @FXML
    private Text n2;
    @FXML
    private Text n3;
    @FXML
    private Text n4;
    @FXML
    private Text n5;
    @FXML
    private Pane r1a1t;
    @FXML
    private Pane r1a2t;
    @FXML
    private Pane r1a3t;
    @FXML
    private Pane r2a1t;
    @FXML
    private Pane r2a2t;
    @FXML
    private Pane r2a3t;
    @FXML
    private Pane r3a1t;
    @FXML
    private Pane r3a2t;
    @FXML
    private Pane r3a3t;
    @FXML
    private Pane r4a1t;
    @FXML
    private Pane r4a2t;
    @FXML
    private Pane r4a3t;
    @FXML
    private Pane r5a1t;
    @FXML
    private Pane r5a2t;
    @FXML
    private Pane r5a3t;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        String idProfile = "7";
        ProgrammeAlimentaireService pas = new ProgrammeAlimentaireService();
        AlimentAssocieService aas = new AlimentAssocieService();
        programmeAlimentaire p = pas.chercherProgrammeAlimentaireParId(idProfile);
        AlimentService as = new AlimentService();
        bmr.setText(Integer.toString(p.getBmr()));
        calrequis.setText(Integer.toString(p.getCalRequis()));
        protrequis.setText(Integer.toString(p.getProteinsRequis()));
        carbrequis.setText(Integer.toString(p.getCarbsRequis()));
        fatrequis.setText(Integer.toString(p.getFatsRequis()));
        List<alimentAssocie> listAS = aas.listerAlimentsAssociesParId(idProfile);
        List<Tooltip> alimentInfos = new ArrayList();
        for(int i = 0; i < 45; i++){
            Tooltip t = new Tooltip();
            t.setStyle(
                "-fx-hgap: 20px;\n" +
"    -fx-background-color: rgb(40, 40, 64);\n" +
"    -fx-background-radius: 15px;\n" +
"    -fx-border-radius: 15px;\n" +
"    -fx-border-width: 2px;\n" +
"    -fx-border-color: linear-gradient(from 25% 25% to 100% 100%, rgb(121, 99, 250), rgb(162, 78, 243));\n" +
"    -fx-font-size: 1.5em;\n" +
"    -fx-font-weight: bold;\n" +
"    -fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.2), 10, 0, 0, 0);\n" +
"    -fx-text-fill: linear-gradient(from 100% 100% to 25% 25%, rgb(121, 99, 250), rgb(162, 78, 243));");
            
            alimentInfos.add(t);
        }
        if(listAS.size() / 3 == 1){
            r1.setVisible(false);
            r2.setVisible(false);
            r4.setVisible(false);
            r5.setVisible(false);
            n3.setText(Integer.toString(listAS.get(0).getRepas()));
            r3a1g.setText(Integer.toString(listAS.get(0).getQte()));
            r3a2g.setText(Integer.toString(listAS.get(1).getQte()));
            r3a3g.setText(Integer.toString(listAS.get(2).getQte()));
            r3a1.setText(as.chercherAlimentParId(listAS.get(0).getIdAliment()).getNom());
            r3a2.setText(as.chercherAlimentParId(listAS.get(1).getIdAliment()).getNom());
            r3a3.setText(as.chercherAlimentParId(listAS.get(3).getIdAliment()).getNom());
            alimentInfos.get(0).setText("     " + r3a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r3a1t, alimentInfos.get(0));
            alimentInfos.get(1).setText("     " + r3a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r3a2t, alimentInfos.get(1));
            alimentInfos.get(2).setText("     " + r3a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r3a3t, alimentInfos.get(2));
        }
        if(listAS.size() / 3 == 2){
            r1.setVisible(false);
            r3.setVisible(false);
            r5.setVisible(false);
            n2.setText(Integer.toString(listAS.get(0).getRepas()));
            n4.setText(Integer.toString(listAS.get(3).getRepas()));
            r2a1g.setText(Integer.toString(listAS.get(0).getQte()));
            r2a2g.setText(Integer.toString(listAS.get(1).getQte()));
            r2a3g.setText(Integer.toString(listAS.get(2).getQte()));
            r4a1g.setText(Integer.toString(listAS.get(3).getQte()));
            r4a2g.setText(Integer.toString(listAS.get(4).getQte()));
            r4a3g.setText(Integer.toString(listAS.get(5).getQte()));
            r2a1.setText(as.chercherAlimentParId(listAS.get(0).getIdAliment()).getNom());
            r2a2.setText(as.chercherAlimentParId(listAS.get(1).getIdAliment()).getNom());
            r2a3.setText(as.chercherAlimentParId(listAS.get(3).getIdAliment()).getNom());
            r4a1.setText(as.chercherAlimentParId(listAS.get(4).getIdAliment()).getNom());
            r4a2.setText(as.chercherAlimentParId(listAS.get(5).getIdAliment()).getNom());
            r4a3.setText(as.chercherAlimentParId(listAS.get(6).getIdAliment()).getNom());
            alimentInfos.get(3).setText("     " + r2a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r2a1t, alimentInfos.get(3));
            alimentInfos.get(4).setText("     " + r2a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r2a2t, alimentInfos.get(4));
            alimentInfos.get(5).setText("     " + r2a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r2a3t, alimentInfos.get(5));
            alimentInfos.get(6).setText("     " + r4a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r4a1t, alimentInfos.get(6));
            alimentInfos.get(7).setText("     " + r4a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r4a2t, alimentInfos.get(7));
            alimentInfos.get(8).setText("     " + r4a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r4a3t, alimentInfos.get(8));
        }
        if(listAS.size() / 3 == 3){
            r1.setVisible(false);
            r5.setVisible(false);
            n2.setText(Integer.toString(listAS.get(0).getRepas()));
            n3.setText(Integer.toString(listAS.get(3).getRepas()));
            n4.setText(Integer.toString(listAS.get(6).getRepas()));
            r2a1g.setText(Integer.toString(listAS.get(0).getQte()));
            r2a2g.setText(Integer.toString(listAS.get(1).getQte()));
            r2a3g.setText(Integer.toString(listAS.get(2).getQte()));
            r3a1g.setText(Integer.toString(listAS.get(3).getQte()));
            r3a2g.setText(Integer.toString(listAS.get(4).getQte()));
            r3a3g.setText(Integer.toString(listAS.get(5).getQte()));
            r4a1g.setText(Integer.toString(listAS.get(6).getQte()));
            r4a2g.setText(Integer.toString(listAS.get(7).getQte()));
            r4a3g.setText(Integer.toString(listAS.get(8).getQte()));
            r2a1.setText(as.chercherAlimentParId(listAS.get(0).getIdAliment()).getNom());
            r2a2.setText(as.chercherAlimentParId(listAS.get(1).getIdAliment()).getNom());
            r2a3.setText(as.chercherAlimentParId(listAS.get(2).getIdAliment()).getNom());
            r3a1.setText(as.chercherAlimentParId(listAS.get(3).getIdAliment()).getNom());
            r3a2.setText(as.chercherAlimentParId(listAS.get(4).getIdAliment()).getNom());
            r3a3.setText(as.chercherAlimentParId(listAS.get(5).getIdAliment()).getNom());
            r4a1.setText(as.chercherAlimentParId(listAS.get(6).getIdAliment()).getNom());
            r4a2.setText(as.chercherAlimentParId(listAS.get(7).getIdAliment()).getNom());
            r4a3.setText(as.chercherAlimentParId(listAS.get(8).getIdAliment()).getNom()); 
            alimentInfos.get(9).setText("     " + r2a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r2a1t, alimentInfos.get(9));
            alimentInfos.get(10).setText("     " + r2a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r2a2t, alimentInfos.get(10));
            alimentInfos.get(11).setText("     " + r2a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r2a3t, alimentInfos.get(11));
            alimentInfos.get(12).setText("     " + r3a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r3a1t, alimentInfos.get(12));
            alimentInfos.get(13).setText("     " + r3a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r3a2t, alimentInfos.get(13));
            alimentInfos.get(14).setText("     " + r3a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r3a3t, alimentInfos.get(14));
            alimentInfos.get(15).setText("     " + r4a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(6).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(6).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(6).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(6).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r4a1t, alimentInfos.get(15));
            alimentInfos.get(16).setText("     " + r4a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(7).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(7).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(7).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(7).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r4a2t, alimentInfos.get(16));
            alimentInfos.get(17).setText("     " + r4a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(8).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(8).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(8).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(8).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r4a3t, alimentInfos.get(17));
        }
        if(listAS.size() / 3 == 4){
            r3.setVisible(false);
            n1.setText(Integer.toString(listAS.get(0).getRepas()));
            n2.setText(Integer.toString(listAS.get(3).getRepas()));
            n4.setText(Integer.toString(listAS.get(6).getRepas()));
            n5.setText(Integer.toString(listAS.get(9).getRepas()));
            r1a1g.setText(Integer.toString(listAS.get(0).getQte()));
            r1a2g.setText(Integer.toString(listAS.get(1).getQte()));
            r1a3g.setText(Integer.toString(listAS.get(2).getQte()));
            r2a1g.setText(Integer.toString(listAS.get(3).getQte()));
            r2a2g.setText(Integer.toString(listAS.get(4).getQte()));
            r2a3g.setText(Integer.toString(listAS.get(5).getQte()));
            r4a1g.setText(Integer.toString(listAS.get(6).getQte()));
            r4a2g.setText(Integer.toString(listAS.get(7).getQte()));
            r4a3g.setText(Integer.toString(listAS.get(8).getQte()));
            r5a1g.setText(Integer.toString(listAS.get(9).getQte()));
            r5a2g.setText(Integer.toString(listAS.get(10).getQte()));
            r5a3g.setText(Integer.toString(listAS.get(11).getQte()));
            r1a1.setText(as.chercherAlimentParId(listAS.get(0).getIdAliment()).getNom());
            r1a2.setText(as.chercherAlimentParId(listAS.get(1).getIdAliment()).getNom());
            r1a3.setText(as.chercherAlimentParId(listAS.get(2).getIdAliment()).getNom());
            r2a1.setText(as.chercherAlimentParId(listAS.get(3).getIdAliment()).getNom());
            r2a2.setText(as.chercherAlimentParId(listAS.get(4).getIdAliment()).getNom());
            r2a3.setText(as.chercherAlimentParId(listAS.get(5).getIdAliment()).getNom());
            r4a1.setText(as.chercherAlimentParId(listAS.get(6).getIdAliment()).getNom());
            r4a2.setText(as.chercherAlimentParId(listAS.get(7).getIdAliment()).getNom());
            r4a3.setText(as.chercherAlimentParId(listAS.get(8).getIdAliment()).getNom());
            r5a1.setText(as.chercherAlimentParId(listAS.get(9).getIdAliment()).getNom());
            r5a2.setText(as.chercherAlimentParId(listAS.get(10).getIdAliment()).getNom());
            r5a3.setText(as.chercherAlimentParId(listAS.get(11).getIdAliment()).getNom());
            alimentInfos.get(18).setText("     " + r1a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r1a1t, alimentInfos.get(18));
            alimentInfos.get(19).setText("     " + r1a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r1a2t, alimentInfos.get(19));
            alimentInfos.get(20).setText("     " + r1a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r1a3t, alimentInfos.get(20));
            alimentInfos.get(21).setText("     " + r2a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r2a1t, alimentInfos.get(21));
            alimentInfos.get(22).setText("     " + r2a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r2a2t, alimentInfos.get(22));
            alimentInfos.get(23).setText("     " + r2a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r2a3t, alimentInfos.get(23));
            alimentInfos.get(24).setText("     " + r4a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(6).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(6).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(6).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(6).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r4a1t, alimentInfos.get(24));
            alimentInfos.get(25).setText("     " + r4a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(7).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(7).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(7).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(7).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r4a2t, alimentInfos.get(25));
            alimentInfos.get(26).setText("     " + r4a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(8).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(8).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(8).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(8).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r4a3t, alimentInfos.get(26));
            alimentInfos.get(27).setText("     " + r5a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(9).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(9).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(9).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(9).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r5a1t, alimentInfos.get(27));
            alimentInfos.get(28).setText("     " + r5a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(10).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(10).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(10).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(10).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r5a2t, alimentInfos.get(28));
            alimentInfos.get(29).setText("     " + r5a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(11).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(11).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(11).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(11).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r5a3t, alimentInfos.get(29));
        }
        if(listAS.size() / 3 == 5){
            n1.setText(Integer.toString(listAS.get(0).getRepas()));
            n2.setText(Integer.toString(listAS.get(3).getRepas()));
            n3.setText(Integer.toString(listAS.get(6).getRepas()));
            n4.setText(Integer.toString(listAS.get(9).getRepas()));
            n5.setText(Integer.toString(listAS.get(12).getRepas()));
            r1a1g.setText(Integer.toString(listAS.get(0).getQte()));
            r1a2g.setText(Integer.toString(listAS.get(1).getQte()));
            r1a3g.setText(Integer.toString(listAS.get(2).getQte()));
            r2a1g.setText(Integer.toString(listAS.get(3).getQte()));
            r2a2g.setText(Integer.toString(listAS.get(4).getQte()));
            r2a3g.setText(Integer.toString(listAS.get(5).getQte()));
            r3a1g.setText(Integer.toString(listAS.get(6).getQte()));
            r3a2g.setText(Integer.toString(listAS.get(7).getQte()));
            r3a3g.setText(Integer.toString(listAS.get(8).getQte()));
            r4a1g.setText(Integer.toString(listAS.get(9).getQte()));
            r4a2g.setText(Integer.toString(listAS.get(10).getQte()));
            r4a3g.setText(Integer.toString(listAS.get(11).getQte()));
            r5a1g.setText(Integer.toString(listAS.get(12).getQte()));
            r5a2g.setText(Integer.toString(listAS.get(13).getQte()));
            r5a3g.setText(Integer.toString(listAS.get(14).getQte()));
            r1a1.setText(as.chercherAlimentParId(listAS.get(0).getIdAliment()).getNom());
            r1a2.setText(as.chercherAlimentParId(listAS.get(1).getIdAliment()).getNom());
            r1a3.setText(as.chercherAlimentParId(listAS.get(2).getIdAliment()).getNom());
            r2a1.setText(as.chercherAlimentParId(listAS.get(3).getIdAliment()).getNom());
            r2a2.setText(as.chercherAlimentParId(listAS.get(4).getIdAliment()).getNom());
            r2a3.setText(as.chercherAlimentParId(listAS.get(5).getIdAliment()).getNom());
            r3a1.setText(as.chercherAlimentParId(listAS.get(6).getIdAliment()).getNom());
            r3a2.setText(as.chercherAlimentParId(listAS.get(7).getIdAliment()).getNom());
            r3a3.setText(as.chercherAlimentParId(listAS.get(8).getIdAliment()).getNom());
            r4a1.setText(as.chercherAlimentParId(listAS.get(9).getIdAliment()).getNom());
            r4a2.setText(as.chercherAlimentParId(listAS.get(10).getIdAliment()).getNom());
            r4a3.setText(as.chercherAlimentParId(listAS.get(11).getIdAliment()).getNom());
            r5a1.setText(as.chercherAlimentParId(listAS.get(12).getIdAliment()).getNom());
            r5a2.setText(as.chercherAlimentParId(listAS.get(13).getIdAliment()).getNom());
            r5a3.setText(as.chercherAlimentParId(listAS.get(14).getIdAliment()).getNom());
            alimentInfos.get(30).setText("     " + r1a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(0).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r1a1t, alimentInfos.get(30));
            alimentInfos.get(31).setText("     " + r1a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getProteins()
                + "g\n Glucides :     -" + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(1).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r1a2t, alimentInfos.get(31));
            alimentInfos.get(32).setText("     " + r1a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(2).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r1a3t, alimentInfos.get(32));
            alimentInfos.get(33).setText("     " + r2a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(3).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r2a1t, alimentInfos.get(33));
            alimentInfos.get(34).setText("     " + r2a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(4).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r2a2t, alimentInfos.get(34));
            alimentInfos.get(35).setText("     " + r2a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(5).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r2a3t, alimentInfos.get(35));
            alimentInfos.get(36).setText("     " + r3a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(6).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(6).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(6).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(6).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r3a1t, alimentInfos.get(36));
            alimentInfos.get(37).setText("     " + r3a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(7).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(7).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(7).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(7).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r3a2t, alimentInfos.get(37));
            alimentInfos.get(38).setText("     " + r3a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(8).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(8).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(8).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(8).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r3a3t, alimentInfos.get(38));
            alimentInfos.get(39).setText("     " + r4a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(9).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(9).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(9).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(9).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r4a1t, alimentInfos.get(39));
            alimentInfos.get(40).setText("     " + r4a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(10).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(10).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(10).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(10).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r4a2t, alimentInfos.get(40));
            alimentInfos.get(41).setText("     " + r4a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(11).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(11).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(11).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(11).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r4a3t, alimentInfos.get(41));
            alimentInfos.get(42).setText("     " + r5a1.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(12).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(12).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(12).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(12).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r5a1t, alimentInfos.get(42));
            alimentInfos.get(43).setText("     " + r5a2.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(13).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(13).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(13).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(13).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r5a2t, alimentInfos.get(43));
            alimentInfos.get(44).setText("     " + r5a3.getText() + "\n\n Proteines :    " + as.chercherAlimentParId(listAS.get(14).getIdAliment()).getProteins()
                + "g\n Glucides :     " + as.chercherAlimentParId(listAS.get(14).getIdAliment()).getCarbs() + "g\n Lipides :      " + as.chercherAlimentParId(listAS.get(14).getIdAliment()).getFats()
                + "g\n Calories :     " + as.chercherAlimentParId(listAS.get(14).getIdAliment()).getCalories() + "\n\n                (/100g)"
            );
            install(r5a3t, alimentInfos.get(44));
        }
    }    

    @FXML
    private void r2a1p(MouseEvent event) throws Exception{
        String pName = r2a1.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }

    @FXML
    private void r2a2p(MouseEvent event) throws Exception{
        String pName = r2a2.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }

    @FXML
    private void r1a1p(MouseEvent event) throws Exception{
        String pName = r1a1.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName)); 
    }

    @FXML
    private void r1a2p(MouseEvent event) throws Exception{
        String pName = r1a2.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }

    @FXML
    private void r1a3p(MouseEvent event) throws Exception{
        String pName = r1a3.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }

    @FXML
    private void r2a3p(MouseEvent event) throws Exception{
        String pName = r2a3.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }

    @FXML
    private void r3a1p(MouseEvent event) throws Exception{
        String pName = r3a1.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }

    @FXML
    private void r3a2p(MouseEvent event) throws Exception{
        String pName = r3a2.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }

    @FXML
    private void r3a3p(MouseEvent event) throws Exception{
        String pName = r3a3.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }

    @FXML
    private void r4a1p(MouseEvent event) throws Exception{
        String pName = r4a1.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }

    @FXML
    private void r4a2p(MouseEvent event) throws Exception{
        String pName = r4a2.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }

    @FXML
    private void r4a3p(MouseEvent event) throws Exception{
        String pName = r4a3.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }

    @FXML
    private void r5a1p(MouseEvent event) throws Exception{
        String pName = r5a1.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }

    @FXML
    private void r5a2p(MouseEvent event) throws Exception{
        String pName = r5a2.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }

    @FXML
    private void r5a3p(MouseEvent event) throws Exception{
        String pName = r5a3.getText().replaceAll("\\s", "+");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.google.com/search?q=" + pName));
    }
    
}
