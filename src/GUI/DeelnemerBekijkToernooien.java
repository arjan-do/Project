/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Deelnemer;
import Models.MasterclassZoeken;
import Models.Toernooi;
import configuration.SimpleDataSourceV2;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.DateUtil;

/**
 *
 * @author Nick
 */
public class DeelnemerBekijkToernooien extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    private Deelnemer deelnemer;
    private Toernooi toernooi;
    private ArrayList<Toernooi> toernoois = new ArrayList<>();
    private int dcode;
    private int t_code;
    private String heeft_betaald;
    private String dateFormatBetaling;
    /**
     * Creates new form DeelnemerBekijkToernooien
     */
    public DeelnemerBekijkToernooien() {
        initComponents();
    }

    public DeelnemerBekijkToernooien(Deelnemer deelnemer) {
        initComponents();
        fillComponenten();
        this.deelnemer = deelnemer;
        model.setRowCount(0);
        toernoois.clear();
        updateTabel();
    }

    private void fillComponenten() {
        String[] kolommen = {"Datum", "Locatie", "Bedrag", "heeft_betaald", "Datum betaald"};
        model = new DefaultTableModel(kolommen, 0);
        table_Toernooien.setModel(model);
    }

    private void updateTabel() {
        //Voornaam & Achternaam in 1 String.
        String naam = deelnemer.getVoornaam() + " " + deelnemer.getAchternaam();
        //Setting that string in a label.
        lbDeelnemer.setText(naam);
        //getD_Code to find Masterclasses in Volgt.
        dcode = deelnemer.getD_code();


            try {

                //SQL Statement.
                String sql = "select t.*,f.naam, inleggeld_betaald,datum_betaling from heeft_betaald h join toernooi t on t.t_code = h.t_code"
                        + " left join faciliteit f on vindt_plaats_in = f.f_code where d_code = ?";

                Connection conn;
                conn = SimpleDataSourceV2.getConnection();
                PreparedStatement stat = conn.prepareStatement(sql);

                //input of the textfield + "%" for the SQL Statement.
                stat.setInt(1, dcode);

                ResultSet res = stat.executeQuery();


                while (res.next()) {


                    toernooi = new Toernooi(res.getInt("T_Code"),
                            res.getInt("bedrag"),
                            res.getInt("min_aantal_spelers"),
                            res.getDate("datum"),
                            res.getTime("begintijd"),
                            res.getInt("vindt_plaats_in"));
                    toernoois.add(toernooi);
                    //Date Formatting: From SQLDate to String.
                    try{
                    dateFormatBetaling = DateUtil.fromSqlDateToString(res.getDate("datum_betaling"));
                    }catch(Exception e)
                    {
                        
                    }
                    String dateFormat = DateUtil.fromSqlDateToString(toernooi.getDatum());
                    //String[] for setting values in the model.
                    String f_naam = res.getString("naam");
                    String[] MC = new String[]{"" + dateFormat, f_naam, "" + toernooi.getBedrag(), res.getString("Inleggeld_betaald"), dateFormatBetaling};
                    model.addRow(MC);
                }


            } catch (Exception ex) {
            }

        }



    

    private boolean getFaciliteitCheck() {

        try {
            String sql = "Select vindt_plaats_in from toernooi t join heeft_betaald h on t.t_code = h.t_code where d_code = ?";
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, dcode);
            ResultSet res = stat.executeQuery();
            while (res.next()) {

                int vindt_plaats_in = res.getInt("vindt_plaats_in");
                if (vindt_plaats_in != 0) {
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    private boolean getDatumCheck() {
        try {
            String sql = "select datum_betaling from heeft_betaald where d_code = ?";
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, dcode);
            ResultSet res = stat.executeQuery();
            while (res.next()) {
                Date betaling = res.getDate("datum_betaling");
                if (betaling != null) {
                    return true;
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
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
        table_Toernooien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbDeelnemer = new javax.swing.JLabel();
        btBack = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btToevoegen = new javax.swing.JButton();
        btWijzigen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_Toernooien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_Toernooien);

        jLabel1.setText("Deelnemer : ");

        jLabel2.setText("Doet mee aan : ");

        btBack.setText("Back");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        jButton1.setText("Verwijderen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btToevoegen.setText("Deelname Toevoegen");
        btToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btToevoegenActionPerformed(evt);
            }
        });

        btWijzigen.setText("Deelname Wijzigen");
        btWijzigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btWijzigenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lbDeelnemer)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btWijzigen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btToevoegen)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btBack)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbDeelnemer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBack)
                    .addComponent(jButton1)
                    .addComponent(btToevoegen)
                    .addComponent(btWijzigen))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        new DeelnemerBeheer().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int[] selected = table_Toernooien.getSelectedRows();
        //Als selected.length 0 is (als er niets geselecteerd is), verschijnt er een messagedialog.
        if (selected.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecteer een Toernooi.");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Weet u zeker dat U de geselecteerde rij(en) wilt verwijderen?") == JOptionPane.YES_OPTION) {


                //Omgedraaide for-loop vanwege problemen met de normale constructie
                for (int i = selected.length - 1; i > -1; i--) {
                    toernooi = toernoois.get(selected[i]);
                    t_code = toernooi.getT_Code();

                    String sql = "delete from Heeft_betaald where t_code = ? AND d_code = ? ";
                    String sqlBetaald = "Select * from heeft_betaald where t_code = ? AND d_code = ?";
                    try {
                        Connection conn = SimpleDataSourceV2.getConnection();
                        PreparedStatement stat = conn.prepareStatement(sqlBetaald);
                        stat.setInt(1, t_code);
                        stat.setInt(2, dcode);
                        ResultSet res = stat.executeQuery();

                        while (res.next()) {
                            heeft_betaald = res.getString("inleggeld_betaald");
                        }


                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    if ("j".equals(heeft_betaald)) {
                        JOptionPane.showMessageDialog(this, "Kan geen deelname verwijderen waarvoor de deelnemer al betaald heeft. Wijzig eerst de betalingsstatus.");
                    } else {

                        model.removeRow(selected[i]);
                        try {
                            Connection conn = SimpleDataSourceV2.getConnection();
                            PreparedStatement stat = conn.prepareStatement(sql);
                            stat.setInt(1, t_code);
                            stat.setInt(2, dcode);
                            stat.execute();

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(this, ex);
                        }

                    }
                }
            }
            //Update de modelRows, clear de arraylist Deelnemers.
            model.setRowCount(0);
            toernoois.clear();
            updateTabel();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btToevoegenActionPerformed
        new DeelnemerToevoegenToernooien(deelnemer).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btToevoegenActionPerformed

    private void btWijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btWijzigenActionPerformed
        //Counts selected rows
        int[] selected = table_Toernooien.getSelectedRows();
        //If 0 selected or more than 1: error messages.
        if (selected.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecteer een Toernooi.");
        } else if (selected.length > 1) {
            JOptionPane.showMessageDialog(this, "Maximaal 1 toernooi selecteren AUB.");
        } else {
            //Else: Selected row = Masterclass in the array.
            int row = table_Toernooien.getSelectedRow();
            toernooi = toernoois.get(row);
            //DeelnemerWijzigenMCs, with both deelnemer and Masterclass as parameters.
            new DeelnemerWijzigenToernooien(deelnemer, toernooi).setVisible(true);
            this.dispose();
        }


    }//GEN-LAST:event_btWijzigenActionPerformed

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
            java.util.logging.Logger.getLogger(DeelnemerBekijkToernooien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeelnemerBekijkToernooien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeelnemerBekijkToernooien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeelnemerBekijkToernooien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DeelnemerBekijkToernooien().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btToevoegen;
    private javax.swing.JButton btWijzigen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDeelnemer;
    private javax.swing.JTable table_Toernooien;
    // End of variables declaration//GEN-END:variables
}
