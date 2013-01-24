/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Deelnemer;
import Models.MasterclassZoeken;
import configuration.SimpleDataSourceV2;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import utils.DateUtil;

/**
 *
 * @author Nick
 */
public class DeelnemerWijzigenMCs extends javax.swing.JFrame {

    /**
     * Creates new form DeelnemerWijzigenMCs
     */
    Deelnemer deelnemer;
    MasterclassZoeken masterclass;
    private int d_code;
    private int m_code;
    private String betaald;
    private Date datum;
    private boolean checkInvoer;

    public DeelnemerWijzigenMCs() {
        initComponents();
    }

    public DeelnemerWijzigenMCs(Deelnemer deelnemer, MasterclassZoeken masterclass) {
        initComponents();
        ButtonGroup button = new ButtonGroup();
        button.add(rbJa);
        button.add(rbNee);

        this.deelnemer = deelnemer;
        this.masterclass = masterclass;
        //gets and sets every value. 
        initValues();

        //checks which radiobutton is selected, sets 'datum' to visible or not.
        radioButtonCheck();
        if (tfDag.isVisible()) {

            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.clear();
            cal.setTime(datum);
            int jaar = cal.get(Calendar.YEAR);
            int maand = cal.get(Calendar.MONTH);
            int dag = cal.get(Calendar.DAY_OF_MONTH);
            maand++;

            String JAAR = Integer.toString(jaar);
            String MAAND = Integer.toString(maand);
            String DAG = Integer.toString(dag);

            tfJaar.setText(JAAR);
            tfMaand.setText(MAAND);
            tfDag.setText(DAG);
        }

    }

    private void radioButtonCheck() {
        if (rbNee.isSelected()) {
            tfDag.setVisible(false);
            tfMaand.setVisible(false);
            tfJaar.setVisible(false);
            jLabel4.setVisible(false);
        } else if (rbJa.isSelected()) {
            tfDag.setVisible(true);
            tfMaand.setVisible(true);
            tfJaar.setVisible(true);
            jLabel4.setVisible(true);
        } else {
            tfDag.setVisible(false);
            tfMaand.setVisible(false);
            tfJaar.setVisible(false);
            jLabel4.setVisible(false);
        }
    }

    private void initValues() {
        String naam = deelnemer.getVoornaam() + " " + deelnemer.getAchternaam();
        m_code = masterclass.getM_Code();
        d_code = deelnemer.getD_code();

        

        lbDeelnemer.setText(naam);
        lbMasterclass.setText(Integer.toString(m_code));
        

        String sql = "Select * from volgt where m_code = ? and d_code = ?";

        try {

            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, m_code);
            stat.setInt(2, d_code);
            ResultSet res = stat.executeQuery();
            while (res.next()) {
                betaald = res.getString("Heeft_betaald");
                datum = res.getDate("datum_betaling");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        if ("j".equals(betaald)) {
            rbJa.setSelected(true);
        } else if ("n".equals(betaald)) {
            rbNee.setSelected(true);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btSave = new javax.swing.JButton();
        btBack = new javax.swing.JButton();
        lbDeelnemer = new javax.swing.JLabel();
        lbMasterclass = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rbJa = new javax.swing.JRadioButton();
        rbNee = new javax.swing.JRadioButton();
        tfDag = new javax.swing.JTextField();
        tfMaand = new javax.swing.JTextField();
        tfJaar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Deelnemer : ");

        jLabel2.setText("MasterClass : ");

        btSave.setText("Sla Op");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btBack.setText("Back");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        jLabel4.setText("Datum (DD/MM/YYYY) : ");

        jLabel6.setText("Betaald : ");

        rbJa.setText("Ja");
        rbJa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbJaActionPerformed(evt);
            }
        });

        rbNee.setText("Nee");
        rbNee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbDeelnemer))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(5, 5, 5)
                                .addComponent(lbMasterclass))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbNee)
                                    .addComponent(rbJa)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDag, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMaand, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfJaar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbDeelnemer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbMasterclass))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rbJa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbNee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMaand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfJaar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave)
                    .addComponent(btBack))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        new DeelnemerBekijkMCs(deelnemer).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btBackActionPerformed

    private void rbJaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbJaActionPerformed
        radioButtonCheck();
    }//GEN-LAST:event_rbJaActionPerformed

    private void rbNeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNeeActionPerformed
        radioButtonCheck();
    }//GEN-LAST:event_rbNeeActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        checkInvoer = true;
        if (tfDag.isVisible()) {
            try {
                int dag = Integer.parseInt(tfDag.getText());
                int maand = Integer.parseInt(tfMaand.getText());
                int jaar = Integer.parseInt(tfJaar.getText());

                datum = DateUtil.toSqlDate(jaar, maand, dag);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Voer gehele getallen in bij datum.");
                checkInvoer = false;
            }
            betaald = "j";
        } else {
            datum = null;
            betaald = "n";
        }


        String sql = "Update volgt set datum_betaling=?, heeft_betaald=? where d_code = ? and m_code = ?";

        if (checkInvoer != false) {

            try {
                Connection conn = SimpleDataSourceV2.getConnection();
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setDate(1, datum);
                stat.setString(2, betaald);
                stat.setInt(3, d_code);
                stat.setInt(4, m_code);
                stat.execute();

                new DeelnemerBekijkMCs(deelnemer).setVisible(true);
                this.dispose();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btSaveActionPerformed

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
            java.util.logging.Logger.getLogger(DeelnemerWijzigenMCs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeelnemerWijzigenMCs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeelnemerWijzigenMCs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeelnemerWijzigenMCs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DeelnemerWijzigenMCs().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbDeelnemer;
    private javax.swing.JLabel lbMasterclass;
    private javax.swing.JRadioButton rbJa;
    private javax.swing.JRadioButton rbNee;
    private javax.swing.JTextField tfDag;
    private javax.swing.JTextField tfJaar;
    private javax.swing.JTextField tfMaand;
    // End of variables declaration//GEN-END:variables
}
