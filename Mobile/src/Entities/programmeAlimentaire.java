package Entities;

public class programmeAlimentaire{
    
    protected String idProfile;
    protected int bmr;
    protected int calRequis;
    protected int fatsRequis;
    protected int carbsRequis;
    protected int proteinsRequis;
    protected String emailProfile;
    
    public programmeAlimentaire(){
    }
       
    public programmeAlimentaire(String idProfile, int bmr, int calRequis, int fatsRequis, int carbsRequis, int proteinsRequis){
        this.idProfile = idProfile;
        this.bmr = bmr;
        this.calRequis = calRequis;
        this.fatsRequis = fatsRequis;
        this.carbsRequis = carbsRequis;
        this.proteinsRequis = proteinsRequis;
    }
    
    public programmeAlimentaire(String idProfile, int bmr, int calRequis, int fatsRequis, int carbsRequis, int proteinsRequis, String emailProfile){
        this.idProfile = idProfile;
        this.bmr = bmr;
        this.calRequis = calRequis;
        this.fatsRequis = fatsRequis;
        this.carbsRequis = carbsRequis;
        this.proteinsRequis = proteinsRequis;
        this.emailProfile = emailProfile;
    }
    
    public void setEmailProfile(String emailProfile){
            this.emailProfile = emailProfile;
    }
    
    public String getEmailProfile(){
        return emailProfile;
    }
    
    public void setIdProfile(String idProfile){
        this.idProfile= idProfile;
    }
    
    public void setBmr(int bmr){
        this.bmr = bmr;
    }
    
    public void setCalRequis(int calRequis){
        this.calRequis = calRequis;
    }
    
    public void setFatsRequis(int fatsRequis){
        this.fatsRequis = fatsRequis;
    }
    
    public void setCarbsRequis(int carbsRequis){
        this.carbsRequis = carbsRequis;
    }
    
    public void setProteinsRequis(int proteinsRequis){
        this.proteinsRequis = proteinsRequis;
    }
    
    public String getIdProfile(){
        return idProfile;
    }
    
    public int getBmr(){
        return bmr;
    }
    
    public int getCalRequis(){
        return calRequis;
    }
    
    public int getFatsRequis(){
        return fatsRequis;
    }
    
    public int getCarbsRequis(){
        return carbsRequis;
    }
    
    public int getProteinsRequis(){
        return proteinsRequis;
    }
    
    @Override
    public String toString(){
        return "\n" + "\nIdProfile : " + idProfile + "\nBMR : " + bmr + "\nCalRequis : " + calRequis + "\nFatsRequis : " + fatsRequis + "\nCarbsRequis : " + carbsRequis + "\nProteinsRequis : " + proteinsRequis + "\n";
    }
    
}
