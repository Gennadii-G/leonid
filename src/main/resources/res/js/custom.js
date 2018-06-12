
$(document).ready(function(){
    HideAllPopUp();
});
function PopUpShowAddDisc(){
    $("#popupadddisc").show();
}
function PopUpHideAddDisc(){
    $("#popupadddisc").hide();
}

function PopUpShowAddHall(){
    $("#popupaddhall").show();
}
function PopUpHideAddHall(){
    $("#popupaddhall").hide();
}

function PopUpShowAddOrder(){
    $("#popupaddorder").show();
}
function PopUpHideAddOrder(){
    $("#popupaddorder").hide();
}

function PopUpShowAddUser(){
    $("#popupadduser").show();
}
function PopUpHideAddUser(){
    $("#popupadduser").hide();
}

function HideAllPopUp(){
    PopUpHideAddDisc();
    PopUpHideAddHall();
    PopUpHideAddOrder();
    PopUpHideAddUser();
}