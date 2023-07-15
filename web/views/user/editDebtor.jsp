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
        <link rel="stylesheet" href="/DebtSystem/assets/css/editDebtor.css"/>
        <title>Edit Debtor</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <div class="box-from">
            <form action="editDebtor" method="post">
                <input type="hidden" name="userID" maxlength="150" value="">
                <input type="hidden" name="type" value="">
                <div class="edit_username" >
                    <div class="edit_id" >
                        <h2> Edit Id</h2>
                        ID:  <input class="edit_id_bar" type="text" name="debtor_id" readonly="" value="${debtor.debtor_id}"></br>
                    </div>
                    <h2> Edit User Name</h2>
                    UserName:  <input class="edit_username_bar" type="text" name="debtor_name" value="${debtor.debtor_name}"></br>
                </div>

                <div class="edit_address">
                    <h2>Edit Address</h2>
                    Address:<input class="edit_address_bar"  type="textarea" name="address" value="${debtor.address}"></br>  
                </div>

                <div class="edit_phone" >
                    <h2>Edit Phone Number</h2>
                    Phone number: <input class="edit_phone_bar" required="required"  type="text" name="phone_number" value="${debtor.phone_number}"></br>
                </div>
                <span style="color:green">
                    ${Yes}
                </span> <br>

                <input class="update_button" type="submit" value="Update">
                <a href="DebtorPage">Back</a><br>

            </form>
        </div>


    </body>
</html>
