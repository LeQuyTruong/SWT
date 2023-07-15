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
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Debt;
import model.Debtor;
import model.Notification;
import model.User;
import service.DebtService;
import utils.HandleCookies;

/**
 *
 * @author admin
 */
public class CreateDebtController extends BaseAuthenticationController {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            int debtorId = Integer.parseInt(request.getParameter("debtorId"));
            Account account = (Account) request.getSession().getAttribute("account");
            UserDBContext userDB = new UserDBContext();
            User user = userDB.findUserByEmail(account.getUsername());

            Debtor debtor = new Debtor();
            debtor.setDebtor_id(debtorId);
            Debt debt = new Debt();
            debt.setDebtor(debtor);
            debt.setReason(request.getParameter("reason"));
            debt.setRoleDebt(request.getParameter("role-debt").equals("creditor"));
            debt.setMoney(Integer.parseInt(request.getParameter("money")));

            SimpleDateFormat fomatter = new SimpleDateFormat("yyyy-MM-dd");
            debt.setDebtCreatedTime(fomatter.parse(request.getParameter("date")));

            DebtService debtService = new DebtService();
            boolean result = debtService.createDebt(user.getUser_id(), debt);

            String txt = "";
            Cookie[] arr = request.getCookies();
            for (Cookie cookie : arr) {
                if (cookie.getName().equals("notification")) {
                    txt += cookie.getValue();
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            HandleCookies hd = new HandleCookies();
            String cookies = hd.addNoti(user.getUser_id(), "success", "CreateDebt", txt);
            Cookie c = new Cookie("notification", cookies);
            c.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(c);
            if (result) {
                response.sendRedirect("debtList?debtorId=" + debtorId);
            } else {
                response.getWriter().println("insert debt failed !");
            }

        } catch (ParseException ex) {
            Logger.getLogger(CreateDebtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
