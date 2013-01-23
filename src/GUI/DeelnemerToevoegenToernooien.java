/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Deelnemer;
import Models.Toernooi;
import configuration.SimpleDataSourceV2;
import java.sql.*;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import utils.DateUtil;

/**
 *
 * @author Nick
 */
public class DeelnemerToevoegenToernooien extends javax.swing.JFrame {

    private Deelnemer deelnemer;
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    Toernooi toernooi;
    private String voornaam;
    private String achternaam;
    private int t_code;
    private boolean voegToeCheck;
    Date datum;
    String heeft_betaald;
    /**
     * Creates new form DeelnemerToevoegenToernooien
     */
    public DeelnemerToevoegenToernooien() {
        initComponents();
    }

    public DeelnemerToevoegenToernooien(Deelnemer deelnemer) {
        initComponents();
        this.deelnemer = deelnemer;

        voornaam = deelnemer.getVoornaam();
        achternaam = deelnemer.getAchternaam();

        initScreen();
        ButtonGroup betaald = new ButtonGroup();
        betaald.add(rbJa);
        betaald.add(rbNee);
    }

    private void initScreen() {
        String sql = "Select t_code from toernooi";
        lbDeelnemer.setText(voornaam + " " + achternaam);
        radioButtonCheck();
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet res = stat.executeQuery();
            while (res.next()) {
                t_code = res.getInt("t_code");

                model.addElement(t_code);


            }
            cbMasterclass.setModel(model);



        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void radioButtonCheck() {
        if (rbNee.isSelected()) {
            tfDag.setVisible(false);
            tfMaand.setVisible(false);
            tfJaar.setVisible(false);
            jLabel3.setVisible(false);
        } else if (rbJa.isSelected()) {
            tfDag.setVisible(true);
            tfMaand.setVisible(true);
            tfJaar.setVisible(true);
            jLabel3.setVisible(true);
        } else {
            tfDag.setVisible(false);
            tfMaand.setVisible(false);
            tfJaar.setVisible(false);
            jLabel3.setVisible(false);
        }
    }
    
        private int comboBoxSelectedValue() {
        int selectedItem = 0;
        Object selected = cbMasterclass.getSelectedItem();
        if (selected != null) {
            String selectedItemStr = selected.toString();
            selectedItem = Integer.parseInt(selectedItemStr);
        }
        return selectedItem;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbMasterclass = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btBack = new javax.swing.JButton();
        btVoegToe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbDeelnemer = new javax.swing.JLabel();
        tfDag = new javax.swing.JTextField();
        tfMaand = new javax.swing.JTextField();
        tfJaar = new javax.swing.JTextField();
        rbJa = new javax.swing.JRadioButton();
        rbNee = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbMasterclass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMasterclass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbMasterclassMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbMasterclassMousePressed(evt);
            }
        });
        cbMasterclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMasterclassActionPerformed(evt);
            }
        });

        jLabel4.setText("Deelnemer:");

        jLabel2.setText("Betaald : ");

        btBack.setText("Back");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        btVoegToe.setText("Voeg Toe");
        btVoegToe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoegToeActionPerformed(evt);
            }
        });

        jLabel1.setText("Toernooi : ");

        jLabel3.setText("Datum Betaling : (DD/MM/YYYY)");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btVoegToe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                        .addComponent(btBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(lbDeelnemer))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbNee)
                                            .addComponent(cbMasterclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rbJa)))
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addComponent(tfDag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMaand, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfJaar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMaand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfJaar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                    .addComponent(cbMasterclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbDeelnemer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(rbJa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbNee))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)))
                        .addGap(51, 51, 51)))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBack)
                    .addComponent(btVoegToe))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMasterclassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMasterclassMouseClicked
   }//GEN-LAST:event_cbMasterclassMouseClicked

    private void cbMasterclassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMasterclassMousePressed
   }//GEN-LAST:event_cbMasterclassMousePressed

    private void cbMasterclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMasterclassActionPerformed

    }//GEN-LAST:event_cbMasterclassActionPerformed

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        new DeelnemerBekijkToernooien(deelnemer).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btBackActionPerformed

    private void btVoegToeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoegToeActionPerformed
        String sqlVoegToe = "insert into heeft_betaald(d_code,t_code,inleggeld_betaald,datum_betaling) values(?,?,?,?)";
        voegToeCheck = true;
        datum = null;

        t_code = comboBoxSelectedValue();

        int d_code = deelnemer.getD_code();

        if (rbJa.isSelected()) {
            try {

                int dag = Integer.parseInt(tfDag.getText());
                int maand = Integer.parseInt(tfMaand.getText());
                int jaar = Integer.parseInt(tfJaar.getText());

                datum = DateUtil.toSqlDate(jaar, maand, dag);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Voer gehele getallen in bij datum_betaling.");
                voegToeCheck = false;
            }
        }
        if (rbJa.isSelected() && voegToeCheck != false) {
            heeft_betaald = "j";
            voegToeCheck = true;
        } else if (rbNee.isSelected() && voegToeCheck != false) {
            heeft_betaald = "n";
            voegToeCheck = true;
        } else if (!rbNee.isSelected() && !rbJa.isSelected()) {
            JOptionPane.showMessageDialog(this, "Selecteer een waarde bij 'heeft betaald'.");
            voegToeCheck = false;
        }

        if (voegToeCheck != false) {
            try {
                Connection conn = SimpleDataSourceV2.getConnection();
                PreparedStatement stat = conn.prepareStatement(sqlVoegToe);
                stat.setInt(1, d_code);
                stat.setInt(2, t_code);
                stat.setString(3, heeft_betaald);
                stat.setDate(4, datum);

                stat.execute();
                new DeelnemerBekijkToernooien(deelnemer).setVisible(true);
                this.dispose();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_btVoegToeActionPerformed

    private void rbJaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbJaActionPerformed
        radioButtonCheck();
    }//GEN-LAST:event_rbJaActionPerformed

    private void rbNeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNeeActionPerformed
        radioButtonCheck();
    }//GEN-LAST:event_rbNeeActionPerformed

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
            java.util.logging.Logger.getLogger(DeelnemerToevoegenToernooien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeelnemerToevoegenToernooien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeelnemerToevoegenToernooien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeelnemerToevoegenToernooien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DeelnemerToevoegenToernooien().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btVoegToe;
    private javax.swing.JComboBox cbMasterclass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbDeelnemer;
    private javax.swing.JRadioButton rbJa;
    private javax.swing.JRadioButton rbNee;
    private javax.swing.JTextField tfDag;
    private javax.swing.JTextField tfJaar;
    private javax.swing.JTextField tfMaand;
    // End of variables declaration//GEN-END:variables
}
