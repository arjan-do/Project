/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Deelnemer;
import configuration.SimpleDataSourceV2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arjan
 */
public class DeelnemerBeheer extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    private ArrayList<Deelnemer> deelnemers = new ArrayList<>();
    int d_code;
    Deelnemer deelnemer;

    /**
     * Creates new form DeelnemerBeheer
     */
    public DeelnemerBeheer() {
        initComponents();
        FillComponents();
        updateTable();
    }

    // filling all components
    private void FillComponents() {
        String[] kolommen = {"Voornaam", "Achternaam", "Rating"};
        model = new DefaultTableModel(kolommen, 0);
        Table_Deelnemers.setModel(model);
    }

    private void updateTable() {
        String input = TextField_Zoekopnaam.getText();


        try {

            //SQL Statement.
            String sql = "Select * from deelnemer where voornaam like ? or achternaam like ?";

            Connection conn;
            conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            //input of the textfield + "%" for the SQL Statement.
            stat.setString(1, input + '%');
            stat.setString(2, input + '%');

            ResultSet res = stat.executeQuery();


            while (res.next()) {


                deelnemer = new Deelnemer(res.getInt("d_code"),
                        res.getString("Voornaam"),
                        res.getString("Achternaam"),
                        res.getString("Postcode"),
                        res.getString("woonplaats"),
                        res.getInt("tel_nr"),
                        res.getInt("huisnummer"),
                        res.getString("is_bekend"),
                        res.getString("straat"),
                        res.getString("e_mailadres"),
                        res.getInt("rating"));
                deelnemers.add(deelnemer);
                model.addRow(deelnemer.getInfo());

            }




        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private boolean getBetalendMasterclass(int d_code) {

        String sql = "select * from volgt where d_code = ?";
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, d_code);
            ResultSet res = stat.executeQuery();

            while (res.next()) {
                String betaalCheck = res.getString("heeft_betaald");
                if ("j".equals(betaalCheck)) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return true;
    }

    private boolean getBetalendToernooi(int d_code) {

        String sql = "select * from heeft_betaald where d_code = ?";
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, d_code);
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
        Button_Bekijken = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btToernooi = new javax.swing.JButton();

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

        jLabel1.setText("Zoeken:");

        Button_Bekijken.setText("Bekijken");
        Button_Bekijken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BekijkenActionPerformed(evt);
            }
        });

        jButton1.setText("Masterclass");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btToernooi.setText("Toernooi");
        btToernooi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btToernooiActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(TextField_Zoekopnaam, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 360, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(15, 15, 15)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(layout.createSequentialGroup()
                                        .add(Button_Wijzigen, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .add(layout.createSequentialGroup()
                                        .add(Button_Bekijken, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(Button_Toevoegen, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(Button_Verwijderen, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(btToernooi, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .add(18, 18, 18)
                                .add(Button_Back)))
                        .add(0, 18, Short.MAX_VALUE)))
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
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Button_Wijzigen)
                    .add(jButton1)
                    .add(btToernooi))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 8, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Button_Bekijken)
                    .add(Button_Verwijderen)
                    .add(Button_Back)
                    .add(Button_Toevoegen)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ToevoegenActionPerformed
        new DeelnemerToevoegen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Button_ToevoegenActionPerformed

    private void Button_WijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_WijzigenActionPerformed

        int[] selected = Table_Deelnemers.getSelectedRows();
        //Als selected.length 0 is (als er niets geselecteerd is), verschijnt er een messagedialog.
        if (selected.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecteer een deelnemer.");
            //Als er meer dan 1 persoon geselecteerd is, verschijnt er een messagedialog.
        } else if (selected.length > 1) {
            JOptionPane.showMessageDialog(this, "Selecteer maximaal 1 persoon.");
            //Als bovenstaande condities niet waar zijn, wordt het wijzigscherm toegelaten.
        } else {
            int row = Table_Deelnemers.getSelectedRow();
            deelnemer = deelnemers.get(row);
            d_code = deelnemer.getD_code();



            try {
                String sql = "Select * from deelnemer where d_code = ?";
                Connection conn = SimpleDataSourceV2.getConnection();
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setInt(1, d_code);

                ResultSet res = stat.executeQuery();
                while (res.next()) {
                    //Maakt een nieuwe deelnemer met alle bijbehorende attributen.
                    deelnemer = new Deelnemer(res.getInt("d_code"),
                            res.getString("Voornaam"),
                            res.getString("Achternaam"),
                            res.getString("Postcode"),
                            res.getString("woonplaats"),
                            res.getInt("tel_nr"),
                            res.getInt("huisnummer"),
                            res.getString("is_bekend"),
                            res.getString("straat"),
                            res.getString("e_mailadres"),
                            res.getInt("rating"));
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
            //geeft deelnemer mee aan het Wijzigen-scherm.
            new DeelnemerWijzigen(deelnemer).setVisible(true);
            this.dispose();

        }


    }//GEN-LAST:event_Button_WijzigenActionPerformed

    private void Button_VerwijderenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_VerwijderenActionPerformed

        int[] selected = Table_Deelnemers.getSelectedRows();
        //Als selected.length 0 is (als er niets geselecteerd is), verschijnt er een messagedialog.
        if (selected.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecteer een deelnemer.");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Weet u zeker dat U de geselecteerde rij(en) wilt verwijderen?") == JOptionPane.YES_OPTION) {


                //Omgedraaide for-loop vanwege problemen met de normale constructie
                for (int i = selected.length - 1; i > -1; i--) {
                    deelnemer = deelnemers.get(selected[i]);
                    d_code = deelnemer.getD_code();
                    String sql = "delete from deelnemer where d_code = ?";
                    String sql2 = "Delete from heeft_betaald where d_code = ?";
                    String sql3 = "Delete from volgt where d_code = ?";

                    if (getBetalendMasterclass(d_code) == true && getBetalendToernooi(d_code) == true) {

                        model.removeRow(selected[i]);


                        try {
                            Connection conn = SimpleDataSourceV2.getConnection();
                            PreparedStatement stat = conn.prepareStatement(sql2);
                            stat.setInt(1, d_code);
                            stat.execute();

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(this, ex);
                        }
                        try {
                            Connection conn = SimpleDataSourceV2.getConnection();
                            PreparedStatement stat = conn.prepareStatement(sql3);
                            stat.setInt(1, d_code);
                            stat.execute();

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(this, ex);
                        }

                        try {
                            Connection conn = SimpleDataSourceV2.getConnection();
                            PreparedStatement stat = conn.prepareStatement(sql);
                            stat.setInt(1, d_code);
                            stat.execute();

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(this, ex);
                        }
                    }else if(!getBetalendMasterclass(d_code))
                    {
                        JOptionPane.showMessageDialog(this, "Deze deelnemer heeft betaald voor een Masterclass. Verander eerst de status.");
                    }else if(!getBetalendToernooi(d_code))
                    {
                        JOptionPane.showMessageDialog(this, "Deze persoon staat nog ingeschreven voor een toernooi. Verander eerst de status.");
                    }
                }
            }
            //Update de modelRows, clear de arraylist Deelnemers.
            model.setRowCount(0);
            deelnemers.clear();
            updateTable();
        }



    }//GEN-LAST:event_Button_VerwijderenActionPerformed

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackActionPerformed
        //Open Mainmenu
        new HoofdMenu().setVisible(true);
        //Close current Window
        this.dispose();
    }//GEN-LAST:event_Button_BackActionPerformed

    private void TextField_ZoekopnaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_ZoekopnaamKeyReleased
        //setRowCount to refresh the model.
        model.setRowCount(0);
        //clear ArrayList for refreshing purposes.
        deelnemers.clear();
        updateTable();


    }//GEN-LAST:event_TextField_ZoekopnaamKeyReleased

    private void TextField_ZoekopnaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_ZoekopnaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_ZoekopnaamActionPerformed

    private void Button_BekijkenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BekijkenActionPerformed

        int[] selected = Table_Deelnemers.getSelectedRows();
        //Als selected.length 0 is (als er niets geselecteerd is), verschijnt er een messagedialog.
        if (selected.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecteer een deelnemer.");
            //Als er meer dan 1 persoon geselecteerd is, verschijnt er een messagedialog.
        } else if (selected.length > 1) {
            JOptionPane.showMessageDialog(this, "Selecteer maximaal 1 persoon.");
            //Als bovenstaande condities niet waar zijn, wordt het wijzigscherm toegelaten.
        } else {
            int row = Table_Deelnemers.getSelectedRow();
            deelnemer = deelnemers.get(row);
            d_code = deelnemer.getD_code();



            try {
                String sql = "Select * from deelnemer where d_code = ?";
                Connection conn = SimpleDataSourceV2.getConnection();
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setInt(1, d_code);

                ResultSet res = stat.executeQuery();
                while (res.next()) {
                    //Maakt een nieuwe deelnemer met alle bijbehorende attributen.
                    deelnemer = new Deelnemer(res.getInt("d_code"),
                            res.getString("Voornaam"),
                            res.getString("Achternaam"),
                            res.getString("Postcode"),
                            res.getString("woonplaats"),
                            res.getInt("tel_nr"),
                            res.getInt("huisnummer"),
                            res.getString("is_bekend"),
                            res.getString("straat"),
                            res.getString("e_mailadres"),
                            res.getInt("rating"));
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
            new DeelnemerBekijken(deelnemer).setVisible(true);
        }


    }//GEN-LAST:event_Button_BekijkenActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


        int[] selected = Table_Deelnemers.getSelectedRows();
        //Als selected.length 0 is (als er niets geselecteerd is), verschijnt er een messagedialog.
        if (selected.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecteer een deelnemer.");
            //Als er meer dan 1 persoon geselecteerd is, verschijnt er een messagedialog.
        } else if (selected.length > 1) {
            JOptionPane.showMessageDialog(this, "Selecteer maximaal 1 persoon.");
            //Als bovenstaande condities niet waar zijn, wordt het wijzigscherm toegelaten.
        } else {
            int row = Table_Deelnemers.getSelectedRow();
            deelnemer = deelnemers.get(row);
            d_code = deelnemer.getD_code();



            try {
                String sql = "Select * from deelnemer where d_code = ?";
                Connection conn = SimpleDataSourceV2.getConnection();
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setInt(1, d_code);

                ResultSet res = stat.executeQuery();
                while (res.next()) {
                    //Maakt een nieuwe deelnemer met alle bijbehorende attributen.
                    deelnemer = new Deelnemer(res.getInt("d_code"),
                            res.getString("Voornaam"),
                            res.getString("Achternaam"),
                            res.getString("Postcode"),
                            res.getString("woonplaats"),
                            res.getInt("tel_nr"),
                            res.getInt("huisnummer"),
                            res.getString("is_bekend"),
                            res.getString("straat"),
                            res.getString("e_mailadres"),
                            res.getInt("rating"));
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
            new DeelnemerBekijkMCs(deelnemer).setVisible(true);
            this.dispose();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btToernooiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btToernooiActionPerformed

        int[] selected = Table_Deelnemers.getSelectedRows();
        //Als selected.length 0 is (als er niets geselecteerd is), verschijnt er een messagedialog.
        if (selected.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecteer een deelnemer.");
            //Als er meer dan 1 persoon geselecteerd is, verschijnt er een messagedialog.
        } else if (selected.length > 1) {
            JOptionPane.showMessageDialog(this, "Selecteer maximaal 1 persoon.");
            //Als bovenstaande condities niet waar zijn, wordt het wijzigscherm toegelaten.
        } else {
            int row = Table_Deelnemers.getSelectedRow();
            deelnemer = deelnemers.get(row);
            d_code = deelnemer.getD_code();



            try {
                String sql = "Select * from deelnemer where d_code = ?";
                Connection conn = SimpleDataSourceV2.getConnection();
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setInt(1, d_code);

                ResultSet res = stat.executeQuery();
                while (res.next()) {
                    //Maakt een nieuwe deelnemer met alle bijbehorende attributen.
                    deelnemer = new Deelnemer(res.getInt("d_code"),
                            res.getString("Voornaam"),
                            res.getString("Achternaam"),
                            res.getString("Postcode"),
                            res.getString("woonplaats"),
                            res.getInt("tel_nr"),
                            res.getInt("huisnummer"),
                            res.getString("is_bekend"),
                            res.getString("straat"),
                            res.getString("e_mailadres"),
                            res.getInt("rating"));
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
            new DeelnemerBekijkToernooien(deelnemer).setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btToernooiActionPerformed

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
    private javax.swing.JButton Button_Bekijken;
    private javax.swing.JButton Button_Toevoegen;
    private javax.swing.JButton Button_Verwijderen;
    private javax.swing.JButton Button_Wijzigen;
    private javax.swing.JTable Table_Deelnemers;
    private javax.swing.JTextField TextField_Zoekopnaam;
    private javax.swing.JButton btToernooi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
