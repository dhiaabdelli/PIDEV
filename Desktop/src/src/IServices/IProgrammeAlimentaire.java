package IServices;

import java.util.List;
import Entities.programmeAlimentaire;

public interface IProgrammeAlimentaire{
    
    public boolean ajouterProgrammeAlimentaire(programmeAlimentaire p);
    
    public boolean supprimerProgrammeAlimentaire(String idProfile);
    
    public boolean modifierProgrammeAlimentaire(programmeAlimentaire p);
    
    public programmeAlimentaire chercherProgrammeAlimentaireParId(String idProfile);
    
    public String getNextId();
    
    public List<programmeAlimentaire> listerProgrammesAlimentaires();
    
    public void calculerProgrammeAlimentaire(String idProfile);
    
}
