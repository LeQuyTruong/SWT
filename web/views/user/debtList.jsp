<%-- 
    Document   : debtList
    Created on : Feb 26, 2023, 10:12:49 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Debt List Page</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>

        <link rel="stylesheet" href="/DebtSystem/assets/css/debtList.css" type="text/css" />
    </head>
    <body>

        <div class="container">
           

            <div class="heading-content">
                Name: ${requestScope.debtor.debtor_name}
            </div>
            
            <a href="#">Create Debt</a>
            

            <table class="table table-bordered table-striped table-hover mt-5">
                <thead>
                    <tr>
                        <th><button class="btn-header" >ID</button></th>
                        <th><button class="btn-header" >Lý do</button></th>
                        <th><button class="btn-header">Loại nợ</button></th>
                        <th><button class="btn-header" >Số tiền</button></th>
                        <th><button class="btn-header" >Thời gian tạo</button></th>
                        <th><button class="btn-header">Ngày lập phiếu</button></th>
                        <th class="d-flex justify-content-center mt-2">Action</th>
                    </tr>

                    <tr>
                        <th>
                            <div class="input-group">
                                <input type="text" class="form-control heading-input" name="" /> 
                            </div>    
                        </th>

                        <th>
                            <div class="input-group ">
                                <input  type="text" class="form-control heading-input" />
                            </div>
                        </th>

                        <th>
                            <div class="input-group">
                                <select class="form-select heading-input">
                                    <option value="All">All</option>
                                    <option value="+">+</option>
                                    <option value="-">-</option>
                                </select>
                            </div>
                        </th>

                        <th>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="From" />

                            </div>
                            <div class="input-group mb-2">
                                <input type="text" class="form-control"placeholder="To" />

                            </div>
                        </th>

                        <th>
                            <div class="input-group">
                                <input type="date" class="form-control" placeholder="From" />
                            </div>

                            <div class="input-group mb-2">
                                <input type="date" class="form-control"placeholder="To" />
                            </div>
                        </th>

                        <th>
                            <div class="input-group">
                                <input type="date" class="form-control" placeholder="From" />
                            </div>

                            <div class="input-group mb-2">
                                <input type="date" class="form-control"placeholder="To" />
                            </div>
                        </th>

                        <th>

                            <div class="text-center">
                                <a href="debtList?debtorId=${param.debtorId}">
                                    <button type="button" class="btn btn-outline-danger"  >
                                        CLEAR FILTER
                                    </button>
                                </a>
                            </div>
                            <div class="text-center">
                                <a href="debtList?debtorId=${param.debtorId}">
                                    <button type="button" class="btn btn-outline-warning mb-1"  >
                                        HIDE
                                    </button>
                                </a>
                            </div>
                        </th>
                    </tr>

                </thead>

                <tbody>
                    <c:forEach items="${requestScope.debts}" var="debt">
                        <tr>
                            <td>${debt.id}</td>
                            <td>${debt.reason}</td>
                            <td>
                                <c:if test="${!debt.roleDebt}">
                                    <strong class="text-success">+</strong>
                                </c:if>
                                <c:if test="${debt.roleDebt}">
                                    <strong class="text-danger">-</strong>
                                </c:if>
                            </td>
                            <td>${debt.money}</td>
                            <td>${debt.debtCreatedTime}</td>
                            <td>${debt.createdAt}</td>
                            <td>#</td>

                        </tr>                               
                    </c:forEach>

                </tbody>

            </table>


        </div>


    </body>
</html>
