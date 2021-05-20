/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.Produit;
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
public class ProduitService {

    public ArrayList<Produit> produit;

    public static ProduitService instance = null;
    public boolean resultOK;
    private ConnectionRequest con;

    private ProduitService() {
        con = new ConnectionRequest();
    }

    public static ProduitService getInstance() {
        if (instance == null) {
            instance = new ProduitService();
        }
        return instance;
    }

    public ArrayList<Produit> getList() {
        ArrayList<Produit> listProduits = new ArrayList<>();
        String url = Statics.BASE_URL + "/json/produit";
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
                        Produit p = new Produit();
                        float id = Float.parseFloat(obj.get("id").toString());
                        float prix = Float.parseFloat(obj.get("prix").toString());
                        float Qt = Float.parseFloat(obj.get("qt").toString());
                        String libelle = obj.get("libelle").toString();
                        String description = obj.get("description").toString();
                        System.out.println("*********************************************");
                        System.out.println("id " + (int) id);
                        System.out.println("prix " + prix);
                        System.out.println("Qt " + (int) Qt);
                        System.out.println("libelle " + libelle);
                        System.out.println("description " + description);

                        List<Map<String, Object>> listrates = (List<Map<String, Object>>) obj.get("rates");
                        float total = 0;
                        int count = 0;
                        for (Map<String, Object> rate : listrates) {
                            float note = Float.parseFloat(rate.get("note").toString());
                            total += note;
                            count++;
                        }
                       
                        System.out.println("rates " + (int) (total / count));
                        System.out.println("*********************************************");
                        p.setId((int) id);
                        p.setQt((int) Qt);
                        p.setPrix(prix);
                        p.setLibelle(libelle);
                        p.setDescription(description);
                        p.setRating((int) (total / count));
                        listProduits.add(p);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listProduits);
        return listProduits;
    }

 
}
