package Entities;

public class alimentAssocie{
    
    protected String idAliment;
    protected String idProfile;
    protected int qte;
    protected int repas;
    
    public alimentAssocie(){
    }
    
    public alimentAssocie(String idAliment, String idProfile, int qte, int repas){
        this.idAliment = idAliment;
        this.idProfile = idProfile;
        this.qte = qte;
        this.repas = repas;
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
