package Entities;

public class aliment{
    
    protected String id;
    protected String nom;
    protected int fats;
    protected int carbs;
    protected int proteins;
    protected int calories;
    protected int type;
    
    public aliment(){
    }
       
    public aliment(String id, String nom, int fats, int carbs, int proteins, int calories, int type){
        this.id = id;
        this.nom = nom;
        this.fats = fats;
        this.carbs = carbs;
        this.proteins = proteins;
        this.calories = calories;
        this.type = type;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public void setFats(int fats){
        this.fats = fats;
    }
    
    public void setCarbs(int carbs){
        this.carbs = carbs;
    }
    
    public void setProteins(int proteins){
        this.proteins = proteins;
    }
    
    public void setCalories(int calories){
        this.calories = calories;
    }
    
    public void setType(int type){
        this.type = type;
    }
    
    public String getId(){
        return id;
    }
    
    public String getNom(){
        return nom;
    }
    
    public int getFats(){
        return fats;
    }
    
    public int getCarbs(){
        return carbs;
    }
    
    public int getProteins(){
        return proteins;
    }
    
    public int getCalories(){
        return calories;
    }
    
    public int getType(){
        return type;
    }
    
    @Override
    public String toString(){
        return "\nId : " + id + "\nNom : " + nom + "\nFats : " + fats + "\nCarbs : " + carbs + "\nProteins : " + proteins + "\nCalories : " + calories + "\nType : " + type + "\n";
    }
    
}
