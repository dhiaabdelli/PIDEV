
package Entities;


public class Panier {
    protected int idproduit;
    protected String email;
    protected int qt;
    
    protected String libelle;
    protected float prix;
    protected String description;
    protected String img;
    public Panier(){
    }
    
    public Panier(int idproduit,String email,int qt){
        this.idproduit = idproduit;
        this.email = email;
        this.qt = qt;
    }
    
    public Panier(int idproduit,String email,int qt,String libelle,String description,float prix,String img){
        this.idproduit = idproduit;
        this.email = email;
        this.qt = qt;
        this.libelle = libelle;
        this.description = description;
        this.prix = prix;
        this.img = img;
    }
    
    public int getIdproduit(){
        return this.idproduit;
    }
    
    public void setIdproduit(int idproduit){
        this.idproduit = idproduit;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public int getQT(){
        return this.qt;
    }
    
    public void setQT(int qt){
        this.qt = qt;
    }
    
        public String getLibelle(){
        return this.libelle;
    }
    
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    
    public float getPrix(){
        return this.prix;
    }
    
    public void setPrix(float prix){
        this.prix = prix;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
   
    public String getImg(){
        return this.img;
    }
    
    public void setImg(String img){
        this.img = img;
    }
    
    /*
    @Override
    public String toString(){
        return this.libelle;
    }*/
}
