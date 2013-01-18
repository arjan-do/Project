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
    private int Telefoon;
    private int Huisnummer;
    private String isbekend;
    private String straat;
    private String email;
    private int rating;

    public Deelnemer(int D_code, String Voornaam, String Achternaam, String Postcode, String Woonplaats, int Telefoon, int Huisnummer, String isbekend, String straat, String email, int rating) {
        this.D_code = D_code;
        this.Voornaam = Voornaam;
        this.Achternaam = Achternaam;
        this.Postcode = Postcode;
        this.Woonplaats = Woonplaats;
        this.Telefoon = Telefoon;
        this.Huisnummer = Huisnummer;
        this.isbekend = isbekend;
        this.straat = straat;
        this.email = email;
        this.rating = rating;
    }

    public Deelnemer(int D_code) {
        this.D_code = D_code;
    }

 
    
    
    public Deelnemer(String Voornaam, String Achternaam, int rating)
    {
        this.Voornaam = Voornaam;
        this.Achternaam = Achternaam;
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

    public int getHuisnummer() {
        return Huisnummer;
    }

    public void setHuisnummer(int Huisnummer) {
        this.Huisnummer = Huisnummer;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String Postcode) {
        this.Postcode = Postcode;
    }

    public int getTelefoon() {
        return Telefoon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setTelefoon(int Telefoon) {
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

    @Override
    public String toString() {
        return "Deelnemer{" + "D_code=" + D_code + ", Voornaam=" + Voornaam + ", Achternaam=" + Achternaam + ", Postcode=" + Postcode + ", Woonplaats=" + Woonplaats + ", Telefoon=" + Telefoon + ", Huisnummer=" + Huisnummer + ", isbekend=" + isbekend + ", rating=" + rating + '}';
    }
    
        public String[] getInfo(){
        return new String[]{ this.Voornaam , this.Achternaam,"" + this.rating};
    }
    
}


