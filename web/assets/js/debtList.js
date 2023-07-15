var btnDebtor = document.querySelector("#input-debtor");
var btnCreditor = document.querySelector("#input-creditor");
var inputDebtor = document.querySelector("#debtor");
var inputCreditor = document.querySelector("#creditor");

btnDebtor.onclick = () => {
    btnDebtor.classList.add("active");
    btnCreditor.classList.remove("active");
    inputDebtor.checked = true;
};
btnCreditor.onclick = () => {
    btnCreditor.classList.add("active");
    btnDebtor.classList.remove("active");
    inputCreditor.checked = true;
}

//Search 
let inputForm = document.querySelectorAll(".form-search-input");
let selectForm = document.getElementById("selectForm");
let formSearch = document.getElementById("formSearch");


inputForm.forEach(function (item) {
    item.oninput = ( ) => {
        setTimeout(function () {
            formSearch.submit();
        }, 1000);
    };
});

selectForm.onchange = () => {
    setTimeout(function () {
        formSearch.submit();
    }, 1000);
};

//Click and Sort

let btnHeader = document.querySelectorAll(".btn-header");
let debtorID = document.getElementById("debtorID");

let debtChoice = document.getElementById("debtChoice");
let valueChoice = document.getElementById("valueChoice");
if (debtChoice.value !== "" && valueChoice.value !== "") {
    btnHeader.forEach(function (item) {

        if (item.id === debtChoice.value) {
            if (valueChoice.value === "increase") {
                item.parentElement.classList.add("activeUp");
                item.parentElement.classList.remove("activeDown");

            } else {
                item.parentElement.classList.remove("activeUp");
                item.parentElement.classList.add("activeDown");
            }
        }
    });

}
btnHeader.forEach(function (item) {
    item.onclick = ( ) => {
        let parentItem = item.parentElement.classList;
        let check;
        parentItem.forEach(function (itemParrent) {

            if (itemParrent === "activeUp") {
                window.location = "sortDebtList?debtorId=" + debtorID.value + "&choice=" + item.id + "&value=decrease";
            } else {
                window.location = "sortDebtList?debtorId=" + debtorID.value + "&choice=" + item.id + "&value=increase";
            }
        });

    };
});



