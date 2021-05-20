
package Entities;


public class Commande {

    protected int id;
    protected int idpanier;
    protected String email;
    protected int traite;
    
    protected int idproduit;
    protected String nomproduit;
    protected int qt;
    protected float prix;
    public Commande(){
    }
    
    public Commande(int id,int idpanier,String email,int traite){
        this.id = id;
        this.idpanier = idpanier;
        this.email = email;
        this.traite = traite;
    }
    
    
    public Commande(int id,int idpanier,String email,int traite,int idproduit,String nomproduit,int qt){
        this.id = id;
        this.idpanier = idpanier;
        this.email = email;
        this.traite = traite;
        this.idproduit = idproduit;
        this.nomproduit = nomproduit;
        this.qt = qt;
    }
    
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    
    public int getIdpanier(){
        return this.idpanier;
    }
    
    public void setIdpanier(int idpanier){
        this.idpanier = idpanier;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    
    public int getTraite(){
        return this.traite;
    }
    
    public void setTraite(int traite){
        this.traite = traite;
    }
    
    public int getIdproduit(){
        return this.idproduit;
    }
    
    public void setIdproduit(int idproduit){
        this.idproduit = idproduit;
    }
    
    public String getNomProduit(){
        return this.nomproduit;
    }
    
    public void setNomProduit(String nomproduit){
        this.nomproduit = nomproduit;
    }
    
    public int getQT(){
        return this.qt;
    }
    
    public void setQT(int qt){
        this.qt = qt;
    }
    
    public float getPrix(){
        return this.prix;
    }
    
    public void setPrix(float prix){
        this.prix = prix;
    }
}
