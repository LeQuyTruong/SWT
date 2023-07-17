/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.AccountDBContext;
import dal.OTPRequestDBContext;
import dal.UserDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.Account;
import model.User;
import utils.Email;

/**
 *
 * @author asus
 */
public class RegisterController extends HttpServlet {

    UserDBContext ud = new UserDBContext();
    OTPRequestDBContext otp = new OTPRequestDBContext();
    Email emails = new Email();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Nam : 1 - Nu : 0
        String display_name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String pass = request.getParameter("password");
        String adrs = request.getParameter("adr");
        String gender = request.getParameter("gender");
        int gen = Integer.parseInt(gender);
        String imgDefault = gen == 1 ? "https://tse2.mm.bing.net/th?id=OIP.zL8PN3yVgzgZxy9ECCdXugHaHc&pid=Api&P=0" : "https://www.pngkit.com/png/full/115-1150342_user-avatar-icon-iconos-de-mujeres-a-color.png";
        String img = request.getParameter("pic") == "" ? imgDefault : request.getParameter("pic");
        User us = new User(email, display_name, phone, pass, true, true, adrs, img, gen);

        int type_otp = Integer.parseInt(request.getParameter("type_otp"));
//        //Dang ky tk
        int user_id = ud.registerNewUserAndAccount(us);
        if (user_id == -1) {
//            Co email ton tai roi 
            request.setAttribute("message", "Email already exists!!!!");
            request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
        } else { //chua co email ton tai
            String code = otp.createNewOTPForUser(user_id, type_otp, 0);
            int otp_id = otp.getCodeNotActive(code, user_id).getOtp_id();
//            //Tao mess
            String message_type_otp = otp.messageType(type_otp, code, display_name);
//            //Gui email
            ThreadSendEmail t = new ThreadSendEmail(emails, email, "Code Active", message_type_otp);
            t.start();
//            // tao ban ghi gui email
            otp.createNewEmailForUser(1, type_otp, code);

            AccountDBContext accDB = new AccountDBContext();
            Account account = accDB.findAccountByEmail(email);

            request.setAttribute("typeOTP", type_otp);
            request.setAttribute("account", account);
            request.setAttribute("user", ud.findUserByEmail(email));
            request.setAttribute("userId", account.getUsers().get(0).getUser_id());
            request.setAttribute("otpId", otp_id);
            request.setAttribute("email", email);
            request.setAttribute("code_time", "Time create code: " + otp.getTimeCodeCreate(user_id, otp_id));
            request.getRequestDispatcher("/views/user/verifyEmail.jsp").forward(request, response);
        }
    }

    class ThreadSendEmail extends Thread {

        //Luong` gui email
        Email t;
        String title;
        String mail;
        String content;

        ThreadSendEmail(Email t, String mail, String title, String content) {
            this.t = t;
            this.title = title;
            this.mail = mail;
            this.content = content;
        }

        public void run() {
            try {
                Thread.sleep(100);
                t.sendMail(mail, title, content);
            } catch (Exception e) {
            }
        }
    }
}
