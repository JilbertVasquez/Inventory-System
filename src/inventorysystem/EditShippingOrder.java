/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventorysystem;

import static inventorysystem.PrepareOrder.productQuantity;
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
public class EditShippingOrder extends javax.swing.JFrame {
    public static int shippingProductId;
    public static int inventoryProductQuantity;
    /**
     * Creates new form EditIncomingOrder
     */
    public EditShippingOrder() {
        initComponents();
        getShippingOrdersData();
        description.setEditable(false);
        price.setEditable(false);
        storeName.setEditable(false);
        storeProduct.setEditable(false);
        total.setEditable(false);
        markup.setEditable(false);
    }
    
    public static void getShippingOrdersData() {
        String dbName = "InventorySystem";
        String dbUsername = "root";
        String dbPassword = "root";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUsername, dbPassword)) {
             PreparedStatement ps = con.prepareStatement("select * from shippingorders where shippingId = ?");
             ps.setInt(1, shippingProductId);
             ResultSet rs = ps.executeQuery();
             
            int data1 = 0;
            String data2 = "";
            String data3 = "";
            String data4 = "";
            double data5 = 0.0;
            int data6 = 0;
            double data7 = 0.0;
            double data8 = 0.0;
            while (rs.next()) {
                data1 = rs.getInt("shippingId");
                data2 = rs.getString("storeNickname");
                data3 = rs.getString("shippingProductName");
                data4 = rs.getString("shippingProductDescription");
                data5 = rs.getDouble("shippingProductPrice");
                data6 = rs.getInt("shippingProductQuantity");
                data7 = rs.getDouble("total");
                data8 = rs.getDouble("markup");

                storeName.setText(String.valueOf(data2));
                storeProduct.setText(data3);
                description.setText(data4);
                price.setText(String.valueOf(data5));
                quantity.setText(String.valueOf(data6));
                total.setText(String.valueOf(data7));
                markup.setText(String.valueOf(data8));
            }
            
            PreparedStatement ps2 = con.prepareStatement("select * from inventory where inventoryProductName = ?");
             ps2.setString(1, data3);
             ResultSet rs2 = ps2.executeQuery();
             
             while(rs2.next()) {
                 int data = rs2.getInt("inventoryProductQuantity");
                 inventoryProductQuantity = data + data6;
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
        price = new javax.swing.JTextField();
        markup = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        storeProduct = new javax.swing.JTextField();
        storeName = new javax.swing.JTextField();
        supplierNameLabel = new javax.swing.JLabel();
        supplierNameLabel1 = new javax.swing.JLabel();
        quantityLabel1 = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        supplierNameLabel2 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editOrderLabel.setFont(new java.awt.Font("Nirmala UI", 1, 28)); // NOI18N
        editOrderLabel.setForeground(new java.awt.Color(255, 255, 255));
        editOrderLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/64/editing.png"))); // NOI18N
        editOrderLabel.setText("EDIT TO SHIP PRODUCT");
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
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 120, -1));

        price.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 192, -1));

        markup.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        markup.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        markup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                markupKeyReleased(evt);
            }
        });
        jPanel1.add(markup, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 192, -1));

        quantity.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        quantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 192, -1));

        total.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 192, -1));

        saveButton.setBackground(new java.awt.Color(75, 130, 245));
        saveButton.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24/diskette.png"))); // NOI18N
        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, 120, -1));

        storeProduct.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        storeProduct.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(storeProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 164, 192, -1));

        storeName.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        storeName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(storeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 120, 192, -1));

        supplierNameLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        supplierNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        supplierNameLabel.setText("STORE NAME:");
        jPanel1.add(supplierNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 123, 154, -1));

        supplierNameLabel1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        supplierNameLabel1.setForeground(new java.awt.Color(255, 255, 255));
        supplierNameLabel1.setText("SUPPLIER PRODUCT:");
        jPanel1.add(supplierNameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 167, 154, -1));

        quantityLabel1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        quantityLabel1.setForeground(new java.awt.Color(255, 255, 255));
        quantityLabel1.setText("MARKUP:");
        jPanel1.add(quantityLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 154, -1));

        quantityLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        quantityLabel.setForeground(new java.awt.Color(255, 255, 255));
        quantityLabel.setText("QUANTITY:");
        jPanel1.add(quantityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 154, -1));

        priceLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(255, 255, 255));
        priceLabel.setText("PRICE:");
        jPanel1.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 154, -1));

        totalLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalLabel.setText("TOTAL:");
        jPanel1.add(totalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 154, -1));
        jPanel1.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 190, 90));

        supplierNameLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        supplierNameLabel2.setForeground(new java.awt.Color(255, 255, 255));
        supplierNameLabel2.setText("PRODUCT DESCRIPTION:");
        jPanel1.add(supplierNameLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 160, 80));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/edit.jpg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-280, 0, 830, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        ShippingOrders SO = new ShippingOrders();
        SO.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
        String qty = quantity.getText();
        String mu = markup.getText();
        
        if (!qty.equals("")) {
            int quantityInput = Integer.parseInt(qty);
            if(quantityInput > inventoryProductQuantity) {
                JOptionPane.showMessageDialog(null, " Insufficient stock available. Current number of stocks: " + inventoryProductQuantity, "Success", JOptionPane.INFORMATION_MESSAGE);
                quantity.setText("");
            }
            else {
                double priceInput = Double.parseDouble(price.getText());
                double productMarkUp = Double.parseDouble(mu);
                double ttl = (priceInput + productMarkUp) * quantityInput;
                total.setText(String.valueOf(ttl));
            }
            
            double priceInput = Double.parseDouble(price.getText());
            double ttl = priceInput * quantityInput;
            total.setText(String.valueOf(ttl));
        }
    }//GEN-LAST:event_quantityKeyReleased

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String qty = quantity.getText();

        if (!qty.equals("")) {
            UserService userService = UserService.getInstance();
            String username = userService.getUsername();

            String dbName = "InventorySystem";
            String dbUsername = "root";
            String dbPassword = "root";

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUsername, dbPassword)) {
                String des = description.getText();
                String prod = storeProduct.getText();
                double priceInput = Double.parseDouble(price.getText());
                int quantityInput = Integer.parseInt(qty);
                double ttl = priceInput * quantityInput;
                
                int newInventoryProductQuantity = 0;
                
                if (inventoryProductQuantity > quantityInput) {
                    newInventoryProductQuantity = inventoryProductQuantity - quantityInput;
                    System.out.println(newInventoryProductQuantity);
                    String query2 = "update inventory set inventoryProductQuantity = ?, total = ? where inventoryProductName = ?";
                    PreparedStatement ps2 = con.prepareStatement(query2);
                    
                    ps2.setInt(1, newInventoryProductQuantity);
                    ps2.setDouble(2, newInventoryProductQuantity * priceInput);
                    ps2.setString(3, prod);
                    int rowsAffected = ps2.executeUpdate();
                    System.out.println("Rows affected in inventory update: " + rowsAffected);
                    if (rowsAffected == 0) {
                        System.out.println("No rows updated; check if the product name exists in inventory.");
                    }
                }
                
                String query = "UPDATE shippingorders SET shippingProductQuantity = ?,  total = ?, username = ? where shippingId = ?";
                PreparedStatement ps = con.prepareStatement(query);

                ps.setInt(1, quantityInput); 
                ps.setDouble(2, ttl);
                ps.setString(3, username); 
                ps.setInt(4, shippingProductId);

                ps.execute();

                JOptionPane.showMessageDialog(null, "Data update successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                ShippingOrders SO = new ShippingOrders();
                SO.setVisible(true);
                this.dispose();

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Quantity cannot be null.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }  
    }//GEN-LAST:event_saveButtonActionPerformed

    private void markupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_markupKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_markupKeyReleased

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
            java.util.logging.Logger.getLogger(EditShippingOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditShippingOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditShippingOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditShippingOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditShippingOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private static javax.swing.JTextField description;
    private javax.swing.JLabel editOrderLabel;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JTextField markup;
    private static javax.swing.JTextField price;
    private javax.swing.JLabel priceLabel;
    private static javax.swing.JTextField quantity;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JLabel quantityLabel1;
    private javax.swing.JButton saveButton;
    private static javax.swing.JTextField storeName;
    private static javax.swing.JTextField storeProduct;
    private javax.swing.JLabel supplierNameLabel;
    private javax.swing.JLabel supplierNameLabel1;
    private javax.swing.JLabel supplierNameLabel2;
    private static javax.swing.JTextField total;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
