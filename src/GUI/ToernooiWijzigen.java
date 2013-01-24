/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.FaciliteitSimple;
import Models.Toernooi;
import configuration.SimpleDataSourceV2;
import java.awt.Color;
import java.sql.*;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Josua
 */
public class ToernooiWijzigen extends javax.swing.JFrame {

    /**
     * Creates new form ToernooiToevoegen
     */
    
    Toernooi toernooi;
    
    public ToernooiWijzigen() {
        initComponents();
        initcombobox();
        initinfo();
    }
    
    public ToernooiWijzigen(Toernooi toernooi) {
        this.toernooi = toernooi;
        initComponents();
        initcombobox();
        initinfo();
    }
    
    private void initinfo(){
        TextField_Bedrag.setText(Integer.toString(toernooi.getBedrag()));
        TextField_MinAantalSpelers.setText(Integer.toString(toernooi.getMin_aantal_spelers()));
        Calendar cal = Calendar.getInstance();
        cal.setTime(toernooi.getDatum());
        TextField_Jaar.setText(Integer.toString(cal.get(Calendar.YEAR)));
        TextField_Maand.setText(Integer.toString(cal.get(Calendar.MONTH) + 1));
        TextField_Dag.setText(Integer.toString(cal.get(Calendar.DAY_OF_MONTH)));
        
        TextField_TijdUren.setText(Integer.toString(toernooi.getBegintijd().getHours()));
        TextField_TijdMinuten.setText(Integer.toString(toernooi.getBegintijd().getMinutes()));
        
        TextField_Bedrag.setBackground(Color.green);
        TextField_Dag.setBackground(Color.green);
        TextField_Jaar.setBackground(Color.green);
        TextField_Maand.setBackground(Color.green);
        TextField_MinAantalSpelers.setBackground(Color.green);
        TextField_TijdMinuten.setBackground(Color.green);
        TextField_TijdUren.setBackground(Color.green);
        
        
    }
    
    
    
    private void initcombobox(){
        
        try {
            
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            model.addElement(new FaciliteitSimple(0,"None"));
            //SQL Statement.
            String sql = "SELECT F_Code, Naam FROM fullhouse.faciliteit;";

            Connection conn;
            conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            ResultSet res = stat.executeQuery();
            while (res.next()) {
                   model.addElement(new FaciliteitSimple(res.getInt("F_Code"), res.getString("Naam")));
            }

            ComboBox_Faciliteit.setModel(model);
            ComboBox_Faciliteit.setSelectedIndex(toernooi.getVind_plaats_in());
            
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

        TextField_Bedrag = new javax.swing.JTextField();
        TextField_MinAantalSpelers = new javax.swing.JTextField();
        TextField_Dag = new javax.swing.JTextField();
        TextField_TijdUren = new javax.swing.JTextField();
        TextField_Maand = new javax.swing.JTextField();
        TextField_Jaar = new javax.swing.JTextField();
        ComboBox_Faciliteit = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Button_Wijzigen = new javax.swing.JButton();
        Button_Back = new javax.swing.JButton();
        TextField_TijdMinuten = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextField_Bedrag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_BedragKeyReleased(evt);
            }
        });

        TextField_MinAantalSpelers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_MinAantalSpelersKeyReleased(evt);
            }
        });

        TextField_Dag.setText("DD");
        TextField_Dag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_DagKeyReleased(evt);
            }
        });

        TextField_TijdUren.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_TijdUrenKeyReleased(evt);
            }
        });

        TextField_Maand.setText("MM");
        TextField_Maand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_MaandKeyReleased(evt);
            }
        });

        TextField_Jaar.setText("YYYY");
        TextField_Jaar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_JaarKeyReleased(evt);
            }
        });

        ComboBox_Faciliteit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Bedrag");

        jLabel3.setText("Min. aantal spelers");

        jLabel4.setText("Datum");

        jLabel5.setText("Tijd");

        jLabel6.setText("Faciliteit");

        Button_Wijzigen.setText("Wijzigen");
        Button_Wijzigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_WijzigenActionPerformed(evt);
            }
        });

        Button_Back.setText("Back");
        Button_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BackActionPerformed(evt);
            }
        });

        TextField_TijdMinuten.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_TijdMinutenKeyReleased(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TextField_Dag, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextField_Maand, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextField_Jaar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
                            .addComponent(ComboBox_Faciliteit, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextField_Bedrag)
                            .addComponent(TextField_MinAantalSpelers, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TextField_TijdUren, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextField_TijdMinuten, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Button_Back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_Wijzigen)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(TextField_Bedrag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_MinAantalSpelers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_Dag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField_Maand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField_Jaar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextField_TijdUren, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TextField_TijdMinuten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox_Faciliteit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Wijzigen)
                    .addComponent(Button_Back))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackActionPerformed
        // Open ToernooiBeheer
        new ToernooiBeheer().setVisible(true);
        // Close current Window
        this.dispose();
    }//GEN-LAST:event_Button_BackActionPerformed

    private void Button_WijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_WijzigenActionPerformed
         
         
         try {
            
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            
            //SQL Statement.
            String sql = "update toernooi set Bedrag = ?, Min_aantal_spelers = ?,Datum = ?,Begintijd = ?,vindt_plaats_in = ? where T_Code = ?";

            Connection conn;
            conn = SimpleDataSourceV2.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, Integer.parseInt(TextField_Bedrag.getText()));
            stat.setInt(2, Integer.parseInt(TextField_MinAantalSpelers.getText()));
            stat.setString(3, TextField_Jaar.getText() + "-" + TextField_Maand.getText() + "-" + TextField_Dag.getText());
            stat.setString(4, TextField_TijdUren.getText() + ":" + TextField_TijdMinuten.getText());
            
            FaciliteitSimple fac = (FaciliteitSimple)ComboBox_Faciliteit.getSelectedItem();
            
            if (fac.getNaam().equals("None")){
                stat.setNull(5, 1);
            } else {
                stat.setInt(5, fac.getF_code());
            }
            stat.setInt(6, toernooi.getT_Code());
            
            stat.execute();
            
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Database Error" + ex.getMessage());
        }
         
        new ToernooiBeheer().setVisible(true);
        this.dispose();
         
    }//GEN-LAST:event_Button_WijzigenActionPerformed

    private void TextField_BedragKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_BedragKeyReleased
        String pattern = "[0-9]+";
        
        if (TextField_Bedrag.getText().matches(pattern)){
            TextField_Bedrag.setBackground(Color.green);
        } else {
            TextField_Bedrag.setBackground(Color.RED);
        }
    }//GEN-LAST:event_TextField_BedragKeyReleased

    private void TextField_MinAantalSpelersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_MinAantalSpelersKeyReleased
         String pattern = "[0-9]+";
        
        if (TextField_MinAantalSpelers.getText().matches(pattern)){
            TextField_MinAantalSpelers.setBackground(Color.green);
        } else {
            TextField_MinAantalSpelers.setBackground(Color.RED);
        }
    }//GEN-LAST:event_TextField_MinAantalSpelersKeyReleased

    private void TextField_DagKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_DagKeyReleased
        String pattern = "[0-9]{2}";
        
        if (TextField_Dag.getText().matches(pattern)){
            TextField_Dag.setBackground(Color.green);
        } else {
            TextField_Dag.setBackground(Color.RED);
        }
    }//GEN-LAST:event_TextField_DagKeyReleased

    private void TextField_MaandKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_MaandKeyReleased
        String pattern = "[0-9]{2}";
        
        if (TextField_Maand.getText().matches(pattern)){
            TextField_Maand.setBackground(Color.green);
        } else {
            TextField_Maand.setBackground(Color.RED);
        }
    }//GEN-LAST:event_TextField_MaandKeyReleased

    private void TextField_JaarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_JaarKeyReleased
        String pattern = "[0-9]{4}";
        
        if (TextField_Jaar.getText().matches(pattern)){
            TextField_Jaar.setBackground(Color.green);
        } else {
            TextField_Jaar.setBackground(Color.RED);
        }
    }//GEN-LAST:event_TextField_JaarKeyReleased

    private void TextField_TijdUrenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_TijdUrenKeyReleased
        String pattern = "[0-9]{2}";
        
        if (TextField_TijdUren.getText().matches(pattern)){
            TextField_TijdUren.setBackground(Color.green);
        } else {
            TextField_TijdUren.setBackground(Color.RED);
        }
    }//GEN-LAST:event_TextField_TijdUrenKeyReleased

    private void TextField_TijdMinutenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_TijdMinutenKeyReleased
         String pattern = "[0-9]{2}";
        
        if (TextField_TijdMinuten.getText().matches(pattern)){
            TextField_TijdMinuten.setBackground(Color.green);
        } else {
            TextField_TijdMinuten.setBackground(Color.RED);
        }
    }//GEN-LAST:event_TextField_TijdMinutenKeyReleased

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
            java.util.logging.Logger.getLogger(ToernooiWijzigen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToernooiWijzigen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToernooiWijzigen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToernooiWijzigen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ToernooiWijzigen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_Wijzigen;
    private javax.swing.JComboBox ComboBox_Faciliteit;
    private javax.swing.JTextField TextField_Bedrag;
    private javax.swing.JTextField TextField_Dag;
    private javax.swing.JTextField TextField_Jaar;
    private javax.swing.JTextField TextField_Maand;
    private javax.swing.JTextField TextField_MinAantalSpelers;
    private javax.swing.JTextField TextField_TijdMinuten;
    private javax.swing.JTextField TextField_TijdUren;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
