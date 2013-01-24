/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.MasterclassZoeken;
import Models.Toernooizoeken;
import configuration.SimpleDataSourceV2;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.DateUtil;
/**
 *
 * @author Otto
 */
public class MasterclassBeheer extends javax.swing.JFrame {
        
    DefaultTableModel tabel = new DefaultTableModel();
    private ArrayList<MasterclassZoeken> masterclasses = new ArrayList<>();
    int M_Code;
    MasterclassZoeken masterclass;
    /**
     * Creates new form MasterclassBeheer
     */
    public MasterclassBeheer() {
        initComponents();
        tabelMaken();
    }
    
    private void tabelMaken()
    {
        String[] kolommen = {"Code", "Prijs", "Datum", "Rating", "Docent", "Locatie"};
        tabel = new DefaultTableModel(kolommen, 0);
        Table_Masterclass.setModel(tabel);
        
        sqlUpdateTabel();
    }
    
    private void sqlUpdateTabel()
    {
        tabel.setRowCount(0);
        
        try{
            //SQL Statement.
            String sql = "select M_Code, Prijs, Datum, Minimale_rating, Docent, Vindt_plaats_in from masterclass";

            Connection conn;
            conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);


            
            ResultSet res = stat.executeQuery();

            while (res.next()) {
                 int M_Code = res.getInt("M_Code");
                 Double Prijs = res.getDouble("Prijs");
                 Date Datum = res.getDate("Datum");
                 int Rating = res.getInt("Minimale_rating");
                 int Docent = res.getInt("Docent");
                 int Locatie = res.getInt("Vindt_plaats_in");
                 masterclass = new MasterclassZoeken(res.getInt("M_Code"), res.getDouble("Prijs"), res.getDate("Datum"), res.getInt("Minimale_rating"), res.getInt("Docent"), res.getInt("Vindt_plaats_in"));
                 masterclasses.add(masterclass);
                 String DateFormat = DateUtil.fromSqlDateToString(Datum);
                 String[] mczoek = new String[]{"" + M_Code, "" + Prijs, "" + DateFormat, "" + Rating, "" + Docent, "" + Locatie};

                 tabel.addRow(mczoek);
                
            }

            Table_Masterclass.setModel(tabel);
            
        }catch(Exception ex){
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Masterclass = new javax.swing.JTable();
        Button_Toevoegen = new javax.swing.JButton();
        Button_Wijzigen = new javax.swing.JButton();
        Button_Verwijderen = new javax.swing.JButton();
        Button_Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table_Masterclass.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Table_Masterclass);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Button_Toevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Wijzigen, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Verwijderen, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Toevoegen)
                    .addComponent(Button_Wijzigen)
                    .addComponent(Button_Verwijderen)
                    .addComponent(Button_Back))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ToevoegenActionPerformed
        new MasterclassToevoegen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Button_ToevoegenActionPerformed

    private void Button_WijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_WijzigenActionPerformed
        int[] selected = Table_Masterclass.getSelectedRows();
        System.out.println(selected.length);
        //Als selected.length 0 is (als er niets geselecteerd is), verschijnt er een messagedialog.
        if (selected.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecteer een Masterclass.");
            //Als er meer dan 1 persoon geselecteerd is, verschijnt er een messagedialog.
        } else if (selected.length > 1) {
            JOptionPane.showMessageDialog(this, "Selecteer maximaal 1 Masterclass.");
            //Als bovenstaande condities niet waar zijn, wordt het wijzigscherm toegelaten.
        } else {
            int row = Table_Masterclass.getSelectedRow();
            masterclass = masterclasses.get(row);
            M_Code = masterclass.getM_Code();
            System.out.println(M_Code);
            try {
                String sql = "Select * from masterclass where M_Code = ?";
                Connection conn = SimpleDataSourceV2.getConnection();
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setInt(1, M_Code);

                ResultSet res = stat.executeQuery();
                while (res.next()) {
                    //Maakt een nieuwe deelnemer met alle bijbehorende attributen.
                    masterclass = new MasterclassZoeken(res.getInt("M_Code"),
                            res.getDouble("Prijs"),
                            res.getDate("Datum"),
                            res.getInt("Minimale_rating"),
                            res.getInt("Docent"),
                            res.getInt("Vindt_plaats_in"));
                            }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }    
                    new MasterclassWijzigen(masterclass).setVisible(true);
                    this.dispose();
        }
        
        

    }//GEN-LAST:event_Button_WijzigenActionPerformed

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackActionPerformed
        new HoofdMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Button_BackActionPerformed

    private void Button_VerwijderenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_VerwijderenActionPerformed
        int[] selected = Table_Masterclass.getSelectedRows();
        //Als selected.length 0 is (als er niets geselecteerd is), verschijnt er een messagedialog.
        if (selected.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecteer een Masterclass.");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Weet u zeker dat U de geselecteerde rij(en) wilt verwijderen?") == JOptionPane.YES_OPTION) {


                //Omgedraaide for-loop vanwege problemen met de normale constructie
                for (int i = selected.length - 1; i > -1; i--) {
                    masterclass = masterclasses.get(selected[i]);
                    M_Code = masterclass.getM_Code();
                    tabel.removeRow(selected[i]);

                    String sql = "delete from masterclass where M_Code = ?";

                    try {
                        Connection conn = SimpleDataSourceV2.getConnection();
                        PreparedStatement stat = conn.prepareStatement(sql);
                        stat.setInt(1, M_Code);
                        stat.execute();

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }

                }
            }
            //Update de modelRows, clear de arraylist Deelnemers.
            tabel.setRowCount(0);
            masterclasses.clear();
            tabelMaken();
        }
    }//GEN-LAST:event_Button_VerwijderenActionPerformed


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
            java.util.logging.Logger.getLogger(MasterclassBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterclassBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterclassBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterclassBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MasterclassBeheer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_Toevoegen;
    private javax.swing.JButton Button_Verwijderen;
    private javax.swing.JButton Button_Wijzigen;
    private javax.swing.JTable Table_Masterclass;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
