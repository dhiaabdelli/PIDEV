package Entities;

public class alimentAssocie{
    
    protected String idAliment;
    protected String idProfile;
    protected int qte;
    protected int num;
    
    public alimentAssocie(){
    }
    
    public alimentAssocie(String idAliment, String idProfile, int qte, int num){
        this.idAliment = idAliment;
        this.idProfile = idProfile;
        this.qte = qte;
        this.num = num;
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
    
    public void setNum(int num){
        this.num = num;
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
    
    public int getNum(){
        return num;
    }
    
    @Override
    public String toString(){
        return "\nIdAliment : " + idAliment + "\nIdProfile : " + idProfile + "\nQte : " + qte + "\nNum : " + num + "\n";
    }
    
}
