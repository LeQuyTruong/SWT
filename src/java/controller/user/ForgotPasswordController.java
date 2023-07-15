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
import java.io.PrintWriter;
import model.Account;
import model.User;
import utils.Email;

/**
 *
 * @author admin
 */
public class ForgotPasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/user/forgotPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String emailInput = request.getParameter("email");
        AccountDBContext accDB = new AccountDBContext();
        Account account = accDB.findAccountByEmail(emailInput);

        if (account != null) {

            int otpType = Integer.parseInt(request.getParameter("type_otp"));
            OTPRequestDBContext otpDB = new OTPRequestDBContext();
            String code = otpDB.createNewOTPForUser(account.getUsers().get(0).getUser_id(), otpType, 0);
            int otpId = otpDB.getCodeNotActive(code, account.getUsers().get(0).getUser_id()).getOtp_id();

            String messageTypeOTP = otpDB.messageType(otpType, code, account.getUsers().get(0).getDisplay_name());

            Email email = new Email();
            ThreadSendEmail t = new ThreadSendEmail(email, account.getUsers().get(0).getEmail(), "Code Active", messageTypeOTP);
            t.start();

            otpDB.createNewEmailForUser(1, otpType, code);
            request.setAttribute("typeOTP", otpType);
            request.setAttribute("account", account);
            request.setAttribute("email", account.getUsername());
            request.setAttribute("userId", account.getUsers().get(0).getUser_id());
            request.setAttribute("otpId", otpId);
            request.setAttribute("expiredTimeCode", "Expired Time: " + otpDB.getTimeCodeCreate(account.getUsers().get(0).getUser_id(), otpId));
            try {
                Thread.sleep(1000);
                request.getRequestDispatcher("/views/user/verifyEmail.jsp").forward(request, response);
            } catch (Exception e) {
            }
        } else {
            String message = "Your account does not exist. Please try again !";
            request.setAttribute("message", message);
            request.getRequestDispatcher("views/user/forgotPassword.jsp").forward(request, response);
        }

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

    public static void main(String[] args) {

    }

}
