<%-- 
    Document   : forgotPassword
    Created on : Feb 16, 2023, 10:54:07 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password Page</title>

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

        <!-- CSS -->
        <link rel="stylesheet" href="/DebtSystem/assets/css/forgotPassword.css" />

    </head>

    <body>
    <c:if test="${requestScope.message ne null}">
        <div class="alert alert-danger text-center mt-5">
            ${requestScope.message}
        </div>
    </c:if>

    <div class="container">
        <div class="content mt-5">
            <div class="h3 text-center content-text">Find your account</div>
            <p class="text-center content-desc">Please enter your email to find your account.</p>

            <form action="forgotPassword" class="mt-4" id="forgotPasswordForm" method="post"  >

                <div class="form-group form-item">
                    <input type="email" class="form-control " placeholder="E-mail" id="email" name="email">
                    <div id="email-error" class="text-danger ml-1"></div>
                </div>
                
                <input name="type_otp" value="3" type="hidden"></input>

                <div class="form-group mt-3 form-item-btn">
                    <!--                        <button type="button" class="btn btn-primary btn-register form-control"
                                                    id="cancel-btn"><a href="login">Cancel</a></button>-->
                    <button type="submit" class="btn btn-primary btn-register form-control"
                            id="find-btn">Find</button>
                </div>

            </form>
        </div>
    </div>

    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"
    type="text/javascript"></script>
    <script src="/DebtSystem/assets/js/forgotPassword.js" ></script>

</body>
</html>
