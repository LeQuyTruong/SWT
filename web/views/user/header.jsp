<header>
    <head>
        <link rel="stylesheet" href="styleheader.css">
        <script src="home.js"></script>
        <link rel="stylesheet" href="/DebtSystem/assets/css/homepage.css">
        <style>

            /*Notification*/
            .noti-details{
                position: fixed;
                top: 13%;
                right: 0;
                background-color: #fff;
                /*box-shadow: 5px 8px rgba(0, 0, 0, 0.08);*/
                animation: slideInRight ease 1s;
                transition: all linear 1s;
                display: none;
                max-width: 500px;
                min-width: 300px;
                border-radius: 5%;
                height: 60vh;
                overflow: scroll;
                z-index: 1;
            }

            .noti-block{
                display: flex;
                align-items: center;
                padding: 20px;


            }

            @keyframes slideInRight{
                from {
                    opacity : 0;
                    transform: translateX(500px);
                }
                to{
                    opacity : 1;
                    transform: translateX(0);
                }
            }

            @keyframes slideBack{
                from {
                    opacity : 0;
                    transform: translateX(0);
                }
                to{
                    opacity : 1;
                    transform: translateX(-460px);

                }
            }

            .body{
                width: 200px;
            }
            .icon{
                font-size: 40px;
            }
            .success{
                color: #47d864;
            }
            .fail{
                color: #ff623d;
            }
            .mr-20{
                margin-right:20px;
            }
            .exist-btn {
                font-size: 30px;
                color: red;
                cursor: pointer;
                position: absolute;
                top: 10px;
                right: 0%;
            }
            .noti-logo{
                position: fixed;
                right: 200px;
                font-size: 30px;
                margin-top: 18px;
                cursor: pointer;
                margin-right: 24px;
            }
            .noti-logo ion-icon{
                color: #EAA023;
            }
            .noti-logo span{
                color: #fff;
                font-size: 20px;
                position: relative;
                top: 10px;
                left: -15px;
            }
            .noti.time{
                width: 50%;
            }
        </style>
    </head>
    <div class="header">
        <h1></h1>  
        <div class="logo">
            <label class="profile-text"style="font-size: 15px; color: white">Profile</label>
            <a href="profile"><ion-icon name="person-outline"></ion-icon></a>
        </div>
        <div class="logout-logo">
            <label class="logout-text"style="font-size: 15px; color: white">Logout</label>
            <a href="logout"><ion-icon name="log-out-outline"></ion-icon></a>
        </div>
        <div class="debtors-logo">
            <a href="debtorList" style="color: white"><ion-icon name="book-outline"></ion-icon></a>
            <label class="debtor-text"style="font-size: 15px; color: white">Debit Book</label>
        </div>

        <div class="home-logo">
            <a href="home" style="color: white"><ion-icon name="home-outline"></ion-icon></a>
            <label class="home-text"style="font-size: 15px; color: white">Home</label>
        </div>

        <div class="noti-logo notification" >
            <label class="noti-text" style="font-size: 15px; color: white">Notification</label>
            <ion-icon name="notifications-outline" style="color:white"></ion-icon>
            <c:if test="${sessionScope.lengthNoti != null}">  
                <span style="">${sessionScope.lengthNoti}</span>
            </c:if>  
            <c:if test="${sessionScope.lengthNoti == null}">  
                <span style="">0</span>
            </c:if>  

        </div>
    </div>

    <section class="noti-details">
        <div class="noti exist-btn  ">
            <ion-icon name="close-circle-outline"></ion-icon>
        </div>
        <c:if test="${sessionScope.lengthNoti != null}">  
            <c:forEach items="${sessionScope.dataNoti}" var="noti">
                <div class="noti-block">
                    <div class="noti icon ${noti.getStatus()} mr-20">
                        <ion-icon name="${noti.getIcon()}"></ion-icon>
                    </div>
                    <div class="noti body mr-20">
                        <h3 class="noti_title ${noti.getStatus()}">${noti.getTitle()}</h3>
                        <p class="noti_msg">${noti.getMessage()}</p>
                    </div>

                    <div  class="noti time mr-20">
                        <p class="noti_msg">${noti.getTime()}</p>
                    </div>
                </div>
            </c:forEach>
        </c:if>  
    </section>

    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <script src="/DebtSystem/assets/js/home.js"></script>
    <script >
        let notification = document.querySelector(".notification");
        let noti_icon = document.querySelector(".noti-details");
        let exist_btn = document.querySelector(".exist-btn ");
        notification.onclick = () => {
            noti_icon.style.display = 'block';
        };
        exist_btn.onclick = () => {
            noti_icon.style.display = 'none';
        };

    </script>
</header>