package Entities;

public class alimentAssocie{
    
    protected String idAliment;
    protected String idProfile;
    protected int qte;
    
    public alimentAssocie(){
    }
    
    public alimentAssocie(String idAliment, String idProfile, int qte){
        this.idAliment = idAliment;
        this.idProfile = idProfile;
        this.qte = qte;
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
    
    public String getIdAliment(){
        return idAliment;
    }
    
    public String getIdProfile(){
        return idProfile;
    }
    
    public int getQte(){
        return qte;
    }
    
    public String toString(){
        return "IdAliment : " + idAliment + "\nIdProfile : " + idProfile + "\nQte : " + qte;
    }
    
}
