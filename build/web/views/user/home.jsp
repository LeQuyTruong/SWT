<%-- 
    Document   : home
    Created on : Feb 4, 2023, 3:19:35 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>

    </head>
    <body>
        <%@ include file="header.jsp" %>

        <!-- content for home.jsp goes here -->
        <section class="big-image">
            <div class="big-image-content">
                <h2>Slogan</h2>
                <p>Người lạ ơi xin hãy ” trả nợ dùm tôi”. Mượn hoài không trả, đòi hoài ngại quá!
                </p>
            </div>
        </section>
        <section class="about section-pading">
            <div class="container">
                <div class="row">
                    <div class="section-title">
                        <h2 data-title="Câu chuyện">về chúng tôi</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="about-item">
                        <h2>Giới thiệu</h2>
                        <p>Với phần mềm ghi nợ, bạn không còn phải lo lắng về việc quản lý các khoản nợ của mình nữa.
                            Từ bây giờ, việc ghi nợ sẽ trở nên đơn giản và dễ dàng hơn bao giờ hết với phần mềm này.</p>
                    </div>
                    <div class="about-item">
                        <div class="about-item-img">
                            <span>Sinh viên kỳ 5</span>
                            <img src="/DebtSystem/assets/image/dola.jpg" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </body>
</html>
