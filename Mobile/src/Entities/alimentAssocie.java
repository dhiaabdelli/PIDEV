package Entities;

public class alimentAssocie{
    
    protected String idAliment;
    protected String idProfile;
    protected int qte;
    protected int repas;
    protected String nomAliment;
    protected String emailProfile;
    
    public alimentAssocie(){
    }
    
    public alimentAssocie(String idAliment, String idProfile, int qte, int repas){
        this.idAliment = idAliment;
        this.idProfile = idProfile;
        this.qte = qte;
        this.repas = repas;
    }
    
    public alimentAssocie(String idAliment, String idProfile, int qte, int repas, String nomAliment, String emailProfile){
        this.idAliment = idAliment;
        this.idProfile = idProfile;
        this.qte = qte;
        this.repas = repas;
        this.nomAliment = nomAliment;
        this.emailProfile = emailProfile;
    }
    
    public void setNomAliment(String nomAliment){
        this.nomAliment = nomAliment;
    }
    
     public String getNomAliment(){
        return nomAliment;
    }
     
    public void setEmailProfile(String emailProfile){
        this.emailProfile = emailProfile;
    }
    
     public String getEmailProfile(){
        return emailProfile;
    }

    public void setIdAliment(String idAliment){
        this.idAliment = idAliment;
    }
    
    public void setIdProfile(String idProfile){
        this.idProfile = idProfile;
    }
    
    public void setQte(int qte){
        this.qte = qte;
    }
    
    public void setRepas(int repas){
        this.repas = repas;
    }
    
    public String getIdAliment(){
        return idAliment;
    }
    
    public String getIdProfile(){
        return idProfile;
    }
    
    public int getQte(){
        return qte;
    }

    public int getRepas(){
        return repas;
    }
    
    @Override
    public String toString(){
        return "\nIdAliment : " + idAliment + "\nIdProfile : " + idProfile + "\nQte : " + qte +  "\nRepas : " + repas + "\n";
    }
    
}
