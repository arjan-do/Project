/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;


/**
 *
 * @author Otto Boender
 */
public class MasterclassZoeken {
    private int M_Code;
    private int Niveau;
    private int Prijs;
    private Date Datum;
    private int Rating;
    private int Docent;
    private int Locatie;
    
    String m_code = Integer.toString(M_Code);
    String niveau = Integer.toString(Niveau);
    String prijs = Integer.toString(Prijs);

    String rating = Integer.toString(Rating);
    String docent = Integer.toString(Docent);
    String locatie = Integer.toString(Locatie);

    public MasterclassZoeken(int M_Code, int Niveau, int Prijs, Date Datum, int Rating, int Docent, int Locatie) {
        this.M_Code = M_Code;
        this.Niveau = Niveau;
        this.Prijs = Prijs;
        this.Datum = Datum;
        this.Rating = Rating;
        this.Docent = Docent;
        this.Locatie = Locatie;
        
    }

    public int getM_Code() {
        return M_Code;
    }

    public void setM_Code(int M_Code) {
        this.M_Code = M_Code;
    }

    public int getNiveau() {
        return Niveau;
    }

    public void setNiveau(int Niveau) {
        this.Niveau = Niveau;
    }

    public int getPrijs() {
        return Prijs;
    }

    public void setPrijs(int Prijs) {
        this.Prijs = Prijs;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date Datum) {
        this.Datum = Datum;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }

    public int getDocent() {
        return Docent;
    }

    public void setDocent(int Docent) {
        this.Docent = Docent;
    }
    
    public int getLocatie(int Locatie) {
        return Locatie;
    }
    
    public void setLocatie(int Locatie) {
        this.Locatie = Locatie;
    }
            
    public String[] getrow(){
        return new String[]{m_code, niveau, prijs, this.Datum.toString(), rating, docent, locatie};
    }
    
        public String[] getInfo(){
        return new String[]{"" + this.m_code ,"" + this.Datum,"" + this.rating};
    }
    
}
