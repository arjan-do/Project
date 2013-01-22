/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Deelnemer;
import Models.MasterclassZoeken;
import configuration.SimpleDataSourceV2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.DateUtil;
/**
 *
 * @author Nick
 */
public class DeelnemerBekijkMCs extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    private Deelnemer deelnemer;
    private ArrayList<MasterclassZoeken> masterclassZoeken = new ArrayList<>();
    private int dcode;
    private MasterclassZoeken masterclass;
    private int m_code;
    /**
     * Creates new form DeelnemerBekijkMCs
     */
    public DeelnemerBekijkMCs() {
        initComponents();
    }
    
    public DeelnemerBekijkMCs(Deelnemer deelnemer)
    {
        initComponents();
        this.deelnemer = deelnemer;
        fillComponents();
        model.setRowCount(0);
        masterclassZoeken.clear();    
        updateTable();
    }
    
        private void fillComponents() {
        String[] kolommen = {"Niveau", "Datum", "Rating","Heeft Betaald"};
        model = new DefaultTableModel(kolommen, 0);
        table_Masterclasses.setModel(model);
    }
    
    
        private void updateTable() {
        String naam = deelnemer.getVoornaam()+" " + deelnemer.getAchternaam();
        lbDeelnemer.setText(naam);
        dcode = deelnemer.getD_code();
        


        try {

            //SQL Statement.
            String sql = "Select m.*, heeft_betaald from Masterclass m join volgt v on m.m_code = v.m_code"
                                                                  + " where m.m_code in (Select m_code "
                                                                  + "From volgt "
                                                                  + "Where d_code = ? )"
                                                                  + "group by m_code";

            Connection conn;
            conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            //input of the textfield + "%" for the SQL Statement.
            stat.setInt(1,dcode);

            ResultSet res = stat.executeQuery();


            while (res.next()) {


                masterclass = new MasterclassZoeken(res.getInt("m_code"),
                        res.getInt("niveau"),
                        res.getInt("prijs"),
                        res.getDate("datum"),
                        res.getInt("minimale_rating"),
                        res.getInt("Docent"),
                        res.getInt("vindt_plaats_in"));
                String heeft_betaald = res.getString("Heeft_betaald");
                masterclassZoeken.add(masterclass);
                String dateFormat = DateUtil.fromSqlDateToString(masterclass.getDatum());
                String[] MC = new String[]{"" + masterclass.getNiveau() ,"" + dateFormat,"" + masterclass.getRating(),heeft_betaald };
                model.addRow(MC);
            }


        } catch (Exception ex) {
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

        jLabel1 = new javax.swing.JLabel();
        lbDeelnemer = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Masterclasses = new javax.swing.JTable();
        btBack = new javax.swing.JButton();
        btWijzigen = new javax.swing.JButton();
        btToevoegen = new javax.swing.JButton();
        btVerwijderen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Deelnemer : ");

        jLabel2.setText("Doet mee aan:");

        table_Masterclasses.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_Masterclasses);

        btBack.setText("Back");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        btWijzigen.setText("Deelname wijzigen");
        btWijzigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btWijzigenActionPerformed(evt);
            }
        });

        btToevoegen.setText("Deelname toevoegen");
        btToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btToevoegenActionPerformed(evt);
            }
        });

        btVerwijderen.setText("Verwijderen");
        btVerwijderen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerwijderenActionPerformed(evt);
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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lbDeelnemer))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btWijzigen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btToevoegen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btVerwijderen)
                                .addGap(10, 10, 10)
                                .addComponent(btBack)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBack)
                    .addComponent(btWijzigen)
                    .addComponent(btToevoegen)
                    .addComponent(btVerwijderen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        new DeelnemerBeheer().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btBackActionPerformed

    private void btWijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btWijzigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btWijzigenActionPerformed

    private void btVerwijderenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerwijderenActionPerformed
        
        
        int[] selected = table_Masterclasses.getSelectedRows();
        //Als selected.length 0 is (als er niets geselecteerd is), verschijnt er een messagedialog.
        if (selected.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecteer een deelnemer.");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Weet u zeker dat U de geselecteerde rij(en) wilt verwijderen?") == JOptionPane.YES_OPTION) {


                //Omgedraaide for-loop vanwege problemen met de normale constructie
                for (int i = selected.length - 1; i > -1; i--) {
                    masterclass = masterclassZoeken.get(selected[i]);
                    m_code = masterclass.getM_Code();
                    model.removeRow(selected[i]);

                    String sql = "delete from volgt where m_code = ? AND d_code = ? ";

                    try {
                        Connection conn = SimpleDataSourceV2.getConnection();
                        PreparedStatement stat = conn.prepareStatement(sql);
                        stat.setInt(1, m_code);
                        stat.setInt(2,dcode);
                        stat.execute();

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }

                }
            }
            //Update de modelRows, clear de arraylist Deelnemers.
            model.setRowCount(0);
            masterclassZoeken.clear();
            updateTable();
        }



    }//GEN-LAST:event_btVerwijderenActionPerformed

    private void btToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btToevoegenActionPerformed
         
    }//GEN-LAST:event_btToevoegenActionPerformed

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
            java.util.logging.Logger.getLogger(DeelnemerBekijkMCs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeelnemerBekijkMCs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeelnemerBekijkMCs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeelnemerBekijkMCs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DeelnemerBekijkMCs().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btToevoegen;
    private javax.swing.JButton btVerwijderen;
    private javax.swing.JButton btWijzigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDeelnemer;
    private javax.swing.JTable table_Masterclasses;
    // End of variables declaration//GEN-END:variables
}
