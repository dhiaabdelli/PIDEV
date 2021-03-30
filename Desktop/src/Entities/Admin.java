/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author mrabe
 */
public class Admin {
    private String user;
    private String mdp;


public Admin() {
    }

public Admin(String user, String mdp) {
        this.user = user;
        this.mdp = mdp;
    }


 public String getUser() {
        return user;
    }

public void setUser(String user) {
        this.user = user;
    }    

public String getMdp() {
        return mdp;
    }

public void setMdp(String mdp) {
        this.mdp = mdp;
    }    

   
    @Override
    public String toString() {
        return "Admin{" + "user=" + user + ", mdp=" + mdp + '}';
    }
}