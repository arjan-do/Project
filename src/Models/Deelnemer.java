/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author arjan
 */
public class Deelnemer {
    
    private int D_code;
    private String Voornaam;
    private String Achternaam;
    private String Postcode;
    private String Woonplaats;
    private String Telefoon;
    private String Huisnummer;
    private String isbekend;
    private int rating;

    public Deelnemer(int D_code, String Voornaam, String Achternaam, String Postcode, String Woonplaats, String Telefoon, String Huisnummer, String isbetaald, int rating) {
        this.D_code = D_code;
        this.Voornaam = Voornaam;
        this.Achternaam = Achternaam;
        this.Postcode = Postcode;
        this.Woonplaats = Woonplaats;
        this.Telefoon = Telefoon;
        this.Huisnummer = Huisnummer;
        this.isbekend = isbetaald;
        this.rating = rating;
    }

    public String getAchternaam() {
        return Achternaam;
    }

    public void setAchternaam(String Achternaam) {
        this.Achternaam = Achternaam;
    }

    public int getD_code() {
        return D_code;
    }

    public void setD_code(int D_code) {
        this.D_code = D_code;
    }

    public String getHuisnummer() {
        return Huisnummer;
    }

    public void setHuisnummer(String Huisnummer) {
        this.Huisnummer = Huisnummer;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String Postcode) {
        this.Postcode = Postcode;
    }

    public String getTelefoon() {
        return Telefoon;
    }

    public void setTelefoon(String Telefoon) {
        this.Telefoon = Telefoon;
    }

    public String getVoornaam() {
        return Voornaam;
    }

    public void setVoornaam(String Voornaam) {
        this.Voornaam = Voornaam;
    }

    public String getWoonplaats() {
        return Woonplaats;
    }

    public void setWoonplaats(String Woonplaats) {
        this.Woonplaats = Woonplaats;
    }

    public String getIsbekend() {
        return isbekend;
    }

    public void setIsbekend(String isbekend) {
        this.isbekend = isbekend;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    
}
