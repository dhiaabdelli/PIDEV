/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author ASUS
 */
public class FxmlLoader {
    private Pane view;
    public Pane getPage(String filename){
        try{
            URL fileUrl = ElixirApp.class.getResource(filename+".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            view = FXMLLoader.load(fileUrl);
        }catch(Exception e){
            System.out.println("No page "+filename+" please check FxmlLoader");
            e.printStackTrace();
        }
        return view;
    }
}
