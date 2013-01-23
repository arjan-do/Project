/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author arjandoets
 */
public class OpstellingDeelnemer {
    private int R_Code;
    private int TF_Code;
    private int D_Code;
    private String naam;
    private String achternaam;
    private int plaats;

    public OpstellingDeelnemer(int R_Code, int TF_Code, int D_Code, String naam, String achternaam, int plaats) {
        this.R_Code = R_Code;
        this.TF_Code = TF_Code;
        this.D_Code = D_Code;
        this.naam = naam;
        this.achternaam = achternaam;
        this.plaats = plaats;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
 
    public int getD_Code() {
        return D_Code;
    }

    public void setD_Code(int D_Code) {
        this.D_Code = D_Code;
    }

    public int getR_Code() {
        return R_Code;
    }

    public void setR_Code(int R_Code) {
        this.R_Code = R_Code;
    }

    public int getTF_Code() {
        return TF_Code;
    }

    public void setTF_Code(int TF_Code) {
        this.TF_Code = TF_Code;
    }

    public int getPlaats() {
        return plaats;
    }

    public void setPlaats(int plaats) {
        this.plaats = plaats;
    }
    
    public String[] torow(){
        
        return new String[] {naam, achternaam, Integer.toString(TF_Code)};
    }
}
