/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.User;
import utils.MD5;

/**
 *
 * @author torao
 */
public class AccountDBContext extends DBContext {

    public Account getAccount(String username, String password) throws NoSuchAlgorithmException {
        PreparedStatement stm = null;
        ResultSet rs = null;
        MD5 md = new MD5();
        try {
            String sql = "SELECT a.username,\n"
                    + "	   u.id, u.[name], u.email\n"
                    + "FROM Account a LEFT JOIN [User] u ON a.username = u.email\n"
                    + "WHERE a.username = ? AND a.[password] = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, md.encodeMD5(password));
            rs = stm.executeQuery();

            Account account = null;

            if (rs.next()) {
                if (account == null) {
                    account = new Account();
                    account.setUsername(username);
                }
                User user = new User();
                user.setUser_id(rs.getInt("id"));
                user.setDisplay_name(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                account.getUsers().add(user);
            }
            return account;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (stm != null)
                try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (connection != null)
                try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public Account findAccountByEmail(String email) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT a.username,\n"
                    + "		u.id, u.[name], u.email, u.phone_number\n"
                    + "FROM Account a LEFT JOIN [User] u ON a.username = u.email\n"
                    + "WHERE a.username = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            rs = stm.executeQuery();

            Account account = null;

            if (rs.next()) {
                if (account == null) {
                    account = new Account();
                    account.setUsername(rs.getString("username"));
                }
                User user = new User();
                user.setUser_id(rs.getInt("id"));
                user.setDisplay_name(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone_number(rs.getString("phone_number"));
                account.getUsers().add(user);
            }
            return account;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (stm != null)
                try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (connection != null)
                try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void changePassword(String email, String password) throws NoSuchAlgorithmException {
        PreparedStatement stm = null;
        MD5 md = new MD5();
        try {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "   SET [password] = ?\n"
                    + " WHERE [username] = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, md.encodeMD5(password));
            stm.setString(2, email);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
