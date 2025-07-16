/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorysystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author 
 */


public class UserService {
    private static UserService instance;
    private int userId;
    private String username;
    private String userRole;

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
    
    public String getUserRole() {
        return userRole;
    }
    
    private UserService() {}

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    
    public boolean login(String uname, String pass) {
        String dbName = "InventorySystem";
        String dbUsername = "root";
        String dbPassword = "root";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUsername, dbPassword)) {
            String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, uname);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.userId = rs.getInt("userId");
                this.username = rs.getString("username");
                this.userRole = rs.getString("userRole");

                JOptionPane.showMessageDialog(null, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean register(String fname, String lname, String uname, String gmail, String pass, String userRole) {
        String dbName = "InventorySystem";
        String dbUsername = "root";
        String dbPassword = "root";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUsername, dbPassword)) {
            
            String sql2 = "select * from users where username = ? or gmail = ?";
            PreparedStatement ps2 = con.prepareStatement(sql2);

            ps2.setString(1, gmail);
            ps2.setString(2, uname);
            ResultSet rs2 = ps2.executeQuery();
            
            if (rs2.next()) {
                JOptionPane.showMessageDialog(null, "User already exist!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            else {
                String sql = "INSERT INTO Users (firstname, lastname, gmail, username, password, userRole) VALUES(?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, fname);
                ps.setString(2, lname);
                ps.setString(3, gmail);
                ps.setString(4, uname);
                ps.setString(5, pass);
                ps.setString(6, userRole);
                ps.execute();

                JOptionPane.showMessageDialog(null, "Registration User Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean updateUser(int id, String fname, String lname, String uname, String gmail , String userRole) {
        String dbName = "InventorySystem";
        String dbUsername = "root";
        String dbPassword = "root";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUsername, dbPassword)) {
            
            String sql2 = "update users set firstname = ?, lastname = ?, gmail = ?, username = ?, userRole = ? where userId = ?";
            PreparedStatement ps2 = con.prepareStatement(sql2);

            ps2.setString(1, fname);
            ps2.setString(2, lname);
            ps2.setString(3, gmail);
            ps2.setString(4, uname);
            ps2.setString(5, userRole);
            ps2.setInt(6, id);
            ps2.execute();
            
            JOptionPane.showMessageDialog(null, "Edit User Details Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            return true;
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void logout() {
        userId = 0;
        username = null;
    }
}
