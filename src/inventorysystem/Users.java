/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class Users extends javax.swing.JFrame {
    /**
     * Creates new form IncomingOrders
     */
    public Users() {
        initComponents();
        getSupplierList();
    }
    
    public static void getSupplierList() {
        DefaultTableModel tablemodel = (DefaultTableModel)storesTable.getModel();
        int tablecount = tablemodel.getRowCount();
        for (int i = tablecount-1; i >= 0; i--) {
            tablemodel.removeRow(i);
        }
        
        String dbName = "InventorySystem";
        String dbUsername = "root";
        String dbPassword = "root";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUsername, dbPassword)) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            while (rs.next()) {
                int data1 = rs.getInt("userId");
                String data2 = rs.getString("firstname");
                String data3 = rs.getString("lastname");
                String data4 = rs.getString("gmail");
                String data5 = rs.getString("username");
                String data6 = rs.getString("userRole");
                String data7 = rs.getString("userCreated_at");

                String[] incomingOrdersData = {
                    String.valueOf(data1),
                    data2,
                    data3,
                    data4,
                    data5,
                    data6,
                    data7.split(" ")[0]
                };

                tablemodel.addRow(incomingOrdersData);
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
        sectionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        storesTable = new javax.swing.JTable();
        searchLabel = new javax.swing.JLabel();
        productName = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        addUserButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sectionLabel.setFont(new java.awt.Font("Nirmala UI", 1, 28)); // NOI18N
        sectionLabel.setForeground(new java.awt.Color(255, 255, 255));
        sectionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/64/admin-panel.png"))); // NOI18N
        sectionLabel.setText("USERS");
        jPanel1.add(sectionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 27, -1, -1));

        storesTable.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        storesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FIRSTNAME", "LASTNAME", "USERNAME", "GMAIL", "USEROLE", "DATE CREATED"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(storesTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 158, 1000, -1));

        searchLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(255, 255, 255));
        searchLabel.setText("PRODUCT: ");
        jPanel1.add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 114, -1, -1));

        productName.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jPanel1.add(productName, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 111, 185, -1));

        searchButton.setBackground(new java.awt.Color(75, 130, 245));
        searchButton.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24/magnifying-glass.png"))); // NOI18N
        searchButton.setText("SEARCH");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 109, 120, -1));

        editButton.setBackground(new java.awt.Color(75, 130, 245));
        editButton.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24/editing.png"))); // NOI18N
        editButton.setText("EDIT");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        jPanel1.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 610, 110, -1));

        addUserButton.setBackground(new java.awt.Color(75, 130, 245));
        addUserButton.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        addUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24/add (1).png"))); // NOI18N
        addUserButton.setText("ADD USER");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, -1, -1));

        backButton.setBackground(new java.awt.Color(75, 130, 245));
        backButton.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24/left-arrow.png"))); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(926, 50, 130, -1));

        resetButton.setBackground(new java.awt.Color(75, 130, 245));
        resetButton.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        resetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24/undo-arrow.png"))); // NOI18N
        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        jPanel1.add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 110, 120, -1));

        deleteButton.setBackground(new java.awt.Color(75, 130, 245));
        deleteButton.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24/delete.png"))); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 610, 110, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/office.jpg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 0, 1270, 660));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 658));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        AddUser AU = new AddUser();
        AU.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        DefaultTableModel tablemodel = (DefaultTableModel)storesTable.getModel();
        int[] sel = storesTable.getSelectedRows();
        
        if (sel.length == 0) {
            JOptionPane.showMessageDialog(this, "Please select a data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        else if (sel.length != 1) {
            JOptionPane.showMessageDialog(this, "Please select only one data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            int id = Integer.parseInt((String) tablemodel.getValueAt(sel[0], 0)); 
            
            EditUser.userId = id;
            EditUser EU = new EditUser();
            
            EU.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainMenu MM = new MainMenu();
        MM.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        productName.setText("");
        getSupplierList();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String product = productName.getText();
        
        if (product.equals("")) {
            JOptionPane.showMessageDialog(this, "Please input a product.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            DefaultTableModel tablemodel = (DefaultTableModel)storesTable.getModel();
            int tablecount = tablemodel.getRowCount();
            for (int i = tablecount-1; i >= 0; i--) {
                tablemodel.removeRow(i);
            }

            String dbName = "InventorySystem";
            String dbUsername = "root";
            String dbPassword = "root";

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUsername, dbPassword)) {
                PreparedStatement ps = con.prepareStatement("select * from suppliers WHERE supplierId = ? or supplierName = ? or supplierNickname = ? or supplierLocation = ?");
                ps.setString(1, product);
                ps.setString(2, product);
                ps.setString(3, product);
                ps.setString(4, product);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int data1 = rs.getInt("supplierId");
                    String data2 = rs.getString("supplierName");
                    String data3 = rs.getString("supplierNickname");
                    String data4 = rs.getString("supplierLocation");
                    String data5 = rs.getString("supplierCreated_at");

                    String[] incomingOrdersData = {
                        String.valueOf(data1),
                        data2,
                        data3,
                        data4,
                        data5.split(" ")[0]
                    };

                    tablemodel.addRow(incomingOrdersData);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DefaultTableModel tablemodel = (DefaultTableModel)storesTable.getModel();
        int[] sel = storesTable.getSelectedRows();
        UserService userService = UserService.getInstance();
        String username = userService.getUsername();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        try {
            int a=JOptionPane.showConfirmDialog(this,"Are you sure you want to delete this user/s?");
            
            if (a==JOptionPane.YES_OPTION) {
                String dbName = "InventorySystem";
                String dbUsername = "root";
                String dbPassword = "root";

                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUsername, dbPassword)) {
                    for (int i = 0; i < sel.length; i++) {
                        String suppId = (String) tablemodel.getValueAt(sel[i], 0);
     
                        String sql = "Delete from suppliers where supplierId = ?";
                        PreparedStatement ps = con.prepareStatement(sql);

                        ps.setString(1, suppId);
                        ps.execute();
                    }
                    getSupplierList();
                    JOptionPane.showMessageDialog(null, "Store deletion successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please fill out all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Users().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField productName;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JLabel sectionLabel;
    private static javax.swing.JTable storesTable;
    // End of variables declaration//GEN-END:variables
}
