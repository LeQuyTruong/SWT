/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.OTPRequest;
import model.User;
import utils.MD5;

/**
 *
 * @author asus
 */
public class UserDBContext extends DBContext {

    public List<User> getAllUserInformation() {
        List<User> list = new ArrayList<User>();
        String sql = "SELECT [user_id]\n"
                + "      ,[display_name]\n"
                + "      ,[email]\n"
                + "      ,[address]\n"
                + "      ,[phone_number]\n"
                + "      ,[gender]\n"
                + "      ,[image]\n"
                + "      ,[isActive]\n"
                + "      ,[isAdmin]\n"
                + "  FROM [dbo].[User]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User us = new User();
                us.setUser_id(rs.getInt("user_id"));
                us.setDisplay_name(rs.getString("display_name"));
                us.setEmail(rs.getString("email"));
                us.setAdr(rs.getString("address"));
                us.setPhone_number(rs.getString("phone_number"));
                us.setGender(rs.getInt("gender"));
                us.setImg(rs.getString("image"));
                us.setIsActive(rs.getBoolean("isActive"));
                us.setIsAdmin(rs.getBoolean("isAdmin"));
                list.add(us);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public User findUserByEmail(String email) {
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[email]\n"
                + "      ,[address]\n"
                + "      ,[phone_number]\n"
                + "      ,[gender]\n"
                + "      ,[image]\n"
                + "      ,[isActive]\n"
                + "      ,[isAdmin]\n"
                + "  FROM [dbo].[User]\n"
                + "  WHERE email = ?";
        User us = new User();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                us.setUser_id(rs.getInt("id"));
                us.setDisplay_name(rs.getString("name"));
                us.setEmail(rs.getString("email"));
                us.setAdr(rs.getString("address"));
                us.setPhone_number(rs.getString("phone_number"));
                us.setGender(rs.getInt("gender"));
                us.setImg(rs.getString("image"));
                us.setIsActive(rs.getBoolean("isActive"));
                us.setIsAdmin(rs.getBoolean("isAdmin"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return us;
    }

    public User findUserByID(int id) {
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[email]\n"
                + "      ,[address]\n"
                + "      ,[phone_number]\n"
                + "      ,[gender]\n"
                + "      ,[image]\n"
                + "      ,[isActive]\n"
                + "      ,[isAdmin]\n"
                + "  FROM [dbo].[User]\n"
                + "  WHERE id = ?";
        User us = new User();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                us.setUser_id(rs.getInt("id"));
                us.setDisplay_name(rs.getString("name"));
                us.setEmail(rs.getString("email"));
                us.setAdr(rs.getString("address"));
                us.setPhone_number(rs.getString("phone_number"));
                us.setGender(rs.getInt("gender"));
                us.setImg(rs.getString("image"));
                us.setIsActive(rs.getBoolean("isActive"));
                us.setIsAdmin(rs.getBoolean("isAdmin"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return us;
    }

    public void registerNewUser(User us) {
        MD5 md5 = new MD5();
        String sql_user
                = "INSERT INTO [dbo].[User]\n"
                + "           ([name]\n"
                + "           ,[email]\n"
                + "           ,[address]\n"
                + "           ,[phone_number]\n"
                + "           ,[gender]\n"
                + "           ,[image]\n"
                + "           ,[isActive]\n"
                + "           ,[isAdmin])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st1 = connection.prepareCall(sql_user);
            st1.setString(2, us.getEmail());
            st1.setString(1, us.getDisplay_name());
            st1.setString(3, us.getAdr());
            st1.setString(4, us.getPhone_number());
            st1.setInt(5, us.getGender());
            st1.setString(6, us.getImg());
            st1.setInt(7, 0);
            st1.setInt(8, 0);

            st1.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void registerNewAccount(User us) {
        MD5 md5 = new MD5();
        String sql_account
                = "INSERT INTO Account(username, [password])\n"
                + "VALUES  (?,?)";

        try {
            PreparedStatement st = connection.prepareCall(sql_account);
            st.setString(1, us.getEmail());
            st.setString(2, md5.encodeMD5(us.getPassword()));
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateUser(int user_id, String display_name, String phone, String address) {
        String sql = "UPDATE [User]\n"
                + "SET [name] = ?, phone_number = ?, [address] = ?\n"
                + "WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, display_name);
            st.setString(2, phone);
            st.setString(3, address);
            st.setInt(4, user_id);

            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int registerNewUserAndAccount(User uss) {
        UserDBContext ud = new UserDBContext();
        int status;
        if (ud.findUserByEmail(uss.getEmail()).getUser_id() == 0) {
            //Ko ton tai email , register dc
            ud.registerNewAccount(uss);
            ud.registerNewUser(uss);
            User us = findUserByEmail(uss.getEmail());
            status = us.getUser_id();
        } else {
            //ton tai roi ko register
            status = -1;
        }
        return status;
    }

    public void ActiveUser(int user_id) {
        String sql_account
                = "UPDATE [dbo].[User]\n"
                + "   SET [isActive] = ?\n"
                + " WHERE [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql_account);
            st.setInt(1, 1);
            st.setInt(2, user_id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
