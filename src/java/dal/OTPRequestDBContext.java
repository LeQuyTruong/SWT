/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.OTPRequest;
import utils.Email;
import utils.MD5;

/**
 *
 * @author asus
 */
public class OTPRequestDBContext extends DBContext {

    String message_register = " <div style=\"text-align: center;\n"
            + "       background-color: #d3d3d3;\n"
            + "       padding: 10px;    font-size: 20px;;\">"
            + "Bạn hoặc ai đó đã sử dụng email để kích hoạt tài khoản khi đăng ký có tên " + "<h1>display_name</h1>" + "\n"
            + "\n"
            + "Ðây là  đoạn mã để kích hoạt tài khoản : <h1 style=\"color: red;\">otp_code</h1>\n"
            + "\n"
            + " <p style=\"font-style: italic;\"> Lưu ý: Mã code này chỉ có thẻ sử dụng  trong vòng 2 phút kể từ thời gian  gửi . Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản. </p>\n"
            + "\n"
            + "\n"
            + "<p style=\"font-weight: 800;\">Trân trọng cảm ơn!!</p>"
            + "</div>";
    String message_login
            = " <div style=\"text-align: center;\n"
            + "       background-color: #d3d3d3;\n"
            + "       padding: 10px;    font-size: 20px;\">"
            + "Bạn hoặc ai đó đã sử dụng email để kích hoạt tài khoản khi đăng nhập  có tên  " + "<h1>display_name</h1>" + "\n"
            + "\n"
            + "Ðây là  đoạn mã để kích hoạt tài khoản : <h1 style=\"color: red;\">otp_code</h1>\n"
            + "\n"
            + " <p style=\"font-style: italic;\"> Lưu ý: Mã code này chỉ có thẻ sử dụng  trong vòng 2 phút kể từ thời gian  gửi . Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản. </p>\n"
            + "\n"
            + "\n"
            + "<p style=\"font-weight: 800;\">Trân trọng cảm ơn!!</p>"
            + "</div>";
    String message_payment
            = " <div style=\"text-align: center;\n"
            + "       background-color: #d3d3d3;\n"
            + "       padding: 10px;    font-size: 20px;\">"
            + "Bạn hoặc ai đó đã sử dụng email để giao dịch chuyển khoản thông qua tài khoản có tên " + "<h1>display_name</h1>" + "\n"
            + "\n"
            + "Ðây là  đoạn mã để kích hoạt tài khoản : <h1 style=\"color: red;\">otp_code</h1>\n"
            + "\n"
            + " <p style=\"font-style: italic;\"> Lưu ý: Mã code này chỉ có thẻ sử dụng  trong vòng 2 phút kể từ thời gian gửi . Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản. </p>\n"
            + "\n"
            + "\n"
            + "<p style=\"font-weight: 800;\">Trân trọng cảm ơn!!</p>"
            + "</div>";
    String message_forgotPassword
            = " <div style=\"text-align: center;\n"
            + "       background-color: #d3d3d3;\n"
            + "       padding: 10px;    font-size: 20px;\">"
            + "Bạn hoặc ai đó đã sử dụng email khi quên mật khẩu với tài khoản có tên " + "<h1>display_name</h1>" + "\n"
            + "\n"
            + "Ðây là  đoạn mã để kích hoạt tài khoản : <h1 style=\"color: red;\">otp_code</h1>\n"
            + "\n"
            + " <p style=\"font-style: italic;\"> Lưu ý: Mã code này chỉ có thẻ sử dụng  trong vòng 2 phút kể từ thời gian  gửi . Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản. </p>\n"
            + "\n"
            + "\n"
            + "<p style=\"font-weight: 800;\">Trân trọng cảm ơn!!</p>"
            + "</div>";
//    String message_ChangePassword = 
//             " <div style=\"text-align: center;\n"
//            + "       background-color: #d3d3d3;\n"
//            + "       padding: 10px;    font-size: 20px;\">"
//            +"Bạn hoặc ai đó đã sử dụng email để thay đổi mật khẩu  với tài khoản có tên " + "<h1>display_name</h1>" + "\n"
//            + "\n"
//            + "Ðây là  code để kích hoạt tài khoản : <h1 style=\"color: red;\">otp_code</h1>\n"
//            + "\n"
//            + " <p style=\"font-style: italic;\"> Lưu ý: Mã code này chỉ có thẻ sử dụng  trong vòng 2 phút kể từ thời gian  gửi . Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản. </p>\n"
//            + "\n"
//            + "\n"
//            + "<p style=\"font-weight: 800;\">Trân trọng cảm ơn!!</p>"
//             + "</div>";

    public String createNewOTPForUser(int user_id, int typeOTP, int isVerify) {
        Email emails = new Email();
        String message = null;

        if (typeOTP == 1) {
            message = "Login";
        }
        if (typeOTP == 2) {
            message = "Register";
        }
        if (typeOTP == 3) {
            message = "ForgotPassword";
        }
        if (typeOTP == 4) {
            message = "Payment";
        }
        String code = emails.randomCode();
        String sql_user
                = "INSERT INTO [dbo].[OTPRequest]\n"
                + "           ([code]\n"
                + "           ,[type]\n"
                + "           ,[expired_time]\n"
                + "           ,[isVerify]\n"
                + "           ,[createdBy]\n"
                + "           ,[createdAt]\n"
                + "           ,[isDeleted])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,GETDATE()\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,GETDATE()\n"
                + "           ,0)";

        try {

            PreparedStatement st = connection.prepareCall(sql_user);
            st.setString(1, code);
            st.setString(2, message);
            st.setInt(3, isVerify);
            st.setInt(4, user_id);

            st.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    public void createNewEmailForUser(int isSent, int type, String code) {
        String message = null;

        if (type == 1) {
            message = "Login";
        }
        if (type == 2) {
            message = "Register";
        }
        if (type == 3) {
            message = "ForgotPassword";
        }
        if (type == 4) {
            message = "Payment";
        }
        String sql_user
                = "INSERT INTO [dbo].[Email]\n"
                + "           ([content]\n"
                + "           ,[isSend])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        String content = message + "- Code : " + code;
        try {

            PreparedStatement st = connection.prepareCall(sql_user);
            st.setString(1, content);
            st.setInt(2, isSent);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public User findUserByEmail(String email) {
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[email]\n"
                + "      ,[phone_number]\n"
                + "      ,[isActive]\n"
                + "      ,[isAdmin]\n"
                + "  FROM [dbo].[User] where email = ?";
        User us = new User();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                us.setUser_id(rs.getInt("id"));
                us.setDisplay_name(rs.getString("name"));
                us.setEmail(rs.getString("email"));
                us.setPhone_number(rs.getString("phone_number"));
                us.setIsActive(rs.getBoolean("isActive"));
                us.setIsAdmin(rs.getBoolean("isAdmin"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return us;
    }

    public String messageType(int type, String code, String name) {
        String message = "";
        if (type == 1) {
            message = message_login;
        }
        if (type == 2) {
            message = message_register;
        }
        if (type == 3) {
            message = message_forgotPassword;
        }
        if (type == 4) {
            message = message_payment;
        }
        String replaceName = message.replace("display_name", name);
        String replacedCode = replaceName.replace("otp_code", code);

        return replacedCode;
    }

    public OTPRequest getCodeNotActive(String code, int user_id) {
        String sql_account
                = "SELECT [id]\n"
                + "      ,[code]\n"
                + "      ,[type]\n"
                + "      ,[expired_time]\n"
                + "      ,[isVerify]\n"
                + "      ,[createdBy]\n"
                + "      ,[createdAt]\n"
                + "      ,[isDeleted]\n"
                + "  FROM [dbo].[OTPRequest]\n"
                + "  WHERE code = ? AND isVerify = 0 AND createdBy = ? AND isDeleted = 0";
        OTPRequest co = new OTPRequest();
        try {
            PreparedStatement st = connection.prepareStatement(sql_account);
            st.setString(1, code);
            st.setInt(2, user_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                co.setOtp_id(rs.getInt("id"));
                co.setUser_id(rs.getInt("createdBy"));
                co.setCode(rs.getString("code"));
                co.setType_name(rs.getString("type"));
                co.setExp_time(rs.getTimestamp("expired_time"));
                co.setIsVerify(rs.getBoolean("isVerify"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return co;
    }

    public OTPRequest checkCodeActive(String code, int user_id) {
        MD5 md5 = new MD5();
        String sql_account
                = "SELECT [id]\n"
                + "      ,[code]\n"
                + "      ,[type]\n"
                + "      ,[expired_time]\n"
                + "      ,[isVerify]\n"
                + "      ,[createdBy]\n"
                + "      ,[createdAt]\n"
                + "      ,[isDeleted]\n"
                + "  FROM [dbo].[OTPRequest]\n"
                + "  WHERE id = ? AND isVerify = 0 AND createdBy = ? AND isDeleted = 0";
        OTPRequest co = new OTPRequest();
        try {
            PreparedStatement st = connection.prepareStatement(sql_account);
            st.setInt(1, getCodeNotActive(code, user_id).getOtp_id());
            st.setInt(2, user_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                co.setOtp_id(rs.getInt("id"));
                co.setUser_id(rs.getInt("createdBy"));
                co.setCode(rs.getString("code"));
                co.setType_name(rs.getString("type"));
                co.setExp_time(rs.getTimestamp("expired_time"));
                co.setIsVerify(rs.getBoolean("isVerify"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return co;
    }

    public String getTimeCodeCreate(int user_id, int otp_id) {
        MD5 md5 = new MD5();
        String sql_account
                = "SELECT [id]\n"
                + "      ,[code]\n"
                + "      ,[type]\n"
                + "      ,[expired_time]\n"
                + "      ,[isVerify]\n"
                + "      ,[createdBy]\n"
                + "      ,[createdAt]\n"
                + "      ,[isDeleted]\n"
                + "  FROM [dbo].[OTPRequest]\n"
                + "  WHERE id = ? AND isVerify = 0 AND createdBy = ? AND isDeleted = 0";
        OTPRequest co = new OTPRequest();
        try {
            PreparedStatement st = connection.prepareStatement(sql_account);
            st.setInt(1, otp_id);
            st.setInt(2, user_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                co.setOtp_id(rs.getInt("id"));
                co.setUser_id(rs.getInt("createdBy"));
                co.setCode(rs.getString("code"));
                co.setType_name(rs.getString("type"));
                co.setExp_time(rs.getTimestamp("expired_time"));
                co.setIsVerify(rs.getBoolean("isVerify"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        String time = d.format(co.getExp_time());
        return time;
    }

    public void VerifyCodeActive(int otp_id) {
        MD5 md5 = new MD5();
        String sql_account
                = "UPDATE [dbo].[OTPRequest]\n"
                + "   SET [isVerify] = ?\n"
                + "      ,[updatedAt] = GETDATE()\n"
                + " WHERE id = ?";
        OTPRequest co = new OTPRequest();
        try {
            PreparedStatement st = connection.prepareStatement(sql_account);
            st.setInt(1, 1);
            st.setInt(2, otp_id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean checkTimeCode(Date dateCode) {
        Date dateNow = new Date();
        long result = dateNow.getTime() - dateCode.getTime();
        int second = (int) (result / 1000);
        if (second > 120) {
            return false;
        } else {
            return true;
        }
    }

}
