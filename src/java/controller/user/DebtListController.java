/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import controller.auth.BaseAuthenticationController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Debt;
import model.Debtor;
import model.Notification;
import service.DebtService;
import service.DebtorService;
import utils.HandleCookies;
import utils.Helper;

/**
 *
 * @author admin
 */
public class DebtListController extends BaseAuthenticationController {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String rawDebtId = request.getParameter("debtId");
            String rawReason = request.getParameter("reason");
            String rawRoleDebt = request.getParameter("roleDebt");
            String rawMoneyFrom = request.getParameter("moneyFrom");
            String rawMoneyTo = request.getParameter("moneyTo");
            String rawDebtFrom = request.getParameter("debtFrom");
            String rawDebtTo = request.getParameter("debtTo");
            String rawRecordFrom = request.getParameter("recordFrom");
            String rawRecordTo = request.getParameter("recordTo");

            if (rawDebtId == null || rawDebtId.length() == 0) {
                rawDebtId = "-1";
            }
            if (rawRoleDebt == null || rawRoleDebt.length() == 0) {
                rawRoleDebt = "all";
            }
            if (rawMoneyFrom == null || rawMoneyFrom.length() == 0) {
                rawMoneyFrom = "-1";
            }
            if (rawMoneyTo == null || rawMoneyTo.length() == 0) {
                rawMoneyTo = "-1";
            }

            int debtId = Integer.parseInt(rawDebtId);
            String reason = rawReason;
            Boolean roleDebt = rawRoleDebt.equals("all") ? null : rawRoleDebt.equals("creditor");
            int moneyFrom = Integer.parseInt(rawMoneyFrom);
            int moneyTo = Integer.parseInt(rawMoneyTo);
            Date debtFrom = (rawDebtFrom == null || rawDebtFrom.length() == 0) ? null : Helper.convertStringToDate(rawDebtFrom);
            Date debtTo = (rawDebtTo == null || rawDebtTo.length() == 0) ? null : Helper.convertStringToDate(rawDebtTo);
            Date recordFrom = (rawRecordFrom == null || rawRecordFrom.length() == 0) ? null : Helper.convertStringToDate(rawRecordFrom);
            Date recordTo = (rawRecordTo == null || rawRecordTo.length() == 0) ? null : Helper.convertStringToDate(rawRecordTo);

            DebtorService debtorService = new DebtorService();
            DebtService debtService = new DebtService();
            int debtorId = Integer.parseInt(request.getParameter("debtorId"));
            Debtor debtor = debtorService.getDebtorById(debtorId);

            String size = request.getParameter("size");
            int pageSize = 5;
            if (size != null) {
                pageSize = Integer.parseInt(size);
            }

            String page = request.getParameter("page");
            int pageIndex = 1;
            if (page != null) {
                pageIndex = Integer.parseInt(page);
            }

            String btnPaging = request.getParameter("btn-paging");
            if (btnPaging != null) {
                if (btnPaging.equals("Previous")) {
                    --pageIndex;
                }
                if (btnPaging.equals("Next")) {
                    ++pageIndex;
                }
            }

            int totalRecord = debtService.getCount(debtorId);
            int totalPage = (totalRecord % pageSize == 0) ? totalRecord / pageSize
                    : (totalRecord / pageSize) + 1;

            request.setAttribute("totalRecord", totalRecord);
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("pageSize", pageSize);

            ArrayList<Debt> debts = debtService.paging(debtorId, debtId, reason, roleDebt, moneyFrom, moneyTo, debtFrom, debtTo, recordFrom, recordTo, pageIndex, pageSize);
            request.setAttribute("debtor", debtor);
            request.setAttribute("debts", debts);

            String txt = "";
            HandleCookies hd = new HandleCookies();
            Cookie[] arr = request.getCookies();
            for (Cookie cookie : arr) {
                if (cookie.getName().equals("notification")) {
                    txt += cookie.getValue();
                }
            }
            Account account1 = (Account) request.getSession().getAttribute("account");
            List<Notification> listNoti = hd.getNoti(txt, account1.getUsers().get(0).getUser_id());
            int notiQuantity = listNoti.size();
            request.getSession().setAttribute("dataNoti", listNoti);
            request.getSession().setAttribute("lengthNoti", notiQuantity);

            request.getRequestDispatcher("/views/user/debtList.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(DebtListController.class.getName()).log(Level.SEVERE, null, ex);
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
