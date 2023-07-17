<%-- 
    Document   : verifyForgotPassword
    Created on : Feb 16, 2023, 10:22:47 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Forgot Password Page</title>

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
        <link rel="stylesheet" href="/DebtSystem/assets/css/verifyForgotPassword.css" />

    </head>
    <body>

        <c:if test="${requestScope.message ne null}">
            <div class="alert alert-danger text-center mt-5">
                ${requestScope.message}
            </div>
        </c:if>

        <c:if test="${requestScope.noti ne null}">
            <div class="alert alert-success text-center mt-5">
                ${requestScope.noti}
            </div>
        </c:if>

        <div class="container">
            <div class="content mt-5">
                <div class="h3 text-center content-text">Verify your email</div>

                <form action="verifyEmail" class="mt-4" id="verifyEmailForm" method="post"  >
                    <p>Email: ${requestScope.account.username}</p>
                    <p>Display Name: ${requestScope.account.getUsers().get(0).getDisplay_name()}</p>
                    <p>Phone Number: ${requestScope.account.getUsers().get(0).getPhone_number()}</p>
                    <input  name="userId" type="hidden" value="${requestScope.userId}">
                    <input  name="otpId" type="hidden" value="${requestScope.otpId}">
                    <input  name="email" type="hidden" value="${requestScope.email}">
                    <input  name="typeOTP" type="hidden" value="${requestScope.typeOTP}">
                    <div class="form-group form-item">
                        <label for="code" class="label-field">Code Active <span class="text-danger">*</span></label>
                        <input type="text" class="form-control " placeholder="Enter your code" id="code" name="code">
                        <div id="code-error" class="text-danger ml-1"></div>

                        <a href="resend?userId=${requestScope.userId}&typeOTP=${requestScope.typeOTP}">Resend Code</a>
                    </div>
                    <div class="form-group mt-3 form-item-btn">
                        <button type="submit" class="btn btn-primary form-control"
                                id="active-btn">Active</button>
                    </div>
                </form>
            </div>
        </div>

        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"
        type="text/javascript"></script>
        <script src="/DebtSystem/assets/js/verifyEmail.js" ></script>

    </body>
</html>
