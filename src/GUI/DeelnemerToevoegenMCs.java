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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import utils.DateUtil;

/**
 *
 * @author Nick
 */
public class DeelnemerToevoegenMCs extends javax.swing.JFrame {

    private Deelnemer deelnemer;
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    int niveau;
    MasterclassZoeken masterclass;
    private int m_code;
    private String voornaam;
    private String achternaam;
    private String heeft_betaald;
    private String sqlVoegToe;
    private boolean voegToeCheck;
    private Date datum;

    /**
     * Creates new form DeelnemerToevoegenMCs
     */
    public DeelnemerToevoegenMCs() {
        initComponents();
        initScreen();
    }

    public DeelnemerToevoegenMCs(Deelnemer deelnemer) {
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
        String sql = "Select m_code from masterclass";
        lbDeelnemer.setText(voornaam + " " + achternaam);
        radioButtonCheck();
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet res = stat.executeQuery();
            while (res.next()) {
                m_code = res.getInt("m_code");

                model.addElement(m_code);


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

        btBack = new javax.swing.JButton();
        btVoegToe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbMasterclass = new javax.swing.JComboBox();
        lbNiveau = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rbJa = new javax.swing.JRadioButton();
        rbNee = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        tfDag = new javax.swing.JTextField();
        tfMaand = new javax.swing.JTextField();
        tfJaar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbDeelnemer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel1.setText("Masterclass :");

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

        jLabel2.setText("Betaald : ");

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

        jLabel3.setText("Datum Betaling : (DD/MM/YYYY)");

        jLabel4.setText("Deelnemer:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btVoegToe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbMasterclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbNiveau, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbJa)
                                            .addComponent(rbNee)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfDag, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMaand, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfJaar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(lbDeelnemer)))
                        .addGap(0, 82, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbDeelnemer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMasterclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNiveau)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rbJa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbNee)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfDag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMaand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfJaar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBack)
                    .addComponent(btVoegToe))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMasterclassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMasterclassMousePressed
    }//GEN-LAST:event_cbMasterclassMousePressed

    private void cbMasterclassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMasterclassMouseClicked
    }//GEN-LAST:event_cbMasterclassMouseClicked

    private void cbMasterclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMasterclassActionPerformed

        m_code = comboBoxSelectedValue();

        String sql = "select niveau from masterclass where m_code = ?";
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, m_code);
            ResultSet res = stat.executeQuery();

            while (res.next()) {
                niveau = res.getInt("niveau");
            }

            lbNiveau.setText("Niveau : " + niveau);

        } catch (Exception e) {
            System.out.println(e);
        }


        lbNiveau.setText("Niveau : " + Integer.toString(niveau));

    }//GEN-LAST:event_cbMasterclassActionPerformed

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

    private void btVoegToeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoegToeActionPerformed
        sqlVoegToe = "insert into volgt(d_code,m_code,datum_betaling,heeft_betaald) values(?,?,?,?)";
        voegToeCheck = true;
        datum = null;

        m_code = comboBoxSelectedValue();

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
        } else {
            JOptionPane.showMessageDialog(this, "Selecteer een waarde bij 'heeft betaald'.");
            voegToeCheck = false;
        }

        if (voegToeCheck != false) {
            try {
                Connection conn = SimpleDataSourceV2.getConnection();
                PreparedStatement stat = conn.prepareStatement(sqlVoegToe);
                stat.setInt(1, d_code);
                stat.setInt(2, m_code);
                stat.setDate(3, datum);
                stat.setString(4, heeft_betaald);

                stat.execute();
                new DeelnemerBekijkMCs(deelnemer).setVisible(true);
                this.dispose();

            } catch (Exception e) {
                System.out.println(e);
            }
        }


    }//GEN-LAST:event_btVoegToeActionPerformed

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
            java.util.logging.Logger.getLogger(DeelnemerToevoegenMCs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeelnemerToevoegenMCs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeelnemerToevoegenMCs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeelnemerToevoegenMCs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DeelnemerToevoegenMCs().setVisible(true);
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
    private javax.swing.JLabel lbNiveau;
    private javax.swing.JRadioButton rbJa;
    private javax.swing.JRadioButton rbNee;
    private javax.swing.JTextField tfDag;
    private javax.swing.JTextField tfJaar;
    private javax.swing.JTextField tfMaand;
    // End of variables declaration//GEN-END:variables
}
