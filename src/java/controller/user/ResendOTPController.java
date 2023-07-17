/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.AccountDBContext;
import dal.OTPRequestDBContext;
import dal.UserDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Account;
import utils.Email;

/**
 *
 * @author asus
 */
public class ResendOTPController extends HttpServlet {

    UserDBContext ud = new UserDBContext();
    OTPRequestDBContext otp = new OTPRequestDBContext();
    Email emails = new Email();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter("userId"));
        int type_otp = Integer.parseInt(request.getParameter("typeOTP"));
        String code = otp.createNewOTPForUser(user_id, type_otp, 0);
        int otp_id = otp.getCodeNotActive(code, user_id).getOtp_id();
        //Tao mess
        String name = ud.findUserByID(user_id).getDisplay_name();
        String message_type_otp = otp.messageType(type_otp, code, name);
        //Gui email
        String email = ud.findUserByID(user_id).getEmail();
        ThreadSendEmail t = new ThreadSendEmail(emails, email, "Code Active", message_type_otp);
        t.start();

        AccountDBContext accDB = new AccountDBContext();
        Account account = accDB.findAccountByEmail(email);
        request.setAttribute("account", account);

        //Tao ban ghi email da gui
        otp.createNewEmailForUser(1, type_otp, code);
        request.setAttribute("noti", "Code is resend !");
        request.setAttribute("otpId", otp_id);
        request.setAttribute("userId", user_id);
        request.setAttribute("email", email);
        request.setAttribute("typeOTP", type_otp);
//        request.setAttribute("code_time", "Time create code: " + otp.getTimeCodeCreate(user_id, otp_id));
        request.setAttribute("user", ud.findUserByID(user_id));
        request.getRequestDispatcher("/views/user/verifyEmail.jsp").forward(request, response);

    }

    class ThreadSendEmail extends Thread {

        //Luong` gui email
        Email t;
        String title;
        String mail;
        String content;

        ThreadSendEmail(Email t, String mail, String title, String content) {
            this.t = t;
            this.title = title;
            this.mail = mail;
            this.content = content;
        }

        public void run() {
            try {
                Thread.sleep(100);
                t.sendMail(mail, title, content);
            } catch (Exception e) {
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }
}
