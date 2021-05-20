/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.Panier;
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
public class PanierService {

    public ArrayList<Panier> commande;

    public static PanierService instance = null;
    public boolean resultOK;
    private ConnectionRequest con;

    private PanierService() {
        con = new ConnectionRequest();
    }

    public static PanierService getInstance() {
        if (instance == null) {
            instance = new PanierService();
        }
        return instance;
    }

    public ArrayList<Panier> getList() {
        ArrayList<Panier> listPaniers = new ArrayList<>();
        String url = Statics.BASE_URL + "/json/panier";
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
                        Panier p = new Panier();
                        float qt = Float.parseFloat(obj.get("qt").toString());
                        Map<String, Object> map5 = new HashMap<>();
                        map5 = (Map<String, Object>) obj.get("idproduit");
                        
                        Map<String, Object> map1 = new HashMap<>();
                        map1 = (Map<String, Object>) obj.get("email");
                        
                        float idproduit = Float.parseFloat(map5.get("id").toString());
                        String libelle = map5.get("libelle").toString();
                        float prix = Float.parseFloat(map5.get("prix").toString());
                        
                        String email = map1.get("email").toString();
                        System.out.println("*********************************************");
                        System.out.println("idproduit " + idproduit);
                        System.out.println("libelle " + libelle);
                        System.out.println("prix " + prix);
                        System.out.println("Qt " + (int) qt);
                        System.out.println("email " + email);
                        System.out.println("*********************************************");
                        p.setIdproduit((int)idproduit);
                        p.setLibelle(libelle);
                        p.setPrix(prix);
                        p.setQT((int)qt);
                        p.setEmail(email);
                        listPaniers.add(p);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listPaniers);
        return listPaniers;
    }

 
}
