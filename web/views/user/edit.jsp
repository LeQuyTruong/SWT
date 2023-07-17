<%-- 
    Document   : edit
    Created on : Feb 16, 2023, 10:31:18 PM
    Author     : ngoan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/DebtSystem/assets/css/editprofile.css"/>
        <title>Edit</title>
    </head>
    <body>
       <form action="edit" method="post">
           <input type="hidden" name="userID" maxlength="150" value="${sessionScope.user.user_id}">
           <input type="hidden" name="type" value="${type}">
            <div class="edit_username" <c:if test="${type != 'username'}">hidden</c:if>>
                <h1> Edit User Name</h1>
            UserName:  <input class="edit_username_bar" type="text" name="name" value="${sessionScope.user.display_name}"></br>
                </div>
            
            <div class="edit_phone" <c:if test="${type != 'phone'}">hidden</c:if>>
              <h1>Edit Phone Number</h1>
              Phone number: <input class="edit_phone_bar" required="required"  type="text" name="phoneNumber" value="${sessionScope.user.phone_number}"></br>
            </div>

            <div class="edit_address" <c:if test="${type != 'address'}">hidden</c:if>>
                <h1>Edit Phone Number</h1>
            Address:<input class="edit_address_bar"  type="textarea" name="address" value="${sessionScope.user.adr}"></br>  
            </div>

            <span style="color:green">
                ${Yes}
            </span> <br>
            
            <input class="update_button" type="submit" value="Update">
            <a href="profile">Back</a><br>
          
        </form>
            
    </body>
</html>
