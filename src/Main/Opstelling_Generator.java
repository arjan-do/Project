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
        new Opstelling_Generator().calculatetavels(11);
        
    }
    
    private void calculatetavels(int ammount_of_players){
        
        int aantal = 1;
            
        //              1,2,3,4,5,6,7,8
        int[] tavels = {0,0,0,0,0,0,0,0};

        tavels[7] = aantal / 8;
        int ex = aantal % 8;

        int max_table = 8;

        if ((ex != 0) && (aantal > 8)){
            tavels[ex - 1] = 1;

            do{
                if (tavels[7] != 0){
                    max_table = 8;
                } else if (tavels[6] != 0) {
                    max_table = 7;
                } else if (tavels[5] != 0) {
                    max_table = 6;
                } else if (tavels[4] != 0) {
                    max_table = 5;
                } else if (tavels[3] != 0) {
                    max_table = 4;
                } else if (tavels[2] != 0) {
                    max_table = 3;
                } else if (tavels[1] != 0) {
                    max_table = 2;
                } else if (tavels[0] != 0) {
                    max_table = 1;
                }

                tavels[max_table - 1] --;
                tavels[max_table - 2] ++;
                tavels[ex - 1] --;
                tavels[ex] ++;
                ex ++;

            }   while(((ex + 1) < max_table) && (ex < 8));

            } else if (aantal < 8){
                tavels[ex - 1] = 1;
            }
            System.out.println(aantal);
            
            // log only do not include in finale version
            System.out.println(tavels[0]);
            System.out.println(tavels[1]);
            System.out.println(tavels[2]);
            System.out.println(tavels[3]);
            System.out.println(tavels[4]);
            System.out.println(tavels[5]);
            System.out.println(tavels[6]);
            System.out.println(tavels[7]);
            // end of log only

        
    }
    
}
