package Presentation.controllers.models;


import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class ProfileInfosController implements Initializable {

    @FXML
    private Text age;
    @FXML
    private Text poids;
    @FXML
    private Text taille;
    @FXML
    private Text objectif;
    @FXML
    private Text nbr;
    @FXML
    private Text n;
    @FXML
    private StackPane male;
    @FXML
    private StackPane female;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    public void setData(int age, float poids, float taille, int objectif, int nbRepas, int i, int sexe) {
        this.age.setText(String.valueOf(age));
        this.poids.setText(String.valueOf(poids));
        this.taille.setText(String.valueOf(taille));
        if(objectif == 0){
            this.objectif.setText("Prise de masse");
        }else{
            this.objectif.setText("Perte de poids");
        }
        nbr.setText(String.valueOf(nbRepas));
        n.setText(String.valueOf(i));
        if(sexe == 0){
            this.male.setVisible(true);
            this.female.setVisible(false);
        }else{
            this.female.setVisible(true);
            this.male.setVisible(false);
        }
    }
    
}
