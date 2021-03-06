/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Toernooi;
import Models.Toernooizoeken;
import configuration.SimpleDataSourceV2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josua
 */
public class ToernooiBeheer extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    List<Toernooi> toernoois = new ArrayList<Toernooi>();
    List<Toernooizoeken> toernooiszoeken = new ArrayList<Toernooizoeken>();
    Toernooi toernooi;

    /**
     * Creates new form ToernooiBeheer
     */
    public ToernooiBeheer() {
        initComponents();
        initJtable();
    }

    private void initJtable() {
        //setup the jtable
        String[] kolommen = {"Datum", "Begintijd", "Locatienaam", "Min aantal spelers", "Aantal spelers"};
        model = new DefaultTableModel(kolommen, 0);
        TableToernooi.setModel(model);

        //running the sql querry
        sqlupdatetable("");

    }

    private boolean laatsteRonde(int t_code) {
        String sql = "select distinct ronde from plaats where toernooi = ? "
                + "group by ronde having max(tafel) = 1";
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, t_code);
            ResultSet res = stat.executeQuery();

            if (res.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    private boolean geenNullPlaats(int t_code) {
        String sql = "select * from plaats where toernooi = ? and plaats is null group by ronde, d_code";
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, t_code);
            ResultSet res = stat.executeQuery();
            if (res.next()) {
                return false;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return true;
    }

    private boolean toernooiIsGestart(int t_code) {
        String sql = "Select * from plaats where Toernooi = ?";
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, t_code);
            ResultSet res = stat.executeQuery();
            while (res.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    private boolean getBetalend(int t_code) {

        String sql = "select * from heeft_betaald where t_code = ?";
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, t_code);
            ResultSet res = stat.executeQuery();

            while (res.next()) {
                String betaalCheck = res.getString("inleggeld_betaald");
                if ("j".equals(betaalCheck)) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return true;
    }

    private void sqlupdatetable(String zoeken) {
        toernoois.clear();
        model.setRowCount(0);

        try {

            //SQL Statement.
            String sql = "select toernooi.vindt_plaats_in, toernooi.bedrag, toernooi.t_code, toernooi.datum , toernooi.begintijd, faciliteit.naam as locatienaam, toernooi.Min_aantal_spelers, count(heeft_betaald.T_code) as aantal_deelneer from toernooi left outer join faciliteit on toernooi.vindt_plaats_in = faciliteit.F_code left outer join heeft_betaald on toernooi.t_code = heeft_betaald.t_code group by toernooi.t_code having toernooi.t_code like ? or toernooi.datum like ? or toernooi.begintijd like ? or faciliteit.naam like ? or toernooi.Min_aantal_spelers like ? or count(heeft_betaald.T_code) like ?";

            Connection conn;
            conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, '%' + zoeken + '%');
            stat.setString(2, '%' + zoeken + '%');
            stat.setString(3, '%' + zoeken + '%');
            stat.setString(4, '%' + zoeken + '%');
            stat.setString(5, '%' + zoeken + '%');
            stat.setString(6, '%' + zoeken + '%');

            ResultSet res = stat.executeQuery();

            while (res.next()) {


                int vindtplaatsin = res.getInt("vindt_plaats_in");


                int bedrag = res.getInt("bedrag");
                int t_code = res.getInt("t_code");
                Date datum = res.getDate("datum");
                Time begintijd = res.getTime("begintijd");
                String locatienaam = res.getString("locatienaam");
                int minspelers = res.getInt("Min_aantal_spelers");
                int spelers = res.getInt("aantal_deelneer");

                Toernooizoeken toernooizoek = new Toernooizoeken(t_code, datum, begintijd, locatienaam, minspelers, spelers);
                model.addRow(toernooizoek.getrow());
                toernoois.add(new Toernooi(t_code, bedrag, minspelers, datum, begintijd, vindtplaatsin));
                toernooiszoeken.add(toernooizoek);
            }

            TableToernooi.setModel(model);

        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Database Error" + ex.getMessage());
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

        Button_Toevoegen = new javax.swing.JButton();
        Button_Wijzigen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableToernooi = new javax.swing.JTable();
        Button_Verwijderen = new javax.swing.JButton();
        Button_Back = new javax.swing.JButton();
        Button_Start = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TextField_Zoeken = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        TableToernooi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Datum", "Locatie", "Aantal Deelnemers"
            }
        ));
        jScrollPane1.setViewportView(TableToernooi);

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

        Button_Start.setText("Start");
        Button_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_StartActionPerformed(evt);
            }
        });

        jLabel1.setText("Zoeken:");

        TextField_Zoeken.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_ZoekenKeyReleased(evt);
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
                        .addComponent(Button_Toevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Wijzigen, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Verwijderen, javax.swing.GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Start)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Back))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextField_Zoeken, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextField_Zoeken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Toevoegen)
                    .addComponent(Button_Wijzigen)
                    .addComponent(Button_Verwijderen)
                    .addComponent(Button_Back)
                    .addComponent(Button_Start))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ToevoegenActionPerformed
        new ToernooiToevoegen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Button_ToevoegenActionPerformed

    private void Button_WijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_WijzigenActionPerformed
        //todo: datum, locatie en aantal deelnemers uit lijst halen en meegeven als parameter
        try{       
            Toernooi selected = toernoois.get(TableToernooi.getSelectedRow());
            new ToernooiWijzigen(selected).setVisible(true);
            this.dispose();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Selecteer een toernooi");
        }
    }//GEN-LAST:event_Button_WijzigenActionPerformed

    private void Button_VerwijderenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_VerwijderenActionPerformed

        int t_code = 0;

        int[] selected = TableToernooi.getSelectedRows();
        //Als selected.length 0 is (als er niets geselecteerd is), verschijnt er een messagedialog.
        if (selected.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecteer een toernooi.");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Weet u zeker dat U de geselecteerde rij(en) wilt verwijderen?") == JOptionPane.YES_OPTION) {


                //Omgedraaide for-loop vanwege problemen met de normale constructie
                for (int i = selected.length - 1; i > -1; i--) {
                    toernooi = toernoois.get(selected[i]);
                    t_code = toernooi.getT_Code();

                        String sql = "delete from heeft_betaald where t_code = ?";
                        String sql2 = "delete from toernooi where t_code = ?";
                        String sql4 = "delete from opstelling where toernooi = ?";
                        

                    if (getBetalend(toernooi.getT_Code()) != true && toernooiIsGestart(t_code) != true) {
                        JOptionPane.showMessageDialog(this, "Kan het toernooi niet verwijderen; Er zijn nog deelnemers die betaald hebben.");
                    } else if(getBetalend(toernooi.getT_Code()) == true && toernooiIsGestart(t_code)!=true){


                        try {
                            Connection conn = SimpleDataSourceV2.getConnection();
                            PreparedStatement stat = conn.prepareStatement(sql);
                            stat.setInt(1, t_code);
                            stat.execute();

                        } catch (SQLException ex) {
                            System.out.println(ex + "exBetaald");
                        }

                        try {
                            Connection conn = SimpleDataSourceV2.getConnection();
                            PreparedStatement stat = conn.prepareStatement(sql2);
                            stat.setInt(1, t_code);
                            stat.execute();
                        } catch (SQLException exc) {
                            JOptionPane.showMessageDialog(this, exc + "excBetaald");
                        }
                        model.removeRow(selected[i]);

                    }

                    else if(toernooiIsGestart(t_code) == true && laatsteRonde(t_code)==false ||toernooiIsGestart(t_code)==true &&geenNullPlaats(t_code)==false) {
                        JOptionPane.showMessageDialog(this, "Kan dit toernooi niet verwijderen: het is nog gaande.");

                    } else if(toernooiIsGestart(t_code)==true && laatsteRonde(t_code)==true &&geenNullPlaats(t_code)==true){


  

                        try {
                            Connection conn = SimpleDataSourceV2.getConnection();
                            PreparedStatement stat = conn.prepareStatement(sql4);
                            stat.setInt(1, t_code);
                            stat.execute();

                        } catch (SQLException ex) {
                            System.out.println(ex + "sql4");
                        }


                        try {
                            Connection conn = SimpleDataSourceV2.getConnection();
                            PreparedStatement stat = conn.prepareStatement(sql);
                            stat.setInt(1, t_code);
                            stat.execute();

                        } catch (SQLException ex) {
                            System.out.println(ex + "sql");
                        }

                        try {
                            Connection conn = SimpleDataSourceV2.getConnection();
                            PreparedStatement stat = conn.prepareStatement(sql2);
                            stat.setInt(1, t_code);
                            stat.execute();
                        } catch (SQLException exc) {
                            JOptionPane.showMessageDialog(this, exc + "sql2");
                        }
                        model.removeRow(selected[i]);
                    }
                }
            }

            model.setRowCount(0);
            toernoois.clear();
            sqlupdatetable(TextField_Zoeken.getText());
        }


    }//GEN-LAST:event_Button_VerwijderenActionPerformed

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackActionPerformed
        //Open Mainmenu
        new HoofdMenu().setVisible(true);
        //Close current Window
        this.dispose();
    }//GEN-LAST:event_Button_BackActionPerformed

    private void TextField_ZoekenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_ZoekenKeyReleased
        sqlupdatetable(TextField_Zoeken.getText());

    }//GEN-LAST:event_TextField_ZoekenKeyReleased

    private void Button_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_StartActionPerformed
        try{
            Toernooi selected = toernoois.get(TableToernooi.getSelectedRow());
            Toernooizoeken zoek = toernooiszoeken.get(TableToernooi.getSelectedRow());
            if (selected.getMin_aantal_spelers() <= zoek.getSpelers()) {
                new ToernooiStart(selected.getT_Code()).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Niet genoeg spelers");
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Selecteer een toernooi");
        }
    }//GEN-LAST:event_Button_StartActionPerformed

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
            java.util.logging.Logger.getLogger(ToernooiBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToernooiBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToernooiBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToernooiBeheer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ToernooiBeheer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_Start;
    private javax.swing.JButton Button_Toevoegen;
    private javax.swing.JButton Button_Verwijderen;
    private javax.swing.JButton Button_Wijzigen;
    private javax.swing.JTable TableToernooi;
    private javax.swing.JTextField TextField_Zoeken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
