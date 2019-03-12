$(document).ready(function(e) {
    $("#resList").show();
    $("#resDetail").hide();
});


var helpDetail = function(id) {
    window.parent.document.getElementById("id").value=id;
    window.parent.document.getElementById("formAdd").action="../help/helpDetail.action";
    window.parent.document.getElementById("formAdd").submit();
};

var delHelp=function(id) {
    
 // 设置参数
    delParem = {
        "id" : id
    };
    showInfoMessageDouble("确定要删除吗？","提示信息", function(){
        ajaxPostAction("../helpJ/delHelp.action", delParem, delResult, "问题删除");
    });
};


//删除后判断返回结果
var delResult = function(data) {
    if (data != undefined && data != "") {
        var jsonObj = eval("(" + data + ")");
        var status = jsonObj.status;
        var msg = jsonObj.msg;

        // 处理成功情况
        if (status == "success") {
            showInfoMessage(msg, "提示信息", "/help/helpPageLinks.action");
        } else {
            showInfoMessage(msg, "提示信息",null);
        }
    }
};
