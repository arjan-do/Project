/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arjan
 */
public class DeelnemerBeheer extends javax.swing.JFrame {

    /**
     * Creates new form DeelnemerBeheer
     */
    public DeelnemerBeheer() {
        initComponents();
        FillComponents();
    }

    // filling all components
    private void FillComponents(){
        String[] kolommen = {"Voornaam", "Achternaam", "Rating"};
        DefaultTableModel model = new DefaultTableModel(kolommen, 0);
        Table_Deelnemers.setModel(model);
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
        Table_Deelnemers = new javax.swing.JTable();
        Button_Toevoegen = new javax.swing.JButton();
        Button_Wijzigen = new javax.swing.JButton();
        Button_Verwijderen = new javax.swing.JButton();
        Button_Back = new javax.swing.JButton();
        TextField_Zoekopnaam = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table_Deelnemers.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Table_Deelnemers);

        Button_Toevoegen.setText("Toevoegen");
        Button_Toevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ToevoegenActionPerformed(evt);
            }
        });

        Button_Wijzigen.setText("Wijzigen");
        Button_Wijzigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_WijzigenActionPerformed(evt);
            }
        });

        Button_Verwijderen.setText("Verwijderen");
        Button_Verwijderen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_VerwijderenActionPerformed(evt);
            }
        });

        Button_Back.setText("Back");
        Button_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BackActionPerformed(evt);
            }
        });

        TextField_Zoekopnaam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_ZoekopnaamKeyReleased(evt);
            }
        });

        jLabel1.setText("Zoeken:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(Button_Toevoegen, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Button_Wijzigen, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Button_Verwijderen)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Button_Back))
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(TextField_Zoekopnaam)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(TextField_Zoekopnaam, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 209, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Button_Toevoegen)
                    .add(Button_Wijzigen)
                    .add(Button_Verwijderen)
                    .add(Button_Back))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void Button_ToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ToevoegenActionPerformed
        //create new window to add a new deelnemer
    }//GEN-LAST:event_Button_ToevoegenActionPerformed

    private void Button_WijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_WijzigenActionPerformed
        //create new window to edit a new deelnemer
        //add a existing deelnemer to windows as a parameter 
    }//GEN-LAST:event_Button_WijzigenActionPerformed

    private void Button_VerwijderenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_VerwijderenActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Weet u het zeker") == JOptionPane.YES_OPTION){
            //remove a deelnemer from the list
        }
    }//GEN-LAST:event_Button_VerwijderenActionPerformed

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackActionPerformed
        //go back to main menu
    }//GEN-LAST:event_Button_BackActionPerformed

    private void TextField_ZoekopnaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_ZoekopnaamKeyReleased
        //renew querry and search on name enterd in TextField_Zoekenopnaam
    }//GEN-LAST:event_TextField_ZoekopnaamKeyReleased

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
            java.util.logging.Logger.getLogger(DeelnemerBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeelnemerBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeelnemerBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeelnemerBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DeelnemerBeheer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_Toevoegen;
    private javax.swing.JButton Button_Verwijderen;
    private javax.swing.JButton Button_Wijzigen;
    private javax.swing.JTable Table_Deelnemers;
    private javax.swing.JTextField TextField_Zoekopnaam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
