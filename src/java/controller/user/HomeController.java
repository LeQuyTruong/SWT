/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import controller.auth.BaseAuthenticationController;
import dal.UserDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Account;
import model.User;

/**
 *
 * @author admin
 */
public class HomeController extends BaseAuthenticationController {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserDBContext userDB = new UserDBContext();
        User user = userDB.findUserByID(userId);
        request.setAttribute("user", user);         
        request.getRequestDispatcher("views/user/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
        request.getRequestDispatcher("views/user/home.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
        request.getRequestDispatcher("views/user/home.jsp").forward(request, response);
    }

}
