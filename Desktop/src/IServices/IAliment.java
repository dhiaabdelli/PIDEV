package IServices;

import java.util.List;
import Entities.aliment;

public interface IAliment{
    
    public boolean ajouterAliment(aliment p);
    
    public boolean supprimerAliment(String id);
    
    public boolean modifierAliment(aliment p);
    
    public aliment chercherAlimentParId(String id);
    
    public String getNextId();
    
    public List<aliment> listerAliments();
    
}
