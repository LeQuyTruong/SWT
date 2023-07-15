/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import jakarta.servlet.http.Cookie;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Notification;

/**
 *
 * @author asus
 */
public class HandleCookies {

   public List<Notification> getNoti(String cookie,int userId) throws ParseException {
        //createBy:status:title:message:time
        List<Notification> list = new ArrayList<>();
        SimpleDateFormat d1 = new SimpleDateFormat("dd/MM/yyyy///HH-mm-ss");
        try {
            if (cookie != null && cookie.length() != 0) {
                String[] arrObject = cookie.split("```");
                for (String i : arrObject) {
                    String[] noti = i.split(":");
                    int createdBy = Integer.parseInt(noti[0]);
                    String status = noti[1];
                    String title = noti[2];
                    String message = "";
                    String uppercase = "ABCDEFHIJKLMNOPQRSTUVWXYZ";
                    for (int j = 0; j < noti[3].length(); j++) {
                        if (uppercase.contains(noti[3].charAt(j) + "")) {
                            message += " " + noti[3].charAt(j);
                        } else {
                            message += noti[3].charAt(j);
                        }
                    }
                    String icon = noti[4];
                    Date date = d1.parse(noti[5]);
                    String time = "Time: " + noti[5].replace("///", " ");
                    Notification notification = new Notification(createdBy, title, status, message, time, icon);
                    if(checkTimeCode(date)){
                      list.add(notification);
                    }
                }
            }
        } catch (NumberFormatException e) {

        }
        List<Notification> listUserID = new ArrayList<>();
        for (Notification item : list) {
            if (item.getCreatedBy() == userId) {
                listUserID.add(item);
            }
        }

        return listUserID;
    }
    
     public boolean checkTimeCode(Date dateCode) {
        Date dateNow = new Date();
        long result = dateNow.getTime() - dateCode.getTime();
        int second = (int) (result / 1000);
        if (second > (60*60*24*2)) {
            return false;
        } else {
            return true;
        }
    }
    public String addNoti(int userid, String status, String message, String txt) {
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy///HH-mm-ss");
        String date = f.format(d);
        String statuss = "";
        String icon = "";
        String title = "";
        if (status.equals("success")) {
            statuss = "success";
            title = "Success";
            icon = "checkmark-outline";
        } else {
            statuss = "fail";
            title = "Fail";
            icon = "alert-circle-outline";
        }
        message += title;

        if (txt.isEmpty()) {
            txt = userid + ":" + statuss + ":" + title + ":" + message + ":" + icon + ":" + date;
        } else {
            txt += "```" + userid + ":" + statuss + ":" + title + ":" + message + ":" + icon + ":" + date;
        }

        return txt;
    }

    public static void main(String[] args) {
//        String txt ="";
//                Cookie[] arr = request.getCookies();
//                for (Cookie cookie : arr) {
//                    if (cookie.getName().equals("notification")) {
//                        txt += cookie.getValue();
//                    }
//                }
//                HandleCookies hd = new HandleCookies();
//                request.getSession().setAttribute("dataNoti", hd.getNoti(txt));
//                request.getSession().setAttribute("lengthNoti", hd.getNoti(txt).size());

//1:success:Success:LoginSuccess:checkmark-outline:26/02/2023///15-28-47
//```2:fail:Fail:LoginFail:alert-circle-outline:26/02/2023///15-28-47
//```3:success:Success:UpdateSuccess:checkmark-outline:26/02/2023///15-28-47
//```4:fail:Fail:CreateFail:alert-circle-outline:26/02/2023///15-28-47

//  String txt = "";
//                Cookie[] arr = request.getCookies();
//                for (Cookie cookie : arr) {
//                    if (cookie.getName().equals("notification")) {
//                        txt += cookie.getValue();
//                    }
//                }
//                 HandleCookies hd = new HandleCookies();
//                List<Notification> listNoti = hd.getNoti(txt);
//                int notiQuantity = hd.getNoti(txt).size();
//                request.getSession().setAttribute("dataNoti", listNoti);
//                request.getSession().setAttribute("lengthNoti", notiQuantity);

//                Cookie[] arr = request.getCookies();
//                for (Cookie cookie : arr) {
//                    if(cookie.getName().equals("notification")){
//                        cookie.setMaxAge(0);
//                        response.addCookie(cookie);
//                    }
//                }
                Date d = new Date();
//               SimpleDateFormat d1 = new SimpleDateFormat("dd/MM/yyyy///HH-mm-ss");
//               String date = d1.format(d);
//               //Format : [createBy:status:title:message]```[]
//               String txt = "1:success:Success:LoginSuccess:checkmark-outline:"+date+
//                       "```"+"2:fail:Fail:LoginFail:alert-circle-outline:"+date+
//                       "```"+"3:success:Success:UpdateSuccess:checkmark-outline:"+date+"```"+"4:fail:Fail:CreateFail:alert-circle-outline"+date;
////               
//                Cookie c= new Cookie("notification", txt);
//                c.setMaxAge(7*24*60*60);
//                response.addCookie(c);
//                HandleCookies hd = new HandleCookies();
//                request.getSession().setAttribute("dataNoti", hd.getNoti(txt));
//                 request.getSession().setAttribute("lengthNoti", hd.getNoti(txt).size());
    }
}
