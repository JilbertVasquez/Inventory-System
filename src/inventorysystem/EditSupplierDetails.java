/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventorysystem;

import inventorysystem.UserService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class EditSupplierDetails extends javax.swing.JFrame {
    public static int supplierId;
    /**
     * Creates new form EditIncomingOrder
     */
    public EditSupplierDetails() {
        initComponents();
        getIncomingOrderData();
    }
    
    public static void getIncomingOrderData() {
        String dbName = "InventorySystem";
        String dbUsername = "root";
        String dbPassword = "root";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUsername, dbPassword)) {
             PreparedStatement ps = con.prepareStatement("select * from suppliers where supplierId = ?");
             ps.setInt(1, supplierId);
             ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int data1 = rs.getInt("supplierId");
                String data2 = rs.getString("supplierName");
                String data3 = rs.getString("supplierNickname");
                String data4 = rs.getString("supplierLocation");

                supplierName.setText(String.valueOf(data2));
                supplierNickname.setText(data3);
                location.setText(data4);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        editOrderLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        location = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        supplierNickname = new javax.swing.JTextField();
        supplierName = new javax.swing.JTextField();
        supplierNameLabel = new javax.swing.JLabel();
        supplierNameLabel1 = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editOrderLabel.setFont(new java.awt.Font("Nirmala UI", 1, 28)); // NOI18N
        editOrderLabel.setForeground(new java.awt.Color(255, 255, 255));
        editOrderLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/64/editing.png"))); // NOI18N
        editOrderLabel.setText("EDIT SUPPLIER DETAILS");
        jPanel1.add(editOrderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 26, -1, -1));

        backButton.setBackground(new java.awt.Color(75, 130, 245));
        backButton.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24/left-arrow.png"))); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 120, -1));

        location.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        location.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(location, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 192, -1));

        saveButton.setBackground(new java.awt.Color(75, 130, 245));
        saveButton.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24/diskette.png"))); // NOI18N
        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 120, -1));

        supplierNickname.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        supplierNickname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(supplierNickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 192, -1));

        supplierName.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        supplierName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(supplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 120, 192, -1));

        supplierNameLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        supplierNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        supplierNameLabel.setText("SUPPLIER NAME:");
        jPanel1.add(supplierNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 123, 154, -1));

        supplierNameLabel1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        supplierNameLabel1.setForeground(new java.awt.Color(255, 255, 255));
        supplierNameLabel1.setText("SUPPLIER NICKNAME:");
        jPanel1.add(supplierNameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 154, -1));

        priceLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(255, 255, 255));
        priceLabel.setText("LOCATION:");
        jPanel1.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 154, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/edit.jpg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 0, 830, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Suppliers S = new Suppliers();
        S.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        UserService userService = UserService.getInstance();
        String username = userService.getUsername();

        String dbName = "InventorySystem";
        String dbUsername = "root";
        String dbPassword = "root";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUsername, dbPassword)) {
            String query = "UPDATE suppliers SET supplierName = ?, supplierNickname = ?, supplierLocation = ? where supplierId = ?";
            PreparedStatement ps = con.prepareStatement(query);

            String sName = supplierName.getText();
            String sNName = supplierNickname.getText();
            String sLoc = location.getText();
            
            ps.setString(1, sName); 
            ps.setString(2, sNName);
            ps.setString(3, sLoc); 
            ps.setInt(4, supplierId);

            ps.execute();

            JOptionPane.showMessageDialog(null, "Data update successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            Suppliers S = new Suppliers();
            S.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditSupplierDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditSupplierDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditSupplierDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditSupplierDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditSupplierDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JLabel editOrderLabel;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JTextField location;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JButton saveButton;
    private static javax.swing.JTextField supplierName;
    private javax.swing.JLabel supplierNameLabel;
    private javax.swing.JLabel supplierNameLabel1;
    private static javax.swing.JTextField supplierNickname;
    // End of variables declaration//GEN-END:variables
}
