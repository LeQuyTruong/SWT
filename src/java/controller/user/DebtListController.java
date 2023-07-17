/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Debt;
import model.Debtor;
import service.DebtService;
import service.DebtorService;

/**
 *
 * @author admin
 */
public class DebtListController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int debtorId = Integer.parseInt(request.getParameter("debtorId"));
        DebtService debtService = new DebtService();
        DebtorService debtorService = new DebtorService();
        Debtor debtor = debtorService.getDebtorById(debtorId);
        ArrayList<Debt> debts = debtService.getDebts(debtorId);
        request.setAttribute("debtor", debtor);
        request.setAttribute("debts", debts);
        request.getRequestDispatcher("/views/user/debtList.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
