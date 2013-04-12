/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-10
 * Time: обнГ10:57
 * To change this template use File | Settings | File Templates.
 */

/**
 * init home js
 */
$(function () {
    // bind subDock click function
    bindSubDockClick();
    onBlurToggleClass($(".h_dock_sub"),'btn_onblur');

});

/**
 * bind SubDockDiv Click
 */
function bindSubDockClick() {
    $(".h_dock_sub").click(function ($clickEvt) {
        alert($clickEvt.currentTarget.id);
    });
}

function initSubDockContent() {
    var $obj = $(".h_dock_sub");
    var submitData = {};
    for (var i = 0; i < $obj.length; i++) {
        var tmpSubObj = $obj[i];
        submitData = {};
        submitData["act"] = "getDivContent";
        submitData["div_id"] = tmpSubObj.id;
        var request = $.ajax({
            url: "/divHtmlHandler",
            type: "GET",
            async: false,
            data: submitData,
            dataType: "html"
        });

        request.success(function (data) {
            var $tmpSubObj = $(tmpSubObj);
            $tmpSubObj.html(data);
            fadeInDiv_500($tmpSubObj.attr("id"), null);
        });

        request.fail(function (jqXHR, textStatus) {
            alert("ERROR:----------" + jqXHR.responseText);
        });
    }
}


function testSendEmail(){
    var request = $.ajax({
        url: "/sendEmail",
        type: "POST",
        async: false,
        data: {},
        dataType: "html"
    });

    request.success(function (data) {
        alert(data)
    });

    request.fail(function (jqXHR, textStatus) {
        alert("ERROR:----------" + jqXHR.responseText);
    });
}