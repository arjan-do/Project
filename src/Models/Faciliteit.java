/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Josua
 */
public class Faciliteit {
    
    private int F_code;
    private String Naam;
    private String Straat;
    private String Postcode;
    private String Huisnummer;
    private int Max_aantal;
    private String Plaats;

    public Faciliteit(int F_code, String Naam, String Straat, String Postcode, String Huisnummer, int Max_aantal, String Plaats) {
        this.F_code = F_code;
        this.Naam = Naam;
        this.Straat = Straat;
        this.Postcode = Postcode;
        this.Huisnummer = Huisnummer;
        this.Max_aantal = Max_aantal;
        this.Plaats = Plaats;
    }

    public int getF_code() {
        return F_code;
    }

    public void setF_code(int F_code) {
        this.F_code = F_code;
    }

    public String getHuisnummer() {
        return Huisnummer;
    }

    public void setHuisnummer(String Huisnummer) {
        this.Huisnummer = Huisnummer;
    }

    public String getNaam() {
        return Naam;
    }

    public void setNaam(String Naam) {
        this.Naam = Naam;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String Postcode) {
        this.Postcode = Postcode;
    }

    public String getStraat() {
        return Straat;
    }

    public void setStraat(String Straat) {
        this.Straat = Straat;
    }
    
    public int getMax_aantal() {
        return Max_aantal;
    }

    public void setMax_aantal(int Max_aantal) {
        this.Max_aantal = Max_aantal;
    }
    
    public String Plaats() {
        return Plaats;
    }

    public void setPlaats(String Plaats) {
        this.Plaats = Plaats;
    }
    
    public String[] getrow(){
        return new String[]{this.Naam.toString(), this.Straat.toString(), this.Huisnummer.toString(), String.valueOf(this.Max_aantal)};
    }
        
}
