/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class PrepareOrder extends javax.swing.JFrame {
    /**
     * Creates new form AddIncomingOrder
     */
    public static int productQuantity = 0;
    
    public PrepareOrder() {
        initComponents();
        getSuppliersData(listOfStores);
        price.setEditable(false);
        total.setEditable(false);
        description.setEditable(false);
    }
    
    public static void getSuppliersData(JComboBox<String> listOfSuppliers) {
//        JComboBox<String> listOfSuppliers = new JComboBox<>();
        listOfSuppliers.removeAllItems();

        String dbName = "InventorySystem";
        String dbUsername = "root";
        String dbPassword = "root";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUsername, dbPassword)) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from inventory");
            while (rs.next()) {
                int data = rs.getInt("inventoryProductQuantity");
            }

            PreparedStatement ps2 = con.prepareStatement("select * from inventory");
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                String data2 = rs2.getString("inventoryProductName");
                listOfSuppliersProducts.addItem(data2);
            }
            
            PreparedStatement ps3 = con.prepareStatement("select * from stores");
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()) {
                String data = rs3.getString("storeNickname");
                listOfStores.addItem(data);
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
        addOrderLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        prepareOrdersTable = new javax.swing.JTable();
        listOfStores = new javax.swing.JComboBox<>();
        listOfSuppliersProducts = new javax.swing.JComboBox<>();
        price = new javax.swing.JTextField();
        markup = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        addButton1 = new javax.swing.JButton();
        description = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addOrderLabel.setFont(new java.awt.Font("Nirmala UI", 1, 28)); // NOI18N
        addOrderLabel.setForeground(new java.awt.Color(255, 255, 255));
        addOrderLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/64/add.png"))); // NOI18N
        addOrderLabel.setText("PREPARE ORDERS");
        jPanel1.add(addOrderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 26, -1, -1));

        backButton.setBackground(new java.awt.Color(75, 130, 245));
        backButton.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24/left-arrow.png"))); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 120, -1));

        prepareOrdersTable.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        prepareOrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STORE", "PRODUCT", "DESCRIPTION", "PRICE", "QUANTITY", "TOTAL", "MARKUP", "DATE CREATED"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(prepareOrdersTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 113, 950, -1));

        listOfStores.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jPanel1.add(listOfStores, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 113, 120, -1));

        listOfSuppliersProducts.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        listOfSuppliersProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listOfSuppliersProductsActionPerformed(evt);
            }
        });
        jPanel1.add(listOfSuppliersProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 157, 120, -1));

        price.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price.setText("PRICE");
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 120, -1));

        markup.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        markup.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        markup.setText("MARKUP");
        markup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                markupFocusGained(evt);
            }
        });
        markup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                markupKeyReleased(evt);
            }
        });
        jPanel1.add(markup, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 120, -1));

        quantity.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        quantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantity.setText("QUANTITY");
        quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                quantityFocusGained(evt);
            }
        });
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 120, -1));

        total.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setText("TOTAL");
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 120, -1));

        saveButton.setBackground(new java.awt.Color(75, 130, 245));
        saveButton.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24/diskette.png"))); // NOI18N
        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 570, 120, -1));

        addButton.setBackground(new java.awt.Color(75, 130, 245));
        addButton.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24/add (1).png"))); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 120, -1));

        addButton1.setBackground(new java.awt.Color(75, 130, 245));
        addButton1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        addButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24/delete.png"))); // NOI18N
        addButton1.setText("DELETE");
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(addButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 570, 120, -1));
        jPanel1.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 120, 100));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/warehouse1.jpg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, -20, 1280, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Inventory I = new Inventory();
        I.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void listOfSuppliersProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listOfSuppliersProductsActionPerformed
        String product = (String) listOfSuppliersProducts.getSelectedItem();

        String dbName = "InventorySystem";
        String dbUsername = "root";
        String dbPassword = "root";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUsername, dbPassword)) {
            PreparedStatement ps = con.prepareStatement("select * from inventory WHERE inventoryProductName = ?");
            ps.setString(1, product);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double data = rs.getDouble("inventoryProductPrice");
                String data2 = rs.getString("inventoryProductDescription");
                 int data3 = rs.getInt("inventoryProductQuantity");
                price.setText(String.valueOf(data));
                description.setText(data2);
                productQuantity = data3;
                
//                int id = rs.getInt("supplierProductId");
//                String data1 = rs.getString("supplierNickname");
//                String data2 = rs.getString("supplierProductName");
//                int data3 = rs.getInt("supplierProductPrice");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_listOfSuppliersProductsActionPerformed

    private void quantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityFocusGained
        quantity.setText("");
    }//GEN-LAST:event_quantityFocusGained

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String qty = quantity.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        
        if (qty.equals("")) {
            JOptionPane.showMessageDialog(null, "Please input quantity.", "Error", JOptionPane.ERROR_MESSAGE);        
        }
        else {
            String supplier = (String) listOfStores.getSelectedItem();
            String product = (String) listOfSuppliersProducts.getSelectedItem();
            String des = description.getText();
            double priceInput = Double.parseDouble(price.getText());

            int quantityInput = Integer.parseInt(qty);
            double ttl = Double.parseDouble(total.getText());
            double markupVal = Double.parseDouble(markup.getText());
            
            DefaultTableModel tablemodel = (DefaultTableModel)prepareOrdersTable.getModel();
            String[] incomingOrdersData = {
                    supplier,
                    product,
                    des,
                    String.valueOf(priceInput),
                    String.valueOf(quantityInput),
                    String.valueOf(ttl),
                    String.valueOf(markupVal),
                    date.split(" ")[0]
                };

                tablemodel.addRow(incomingOrdersData);
                productQuantity = productQuantity - quantityInput;
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
        DefaultTableModel tablemodel = (DefaultTableModel)prepareOrdersTable.getModel();
        int[] sel = prepareOrdersTable.getSelectedRows();
        
        if (sel.length == 0) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (int i = sel.length - 1; i >= 0; i--) {
            int rowIndex = sel[i];
            int quantityInput = Integer.parseInt((String) tablemodel.getValueAt(rowIndex, 4));
            productQuantity = productQuantity + quantityInput;
            tablemodel.removeRow(sel[i]);
        }
    }//GEN-LAST:event_addButton1ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        DefaultTableModel tablemodel = (DefaultTableModel)prepareOrdersTable.getModel();
        prepareOrdersTable.setRowSelectionInterval(0, prepareOrdersTable.getRowCount() - 1);
        int[] selAll = prepareOrdersTable.getSelectedRows();
        
        UserService userService = UserService.getInstance();
        String username = userService.getUsername();
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        
        if (selAll.length == 0) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            String dbName = "InventorySystem";
            String dbUsername = "root";
            String dbPassword = "root";

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUsername, dbPassword)) {
                int newproductQuantity = productQuantity;
                
                for (int i = 0; i < selAll.length; i++) {
                    int rowIndex = selAll[i];

                    String store = (String) tablemodel.getValueAt(rowIndex, 0);
                    String product = (String) tablemodel.getValueAt(rowIndex, 1);  
                    String des = (String) tablemodel.getValueAt(rowIndex, 2);  
                    double priceInput = Double.parseDouble((String) tablemodel.getValueAt(rowIndex, 3));
                    int quantityInput = Integer.parseInt((String) tablemodel.getValueAt(rowIndex, 4)); 
                    double ttl = Double.parseDouble((String) tablemodel.getValueAt(rowIndex, 5));
                    double markupValue = Double.parseDouble((String) tablemodel.getValueAt(rowIndex, 6));

                    String query = "INSERT INTO shippingorders (shippingProductName, shippingProductDescription, shippingProductQuantity, shippingProductPrice, total, storeNickname, username, shippingCreated_at, markup) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, product);
                    ps.setString(2, des);
                    ps.setInt(3, quantityInput); 
                    ps.setDouble(4, priceInput); 
                    ps.setDouble(5, ttl);
                    ps.setString(6, store);
                    ps.setString(7, username); 
                    ps.setString(8, date);
                    ps.setDouble(9, markupValue);

                    ps.execute();
                    
                    String sql3 = "UPDATE inventory SET inventoryProductQuantity = ?, total = ?  WHERE inventoryProductName = ?";
                    PreparedStatement ps3 = con.prepareStatement(sql3);
                    ps3.setInt(1, newproductQuantity);
                    ps3.setDouble(2, newproductQuantity * priceInput);
                    ps3.setString(3, product);
                    ps3.executeUpdate();

                    
                }

                JOptionPane.showMessageDialog(null, "Data saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                Inventory I = new Inventory();
                I.setVisible(true);
                this.dispose();

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void markupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_markupFocusGained
        markup.setText("");
    }//GEN-LAST:event_markupFocusGained

    private void markupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_markupKeyReleased
        String qty = quantity.getText();
        String mu = markup.getText();
        
        if (!qty.equals("") || !mu.equals("")) {
            int quantityInput = Integer.parseInt(qty);
            
            if (productQuantity < quantityInput) {
                JOptionPane.showMessageDialog(null, " Insufficient stock available. Current number of stocks: " + productQuantity, "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                double priceInput = Double.parseDouble(price.getText());
                double productMarkUp = Double.parseDouble(mu);
                double ttl = (priceInput + productMarkUp) * quantityInput;
                total.setText(String.valueOf(ttl));
            }
        } else {
            total.setText("");
        }
    }//GEN-LAST:event_markupKeyReleased

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
        String qty = quantity.getText();
        String mu = markup.getText();
        
        if (!qty.equals("") || !mu.equals("")) {
            int quantityInput = Integer.parseInt(qty);
            
            if (productQuantity < quantityInput) {
                JOptionPane.showMessageDialog(null, " Insufficient stock available. Current number of stocks: " + productQuantity, "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            
            double priceInput = Double.parseDouble(price.getText());
            double productMarkUp = Double.parseDouble(mu);
            double ttl = (priceInput + productMarkUp) * quantityInput;
            total.setText(String.valueOf(ttl));
        } else {
            total.setText("");
        }
    }//GEN-LAST:event_quantityKeyReleased

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
            java.util.logging.Logger.getLogger(PrepareOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrepareOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrepareOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrepareOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrepareOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addButton1;
    private javax.swing.JLabel addOrderLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JTextField description;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JComboBox<String> listOfStores;
    private static javax.swing.JComboBox<String> listOfSuppliersProducts;
    private javax.swing.JTextField markup;
    private javax.swing.JTable prepareOrdersTable;
    private javax.swing.JTextField price;
    private javax.swing.JTextField quantity;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
