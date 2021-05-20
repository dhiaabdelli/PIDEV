/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.aliment;
import util.Statics;
import java.util.ArrayList;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author moham
 */
public class AlimentService {

    public ArrayList<aliment> aliment;

    public static AlimentService instance = null;
    public boolean resultOK;
    private ConnectionRequest con;

    private AlimentService() {
        con = new ConnectionRequest();
    }

    public static AlimentService getInstance() {
        if (instance == null) {
            instance = new AlimentService();
        }
        return instance;
    }

    public ArrayList<aliment> getList() {
        ArrayList<aliment> listAliment = new ArrayList<>();
        String url = Statics.BASE_URL + "/json/alim";
        con.setUrl(url);
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();

                System.out.println(new String(con.getResponseData()));
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        aliment p = new aliment();
                        float id = Float.parseFloat(obj.get("id").toString());
                        String nom = obj.get("nom").toString();
                        float fats =Float.parseFloat(obj.get("fats").toString());
                        float carbs =Float.parseFloat(obj.get("carbs").toString());
                        float proteins = Float.parseFloat(obj.get("proteins").toString());
                        float calories = Float.parseFloat(obj.get("calories").toString());
                        float types = Float.parseFloat(obj.get("type").toString());
                       
                        System.out.println("*********************************************");
                        System.out.println("id " + (int) id);
                        System.out.println("nom " + nom);
                        System.out.println("fats " + (int)fats);
                        System.out.println("carbs " + (int)carbs);
                        System.out.println("proteins " + (int)proteins);
                        System.out.println("calories " + (int)calories);
                        System.out.println("type " + (int) types);
                        
                       
                      
                        System.out.println("*********************************************");
                        p.setId((int)id);
                        p.setNom(nom);
                        p.setFats((int)fats);
                        p.setCarbs((int)carbs);
                        p.setProteins((int)proteins);
                        p.setCalories((int)calories);
                        p.setType((int)types);
                        listAliment.add(p);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listAliment);
        return listAliment;
    }

 
}
