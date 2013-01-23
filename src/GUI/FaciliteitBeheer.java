/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Faciliteit;
import javax.swing.JOptionPane;
import configuration.SimpleDataSourceV2;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Josua
 */
public class FaciliteitBeheer extends javax.swing.JFrame {
    
   DefaultTableModel model = new DefaultTableModel();
    private ArrayList<Faciliteit> faciliteiten = new ArrayList<>();
    int F_code;
    Faciliteit faciliteit;
    /**
     * Creates new form FaciliteitBeheer
     */
    public FaciliteitBeheer() {
        initComponents();
        SetTable();
        VulTable();
        
    }              
    
    private void SetTable() {
        String[] kolommen = {"naam", "straat","huisnummer", "Max_aantal_spelers" };
        //DefaultTableModel aanmaken waarin je aan de constructor de header kolommen meegeeft en het aantal lege start rijen 
         model = new DefaultTableModel(kolommen, 0);
        //model setten
        TableFaciliteit.setModel(model);
        //running the sql querry
        
       
                    
        
        
    }
        
    private void VulTable() {
        
        String input = TextField_Zoekopnaam.getText();
        

        try {

            //SQL Statement.
            String sql = "Select * from faciliteit where naam like ? or Straatnaam like ? or huisnummer like? or plaats like? or Max_aantal_spelers like ?";

            Connection conn;
            conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            //input of the textfield + "%" for the SQL Statement.
            stat.setString(1, input + '%');
            stat.setString(2, input + '%');
            stat.setString(3, input + '%');
            stat.setString(4, input + '%');
            stat.setString(5, input + '%');

            ResultSet res = stat.executeQuery();


            while (res.next()) {

                 faciliteit = new Faciliteit(res.getInt("F_code"),
                        res.getString("Naam"),
                        res.getString("Straatnaam"),
                        res.getString("Postcode") ,
                        res.getString("huisnummer"),
                        res.getInt("Max_aantal_spelers"), 
                        res.getString("plaats")
                                  
                        );
                faciliteiten.add(faciliteit);
                model.addRow(faciliteit.getrow());

                  
                

            }



        } catch (Exception ex) {
            System.out.println(ex);
        }
                System.out.println("finish");

    }
    
            
           
        
       
        


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableFaciliteit = new javax.swing.JTable();
        Button_Toevoegen = new javax.swing.JButton();
        Button_Back = new javax.swing.JButton();
        Button_Verwijderen = new javax.swing.JButton();
        Button_Wijzigen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TextField_Zoekopnaam = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableFaciliteit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Naam", "Adres", "Max aantal spelers"
            }
        ));
        jScrollPane1.setViewportView(TableFaciliteit);

        Button_Toevoegen.setText("Toevoegen");
        Button_Toevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ToevoegenActionPerformed(evt);
            }
        });

        Button_Back.setText("Back");
        Button_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BackActionPerformed(evt);
            }
        });

        Button_Verwijderen.setText("Verwijderen");
        Button_Verwijderen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_VerwijderenActionPerformed(evt);
            }
        });

        Button_Wijzigen.setText("Wijzigen");
        Button_Wijzigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_WijzigenActionPerformed(evt);
            }
        });

        jLabel1.setText("Zoeken:");

        TextField_Zoekopnaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_ZoekopnaamActionPerformed(evt);
            }
        });
        TextField_Zoekopnaam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_ZoekopnaamKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Button_Toevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Wijzigen, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Verwijderen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_Back))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextField_Zoekopnaam, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextField_Zoekopnaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Toevoegen)
                    .addComponent(Button_Wijzigen)
                    .addComponent(Button_Verwijderen)
                    .addComponent(Button_Back)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ToevoegenActionPerformed
        new FaciliteitToevoegen().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_Button_ToevoegenActionPerformed

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackActionPerformed
        //Open Mainmenu
        new HoofdMenu().setVisible(true);
        //Close current Window
        this.dispose();
    }//GEN-LAST:event_Button_BackActionPerformed

    private void Button_VerwijderenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_VerwijderenActionPerformed
       int[] selected = TableFaciliteit.getSelectedRows();
        //Als selected.length 0 is (als er niets geselecteerd is), verschijnt er een messagedialog.
        if (selected.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecteer een deelnemer.");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Weet u zeker dat U de geselecteerde rij(en) wilt verwijderen?") == JOptionPane.YES_OPTION) {


                //Omgedraaide for-loop vanwege problemen met de normale constructie
                for (int i = selected.length - 1; i > -1; i--) {
                    faciliteit = faciliteiten.get(selected[i]);
                    F_code = faciliteit.getF_code();
                    model.removeRow(selected[i]);

                    String sql = "delete from faciliteit where f_code = ?";

                    try {
                        Connection conn = SimpleDataSourceV2.getConnection();
                        PreparedStatement stat = conn.prepareStatement(sql);
                        stat.setInt(1, F_code);
                        stat.execute();

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "U kan deze deelnemer niet verwijderen: Deze persoon doet mee aan een Toernooi of Masterclass.");
                    }

                }
            }
            //Update de modelRows, clear de arraylist Deelnemers.
            model.setRowCount(0);
            faciliteiten.clear();
            VulTable();
        }
    }//GEN-LAST:event_Button_VerwijderenActionPerformed

    private void Button_WijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_WijzigenActionPerformed
        Faciliteit selected = faciliteiten.get(TableFaciliteit.getSelectedRow());
        new FaciliteitWijzigen(selected).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_Button_WijzigenActionPerformed

    private void TextField_ZoekopnaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_ZoekopnaamKeyReleased
         //setRowCount to refresh the model.
        model.setRowCount(0);
        //clear ArrayList for refreshing purposes.
        faciliteiten.clear();
        VulTable();
    }//GEN-LAST:event_TextField_ZoekopnaamKeyReleased
     
    private void TextField_ZoekopnaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_ZoekopnaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_ZoekopnaamActionPerformed
    
    
  
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
            java.util.logging.Logger.getLogger(FaciliteitBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FaciliteitBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FaciliteitBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FaciliteitBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FaciliteitBeheer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_Toevoegen;
    private javax.swing.JButton Button_Verwijderen;
    private javax.swing.JButton Button_Wijzigen;
    private javax.swing.JTable TableFaciliteit;
    private javax.swing.JTextField TextField_Zoekopnaam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
