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

        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
            />

        <style>
            .block-btn-header.activeUp{
                border-top: 1px solid black;
            }
            .block-btn-header.activeDown{
                border-bottom: 1px solid black;
            }
        </style>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <div class="container">

            <div class="content mt-5">

                <div class="content-heading bg-light">
                    <div class="name-and-record">
                        <h2>${debtor.debtor_name}</h2>
                        Total: ${requestScope.totalRecord} Records(s)
                    </div>


                    <button type="button" class="btn btn-success btn-add-debt add-new-debtor" data-bs-toggle="modal"
                            data-bs-target="#btn-add-debt"><i class="bi bi-plus-square"></i>Thêm mới khoản nợ</button>
                    <!-- Modal Add Debt -->
                    <div class="modal fade" id="btn-add-debt" data-bs-backdrop="static" data-bs-keyboard="false"
                         tabindex="-1" aria-labelledby="form-debt-label" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="form-debt-label">Thêm mới khoản nợ</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form action="createDebt" method="post">
                                        <input type="hidden" name="debtorId" value="${param.debtorId}">
                                        <div class="form-group form-item">
                                            <label for="reason" class="label-field">Lý do</label>
                                            <textarea class="form-control" placeholder="Take a note" id="reason" name="reason"></textarea>
                                        </div>

                                        <div class="form-group mt-3 form-item">
                                            <label for="role-debt" class="label-field">Loại nợ <span
                                                    class="text-danger">*</span></label> <br>
                                            <button type="button" id="input-debtor" class="debtor role-debt active"> +
                                            </button>
                                            <input type="radio" id="debtor" name="role-debt" value="debtor" checked hidden />

                                            <button type="button" id="input-creditor" class="creditor role-debt"> -
                                            </button>
                                            <input type="radio" id="creditor" name="role-debt" value="creditor"  hidden />
                                            <div id="role-debt-error" class="text-danger ml-1"></div>
                                        </div>

                                        <div class="form-group mt-3 form-item">
                                            <label for="money" class="label-field">Số tiền <span
                                                    class="text-danger">*</span></label>
                                            <input type="number" class="form-control" placeholder="Money" id="money" name="money" />
                                            <div id="money-error" class="text-danger ml-1"></div>
                                        </div>

                                        <div class="form-group mt-3 form-item">
                                            <label for="date" class="label-field">Ngày lập phiếu</label>
                                            <input type="date" class="form-control" id="date" name="date">
                                        </div>

                                        <div class="d-flex justify-content-center">
                                            <button type="submit"
                                                    class="btn btn-success mt-2 d-flex justify-content-center w-25">Add</button>
                                        </div>

                                    </form>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!--Chi tiết-->
                <c:forEach items="${requestScope.debts}" var="debt">
                    <div class="content-heading bg-light">
                        <div class="modal fade" id="details${debt.id}" data-bs-backdrop="static" data-bs-keyboard="false"
                             tabindex="-1" aria-labelledby="form-debt-label" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="form-debt-label">Thêm mới khoản nợ</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">

                                        <div class="form-group form-item">
                                            <label for="reason" class="label-field">Lý do</label>
                                            <textarea class="form-control" placeholder="Take a note" id="reason" name="reason" readonly>${debt.reason}</textarea>
                                        </div>


                                        <div class="form-group mt-3 form-item">

                                            <label for="role-debt" class="label-field">Loại nợ <span
                                                    class="text-danger">*</span></label> <br>

                                            <c:if test="${debt.roleDebt != true}">
                                                <button type="button" id="input-debtor" class="debtor role-debt active "> +</button> 
                                                <button type="button" i="input-creditor" class="creditor role-debt"> -
                                                </button>
                                            </c:if>
                                            <c:if test="${debt.roleDebt == true}">
                                                <button type="button" id="input-debtor" class="debtor role-debt "> +</button> 
                                                <button type="button" i="input-creditor" class="creditor role-debt active"> -
                                                </button>
                                            </c:if>

                                            <div id="role-debt-error" class="text-danger ml-1"></div>
                                        </div>

                                        <div class="form-group mt-3 form-item">
                                            <label for="money" class="label-field">Số tiền <span
                                                    class="text-danger">*</span></label>
                                            <input type="number" class="form-control" placeholder="Money" id="money" name="money" readonly value="${debt.money}"/>
                                            <div id="money-error" class="text-danger ml-1"></div>
                                        </div>

                                        <div class="form-group mt-3 form-item">
                                            <label for="createDate" class="label-field">Thời gian tạo</label>
                                            <input type="date" class="form-control" id="createDate" name="createDate" readonly value="${debt.debtCreatedTime}">
                                        </div>


                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <!-- Modal Payment Debt -->
                <c:forEach items="${requestScope.debts}" var="debt">
                    <div class="modal fade" id="btn-payment-debt${debt.id}" data-bs-backdrop="static" data-bs-keyboard="false"
                         tabindex="-1" aria-labelledby="form-debt-label" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="form-debt-label">Thanh toán</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form action="createDebt" method="post">
                                        <input type="hidden" name="debtorId" value="${param.debtorId}">
                                        <div class="form-group form-item">
                                            <label for="reason" class="label-field">Lý do</label>
                                            <textarea class="form-control" placeholder="Take a note" id="reason" name="reason" 
                                                      >pay the debt for bill id ${debt.id}</textarea>
                                        </div>

                                        <div class="form-group mt-3 form-item">
                                            <label for="role-debt" class="label-field">Loại nợ <span
                                                    class="text-danger">*</span></label> <br>

                                            <c:if test="${debt.roleDebt eq true}">
                                                <button type="button" id="input-debtor" class="debtor role-debt active"> + </button>
                                                <input type="radio" id="debtor" name="role-debt" value="debtor" checked="checked"  hidden />

                                                <button type="button" id="input-creditor" class="creditor role-debt"> -
                                                </button>
                                                <input type="radio" id="creditor" name="role-debt" value="creditor" hidden />
                                            </c:if>

                                            <c:if test="${!debt.roleDebt eq true}">
                                                <button type="button" id="input-debtor" class="debtor role-debt"> + </button>
                                                <input type="radio" id="debtor" name="role-debt" value="debtor" hidden />

                                                <button type="button" id="input-creditor" class="creditor role-debt active"> -
                                                </button>
                                                <input type="radio" id="creditor" name="role-debt" value="creditor" checked="checked"  hidden />
                                            </c:if>

                                        </div>

                                        <div class="form-group mt-3 form-item">
                                            <label for="money" class="label-field">Số tiền <span
                                                    class="text-danger">*</span></label>
                                            <input type="number" class="form-control" placeholder="Money" id="money" name="money" value="${debt.money}" />
                                            <div id="money-error" class="text-danger ml-1"></div>
                                        </div>

                                        <div class="form-group mt-3 form-item">
                                            <label for="date" class="label-field">Ngày lập phiếu</label>
                                            <input type="date" class="form-control" id="date" name="date">
                                        </div>

                                        <div class="d-flex justify-content-center">
                                            <button type="submit"
                                                    class="btn btn-success mt-2 d-flex justify-content-center w-25">Add</button>
                                        </div>

                                    </form>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <div class="container1">
                    <form action="debtList" id="formSearch" >
                        <table class="table table-bordered table-striped table-hover ">
                            <thead>
                                <tr class="header-form-debtlist">
                            <input type="hidden" name="" id="debtChoice"  value="${requestScope.choice}" >
                            <input type="hidden" name="" id="valueChoice" value="${requestScope.value}">
                            <th class="block-btn-header" ><button class="btn-header" id="id">ID</button></th>
                            <th class="block-btn-header" ><button id="reason" class="btn-header">Lý do</button></th>
                            <th class="block-btn-header" ><button id="role_debt" class="btn-header">Loại nợ</button></th>
                            <th class="block-btn-header" ><button id="money" class="btn-header">Số tiền</button></th>
                            <th class="block-btn-header" ><button id="debt_createdTime" class="btn-header">Thời gian tạo</button></th>
                            <th class="block-btn-header"><button   id="createdAt"  class="btn-header">Ngày lập phiếu</button></th>
                            <th class="d-flex justify-content-center mt-2">Action</th>
                            </tr>


                            <tr>
                                <th >
                                    <div class="input-group">
                                        <input type="text" class="form-control  form-search-input heading-input" name="debtId" value="${param.debtId}" />
                                    </div>
                                </th>

                                <th>
                                    <div class="input-group ">
                                        <input type="text" class="form-control form-search-input heading-input" name="reason" value="${param.reason}" />
                                    </div>
                                </th>

                                <th>
                                    <div class="input-group">
                                        <select  id="selectForm" class="form-select heading-input" name="roleDebt">
                                            <option value="all"
                                                    <c:if test="${param.roleDebt eq null || param.roleDebt eq '' }">
                                                        selected
                                                    </c:if>
                                                    >All</option>
                                            <option value="debtor"  
                                                    <c:if test="${param.roleDebt == 'debtor' && param.roleDebt ne null}">
                                                        selected
                                                    </c:if>
                                                    >+</option>
                                            <option value="creditor"
                                                    <c:if test="${param.roleDebt == 'creditor'  && param.roleDebt ne null}">
                                                        selected
                                                    </c:if>
                                                    >-</option>
                                        </select>
                                    </div>
                                </th>

                                <th>
                                    <div class="input-group">
                                        <input type="number" class="form-control form-search-input" placeholder="From" name="moneyFrom" value="${param.moneyFrom}" />
                                    </div>

                                    <div class="input-group mb-2">
                                        <input type="number" class="form-control form-search-input" placeholder="To" name="moneyTo" value="${param.moneyTo}" />
                                    </div>                            
                                </th>

                                <th>
                                    <div class="input-group">
                                        <input type="date" class="form-control form-search-input" placeholder="From" name="debtFrom" value="${param.debtFrom}" />
                                    </div>

                                    <div class="input-group mb-2">
                                        <input type="date" class="form-control form-search-input" placeholder="To" name="debtTo" value="${param.debtTo}" />
                                    </div>
                                </th>

                                <th>
                                    <div class="input-group">
                                        <input type="date" class="form-control form-search-input" placeholder="From"  name="recordFrom"  value="${param.recordFrom}" />
                                    </div>

                                    <div class="input-group mb-2">
                                        <input type="date" class="form-control form-search-input" placeholder="To" name="recordTo"   value="${param.recordTo}" />
                                    </div>
                                </th>

                                <th>

                                    <div class="text-center">
                                        <a href="debtList?debtorId=${param.debtorId}">
                                            <button type="button" class="btn btn-outline-danger btn-action">
                                                CLEAR FILTER
                                            </button>
                                        </a>
                                    </div>

                                    <input type="hidden" name="debtorId" id="debtorID" value="${param.debtorId}">
                                    <input type="hidden" name="page" value="${requestScope.pageIndex}">

                                    <div class="text-center">
                                        <button type="button" class="btn btn-outline-warning mb-1 btn-action">
                                            Hide
                                        </button>
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
                                        <td class="action-form">
                                            <button type="button" class="btn btn-success btn-add-debt" data-bs-toggle="modal"
                                                    data-bs-target="#details${debt.id}">Chi tiết</button>

                                            <button type="button" class="btn btn-success  btn-payment-debt" data-bs-toggle="modal"
                                                    data-bs-target="#btn-payment-debt${debt.id}"                                            
                                                    <c:if test="${!debt.roleDebt}">
                                                        disabled="disabled"
                                                    </c:if> >
                                                <i class="fa-solid fa-plus"></i>
                                            </button>

                                            <button type="button" class="btn btn-danger btn-payment-debt" data-bs-toggle="modal"
                                                    data-bs-target="#btn-payment-debt${debt.id}"                                            
                                                    <c:if test="${debt.roleDebt}">
                                                        disabled="disabled"
                                                    </c:if> >
                                                <i class="fa-solid fa-minus"></i>
                                            </button>

                                        </td>
                                    </tr>


                                </c:forEach>
                            </tbody>
                        </table>

                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item">
                                    <input type="submit" name="btn-paging" id="Previous" value="Previous" />
                                </li>
                                <div class="center">
                                    <span class="-pageInfor">Trang</span>
                                    <div class="-inputPage">
                                        <input type="number" value="${requestScope.pageIndex}" min="1" />
                                    </div>
                                    <span class="dot">/</span>
                                    <span class="-totalpage" id="totalPage">${requestScope.totalPage}</span>

                                    <select id="size" name="size" class="form-select pagination-select" >
                                        <option value="1">1 Records</option>
                                        <option value="2">2 Records</option>
                                        <option value="3">3 Records</option>
                                        <option  value="5">5 Records</option>
                                        <option  value="10">10 Records</option>
                                        <option  value="20">20 Records</option>
                                        <option  value="30">30 Records</option>
                                        <option  value="40">40 Records</option>
                                    </select>
                                </div>

                                <li class="page-item">
                                    <input type="submit" name="btn-paging" id="Next" value="Next" />
                                </li>
                            </ul>
                        </nav>
                    </form>
                </div>


                <script>
                    let record = document.getElementById("size");
                    var recordTemp = ${requestScope.pageSize};
                    for (var i = 0; i < record.options.length; i++) {
                        if (record.options[i].value == recordTemp) {
                            record.options[i].selected = true;
                            break;
                        }
                    }
                    record.onchange = () => {
                        window.location = "debtList?debtorId=${param.debtorId}&page=1&size=" + record.value;
                    };
                </script>  

                <script>
                    if (${requestScope.pageIndex} === 1) {
                        document.getElementById('Previous').disabled = true;
                    }
                    if (${requestScope.totalPage} === 0) {
                        document.getElementById('Previous').disabled = true;
                        document.getElementById('Next').disabled = true;
                        document.getElementById('totalPage').textContent = 0;
                    }
                    if (${requestScope.totalPage} === ${requestScope.pageIndex}) {
                        document.getElementById('Next').disabled = true;
                    }

                </script>


            </div>
        </div>

        <script src="/DebtSystem/assets/js/debtList.js" ></script>


    </body>
</html>
