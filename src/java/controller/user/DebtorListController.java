package controller.user;

import controller.auth.BaseAuthenticationController;
import dal.DebtorDBContext;
import model.FilterDebtor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Account;
import model.Debtor;

public class DebtorListController extends BaseAuthenticationController {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        SimpleDateFormat sf = new SimpleDateFormat("");

        try {
            DebtorDBContext dao = new DebtorDBContext();
            int page = 1;
            int size = 10;
            String column =request.getParameter("column")==null? "": request.getParameter("column");
            String sort=request.getParameter("SORT")==null ? "": request.getParameter("SORT");
            String idFrom = request.getParameter("idFrom") == null ? "" : request.getParameter("idFrom");
            String idTo = request.getParameter("idTo") == null ? "" : request.getParameter("idTo");
            String name = request.getParameter("name") == null ? "" : request.getParameter("name");
            String address = request.getParameter("address") == null ? "" : request.getParameter("address");
            String phone = request.getParameter("phone") == null ? "" : request.getParameter("phone");
            String email = request.getParameter("email") == null ? "" : request.getParameter("email");
            String totalDeptFrom = request.getParameter("totalDeptFrom") == null ? "" : request.getParameter("totalDeptFrom");
            String totalDeptTo = request.getParameter("totalDeptTo") == null ? "" : request.getParameter("totalDeptTo");
            String createDateForm = request.getParameter("createDateForm") == null ? "" : request.getParameter("createDateForm");
            String createDateTo = request.getParameter("createDateTo") == null ? "" : request.getParameter("createDateTo");
            String updateDateFrom = request.getParameter("updateDateFrom") == null ? "" : request.getParameter("updateDateFrom");
            String updateDateTo = request.getParameter("updateDateTo") == null ? "" : request.getParameter("updateDateTo");

            FilterDebtor filterDebtor = new FilterDebtor(idFrom, idTo, name, address, phone, email, totalDeptFrom, totalDeptTo, createDateForm, createDateTo, updateDateFrom, updateDateTo);

            Account account = (Account) request.getSession().getAttribute("account");
            if (account == null) {
                account = new Account();
                account.setUsername("");
            }

            if (request.getParameter("size") != null) {
                size = Integer.valueOf(request.getParameter("size"));
            }

            if (request.getParameter("page") != null) {
                page = Integer.valueOf(request.getParameter("page"));
            }

            int totalRecords = dao.countById(account.getUsername(), filterDebtor);

            String btnPaging = request.getParameter("btnPaging");
            if (btnPaging != null) {
                if (btnPaging.equals("Next")) {
                    page++;
                }
                if (btnPaging.equals("Previus")) {
                    page--;
                }
            }

            List<Debtor> listDebtor = dao.findById(account.getUsername(), (page - 1) * size, size, filterDebtor,column,sort);
            if (listDebtor.isEmpty()) {
                request.setAttribute("MESSAGE", "Không có người nợ");
            }
            request.setAttribute("TOTAL_RECORDS", totalRecords);
            request.setAttribute("PAGE", page);
            request.setAttribute("TOTAL_PAGE", (int) Math.ceil(totalRecords * 1.0 / size));
            request.setAttribute("SIZE", size);
            request.setAttribute("LiST_DEBTOR", listDebtor);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher("/views/user/DebtorPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
        processRequest(request, response);
    }
}
