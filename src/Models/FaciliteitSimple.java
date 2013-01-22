/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author arjandoets
 */
public class FaciliteitSimple {
    private int f_code;
    private String naam;

    public FaciliteitSimple(int f_code, String naam) {
        this.f_code = f_code;
        this.naam = naam;
    }

    public int getF_code() {
        return f_code;
    }

    public void setF_code(int f_code) {
        this.f_code = f_code;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
    
    
    @Override
    public String toString(){        
        return naam;
    }
          
    
}
