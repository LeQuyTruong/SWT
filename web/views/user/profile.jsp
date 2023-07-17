<%-- 
    Document   : profile
    Created on : Feb 14, 2023, 10:00:38 PM
    Author     : ngoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link rel="stylesheet" href="/DebtSystem/assets/css/profile.css"/>
    </head>
    <body>

        <h1 class="title">User Information</h1>
        <form action="profile" method="post">
            <input type="hidden" name="userID" maxlength="150" value="${user.user_id}">
            <div class="profile_username">
                UserName:  <input class="bar_username" type="text" name="name" value="${user.display_name}" readonly><a href="edit?type=username"> Edit </a></br>
            </div>

            <div class="profile_phone">
                Phone number: <input class="bar_phone" type="text" name="phoneNumber" value="${user.phone_number}"readonly><a href="edit?type=phone"> Edit </a>  </br>

            </div>

            <div class="profile_email">
                Email: <input class="bar_email" type="text" name="email" value="${user.email}"readonly></br>
            </div>

            <div class="profile_address" >
                Address:<input class="bar_address" type="textarea" name="address" value="${user.adr}"readonly><a href="edit?type=address"> Edit </a> </br>

            </div>

            <a class="btn_changepassword" href="changepassword?email=${user.email}">Change Password</a> 



        </form>
    </body>
</html>
