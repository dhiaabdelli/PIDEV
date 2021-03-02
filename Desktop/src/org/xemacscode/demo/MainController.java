/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xemacscode.demo;

import java.net.URL;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import javafx.scene.input.MouseEvent;


/**
 *
 * @author dorra
 */
public class MainController implements Initializable {
    
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfNum;
    @FXML
    private TableView<Livreur> tvLivreur;
    @FXML
    private TableColumn<Livreur, Integer> colId;
    @FXML
    private TableColumn<Livreur, String> colNom;
    @FXML
    private TableColumn<Livreur, String> colPrenom;
    @FXML
    private TableColumn<Livreur, Integer> colNum;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    
   
    @FXML
    private void handleButtonAction(ActionEvent event) {
       if(event.getSource()== btnInsert ){
        insertLivreur();
       }else if (event.getSource() == btnUpdate){
         updateLivreur();
        }else if(event.getSource() == btnDelete){
            deleteButton();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showLivreur();
    }

    
    public Connection getConnection(){
       Connection conn ;
     try {
         conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/elixir","root", "");
         return conn;
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
     public ObservableList<Livreur> getLivreurList(){
         ObservableList<Livreur> livreurList = FXCollections.observableArrayList();
         Connection conn = getConnection();
         String query = "SELECT * FROM livreur";
         Statement st;
         ResultSet rs;
            try{
               st = conn.createStatement(); 
                rs = st.executeQuery(query);
                Livreur livreur;
                while(rs.next()){
                    livreur = new Livreur( rs.getInt("id") , rs.getString("Nom"), rs.getString("Prenom"), rs.getInt("Num"));
                    livreurList.add(livreur);
                }
     
        }catch(Exception ex){
            ex.printStackTrace();
        }
            return livreurList;
     }

public void showLivreur(){
     ObservableList<Livreur> list = getLivreurList();
     
     colId.setCellValueFactory(new PropertyValueFactory<Livreur, Integer>("id"));
     colNom.setCellValueFactory(new PropertyValueFactory<Livreur, String>("Nom"));
     colPrenom.setCellValueFactory(new PropertyValueFactory<Livreur, String>("Prenom"));
     colNum.setCellValueFactory(new PropertyValueFactory<Livreur, Integer>("Num"));

     tvLivreur.setItems(list);

    }

private void insertLivreur(){
    String query = "INSERT INTO livreur VALUES (" + tfId.getText() + ",'" + tfNom.getText()+ "','" + tfPrenom.getText() + "'," + tfNum.getText() + ")" ;
    executeQuery(query);
    showLivreur();
}
    
private void updateLivreur(){
    String query = "UPDATE livreur SET Nom = '" + tfNom.getText() + "', Prenom = '" + tfPrenom.getText() + "' , Num = " + tfNum.getText() + " WHERE id = " + tfId.getText() + "";
    executeQuery(query);
    showLivreur();
}

    private void deleteButton(){
        String query = "DELETE FROM livreur WHERE id =" + tfId.getText() + "";
        executeQuery(query);
        showLivreur();
    }

private void executeQuery(String query){
    Connection conn = getConnection();
    Statement st;
    try{
        st = conn.createStatement();
        st.executeUpdate(query);
    }catch(Exception ex ){
        ex.printStackTrace();
    }
}

    @FXML
    private void handleMouseAction(MouseEvent event) {
       Livreur livr =   tvLivreur.getSelectionModel().getSelectedItem();
       tfId.setText("" +livr.getId());
       tfNom.setText(livr.getNom());
       tfPrenom.setText(livr.getPrenom());
       tfNum.setText("" +livr.getNum());
    }
  

   }

