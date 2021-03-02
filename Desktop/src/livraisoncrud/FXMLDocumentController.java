/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraisoncrud;
import Model.Conexion;
import static Model.Conexion.getConnection;
import static Model.Conexion.getLivraisonList;
import Model.Livraison;
import com.jfoenix.controls.JFXComboBox;
//import com.mysql.cj.conf.IntegerProperty;
//import com.sun.jndi.ldap.Connection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author dorra
 */
public class FXMLDocumentController implements Initializable {
    
@FXML
private JFXComboBox cb_id;
    ObservableList<Integer> id;
    ObservableList<Integer> idLivraison;
    //ObservableList<Livraison> listR;
    ObservableList<Livraison> dataList;
     // int index = -1;

        public void executeQuery(String query){
    Connection conn = getConnection();
    Statement st;
    try{
        st = conn.createStatement();
        st.executeUpdate(query);
    }catch(Exception ex ){
        ex.printStackTrace();
    }
}
   

    
   // ObservableList<Livraison> list = GetIdLivraison();
   
    @FXML
    private Label label;
    @FXML
    private TextField tf_idLivraison;
    @FXML
    private TableView<Livraison> tv_Livraison;
    @FXML
    private TableColumn<Livraison, Integer> col_idLivraison;
    @FXML
    private TableColumn<Livraison, Integer> col_idLivreur;
    @FXML
    private TextField tf_idPanier;
    @FXML
    private TextField tf_etat;
    @FXML
    private TextField tf_NC;
    @FXML
    private TableColumn<Livraison, Integer> col_idPanier;
    @FXML
    private TableColumn<Livraison, Integer> col_Etat;
    @FXML
    private TableColumn<Livraison, String> col_NC;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField filterField;
    
    /* @FXML
    void getSelected (MouseEvent event){
    index = tv_Livraison.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    tf_idLivraison.setText(col_idLivraison.getCellData(index).toString());
    tf_idPanier.setText(col_idPanier.getCellData(index).toString());
    label.setText(col_idLivreur.getCellData(index).toString());
    tf_etat.setText(col_Etat.getCellData(index).toString());
    tf_NC.setText(col_NC.getCellData(index));
    
    }*/

    
   @FXML
    private void handleButtonAction(ActionEvent event) {
          if(event.getSource()== btnInsert ){
        insertLivraison();
       }else if (event.getSource() == btnUpdate){
         updateLivraison();
        }else if(event.getSource() == btnDelete){
            deleteButton();
        }
    }
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id = FXCollections.observableArrayList();
        Livraison.GetId(Conexion.getConnection(), id);
        cb_id.setItems(id); 
        showLivraison();

    }    
    

        public ObservableList<Livraison> getLivraisonList(){
         ObservableList<Livraison> livraisonList = FXCollections.observableArrayList();
         java.sql.Connection connection = getConnection();
     
        String query = "SELECT a.idLivraison, a.idPanier, b.id, a.etat, a.nomClient \n" +
"FROM livraison a, livreur b\n" +
"WHERE b.id = a.idLivreur ";
      
       
            try{
              Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(query);
                Livraison livraison;
                while(res.next()){
  livraison = new Livraison( res.getInt("idLivraison"),res.getInt("idPanier"), res.getInt("id"),  res.getInt("etat"), res.getString("nomClient"));
                livraisonList.add(livraison);
                }
     
        }catch(Exception ex){
            ex.printStackTrace();
        }
            return livraisonList;
     }
        
        public void showLivraison(){
            ObservableList<Livraison> list = getLivraisonList();
            
            col_idLivraison.setCellValueFactory(new PropertyValueFactory<Livraison, Integer>("idLivraison"));
            col_idPanier.setCellValueFactory(new PropertyValueFactory<Livraison, Integer>("idPanier"));
            col_idLivreur.setCellValueFactory(new PropertyValueFactory<Livraison, Integer>("id"));
            col_Etat.setCellValueFactory(new PropertyValueFactory<Livraison, Integer>("etat"));
            col_NC.setCellValueFactory(new PropertyValueFactory<Livraison, String>("nomClient"));
            
            tv_Livraison.setItems(list);


        }


             @FXML
    void Select(ActionEvent event) {
        Integer i = (Integer) cb_id.getSelectionModel().getSelectedItem();
        String s=String.valueOf(i);
        label.setText(s);
    }      
           
        
        
        
    private void insertLivraison(){
    String query = "INSERT INTO livraison VALUES (" + tf_idLivraison.getText() + "," + tf_idPanier.getText()+ "," + label.getText() + "," + tf_etat.getText() + ",'" + tf_NC.getText() + "')" ;
    executeQuery(query);
    showLivraison();
}
        
        
private void updateLivraison(){
    String query = "UPDATE livraison SET idPanier = " + tf_idPanier.getText() + ", idLivreur = '" + label.getText() + "' , etat = " + tf_etat.getText() + ", NomClient = '" + tf_NC.getText() + "' WHERE idLivraison = " + tf_idLivraison.getText() + "";
    executeQuery(query);
    showLivraison();
}    
        
    private void deleteButton(){
        String query = "DELETE FROM livraison WHERE idLivraison =" + tf_idLivraison.getText() + "";
        executeQuery(query);
        showLivraison();
    }

        
     
    
  
        
     @FXML
    private void handleMouseAction(MouseEvent event) {
       Livraison livr =   tv_Livraison.getSelectionModel().getSelectedItem();
       tf_idLivraison.setText("" +livr.getIdLivraison());
       tf_idPanier.setText("" +livr.getIdPanier());
       label.setText("" +livr.getId());
       tf_etat.setText("" +livr.getEtat());
       tf_NC.setText(livr.getNomClient());
    }


    public Livraison chercherLivraisonParID(int id) {
        Livraison livraison = null;
        try {
              Statement statement = Conexion.createStatement();
           
            ResultSet res = statement.executeQuery("SELECT * FROM Livraison WHERE idLivraison = " + idLivraison);

            if (res.first()) {

                livraison = new Livraison( res.getInt("idLivraison"),res.getInt("idPanier"), res.getInt("id"),  res.getInt("etat"), res.getString("nomClient"));
                return livraison;
            }
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }
        return livraison;
    }
        

}
    
