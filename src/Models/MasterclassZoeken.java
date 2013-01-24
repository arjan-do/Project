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
    private double Prijs;
    private Date Datum;
    private int Rating;
    private int Docent;
    private int Locatie;
    


    public MasterclassZoeken(int M_Code, double Prijs, Date Datum, int Rating, int Docent, int Locatie) {
        this.M_Code = M_Code;
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

    public double getPrijs() {
        return Prijs;
    }

    public void setPrijs(double Prijs) {
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
        return new String[]{Integer.toString(M_Code), Double.toString(Prijs), this.Datum.toString(), Integer.toString(Rating), Integer.toString(Docent), Integer.toString(Locatie)};
    }
    
    public String[] getInfo(){
        return new String[]{"" + Integer.toString(M_Code) ,"" + this.Datum,"" + Integer.toString(Rating)};
    }
    
}
