$(document).ready(function(e) {
    $("#updatePerson").off('click').click(personSubmit);
    $("#cancel").off('click').click(cancel);
});
     
var personSubmit = function() {

    var userId = $("#userId").val();
    var userName=$("#userName").val();
    var mail=$("#mail").val();
    var id_zhifubao = $("#id_zhifubao").val();
    var id_weixin = $("#id_weixin").val();
    var bank = $("#bank").val();
    var bank_card_name = $("#bank_card_name").val();
    var bank_card_number = $("#bank_card_number").val();
    var receivables_flg = $("#receivables_flg").val();

    
    // 设置参数
    parem = {
        "userId" : userId,
        "userName":userName,
        "mail":mail,
        "id_zhifubao":id_zhifubao,
        "id_weixin":id_weixin,
        "bank":bank,
        "bank_card_name":bank_card_name,
        "bank_card_number":bank_card_number,
        "receivables_flg":receivables_flg
    };
    
    ajaxPostAction("../personJ/personUpdate.action", parem, editResult, "个人信息修改");
};


//录入后判断返回结果
var editResult = function(data) {
    if (data != undefined && data != "") {
        var jsonObj = eval("(" + data + ")");
        var status = jsonObj.status;
        var msg = jsonObj.msg;

        // 处理成功情况
        if (status == "success") {
            showInfoMessage(msg, "提示信息", "/person/tab1Person.action");
        } else {
            showInfoMessage(msg, "提示信息",null);
        }
    }
};

var cancel = function() {
    var url="../person/tab1Person.action";
    deptAction(url,new Array());
};
