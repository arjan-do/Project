/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.MasterclassZoeken;
import configuration.SimpleDataSourceV2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import utils.DateUtil;

/**
 *
 * @author Otto
 */
public class MasterclassWijzigen extends javax.swing.JFrame {
MasterclassZoeken masterclass;
int M_Code;
int Niveau;
Date Datum;
int Prijs;
int Minimale_rating;
int Docent;
int Locatie;
int jaar;
int maand;
int dag;
String Achternaam;
String LNaam;
int DOCENT;
int LOCATIE;
        
        
    /**
     * Creates new form MasterclassWijzigen
     */
    public MasterclassWijzigen() {
        initComponents();
        vulNiveau();
        vulDatum();
        vulPrijs();
        vulMinRating();
        vulDocent();
        vulLocatie();
    }
    public MasterclassWijzigen(MasterclassZoeken masterclass){
        initComponents();
        vulNiveau();
        vulDatum();
        vulPrijs();
        vulMinRating();
        vulDocent();
        vulLocatie();
        this.masterclass = masterclass;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextField_Minimalerating = new javax.swing.JTextField();
        TextField_Prijs = new javax.swing.JTextField();
        Button_Wijzigen = new javax.swing.JButton();
        Button_Back = new javax.swing.JButton();
        ComboBox_Locatie = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextField_Niveau = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ComboBox_Docent = new javax.swing.JComboBox();
        TextField_Jaar = new javax.swing.JTextField();
        TextField_Dag = new javax.swing.JTextField();
        TextField_Maand = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        ComboBox_Locatie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Niveau");

        jLabel2.setText("Datum");

        jLabel3.setText("Locatie");

        jLabel6.setText("Prijs");

        jLabel7.setText("Minimale rating");

        jLabel5.setText("Docent");

        ComboBox_Docent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextField_Prijs, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboBox_Locatie, javax.swing.GroupLayout.Alignment.TRAILING, 0, 89, Short.MAX_VALUE)
                            .addComponent(ComboBox_Docent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextField_Minimalerating)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(Button_Back)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextField_Dag, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextField_Maand, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(TextField_Jaar))
                            .addComponent(Button_Wijzigen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(TextField_Niveau, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_Niveau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextField_Dag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField_Maand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField_Jaar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_Prijs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_Minimalerating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox_Docent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox_Locatie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Back)
                    .addComponent(Button_Wijzigen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackActionPerformed
        new HoofdMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Button_BackActionPerformed

    private void Button_WijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_WijzigenActionPerformed
        try{
        Niveau = Integer.parseInt(TextField_Niveau.getText());
        Prijs = Integer.parseInt(TextField_Prijs.getText());
        Minimale_rating = Integer.parseInt(TextField_Minimalerating.getText());
        
        Datum = null;
        
            dag = Integer.parseInt(TextField_Dag.getText());
            maand = Integer.parseInt(TextField_Maand.getText());
            jaar = Integer.parseInt(TextField_Jaar.getText());
            
            Datum = DateUtil.toSqlDate(jaar, maand, dag);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Voer de velden correct in.");
        }
        
        Docent = ComboBox_Docent.getWidth();
        Locatie = ComboBox_Docent.getWidth();
        
        if("Hoekstra".equals(Achternaam))
        {
            DOCENT = 1 ;
        }
        if("Van Leersum".equals(Achternaam))
        {
            DOCENT = 2 ;
        }
        if("Tromp".equals(Achternaam))
        {
            DOCENT = 3 ;
        }
        
        if("Theehuis".equals(LNaam))
        {
            LOCATIE = 1 ;
        }
        if("Buurthuis".equals(LNaam))
        {
            LOCATIE = 2 ;
        }
        if("Cafe".equals(LNaam))
        {
            LOCATIE = 3 ;
        }
        
        Minimale_rating = Integer.parseInt(TextField_Minimalerating.getText());
        try {
                String sql = "update masterclass set Niveau = ?, Prijs = ?, Datum = ?, Minimale_rating = ?, Docent = ?, Vindt_plaats_in = ? where M_Code = ?";
                Connection conn = SimpleDataSourceV2.getConnection();
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setInt(1, Niveau);
                stat.setInt(2, Prijs);
                stat.setDate(3, Datum);
                stat.setInt(4, Minimale_rating);
                stat.setInt(5, DOCENT);
                stat.setInt(6, LOCATIE);
                stat.setInt(7, M_Code);
                
                stat.execute();
                
                this.dispose();
                new MasterclassBeheer().setVisible(true);
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Databasefout" + ex.toString());
            }
    }//GEN-LAST:event_Button_WijzigenActionPerformed

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
            java.util.logging.Logger.getLogger(MasterclassWijzigen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterclassWijzigen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterclassWijzigen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterclassWijzigen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MasterclassWijzigen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_Wijzigen;
    private javax.swing.JComboBox ComboBox_Docent;
    private javax.swing.JComboBox ComboBox_Locatie;
    private javax.swing.JTextField TextField_Dag;
    private javax.swing.JTextField TextField_Jaar;
    private javax.swing.JTextField TextField_Maand;
    private javax.swing.JTextField TextField_Minimalerating;
    private javax.swing.JTextField TextField_Niveau;
    private javax.swing.JTextField TextField_Prijs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables


    private void vulNiveau() {
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            String sql = "select Niveau from masterclass";
            PreparedStatement stat = conn.prepareStatement(sql);
            
            ResultSet resultSet = stat.executeQuery();
            
            while(resultSet.next()){
                Niveau = resultSet.getInt("Niveau");
            }
            String niveau = Integer.toString(Niveau);
            TextField_Niveau.setText(niveau);
            
            
    }catch(SQLException e)
    {
        JOptionPane.showMessageDialog(this, e);
    }
    }

    private void vulDatum() {
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            String sql = "select Datum from masterclass";
            PreparedStatement stat = conn.prepareStatement(sql);
            
            ResultSet resultSet = stat.executeQuery();
            
            while(resultSet.next()){
                Datum = resultSet.getDate("Datum");
                
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.clear();
                cal.setTime(Datum);
                jaar = cal.get(Calendar.YEAR);
                maand = cal.get(Calendar.MONTH);
                dag = cal.get(Calendar.DAY_OF_MONTH);
                maand++;
                
                String JAAR = Integer.toString(jaar);
                String MAAND = Integer.toString(maand);
                String DAG = Integer.toString(dag);
                
                TextField_Jaar.setText(JAAR);
                TextField_Maand.setText(MAAND);
                TextField_Dag.setText(DAG);
            
            }
            
    }catch(SQLException e)
    {
        JOptionPane.showMessageDialog(this, e);
    }
    }

    private void vulPrijs() {
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            String sql = "select Prijs from masterclass";
            PreparedStatement stat = conn.prepareStatement(sql);
            
            ResultSet resultSet = stat.executeQuery();
            
            while(resultSet.next()){
                Prijs = resultSet.getInt("Prijs");
            }
            String prijs = Integer.toString(Prijs);
            TextField_Prijs.setText(prijs);
            
    }catch(SQLException e)
    {
        JOptionPane.showMessageDialog(this, e);
    }
    }

    private void vulMinRating() {
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            String sql = "select Minimale_rating from masterclass";
            PreparedStatement stat = conn.prepareStatement(sql);
            
            ResultSet resultSet = stat.executeQuery();
            
            while(resultSet.next()){
                Minimale_rating = resultSet.getInt("Minimale_rating");
            }
            String rating = Integer.toString(Minimale_rating);
            TextField_Minimalerating.setText(rating);
            
    }catch(SQLException e)
    {
        JOptionPane.showMessageDialog(this, e);
    }
    }

    private void vulDocent() {
        DefaultComboBoxModel docent = new DefaultComboBoxModel();
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            String sql = "select Achternaam from deelnemer";
            PreparedStatement stat = conn.prepareStatement(sql);
            
            ResultSet resultSet = stat.executeQuery();
            
            while(resultSet.next()){
                Achternaam = resultSet.getString("Achternaam");
                docent.addElement(Achternaam);
            }
            
            ComboBox_Docent.setModel(docent);
    }catch(SQLException e)
    {
        JOptionPane.showMessageDialog(this, e);
    }
    }

    private void vulLocatie() {
        DefaultComboBoxModel locatie = new DefaultComboBoxModel();
        try {
            Connection conn = SimpleDataSourceV2.getConnection();
            String sql = "select Naam from faciliteit";
            PreparedStatement stat = conn.prepareStatement(sql);
            
            ResultSet resultSet = stat.executeQuery();
            
            while(resultSet.next()){
                LNaam = resultSet.getString("Naam");
                locatie.addElement(LNaam);
            }
            
            ComboBox_Locatie.setModel(locatie);
    }catch(SQLException e)
    {
        JOptionPane.showMessageDialog(this, e);
    }
    }
}
