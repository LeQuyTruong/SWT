<%-- 
    Document   : changepassword
    Created on : Feb 14, 2023, 10:08:46 PM
    Author     : ngoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password Page</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>

        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>

        <!--<script src="https://www.google.com/recaptcha/api.js"></script>-->

        <!-- CSS -->
        <link rel="stylesheet" href="/DebtSystem/assets/css/changePassword.css" />


    </head>
    <body>

        <div class="container">
            <div class="content mt-5">

                <div class="h3 text-center content-text">Change your password</div>

                <form action="changepassword" class="mt-4" id="changePasswordForm" method="post"  >
                    <div class="form-group mt-3 form-item">
                        <input  name="email"   type="hidden" value="${requestScope.email}">
                        <label for="password" class="label-field">Password <span class="text-danger">*</span></label>
                        <input type="password" class="form-control " placeholder="Password" id="password" name="password">
                        <div id="password-error" class="text-danger ml-1"></div>
                    </div>

                    <div class="form-group mt-3 form-item">
                        <label for="repassword" class="label-field">Re-password <span class="text-danger">*</span></label>
                        <input type="password" class="form-control " placeholder="Confirm password" id="repassword" name="repassword">
                        <div id="repassword-error" class="text-danger ml-1"></div>
                    </div>

                    <!--<div class="g-recaptcha" data-sitekey="6LeBzHwkAAAAADz0I_qTXDeh5BhEPIk2dJ2lMcuW"></div>-->

                    <div class="form-group mt-3 form-item-btn">
                        <button type="submit" class="btn btn-primary btn-register form-control"
                                id="change-btn">Change</button>
                    </div>
                </form>
            </div>
        </div>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"
        type="text/javascript"></script>
        <script src="/DebtSystem/assets/js/changePassword.js" ></script>


    </body>
</html>
