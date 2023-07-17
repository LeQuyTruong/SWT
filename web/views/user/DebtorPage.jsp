<%-- 
    Document   : DebtorPage
    Created on : Feb 5, 2023, 2:02:05 AM
    Author     : choip
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/assets/css/debtor.css" rel="stylesheet" type="text/css"/>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
            />


    </head>
    <body>
        <!--  asjdfas fhasij a sa ias  >-->

            <div class="col_7">
                <div class="white_box">
                    <div>
                        <div class="list_header">
                            <div class="main_title">
                                <h3>Danh sách người nợ</h3>
                                Total: ${requestScope.TOTAL_RECORDS} Records(s)<br>
                            </div>
                            <div>
                                <button
                                    type="button"
                                    class="btn btn-success"
                                    style="padding: 8px 35px; font-size: 18px"
                                    data-bs-toggle="modal"
                                    data-bs-target="#tableModal"
                                    >
                                    <i class="bi bi-plus-square"></i> Thêm Người Nợ
                                </button>
                                <div
                                    class="modal fade"
                                    id="tableModal"
                                    tabindex="-1"
                                    aria-labelledby="exampleModalLabel"
                                    aria-hidden="true"
                                    >
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">
                                                    Thông tin người nợ
                                                </h5>
                                                <button
                                                    type="button"
                                                    class="btn-close"
                                                    data-bs-dismiss="modal"
                                                    aria-label="Close"
                                                    ></button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="createdebtor" method="get">
                                                    <div class="mb-3">
                                                        <label for="exampleInputEmail1" class="form-label">Họ và tên (*)</label>
                                                        <input type="text" name="name" class="form-control" id="exampleInputEmail1"  />
                                                    </div>
                                                    <div class="mb-3">
                                                        <label for="exampleInputEmail1" class="form-label">Địa chỉ</label>
                                                        <textarea  id="id" name="adr" rows="5" cols="60"></textarea>
                                                    </div>

                                                    <div class="mb-3">
                                                        <label for="exampleInputEmail1" class="form-label">Sđt</label>
                                                        <input type="number" name="phone" class="form-control" id="exampleInputEmail1"  min="1"/>
                                                    </div>

                                                    <div class="mb-3" >
                                                        <label style="margin-right: 40px;" for="" class="form-label">  Gender</label>
                                                        <label for="male" class="form-label">Male</label>
                                                        <input type="radio" name="gender" class="" id="male" value="1" checked/>
                                                        <label for="female" class="form-label">Female</label>
                                                        <input type="radio" name="gender" class="" id="female"  value="0" />
                                                    </div>
                                                    <div class="mb-3">
                                                        <label for="exampleInputEmail1" class="form-label">Email</label>
                                                        <input type="email" name="email" class="form-control" id="exampleInputEmail1"  />
                                                    </div>
                                                    <div class="mb-3">
                                                        <label for="exampleInputEmail1" class="form-label">Tổng nợ</label>
                                                        <input type="text" value="0" class="form-control" id="exampleInputEmail1"  required="" disabled=""/>
                                                    </div>
                                                    <button type="submit" class="mr-1 btn btn-success">Thêm mới</button>
                                                </form>
                                            </div>
                                            <div class="modal-footer">
                                                <button
                                                    type="button"
                                                    class="btn btn-secondary"
                                                    data-bs-dismiss="modal"
                                                    >
                                                    Close
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                                    <form name="inputValue" action="debtorList" method="POST" >

                        <table class=" table table-bordered table-striped table-hover">
                            <thead >
                                <tr>
                                    <th style="border-radius: 10px 0 0 10px"><button name="column" value="id" style=" border: none; background-color: transparent; width: 45px; height: 45px;">ID</button></th>
                                    <th><button name="column" value="name" style=" border: none; background-color: transparent; width: 45px; height: 45px;">Tên</button></th>
                                    <th><button name="column" value="address" style=" border: none; background-color: transparent; width: 45px; height: 45px;">Địa Chỉ</button></th>
                                    <th><button name="column" value="phone_number" style=" border: none; background-color: transparent; width: 45px; height: 45px;">SDT</button></th>
                                    <th><button name="column" value="email" style=" border: none; background-color: transparent; width: 45px; height: 45px;">Email</button></th>
                                    <th><button name="column" value="total_money" style=" border: none; background-color: transparent; width: 45px; height: 45px;">Tổng Nợ</button></th>
                                    <th><button name="column" value="createdAt" style=" border: none; background-color: transparent; width: 45px; height: 45px;">Ngày Tạo</button></th>
                                    <th><button name="column" value="updatedAt" style=" border: none; background-color: transparent; width: 45px; height: 45px;">Cập Nhật</button></th>
                                    <th style="border-radius: 0px 10px 10px 0px">Action</th>
                                        <c:if test="${param.SORT == null || param.SORT == ''}">
                                <input type="hidden" name="SORT" value="ASC" />
                            </c:if>
                            <c:if test="${param.SORT != null && param.SORT !='' && param.SORT == 'ASC'}">
                                <input type="hidden" name="SORT" value="DESC" />
                            </c:if>
                            <c:if test="${param.SORT != null && param.SORT !='' && param.SORT == 'DESC'}">
                                <input type="hidden" name="SORT" value="ASC" />
                            </c:if>
                            </tr>
                            </thead>

                            <tbody>

                                <tr >
                                    <th>
                                        <div class="input-group mb-3">
                                            <input
                                                id="nmt"
                                                type="text"
                                                class="form-control"
                                                placeholder="From"
                                                name="idFrom"
                                                value="${param.idFrom}"

                                                oninput ="setTimeout(function () {
                                                javascript:document.getElementById('page').value = 1;javascript:document.inputValue.submit();
                                                }, 2000);"
                                                />

                                        </div>
                                        <div class="input-group">
                                            <input type="text" 
                                                   class="form-control" 
                                                   placeholder="To"    
                                                   oninput ="setTimeout(function () {
                                                   javascript:document.getElementById('page').value = 1;javascript:document.inputValue.submit();
                                                   }, 2000);"
                                                   name="idTo"
                                                   value="${param.idTo}"/>
                                        </div>
                                    </th>
                                    <th>
                                        <div class="input-group mb-3">
                                            <input
                                                type="text"
                                                class="form-control"

                                                aria-label="Username"
                                                aria-describedby="basic-addon1"
                                                name="name"
                                                value="${param.name}"
                                                oninput ="setTimeout(function () {
                                                javascript:document.getElementById('page').value = 1;javascript:document.inputValue.submit();
                                                }, 2000);" />
                                        </div>
                                    </th>
                                    <th>
                                        <div class="input-group mb-3">
                                            <input
                                                type="text"
                                                class="form-control"

                                                aria-label="Username"
                                                aria-describedby="basic-addon1"
                                                name="address"
                                                value="${param.address}"
                                                oninput ="setTimeout(function () {
                                                javascript:document.getElementById('page').value = 1;javascript:document.inputValue.submit();
                                                }, 2000);" />
                                        </div>
                                    </th>
                                    <th>
                                        <div class="input-group mb-3">
                                            <input
                                                type="text"
                                                class="form-control"

                                                aria-label="Username"
                                                aria-describedby="basic-addon1"
                                                name="phone"
                                                value="${param.phone}"
                                                oninput ="setTimeout(function () {
                                                javascript:document.getElementById('page').value = 1;javascript:document.inputValue.submit();
                                                }, 2000);" />
                                        </div>
                                    </th>
                                    <th>
                                        <div class="input-group mb-3">
                                            <input
                                                type="text"
                                                class="form-control"

                                                aria-label="Username"
                                                aria-describedby="basic-addon1"
                                                name="email"
                                                value="${param.email}"
                                                oninput ="setTimeout(function () {
                                                javascript:document.getElementById('page').value = 1;javascript:document.inputValue.submit();
                                                }, 2000);" />
                                        </div>
                                    </th>
                                    <th>
                                        <div class="input-group mb-3">
                                            <input
                                                type="text"
                                                class="form-control"
                                                placeholder="From"
                                                name="totalDeptFrom"
                                                value="${param.totalDeptFrom}"
                                                oninput ="setTimeout(function () {
                                                javascript:document.getElementById('page').value = 1;javascript:document.inputValue.submit();
                                                }, 2000);"  />
                                        </div>
                                        <div class="input-group mb-3">
                                            <input 
                                                type="text" 
                                                class="form-control" 
                                                placeholder="To" 
                                                name="totalDeptTo"
                                                value="${param.totalDeptTo}"
                                                oninput ="setTimeout(function () {
                                                javascript:document.getElementById('page').value = 1;javascript:document.inputValue.submit();
                                                }, 2000);" /> </div>
                                    </th>
                                    <th>
                                        <div class="input-group mb-3">
                                            <input
                                                type="date"
                                                class="form-control"
                                                placeholder="From"
                                                oninput ="setTimeout(function () {
                                                javascript:document.getElementById('page').value = 1;javascript:document.inputValue.submit();
                                                }, 2000);" name="createDateForm"
                                                value="${param.createDateForm}"
                                                />
                                        </div>
                                        <div class="input-group">
                                            <input type="date" class="form-control" placeholder="To"  
                                                   oninput ="setTimeout(function () {
                                                   javascript:document.getElementById('page').value = 1;javascript:document.inputValue.submit();
                                                   }, 2000);"  
                                                   name="createDateTo"
                                                   value="${param.createDateTo}"/>
                                        </div>
                                    </th>
                                    <th>
                                        <div class="input-group mb-3">
                                            <input
                                                type="date"
                                                class="form-control"
                                                placeholder="From"
                                                name="updateDateFrom"
                                                value="${param.updateDateFrom}"
                                                oninput ="setTimeout(function () {
                                                javascript:document.getElementById('page').value = 1;javascript:document.inputValue.submit();
                                                }, 2000);"    />
                                        </div>
                                        <div class="input-group">
                                            <input type="date" class="form-control" placeholder="To"  
                                                   oninput ="setTimeout(function () {
                                                   javascript:document.getElementById('page').value = 1;javascript:document.inputValue.submit();
                                                   }, 2000);"   name="updateDateTo"
                                                   value="${param.updateDateTo}"/>
                                        </div>
                                    </th>
                                    <th>

                                        <div class="d-grid">
                                            <a href="debtorList">
                                                <button type="button" class="btn btn-outline-danger mb-3"  >
                                                    CLEAR FILTER
                                                </button>
                                            </a>
                                        </div>
                                    </th>
                                </tr>



                                <c:forEach var="debtor" items="${requestScope.LiST_DEBTOR}">
                                    <tr >
                                        <th style="color: ${debtor.total_money < 0 ? "red" : "black"}"><p>${debtor.debtor_id}</p></th>
                                        <th style="color: ${debtor.total_money < 0 ? "red" : "black"}"><p>${debtor.debtor_name}</p></th>
                                        <th style="color: ${debtor.total_money < 0 ? "red" : "black"}"><p>${debtor.address}</p></th>
                                        <th style="color: ${debtor.total_money < 0 ? "red" : "black"}"><p>${debtor.phone_number}</p></th>
                                        <th style="color: ${debtor.total_money < 0 ? "red" : "black"}"><p>${debtor.email}</p></th>
                                        <th style="color: ${debtor.total_money < 0 ? "red" : "black"}"><p><fmt:formatNumber pattern="#,###" value="${debtor.total_money}" />$</p></th>
                                        <th style="color: ${debtor.total_money < 0 ? "red" : "black"}"><p>${debtor.created_time}</p></th>
                                        <th style="color: ${debtor.total_money < 0 ? "red" : "black"}"><p>${debtor.updated_time}</p></th>

                                        <th>
                                            <div style="width: 340px">

                                                <a href="debtorList>  
                                                    <button type="button" class="btn btn-info">
                                                        <i class="bi bi-info-circle-fill"></i> chi tiết  
                                                    </button>
                                                </a>
                                                <a href="debtorList>  
                                                    <button type="button" class="btn btn-outline-success">
                                                        <i class="bi bi-plus-circle-fill"></i> Thêm Phiếu Nợ  
                                                    </button>
                                                </a>
                                                <a href="LoadDebtor?debtor_id=${debtor.debtor_id}">
                                                    <button type="button" class="btn btn-warning">
                                                        <i class="bi bi-pen-fill"></i> Sửa
                                                    </button>
                                                </a>
                                            </div>
                                        </th>
                                    </tr>  
                                </c:forEach>


                            </tbody>

                        </table>

                        ${requestScope.MESSAGE}

                    </div>

                    <div class="pagination">
                        <ul>
                            <li class="btn">
                                <span><input id="Previus" class="btn" type="submit" value="Previus" name="btnPaging" /></span>

                            </li>
                            <li class="numb" }>
                                <span>
                                    <input
                                        id ="page"
                                        name="page"
                                        type="text"
                                        class="form-control pagination-input"
                                        value="${requestScope.PAGE}"
                                        readonly=""
                                        />
                                </span>

                            </li>
                            <li class="numb" }>
                                <span>/</span>
                            </li>
                            <li class="numb" }>

                                <span>
                                    <input
                                        id ="totalpage"
                                        type="text"
                                        class="form-control pagination-input"
                                        value="${requestScope.TOTAL_PAGE}"
                                        readonly=""
                                        />
                                </span>
                            </li>
                            <li class="numb">
                                <span><input id="Next" class="btn" type="submit" value="Next" name="btnPaging"  /></span>
                            </li>


                            <li class="btn">

                                <script>
                                    function defaultPage() {
                                        var size = document.getElementById('size').value;
                                        var sizeOld = ${requestScope.SIZE};
                                        if (size > sizeOld) {
                                            document.getElementById('page').value = 1;

                                        }
                                    }
                                </script>
                                <select id="size" name="size" class="form-select pagination-select"  onchange ="defaultPage();
                                    document.inputValue.submit();">
                                    <option value="1">1 Records</option>
                                    <option value="2">2 Records</option>
                                    <option value="3">3 Records</option>
                                    <option  value="5">5 Records</option>
                                    <option  value="10">10 Records</option>
                                    <option  value="20">20 Records</option>
                                    <option  value="30">30 Records</option>
                                    <option  value="40">40 Records</option>
                                </select>

                                <script>
                                    var select = document.getElementById("size");
                                    var selectedValue = ${requestScope.SIZE};
                                    for (var i = 0; i < select.options.length; i++) {
                                        if (select.options[i].value == selectedValue) {
                                            select.options[i].selected = true;
                                            break;
                                        }
                                    }
                                </script>

                            </li>

                        </ul>
                    </div>


</div>
</div>
</form> 
<div>
    <a href="home">
    <button type="button" class="btn btn-outline-success">
            Back to HomePage</button></a>
            </div>

            <script>
            if (${requestScope.PAGE} <= 1) {
            document.getElementById('Previus').disabled = true;
        }
        if (${requestScope.TOTAL_PAGE} === 0) {
            document.getElementById('Previus').disabled = true;
            document.getElementById('Next').disabled = true;
        }
        if (${requestScope.TOTAL_PAGE} === ${requestScope.PAGE}) {
            document.getElementById('Next').disabled = true;
        }
        if (${requestScope.TOTAL_PAGE} === 0) {
            totalpage;
            document.getElementById('totalpage').value = 1;
        }
        </script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"
        ></script>

        
                                                    
                                                
    </body>
</html>
