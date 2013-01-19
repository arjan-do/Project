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
public class Toernooi {
        
    private int T_Code;
    private int bedrag;
    private int Min_aantal_spelers;
    private Date datum;
    private Time begintijd;
    private int vind_plaats_in;

    public Toernooi(int T_Code, int bedrag, int Min_aantal_spelers, Date datum, Time begintijd, int vind_plaats_in) {
        this.T_Code = T_Code;
        this.bedrag = bedrag;
        this.Min_aantal_spelers = Min_aantal_spelers;
        this.datum = datum;
        this.begintijd = begintijd;
        this.vind_plaats_in = vind_plaats_in;
    }

    public int getMin_aantal_spelers() {
        return Min_aantal_spelers;
    }

    public void setMin_aantal_spelers(int Min_aantal_spelers) {
        this.Min_aantal_spelers = Min_aantal_spelers;
    }

    public int getT_Code() {
        return T_Code;
    }

    public void setT_Code(int T_Code) {
        this.T_Code = T_Code;
    }

    public int getBedrag() {
        return bedrag;
    }

    public void setBedrag(int bedrag) {
        this.bedrag = bedrag;
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

    public int getVind_plaats_in() {
        return vind_plaats_in;
    }

    public void setVind_plaats_in(int vind_plaats_in) {
        this.vind_plaats_in = vind_plaats_in;
    }
    
    
    
}
