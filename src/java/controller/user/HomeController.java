/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import controller.auth.BaseAuthenticationController;
import dal.UserDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Notification;
import model.User;
import utils.HandleCookies;

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
        try {
            String txt = "";
            Cookie[] arr = request.getCookies();
            for (Cookie cookie : arr) {
                // tìm thay cookies thi lay value
                if (cookie.getName().equals("notification")) {
                    txt += cookie.getValue();
                }
            }
            HandleCookies hd = new HandleCookies();
            Account account1 =  (Account) request.getSession().getAttribute("account");
            List<Notification> listNoti = hd.getNoti(txt, account1.getUsers().get(0).getUser_id());
            int notiQuantity = listNoti.size();
            request.getSession().setAttribute("dataNoti", listNoti);
            request.getSession().setAttribute("lengthNoti", notiQuantity);
            request.getRequestDispatcher("views/user/home.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
        try {
            String txt = "";
            Cookie[] arr = request.getCookies();
            for (Cookie cookie : arr) {
                // tìm thay cookies thi lay value
                if (cookie.getName().equals("notification")) {
                    txt += cookie.getValue();
                }
            }
            HandleCookies hd = new HandleCookies();
            Account account2 =  (Account) request.getSession().getAttribute("account");
            List<Notification> listNoti = hd.getNoti(txt, account2.getUsers().get(0).getUser_id());
            int notiQuantity = listNoti.size();
            request.getSession().setAttribute("dataNoti", listNoti);
            request.getSession().setAttribute("lengthNoti", notiQuantity);
            
            request.getRequestDispatcher("views/user/home.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
