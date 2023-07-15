/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.Account;

/**
 *
 * @author admin
 */
public abstract class BaseAuthenticationController extends HttpServlet {

    private boolean isAuthen(HttpServletRequest request) {
        return request.getSession().getAttribute("account") != null;

    }

    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException;

    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (isAuthen(request)) {
            Account account = (Account) request.getSession().getAttribute("account");
            doGet(request, response, account);
        } else {
            response.getWriter().println("access denied !");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (isAuthen(request)) {
            Account account = (Account) request.getSession().getAttribute("account");
            doPost(request, response, account);
        } else {
            response.getWriter().println("access denied !");
        }
    }
}
