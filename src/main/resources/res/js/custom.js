
$(document).ready(function(){
    HideAllPopUp();
});
function PopUpShow(){
    $("#popup1").show();
}
function PopUpHide(){
    $("#popup1").hide();
}

function PopUpShowAddHall(){
    $("#popupaddhall").show();
}
function PopUpHideAddHall(){
    $("#popupaddhall").hide();
}

function HideAllPopUp(){
    PopUpHide();
    PopUpHideAddHall();
}