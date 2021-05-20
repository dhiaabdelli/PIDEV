package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 * Utility methods common to forms e.g. for binding the side menu
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {
    public void installSidemenu(Resources res) {
        Image selection = res.getImage("selection-in-sidemenu.png");

        Image trendingImage = null;
        if(isCurrentShop()) trendingImage = selection;
        
        Image panierImage = null;
        if(isCurrentPanier()) panierImage = selection;
        
        
        Image AlimImage = null;
        if(isCurrentAlim()) AlimImage = selection;
        
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        
        getToolbar().addCommandToSideMenu("Shop", trendingImage, e -> new ViewProduit(res).show());
        getToolbar().addCommandToSideMenu("Panier", panierImage, e -> new ViewPanier(res).show());
        getToolbar().addCommandToSideMenu("Aliment", AlimImage, e -> new ViewAliment(res).show());
        
        // spacer
        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
    }

        
    protected boolean isCurrentPanier() {
        return false;
    }
    
    protected boolean isCurrentShop() {
        return false;
    }

    protected boolean isCurrentAlim() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
}
