/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Panier;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import java.util.ArrayList;
import java.util.List;
import services.PanierService;
import services.ProduitService;

/**
 *
 * @author ASUS
 */
public class ViewPanier extends BaseForm {


    public ViewPanier() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    @Override
    protected boolean isCurrentPanier() {
        return true;
    }
    
    public ViewPanier(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Panier", "Title")
                       
                )
        );
        installSidemenu(resourceObjectInstance);
        
        
        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fab.addActionListener(e -> {
            new ViewPanier().show();
        });
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Panier");
        setName("Panier");
        ArrayList<Panier> listpanier;
        listpanier = PanierService.getInstance().getList();
        
        for (int i = 0; i < listpanier.size(); i++) {
            com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
            com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
            addComponent(gui_Container);
            gui_Container.setName("Container_1");
            gui_Container.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1);
            gui_Container.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_LA);
            gui_Multi_Button_1.setUIID("Label");
            gui_Multi_Button_1.setName("Multi_Button_1");
            gui_Multi_Button_1.setPropertyValue("line1", String.valueOf(listpanier.get(i).getLibelle()));
            gui_Multi_Button_1.setPropertyValue("line2", String.valueOf(listpanier.get(i).getEmail()));
            gui_Multi_Button_1.setPropertyValue("uiid1", "Label");
            gui_Multi_Button_1.setPropertyValue("uiid2", "RedLabel");
            gui_LA.setUIID("Label");
            gui_LA.setName("LA");
            gui_LA.setPropertyValue("line1", String.valueOf(listpanier.get(i).getQT()*listpanier.get(i).getPrix())+" DT");
            gui_LA.setPropertyValue("line2", "x"+String.valueOf(listpanier.get(i).getQT()));
            gui_LA.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
            gui_LA.setPropertyValue("uiid2", "RedLabelRight");
            System.out.println(i);
            gui_Multi_Button_1.addActionListener(e -> {
                    System.out.println("clikina aal mb");
                }
                );
        }
        
    }
}
