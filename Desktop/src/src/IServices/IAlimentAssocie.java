package IServices;

import java.util.List;
import Entities.alimentAssocie;

public interface IAlimentAssocie{
        
    public boolean ajouterAlimentAssocie(alimentAssocie p);
    
    public boolean supprimerAlimentAssocie(String idAliment, String idProfile);
    
    public boolean modifierAlimentAssocie(alimentAssocie p);
    
    public alimentAssocie chercherAlimentAssocieParId(String idAliment, String idProfile);
    
    public String getNextId();
    
    public List<alimentAssocie> listerAlimentsAssocies();
    
    public List<alimentAssocie> listerAlimentsAssociesParId(String idProfile);
 
    public void associerAliments(String idProfile);
    
}
