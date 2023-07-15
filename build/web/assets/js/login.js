$(document).ready(function () {
    $("#loginForm").validate({
        rules: {
            email: {
                required: true,
            },
            password: {
                required: true,
            },       
        },

        messages: {
            email: {
                required: "Email cannot empty !"
            },
            password: {
                required: "Password cannot empty !",
            }, 
        },

        errorPlacement: function (error, element) {
            if (element.attr("name") == "email") {
                error.appendTo("#email-error");
            } else if (element.attr("name") == "password") {
                error.appendTo("#password-error");
            }  else {
                error.insertAfter(element);
            }
        },
    });
    $(document).on("click", "#addButton", function () {
        let result = $("#loginForm").valid();
    });
})



