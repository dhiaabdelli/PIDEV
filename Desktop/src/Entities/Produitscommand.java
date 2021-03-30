package Entities;


public class Produitscommand {
    protected int id;
    protected int idproduit;
    protected int qt;
    public Produitscommand(){
    }
    
    public Produitscommand(int id,int idproduit,int qt){
        this.id = id;
        this.idproduit = idproduit;
        this.qt = qt;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getIdproduit(){
        return this.idproduit;
    }
    
    public void setIdproduit(int idproduit){
        this.idproduit = idproduit;
    }
    
     public int getQT(){
        return this.qt;
    }
    
    public void setQT(int qt){
        this.qt = qt;
    }
   
}
