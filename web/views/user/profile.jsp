<%-- 
    Document   : profile
    Created on : Feb 14, 2023, 10:00:38 PM
    Author     : ngoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link rel="stylesheet" href="/DebtSystem/assets/css/profile.css"/>
    </head>

    <body>
        <%@ include file="header.jsp" %>
        <h1 class="title">User Information</h1>
        <div class="box">
            <img src="/DebtSystem/assets/image/dola.jpg" alt="">
            <form action="profile" method="post" class="form">
                <input type="hidden" name="userID" maxlength="150" value="${user.user_id}">
                <div class="profile_email">
                    <label>Email:</label>
                    <input class="bar_email" type="text" name="email" value="${user.email}"></br>
                </div>

                <div class="profile_username">
                    <label>UserName:</label>
                    <input class="bar_username" type="text" name="name" value="${user.display_name}" ><a href="edit?type=username"> Edit </a></br>
                </div>

                <div class="profile_phone">
                    <label>Phone number:</label>
                    <input class="bar_phone" type="text" name="phoneNumber" value="${user.phone_number}"><a href="edit?type=phone"> Edit </a>  </br>

                </div>



                <div class="profile_address" >
                    <label>Address:</label>
                    <input class="bar_address" type="textarea" name="address" value="${user.adr}"><a href="edit?type=address"> Edit </a> </br>
                </div>

                <a class="btn_changepassword" href="changepassword?email=${user.email}">Change Password</a> 

            </form>
        </div>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <script src="/DebtSystem/assets/js/home.js"></script>
    </body>
</html>
