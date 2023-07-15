/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.UserDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Notification;
import utils.HandleCookies;


/**
 *
 * @author ngoan
 */
public class EditController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
       String type = request.getParameter("type");
       request.setAttribute("type", type);
       request.getRequestDispatcher("views/user/edit.jsp").forward(request, response);
       
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
        try {
            int user_id = Integer.parseInt(request.getParameter("userID"));
            String type = request.getParameter("type");
            String name = request.getParameter("name");
            String phone = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            
            UserDBContext ud = new UserDBContext();
            String txt = "";
            Cookie[] arr = request.getCookies();
            for (Cookie cookie : arr) {
                if (cookie.getName().equals("notification")) {
                    txt += cookie.getValue();
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            
            
            
            String cookies = ud.updateUser(user_id, name, phone, address, txt);
            
            Cookie c = new Cookie("notification", cookies);
            c.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(c);
            
            HandleCookies hd = new HandleCookies();
            Account account1 =  (Account) request.getSession().getAttribute("account");
            List<Notification> listNoti = hd.getNoti(cookies, account1.getUsers().get(0).getUser_id());
            int notiQuantity = listNoti.size();
            request.getSession().setAttribute("dataNoti", listNoti);
            request.getSession().setAttribute("lengthNoti", notiQuantity);
            request.getSession().setAttribute("user", ud.findUserByID(user_id));
            request.setAttribute("type", type);
            request.setAttribute("Yes", "Update successfully");
            request.getRequestDispatcher("views/user/edit.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
