$(document).ready(function () {
    $("#changePasswordForm").validate({
        rules: {
            password: {
                required: true,
            },
            repassword: {
                required: true,
                equalTo: "#password"
            },
        },

        messages: {        
            password: {
                required: "Password cannot empty !",
            },
             repassword: {
                required: "Re-password cannot empty !",
                equalTo: "Re-password must equal to password !"
            },
        },

        errorPlacement: function (error, element) {
            if (element.attr("name") == "repassword") {
                error.appendTo("#repassword-error");
            } else if (element.attr("name") == "password") {
                error.appendTo("#password-error");
            } else {
                error.insertAfter(element);
            }
        },
    });
    $(document).on("click", "#addButton", function () {
        let result = $("#changePasswordForm").valid();
    });
})


