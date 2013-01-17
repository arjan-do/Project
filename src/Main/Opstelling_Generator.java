/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author arjandoets
 */
public class Opstelling_Generator {
    
    public static void main(String[] args) {
        
        double aantal = 90;
        
        double a = aantal / 8;   
        
        int a_int = (int)a;
        
        double ex = a - a_int;
        
        int tavels_acht = a_int;
        int tavels_extra = 1;
        int tavels_extra_spelers = (int)(ex * 8);
        
        if (tavels_extra_spelers < 7){
            
            double tmpa = tavels_extra;
            double tmpb = tavels_extra_spelers;
            int tmpc = tavels_acht;
            boolean running = true;
            
            do {
                
            } while (running);
            
        }
        
        
        //System.out.println(acht);
        //System.out.println(zeven);
        
    }
    
}
