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
import model.OTPRequest;

/**
 *
 * @author admin
 */
public class VerifyEmailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));
        String code = request.getParameter("code");
        OTPRequestDBContext otpDB = new OTPRequestDBContext();
        int otpId = Integer.parseInt(request.getParameter("otpId"));
        OTPRequest verifyCode = otpDB.checkCodeActive(code, userId);
        String email = request.getParameter("email");
        AccountDBContext accDB = new AccountDBContext();
        Account account = accDB.findAccountByEmail(email);
        int typeOTP = Integer.parseInt(request.getParameter("typeOTP"));
        if (verifyCode.getOtp_id() != 0) {

            if (otpDB.checkTimeCode(verifyCode.getExp_time())) {

                otpDB.VerifyCodeActive(verifyCode.getOtp_id());
                UserDBContext userDB = new UserDBContext();
                userDB.ActiveUser(userId);
                request.setAttribute("email", email);

                if (typeOTP == 2) {
                    String noti = "Your account has been registed successfully !";
                    request.setAttribute("noti", noti);
                    request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
                } else if (typeOTP == 3) {
                    request.getRequestDispatcher("/views/user/changepassword.jsp").forward(request, response);
                }

            } else {
                request.setAttribute("message", "Code is expired !");
                request.setAttribute("account", account);
                request.setAttribute("otpId", otpId);
                request.setAttribute("userId", userId);
                request.setAttribute("email", email);
                request.setAttribute("typeOTP", typeOTP);
                request.getRequestDispatcher("/views/user/verifyEmail.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Code is invalid !");
            request.setAttribute("account", account);
            request.setAttribute("otpId", otpId);
            request.setAttribute("userId", userId);
            request.setAttribute("email", email);
            request.setAttribute("typeOTP", typeOTP);
            request.getRequestDispatcher("/views/user/verifyEmail.jsp").forward(request, response);

        }
    }
}
