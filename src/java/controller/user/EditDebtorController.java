/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.DebtorDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Account;
import model.Debtor;

/**
 *
 * @author Admin
 */
public class EditDebtorController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String name = request.getParameter("debtor_name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone_number");
        
        String debtorIdString = request.getParameter("debtor_id");

        int debtorId = Integer.parseInt(debtorIdString);
        
        DebtorDBContext debtordb = new DebtorDBContext();
        String txt = "";
        Cookie[] arr = request.getCookies();
        for (Cookie cookie : arr) {
            if (cookie.getName().equals("notification")) {
                txt += cookie.getValue();
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        Account account = (Account) request.getSession().getAttribute("account");
        String cookies = debtordb.editDebtor(name, address, phone, debtorId, txt, account.getUsers().get(0).getUser_id());
        Cookie c = new Cookie("notification", cookies);
        c.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(c);
        
                response.sendRedirect("debtorList");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
