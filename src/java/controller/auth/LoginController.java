/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.auth;

import dal.AccountDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import utils.VerifyRecaptcha;

/**
 *
 * @author admin
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            AccountDBContext accDB = new AccountDBContext();
            Account account = accDB.getAccount(email, password);

            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
            System.out.println(gRecaptchaResponse);
            boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

            if (account != null && verify) {
                request.getSession().setAttribute("account", account);
                response.sendRedirect("home?userId=" + account.getUsers().get(0).getUser_id());
            } else {

                if (verify) {
                    String message = "Your email or password is invalid. Please try again !";
                    request.setAttribute("message", message);
                } else {
                    String message = "You missed the Captcha";
                    request.setAttribute("message", message);
                }
                request.getRequestDispatcher("views/auth/login.jsp").forward(request, response);

            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
