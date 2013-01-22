/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author Nick
 */
public class VolgtZoeken {
    private int dcode;
    private int mcode;
    private Date datum_betaling;
    private String heeft_betaald;

    public VolgtZoeken(int dcode, int mcode, Date datum_betaling, String heeft_betaald) {
        this.dcode = dcode;
        this.mcode = mcode;
        this.datum_betaling = datum_betaling;
        this.heeft_betaald = heeft_betaald;
    }

    public Date getDatum_betaling() {
        return datum_betaling;
    }

    public void setDatum_betaling(Date datum_betaling) {
        this.datum_betaling = datum_betaling;
    }

    public int getDcode() {
        return dcode;
    }

    public void setDcode(int dcode) {
        this.dcode = dcode;
    }

    public String getHeeft_betaald() {
        return heeft_betaald;
    }

    public void setHeeft_betaald(String heeft_betaald) {
        this.heeft_betaald = heeft_betaald;
    }

    public int getMcode() {
        return mcode;
    }

    public void setMcode(int mcode) {
        this.mcode = mcode;
    }

    
    
    
}
