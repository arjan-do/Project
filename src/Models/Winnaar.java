/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author arjandoets
 */
public class Winnaar {
    
    private int D_Code;
    private int T_Code;
    private String voornaam;
    private String achternaam;
    private int plaats;

    public Winnaar( int D_Code, int T_Code, String voornaam, String achternaam, int plaats) {
        
        this.D_Code = D_Code;
        this.T_Code = T_Code;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.plaats = plaats;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getvoorNaam() {
        return voornaam;
    }

    public void setvoorNaam(String voornaam) {
        this.voornaam = voornaam;
    }
 
    public int getD_Code() {
        return D_Code;
    }

    public void setD_Code(int D_Code) {
        this.D_Code = D_Code;
    }

     public int getT_Code() {
        return T_Code;
    }

    public void setT_Code(int T_Code) {
        this.T_Code = T_Code;
    }
  
    public int getPlaats() {
        return plaats;
    }

    public void setPlaats(int plaats) {
        this.plaats = plaats;
    }
    
    public String[] torow(){
        
        return new String[] {this.voornaam, this.achternaam, "" + this.plaats};
    }
}
