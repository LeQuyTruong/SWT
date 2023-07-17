/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.AccountDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author ngoan
 */
public class ChangePasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        AccountDBContext accDB = new AccountDBContext();
        try {
            accDB.changePassword(email, password);
            String noti = "Your account password has been changed successfully !";
            request.setAttribute("noti", noti);
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        request.setAttribute("email", email);
        request.getRequestDispatcher("views/user/changepassword.jsp").forward(request, response);
    }

}
