<%-- 
    Document   : register
    Created on : Feb 1, 2023, 1:12:03 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>

        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
        <!-- ICON -->
        <link rel="stylesheet" href="./assets/font/fontawesome-free-6.1.2-web/css/all.min.css">
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>

        <link rel="stylesheet" href="/DebtSystem/assets/css/register.css"/>
        <style>
            .container {
                height: 120vh;

            }
            .gender{
                width: 49%;
                display: inline-block;
                border: none;
                border-radius: 5px;
                height: 5vh;
                text-align: center;
                color: black;
                background-color: #fbceb5;
                cursor: pointer;
                border: none;
            }
            .gender.active{
                background-color: #fbceb5;
                color: #fff;
                font-size: 20px;
            }
            .gen_block{
                display: none;
            }
        </style>
    </head>
    <body>
        <!--<div class="h1 text-center mt-4 mb-4 header">Register Form</div>-->

        <div class="container">
            <div class="content mt-5">
                <div class="h3 text-center content-text">Register your account</div>
                <p class="text-center content-desc">
                    You have an account? <a href="login">Sign In Now !</a>
                </p>

                <form action="register" method="post"  name="" class="" id="registerForm">
                    <!-- Name -->
                    <div class="form-group  form-item">
                        <label for="email" class="label-field"
                               >Username <span class="text-danger">*</span></label
                        >
                        <input 
                            type="text"
                            class="form-control"
                            placeholder="Username"
                            id="name"
                            name="name"
                            />
                        <span class="errormess "></span>
                    </div>

                    <!-- Email -->
                    <div class="form-group form-item">
                        <label for="email" class="label-field"
                               >Email <span class="text-danger">*</span></label
                        >
                        <input
                            type="text"
                            class="form-control"
                            placeholder="E-mail"
                            id="email"
                            name="email"
                            />
                        <span class="errormess "></span>
                    </div>
                    <!--  Gioi Tinh--> 
                    <div class="form-group form-item mt-2">
                        <label for="" id="gender" class="gen"
                               >Gender<span class="text-danger">*</span></label
                        >
                    </div>
                    <div class="form-group form-item mt-2">
                        <button type="button" id="inputmale" class="male gender active">
                            Male
                        </button>
                        <button type="button" id="inputfemale" class="female gender">
                            Female
                        </button>
                        <input
                            type="radio"
                            class=""
                            placeholder=""
                            id="male"
                            name="gender"
                            value="1" checked 
                            hidden=""
                            />
                        <input
                            type="radio"
                            class=""
                            placeholder=""
                            id="female"
                            name="gender"
                            value="0" 
                            hidden=""
                            />
                    </div>



                    <!-- Pass -->
                    <div class="form-group  form-item">
                        <label for="password" class="label-field"
                               >Password <span class="text-danger"></span></label
                        >
                        <input
                            type="password"
                            class="form-control"
                            placeholder="Password"
                            id="password"
                            name="password"
                            />
                        <span class="errormess "></span>

                    </div>
                    <!-- Repass -->
                    <div class="form-group  form-item">
                        <label for="password" class="label-field"
                               >Re-password <span class="text-danger">*</span></label
                        >
                        <input
                            type="password"
                            class="form-control"
                            placeholder="Re-password"
                            id="repassword"
                            name="repassword"
                            />
                        <span class="errormess "></span>

                    </div>
                    <!-- Phone -->
                    <div class="form-group form-item">
                        <label for="email" class="label-field"
                               >Phone Number <span class="text-danger">*</span></label
                        >
                        <input
                            type="text"
                            class="form-control"
                            placeholder="Phone Number"
                            id="phone"
                            name="phone"
                            />
                        <span class="errormess "></span>
                    </div>

                    <!--  Dia chi--> 
                    <div class="form-group form-item">
                        <label for="email" class="label-field"
                               >Address <span class="text-danger">*</span></label
                        >
                        <input
                            type="text"
                            class="form-control"
                            placeholder="Address"
                            id="adr"
                            name="adr"
                            />
                        <span class="errormess "></span>
                    </div>

                    <!--  Anh--> 
                    <div class="form-group form-item">
                        <label for="pic" class="label-field"
                               >Picture<span class="text-danger">*</span></label
                        >
                        <input
                            type="text"
                            class="form-control"
                            placeholder="Http only"
                            id="pic"
                            name="pic"
                            />
                        <span class="errormess "></span>
                    </div>
                    <input name="type_otp" value="2" hidden></input>
                    <div class="form-group mt-1 form-item-btn mt-3">
                        <button
                            type="submit"
                            class="btn btn-primary btn-register form-control"
                            id="login-btn"
                            >
                            Sign up
                        </button>
                    </div>

                    <div class="form-group mt-1 form-item-btn mt-3 submit_btn">
                        <button
                            type="submit"
                            class="btn btn-primary btn-register form-control "
                            id="login-btn"
                            
                            >
                            Sign up
                        </button>
                    </div>
                    <p class="mess-error">${requestScope.message}</p>
                </form>

            </div>
        </div>
         <script >
            function checkEmptyInputWhenSubmit() {
                //Take all input tags
                var inputs = document.querySelectorAll("input");
                let isEmpty;
                let checkRadioMale = true;
                let checkRadioFemale = true;
                //Loop through all input tags
                inputs.forEach(function (cur) {
                    if (cur.id === 'male' || cur.id === 'female' || cur.id === 'pic') {
                        if (cur.id === 'pic') {
                            //Check img link
                            if (cur.value !== '') {
                                let isPic = checkLinkImg(cur);
                                if (isPic !== true) {
                                    isEmpty = false;
                                    cur.nextElementSibling.textContent = isPic;
                                    cur.classList.add("invalid");
                                    cur.nextElementSibling.classList.add("invalid");
                                } else {
                                    isEmpty = true;
                                    cur.nextElementSibling.textContent = "";
                                    cur.classList.remove("invalid");
                                    cur.nextElementSibling.classList.remove("invalid");
                                }
                            }
                        }


                    } else {
                        // If input value is empty
                        var valueInput = cur.value;
                        var emptyInput = valueInput.trim() ? true : "Please input information field!";
                        // Return a message error
                        if (emptyInput !== true) {
                            isEmpty = false;
                            // Find next element equal level of current element are focused
                            cur.nextElementSibling.textContent = emptyInput;
                            cur.classList.add("invalid");
                            cur.nextElementSibling.classList.add("invalid");
                        } else {
                            cur.nextElementSibling.textContent = "";
                            cur.classList.remove("invalid");
                            cur.nextElementSibling.classList.remove("invalid");
                            // If all inputs are note empty then check format of phonenumber
                            switch (cur.id) {
                                //Check phone format
                                case "phone":
                                    let isformat = formatPhone(cur);
                                    if (isformat === false) {
                                        isEmpty = false;
                                    } else {
                                        isEmpty = true;
                                    }
                                    break;
                                    //Check account format 
                                case "email":
                                    let isEmail = formatEmail(cur);
                                    if (isEmail !== true) {
                                        isEmpty = false;
                                        cur.nextElementSibling.textContent = isEmail;
                                        cur.classList.add("invalid");
                                        cur.nextElementSibling.classList.add("invalid");
                                    } else {
                                        isEmpty = true;
                                        cur.nextElementSibling.textContent = "";
                                        cur.classList.remove("invalid");
                                        cur.nextElementSibling.classList.remove("invalid");
                                    }
                                    break;
                                case "name":
                                    let isName = formatName(cur);
                                    if (isName !== true) {
                                        isEmpty = false;
                                        cur.nextElementSibling.textContent = isName;
                                        cur.classList.add("invalid");
                                        cur.nextElementSibling.classList.add("invalid");
                                    } else {
                                        isEmpty = true;
                                        cur.nextElementSibling.textContent = "";
                                        cur.classList.remove("invalid");
                                        cur.nextElementSibling.classList.remove("invalid");
                                    }
                                    break;
                                    //Check password format 
                                case "password":
                                    let isPass = formatPassword(cur);
                                    if (isPass !== true) {
                                        isEmpty = false;
                                        cur.nextElementSibling.textContent = isPass;
                                        cur.classList.add("invalid");
                                        cur.nextElementSibling.classList.add("invalid");
                                    } else {
                                        isEmpty = true;
                                        cur.nextElementSibling.textContent = "";
                                        cur.classList.remove("invalid");
                                        cur.nextElementSibling.classList.remove("invalid");
                                    }
                                    break;
                                case "repassword":
                                    let isRePass = checkBothPassword(cur);
                                    if (isRePass !== true) {
                                        isEmpty = false;
                                        cur.nextElementSibling.textContent = isRePass;
                                        cur.classList.add("invalid");
                                        cur.nextElementSibling.classList.add("invalid");
                                    } else {
                                        isEmpty = true;
                                        cur.nextElementSibling.textContent = "";
                                        cur.classList.remove("invalid");
                                        cur.nextElementSibling.classList.remove("invalid");
                                    }
                                    break;


                                default:
                                    break;
                            }

                        }
                    }
                });

                return isEmpty;
            }
            function formatPhone(phone) {
                // let phoneNumber = document.querySelector("#phone").value;
                let checkFormat = /(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})\b/.test(phone.value);
                let messageFormat = checkFormat ? true : "Wrong format of phone number";
                let isFormat = true;
                if (messageFormat !== true) {
                    isFormat = false;
                    // Find next element equal level of current element are focused
                    phone.nextElementSibling.textContent = messageFormat;
                    phone.classList.add("invalid");
                    phone.nextElementSibling.classList.add("invalid");
                } else {
                    isFormat = true;
                    phone.nextElementSibling.textContent = "";
                    phone.classList.remove("invalid");
                    phone.nextElementSibling.classList.remove("invalid");
                }
                return isFormat;
            }

            function formatEmail(email) {
                let check;
                // before the @gmail.com and accepts everything else
                //Not except @ () , . : " " [] <> \ , dấu cách 
                var regexp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                let formatEmail = regexp.test(String(email.value).toLowerCase());
                if (formatEmail !== true) {
                    check = "Wrong email format!";
                } else {
                    check = true;
                }
                return check;
            }

            function formatPassword(pass) {
                let check;
                if (pass.value.length < 6) {
                    check = "Length of password mute above 6 characters";
                } else {
                    let regExp = /^(?=.*[a-zA-Z])(?=.*[0-9])/;
                    let isMatch = regExp.test(pass.value);
                    if (isMatch) {
                        check = true;
                    } else {
                        check = "Password do not have both letter and number";
                    }
                }
                return check;
            }
            function formatName(name) {
                let check;

                let regExp = /^[A-Za-z0-9 ]+$/;
                let isMatch = regExp.test(name.value);
                let re = /^\S+$/;
                if (isMatch) {
                    check = true;
                } else { // có special character
                    check = "Name not allow to have special character";
                }
                return check;
            }


            function checkBothPassword(repassword) {
                let pass = document.querySelector("#password");
                let check;
                if (repassword.value === pass.value) {
                    check = true;
                } else {
                    check = "Repassword is no duplicate with password!";
                }
                return check;
            }

            function checkLinkImg(img) {
                if (img.value.startsWith('https')) {
                    return true;
                } else {
                    return "Picture is not link https";
                }
            }


            var formRegister = document.querySelector("#registerForm");
            if (formRegister) {
                var checkEmptyAllInput;
                formRegister.onsubmit = function (e) {
                    e.preventDefault();
                    checkEmptyAllInput = checkEmptyInputWhenSubmit();
                    //        // equal false min one of these inputs are empty
                    if (checkEmptyAllInput === true) {
                        document.getElementById("registerForm").submit();

                    }
                    document.querySelector(".submit_btn").classList.add("btn_appear");
                };
            }


            var btnMale = document.querySelector("#inputmale");
            var btnFemale = document.querySelector("#inputfemale");

            var inputMale = document.querySelector("#male");
            var inputFemale = document.querySelector("#female");
            btnMale.onclick = () => {
                btnMale.classList.add("active");
                btnFemale.classList.remove("active");
                // inputMale.setAttribute("checked",true);
                inputMale.checked = true;
//                console.log(inputMale);
            };
            btnFemale.onclick = () => {
                btnFemale.classList.add("active");
                btnMale.classList.remove("active");
                inputFemale.checked = true;
//                console.log(inputFemale);
            };
        </script>
    </body>
</html>
