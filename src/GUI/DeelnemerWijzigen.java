/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Deelnemer;
import configuration.SimpleDataSourceV2;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import utils.EmailAddressValidator;

/**
 *
 * @author arjan
 */
public class DeelnemerWijzigen extends javax.swing.JFrame {

    /**
     * Creates new form DeelnemerToevoegen
     */
    Deelnemer deelnemer;
    int d_code;
    private boolean checkPostcode;
    private boolean checkEmail;
    String email;
    String postcode;

    public DeelnemerWijzigen() {
        initComponents();
    }

    public DeelnemerWijzigen(Deelnemer deelnemer) {
        initComponents();
        this.deelnemer = deelnemer;
        FillComponents();
        d_code = deelnemer.getD_code();
        checkEmail(email);
        checkPostcode(postcode);
    }

    private void FillComponents() {
        ButtonGroup bekend = new ButtonGroup();
        bekend.add(RadioButton_BekendJa);
        bekend.add(RadioButton_BekendNee);

        String voornaam = deelnemer.getVoornaam();
        String achternaam = deelnemer.getAchternaam();
        String straat = deelnemer.getStraat();
        int huisnummer = deelnemer.getHuisnummer();
        postcode = deelnemer.getPostcode();
        String woonplaats = deelnemer.getWoonplaats();
        int tel_nr = deelnemer.getTelefoon();
        email = deelnemer.getEmail();
        String is_bekend = deelnemer.getIsbekend();

        TextField_Voornaam.setText(voornaam);
        TextField_Achternaam.setText(achternaam);
        TextField_Straat.setText(straat);
        TextField_Huisnummer.setText(Integer.toString(huisnummer));
        TextField_Postcode.setText(postcode);
        TextField_Woonplaats.setText(woonplaats);
        TextField_Telefoonnummer.setText(Integer.toString(tel_nr));
        TextField_Email.setText(email);

    }

    private void checkEmail(String email) {

        if (EmailAddressValidator.isValidEmailAddress(email) == true) {
            this.lbMeldingEmail.setForeground(Color.green);
            this.lbMeldingEmail.setText("Email - Juiste formaat");
            checkEmail = true;
        } else {
            this.lbMeldingEmail.setForeground(Color.red);
            this.lbMeldingEmail.setText("Email - fout formaat");
            checkEmail = false;
        }
    }

    private void checkPostcode(String postcode) {


        String pattern = "[0-9]{4}\\s[a-zA-z]{2}";

        if (postcode.matches(pattern)) {
            this.lbMelding.setForeground(Color.green);
            this.lbMelding.setText("Postcode - juiste formaat");
            checkPostcode = true;
        } else {
            this.lbMelding.setForeground(Color.red);
            this.lbMelding.setText("Postcode - foute formaat");
            checkPostcode = false;
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextField_Voornaam = new javax.swing.JTextField();
        TextField_Achternaam = new javax.swing.JTextField();
        TextField_Straat = new javax.swing.JTextField();
        TextField_Huisnummer = new javax.swing.JTextField();
        TextField_Postcode = new javax.swing.JTextField();
        TextField_Woonplaats = new javax.swing.JTextField();
        TextField_Telefoonnummer = new javax.swing.JTextField();
        TextField_Email = new javax.swing.JTextField();
        RadioButton_BekendJa = new javax.swing.JRadioButton();
        RadioButton_BekendNee = new javax.swing.JRadioButton();
        Button_Toevoegen = new javax.swing.JButton();
        Button_Back = new javax.swing.JButton();
        lbMelding = new javax.swing.JLabel();
        lbMeldingEmail = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Voornaam:");

        jLabel2.setText("Achternaam:");

        jLabel3.setText("Straat:");

        jLabel4.setText("Huisnummer:");

        jLabel5.setText("Postcode:");

        jLabel6.setText("Woonplaats:");

        jLabel7.setText("Telefoon Nummer:");

        jLabel8.setText("Email:");

        jLabel9.setText("Bekend");

        TextField_Postcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_PostcodeKeyReleased(evt);
            }
        });

        TextField_Email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_EmailKeyReleased(evt);
            }
        });

        RadioButton_BekendJa.setText("Ja");

        RadioButton_BekendNee.setText("Nee");

        Button_Toevoegen.setText("Toepassen");
        Button_Toevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ToevoegenActionPerformed(evt);
            }
        });

        Button_Back.setText("Back");
        Button_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BackActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel7)
                            .add(jLabel6)
                            .add(jLabel8))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(TextField_Woonplaats, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .add(TextField_Telefoonnummer)
                            .add(TextField_Email)
                            .add(lbMeldingEmail, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(0, 0, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(Button_Back)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(Button_Toevoegen))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jLabel5)
                                            .add(jLabel4)
                                            .add(jLabel3)
                                            .add(jLabel2)
                                            .add(jLabel1))
                                        .add(32, 32, 32)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                .add(TextField_Straat, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                                .add(TextField_Achternaam)
                                                .add(TextField_Voornaam)
                                                .add(TextField_Huisnummer))
                                            .add(TextField_Postcode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(lbMelding, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 213, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel9)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(RadioButton_BekendJa)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(RadioButton_BekendNee)))
                                .add(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(0, 11, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, TextField_Voornaam, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(TextField_Achternaam, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(TextField_Straat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(TextField_Huisnummer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(TextField_Postcode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(lbMelding, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(11, 11, 11)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(TextField_Woonplaats, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(TextField_Telefoonnummer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(TextField_Email, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(lbMeldingEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel9)
                    .add(RadioButton_BekendJa)
                    .add(RadioButton_BekendNee))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Button_Toevoegen)
                    .add(Button_Back))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ToevoegenActionPerformed
        //onderstaande code van Email en Postcode zijn
        // Voor de gemakkelijkheid van de gebruiker, die nu niet eerst een toets
        //in hoeft te drukken voor hij/zij gegevens wil aanpassen. 





        if (checkEmail == true && checkPostcode == true) {

            try {
                Connection conn = SimpleDataSourceV2.getConnection();

                //Preparing..
                PreparedStatement stat = conn.prepareStatement("UPDATE `fullhouse`.`deelnemer` "
                        + "SET `voornaam`=?,"
                        + " `achternaam`= ?,"
                        + " `straat`=?, "
                        + "`huisnummer`=?, "
                        + "`postcode`=?, "
                        + "`woonplaats`=?,"
                        + "`tel_nr`=?, "
                        + "`e_mailadres`=?, "
                        + "`is_bekend`=?"
                        + " WHERE  `d_code`=?");
                //SetInts overgeslagen om die in een try-catch block te zetten (numberformatexceptions).
                stat.setString(1, TextField_Voornaam.getText());
                stat.setString(2, TextField_Achternaam.getText());
                stat.setString(3, TextField_Straat.getText());
                stat.setString(5, TextField_Postcode.getText());
                stat.setString(6, TextField_Woonplaats.getText());
                stat.setString(8, TextField_Email.getText());
                stat.setInt(10, d_code);
                //setString(9, is_bekend) overgeslagen vanwege radiobuttons.

                //2 verschillende try-catch blocks met dezelfde exception om onderscheid te maken
                // tussen huisnummer en telefoonnummer.

                try {
                    stat.setInt(4, Integer.parseInt(TextField_Huisnummer.getText()));

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(this, "Voer een geheel getal in voor het huisnummer.");
                }

                try {
                    stat.setInt(7, Integer.parseInt(TextField_Telefoonnummer.getText()));

                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(this, "Voer een geheel getal in voor het telefoonnummer.");
                }


                if (RadioButton_BekendJa.isSelected()) {
                    stat.setString(9, "j");
                } else if (RadioButton_BekendNee.isSelected()) {
                    stat.setString(9, "n");
                } else {
                    JOptionPane.showMessageDialog(this, "Selecteer één van de twee bij 'is_bekend.");
                }

                stat.execute();
                new DeelnemerBeheer().setVisible(true);
                this.dispose();

            } catch (SQLException e) {
                System.out.println(e);

            }
        } else {
            JOptionPane.showMessageDialog(this, "De gegevens van Postcode of Email zijn incorrect.");
        }


    }//GEN-LAST:event_Button_ToevoegenActionPerformed

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackActionPerformed
        // Open DeelnemerBeheer
        new DeelnemerBeheer().setVisible(true);
        // Close current Window
        this.dispose();
    }//GEN-LAST:event_Button_BackActionPerformed

    private void TextField_PostcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_PostcodeKeyReleased
        String postCode = this.TextField_Postcode.getText();

        String pattern = "[0-9]{4}\\s[a-zA-z]{2}";

        if (postCode.matches(pattern)) {
            this.lbMelding.setForeground(Color.green);
            this.lbMelding.setText("Postcode - juiste formaat");
            checkPostcode = true;
        } else {
            this.lbMelding.setForeground(Color.red);
            this.lbMelding.setText("Postcode - foute formaat");
            checkPostcode = false;
        }
    }//GEN-LAST:event_TextField_PostcodeKeyReleased

    private void TextField_EmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_EmailKeyReleased
        String email = this.TextField_Email.getText();

        if (EmailAddressValidator.isValidEmailAddress(email) == true) {
            this.lbMeldingEmail.setForeground(Color.green);
            this.lbMeldingEmail.setText("Email - Juiste formaat");
            checkEmail = true;
        } else {
            this.lbMeldingEmail.setForeground(Color.red);
            this.lbMeldingEmail.setText("Email - fout formaat");
            checkEmail = false;
        }
    }//GEN-LAST:event_TextField_EmailKeyReleased

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
            java.util.logging.Logger.getLogger(DeelnemerWijzigen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeelnemerWijzigen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeelnemerWijzigen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeelnemerWijzigen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DeelnemerWijzigen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_Toevoegen;
    private javax.swing.JRadioButton RadioButton_BekendJa;
    private javax.swing.JRadioButton RadioButton_BekendNee;
    private javax.swing.JTextField TextField_Achternaam;
    private javax.swing.JTextField TextField_Email;
    private javax.swing.JTextField TextField_Huisnummer;
    private javax.swing.JTextField TextField_Postcode;
    private javax.swing.JTextField TextField_Straat;
    private javax.swing.JTextField TextField_Telefoonnummer;
    private javax.swing.JTextField TextField_Voornaam;
    private javax.swing.JTextField TextField_Woonplaats;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbMelding;
    private javax.swing.JLabel lbMeldingEmail;
    // End of variables declaration//GEN-END:variables
}
