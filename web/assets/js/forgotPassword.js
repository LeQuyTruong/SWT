$(document).ready(function () {
    $("#forgotPasswordForm").validate({
        rules: {
            email: {
                required: true,
            },
        },

        messages: {
            email: {
                required: "Email cannot empty !"
            },
        },

        errorPlacement: function (error, element) {
            if (element.attr("name") == "email") {
                error.appendTo("#email-error");
            } else {
                error.insertAfter(element);
            }
        },
    });
    $(document).on("click", "#addButton", function () {
        let result = $("#forgotPasswordForm").valid();
    });
})

