/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.OpstellingDeelnemer;
import configuration.SimpleDataSourceV2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arjandoets
 */
public class Rating extends javax.swing.JFrame {

    /**
     * Creates new form Rating
     */
    private int T_Code;
    private int R_Code;
    private int Tafel;
    List<OpstellingDeelnemer> tafeldeelnemers= new ArrayList<OpstellingDeelnemer>();
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    DefaultTableModel tModel = new DefaultTableModel();
    
    public Rating() {
        initComponents();
    }
    
    public Rating(int T_Code, int R_Code)
    {
        initComponents();
        this.T_Code = T_Code;
        this.R_Code = R_Code;
        initData();
        inittable();
        ComboBox_tafelselectActionPerformed(null);
    }
    
    private void inittable(){
        String[] kolommen = {"Voornaam", "Achternaam", "Plaats", "Rating"};
        tModel = new DefaultTableModel(kolommen, 0);
        Table_HuidigeTafel.setModel(tModel);
    }
    
    private void initData()
    {
        String sql = "Select Distinct tafel from plaats where Toernooi = ? and Ronde = ?";
        
        try{
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,T_Code);
            stat.setInt(2,R_Code);
            ResultSet res = stat.executeQuery();
            while(res.next())
            {
                Tafel = res.getInt("tafel");
                String item = "Tafel " + Tafel;
                model.addElement(item); 
            }
            
            ComboBox_tafelselect.setModel(model);
            
        }catch(Exception ex)
        {
            System.out.println(ex);
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

        ComboBox_tafelselect = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_HuidigeTafel = new javax.swing.JTable();
        Button_Back = new javax.swing.JButton();
        Button_Verloren = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ComboBox_tafelselect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBox_tafelselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_tafelselectActionPerformed(evt);
            }
        });

        Table_HuidigeTafel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Table_HuidigeTafel);

        Button_Back.setText("Back");
        Button_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BackActionPerformed(evt);
            }
        });

        Button_Verloren.setText("Verloren");
        Button_Verloren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_VerlorenActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(ComboBox_tafelselect, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(Button_Back)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 217, Short.MAX_VALUE)
                        .add(Button_Verloren)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(ComboBox_tafelselect, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Button_Back)
                    .add(Button_Verloren))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackActionPerformed
            new ToernooiStart(T_Code).setVisible(true);
            this.dispose();
    }//GEN-LAST:event_Button_BackActionPerformed

    private void ComboBox_tafelselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_tafelselectActionPerformed
        tafeldeelnemers.clear();
        tModel.setRowCount(0);
        String sql =  "select deelnemer.d_code, deelnemer.voornaam, deelnemer.achternaam, deelnemer.rating, plaats.plaats from deelnemer join plaats on deelnemer.d_code = plaats.d_code where plaats.toernooi = ? and plaats.tafel = ? and plaats.ronde = ?";
       
        try{
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,T_Code);
            stat.setInt(2,ComboBox_tafelselect.getSelectedIndex() + 1);
            stat.setInt(3,R_Code);
            ResultSet res = stat.executeQuery();
            
            while(res.next())
            {
                int d_code = res.getInt("deelnemer.d_code");
                String voornaam = res.getString("deelnemer.voornaam");
                String achternaam = res.getString("deelnemer.voornaam");
                int rating = res.getInt("deelnemer.rating");
                int plaats = res.getInt("plaats.plaats");
                
                OpstellingDeelnemer deelnemer = new OpstellingDeelnemer(R_Code, T_Code, d_code, voornaam, achternaam, plaats);
                tafeldeelnemers.add(deelnemer);
                tModel.addRow(new String[] {deelnemer.getNaam(), deelnemer.getAchternaam(), Integer.toString(deelnemer.getPlaats()), Integer.toString(rating)});
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_ComboBox_tafelselectActionPerformed

    private void Button_VerlorenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_VerlorenActionPerformed
        OpstellingDeelnemer deelnemer = tafeldeelnemers.get(Table_HuidigeTafel.getSelectedRow());
        if (deelnemer.getPlaats() == 0){
        
        
        int plaats = tafeldeelnemers.size();
        
        for(int a = 0; a < tafeldeelnemers.size(); a ++){        
            if (tafeldeelnemers.get(a).getPlaats() != 0){
                plaats --;
            }
        }
        String sql = "update plaats set Plaats = ? where toernooi = ? and Ronde = ? and tafel = ? and d_code = ?";
         
        try{
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,plaats);
            stat.setInt(2,T_Code);
            stat.setInt(3,R_Code);
            stat.setInt(4, ComboBox_tafelselect.getSelectedIndex() + 1);
            stat.setInt(5, deelnemer.getD_Code());
            
            stat.execute();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }    
        
        if ((plaats == 1) || (plaats == 2)){
            sql = "update deelnemer set rating = rating + 5 where d_code = ?";
        } else {
            sql = "update deelnemer set rating = rating - 5 where d_code = ?";
        }
        
        try{
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            
            stat.setInt(1, deelnemer.getD_Code());
            stat.execute();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }  
        } else {
            JOptionPane.showMessageDialog(this, "deze Speler is heeft al een plaats");
        }
        
        
        ComboBox_tafelselectActionPerformed(null);
    }//GEN-LAST:event_Button_VerlorenActionPerformed

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
            java.util.logging.Logger.getLogger(Rating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Rating().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_Verloren;
    private javax.swing.JComboBox ComboBox_tafelselect;
    private javax.swing.JTable Table_HuidigeTafel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
