/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import configuration.SimpleDataSourceV2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arjandoets
 */
public class ToernooiStart extends javax.swing.JFrame {

    /**
     * Creates new form ToernooiStart
     */
    private int T_Code;
    private int R_Code = 0;
    private int spelers = 64;
    boolean finale = false;
    
    
    public ToernooiStart() {
        initComponents();
    }

    public ToernooiStart(int T_Code) {
        initComponents();
        this.T_Code = T_Code;
        initRonde();
    }
    
    private void initRonde() {
        //running the sql querry
         String sql = "select max(Ronde) from opstelling where Toernooi = ?";
           
            try{
                Connection conn;
                conn = SimpleDataSourceV2.getConnection();
                PreparedStatement stat = conn.prepareStatement(sql); 
                
                stat.setInt(1, T_Code);
                
                ResultSet res = stat.executeQuery();
                
                while(res.next()){
                    R_Code = res.getInt("max(Ronde)");
                }
                
            } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Database Error" + ex.getMessage());
            }
            
            sql = "Select count(*) from plaats where Toernooi = ? and Ronde = ? and plaats is null";
           
            try{
                Connection conn;
                conn = SimpleDataSourceV2.getConnection();
                PreparedStatement stat = conn.prepareStatement(sql); 
                
                stat.setInt(1, T_Code);
                stat.setInt(2, R_Code);
                
                ResultSet res = stat.executeQuery();
                
                while(res.next()){
                    spelers = res.getInt("count(*)");
                }
                
            } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Database Error" + ex.getMessage());
            }
            
            Label_Ronde.setText("Huidige Ronde: " + R_Code);
            Label_Spelers.setText("Spelers Resterend: " + spelers);
            
            
            int finalecontrole = 0;
            sql = "Select count(*) from plaats where Toernooi = ? and Ronde = ?";
            try{
                Connection conn;
                conn = SimpleDataSourceV2.getConnection();
                PreparedStatement stat = conn.prepareStatement(sql); 
                
                stat.setInt(1, T_Code);
                stat.setInt(2, R_Code);
                
                ResultSet res = stat.executeQuery();
                
                while(res.next()){
                    finalecontrole = res.getInt("count(*)");
                }
                
            } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Database Error" + ex.getMessage());
            }
            
            if (finalecontrole <= 8){
                Button_MaakOpstelling.setText("Einde toernooi");
                finale = true;
                Label_Ronde.setText("Huidige Ronde: Finale");
            }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button_MaakOpstelling = new javax.swing.JButton();
        Button_Rating = new javax.swing.JButton();
        Button_Back = new javax.swing.JButton();
        Label_Ronde = new javax.swing.JLabel();
        Label_Spelers = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Button_MaakOpstelling.setText("Maak Opstelling");
        Button_MaakOpstelling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_MaakOpstellingActionPerformed(evt);
            }
        });

        Button_Rating.setText("Rating");
        Button_Rating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RatingActionPerformed(evt);
            }
        });

        Button_Back.setText("Back");
        Button_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BackActionPerformed(evt);
            }
        });

        Label_Ronde.setText("Huidige Ronde:");

        Label_Spelers.setText("Speler Resterend:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(Button_MaakOpstelling, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(Button_Back)
                            .add(layout.createSequentialGroup()
                                .add(6, 6, 6)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(Label_Spelers)
                                    .add(Label_Ronde))))
                        .add(0, 0, Short.MAX_VALUE))
                    .add(Button_Rating, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(Button_MaakOpstelling)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(Button_Rating)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(Label_Ronde)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(Label_Spelers)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 91, Short.MAX_VALUE)
                .add(Button_Back)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackActionPerformed
        new ToernooiBeheer().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Button_BackActionPerformed

    private void Button_MaakOpstellingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_MaakOpstellingActionPerformed
        
        if (!finale){
            if (spelers == 0){
                new OpstelingToevoegen(T_Code, R_Code).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Er zijn nog spelers bezig");
            }
        } else {
            if (spelers == 0){
                JOptionPane.showMessageDialog(this, "einde van toernooi");
            } else {
                JOptionPane.showMessageDialog(this, "Er zijn nog spelers bezig");
            }
        }
        
    }//GEN-LAST:event_Button_MaakOpstellingActionPerformed

    private void Button_RatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RatingActionPerformed
        new Rating().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Button_RatingActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ToernooiStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToernooiStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToernooiStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToernooiStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ToernooiStart().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_MaakOpstelling;
    private javax.swing.JButton Button_Rating;
    private javax.swing.JLabel Label_Ronde;
    private javax.swing.JLabel Label_Spelers;
    // End of variables declaration//GEN-END:variables
}
