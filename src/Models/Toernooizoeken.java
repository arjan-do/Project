/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author arjandoets
 */
public class Toernooizoeken {
    private int t_code;
    private Date datum;
    private Time begintijd;
    private String locatienaam;
    private int minspelers;
    private int spelers;

    public Toernooizoeken(int t_code, Date datum, Time begintijd, String locatienaam, int minspelers, int spelers) {
        this.t_code = t_code;
        this.datum = datum;
        this.begintijd = begintijd;
        this.locatienaam = locatienaam;
        this.minspelers = minspelers;
        this.spelers = spelers;
    }

    public Time getBegintijd() {
        return begintijd;
    }

    public void setBegintijd(Time begintijd) {
        this.begintijd = begintijd;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getLocatienaam() {
        return locatienaam;
    }

    public void setLocatienaam(String locatienaam) {
        this.locatienaam = locatienaam;
    }

    public int getMinspelers() {
        return minspelers;
    }

    public void setMinspelers(int minspelers) {
        this.minspelers = minspelers;
    }

    public int getSpelers() {
        return spelers;
    }

    public void setSpelers(int spelers) {
        this.spelers = spelers;
    }

    public int getT_code() {
        return t_code;
    }

    public void setT_code(int t_code) {
        this.t_code = t_code;
    }
            
    public String[] getrow(){
        return new String[]{this.datum.toString(), this.begintijd.toString(), this.locatienaam, String.valueOf(this.minspelers), String.valueOf(this.spelers)};
    }
    
}
