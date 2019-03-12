$(document).ready(function(e) {
    windowSize();
   $("#idCalendarPre").one('click',preCalendar);
   $("#idCalendarNext").one('click',nextCalendar);
   $("#btnInsertDiary").click(insertDiary);
   $("#updateDiary").one('click',updateDiary);
   $("#delDiary").one('click',delDiary);
   
 
});

var preCalendar = function() {
    
    var url = "../diary/perCalendar.action";
    
    var year = $("#idYear").val();
    var month = $("#idMonth").val();

    
    // 迁移参数设定
    var params = new Array();
    params[0] = ["year", year];
    params[1] = ["month", month];
    
    deptAction(url,params);
};

var nextCalendar = function() {
    
    var url = "../diary/nextCalendar.action";
    
    var year = $("#idYear").val();
    var month = $("#idMonth").val();
    
    // 迁移参数设定
    var params = new Array();
    params[0] = ["year", year];
    params[1] = ["month", month];
    
    deptAction(url,params);
};

var showDiv = function(day) {

    var url = "../diaryJ/haveDiary.action";
    var year = $("#idYear").val();
    var month = $("#idMonth").val();
    selectDay = day;
    $.post(url, {"year" : year,"month" : month,"day" : day }, function(data) {
        var index = data[0];
        
        if(index == 0) {
            
            $('#popup_container').show();
            ('#popup_container2').hide();
        }else {
            var bean = data[1];
            
            $("#editTitle").val(bean.title);
            $("#diaryTime").html(bean.diaryTime);
            $("#editContent").val(bean.diary);
            $("#diaryId").val(bean.id);
            $('#popup_container').hide();
            $('#popup_container2').show();
        }
    });
    
    
    //alert($("#idTd"+day).html());
};

var today = function() {
    var url = "../diary/diary.action";
    deptAction(url,new Array());
};

var insertDiary = function() {
    
    var title = $("#title").val();
    var content = $("#content").val();
    var year = $("#idYear").val();
    var month = $("#idMonth").val();

    // 设置参数
    parem = {
        "title" : title,
        "content":content,
        "year":year,
        "month":month,
        "day":selectDay
    };
    
    ajaxPostAction("../diaryJ/insertDiary.action", parem, addResult, "日记录入");
    
    
};

//录入后判断返回结果
var addResult = function(data) {

    if (data != undefined && data != "") {
        var jsonObj = eval("(" + data + ")");
        var status = jsonObj.status;
        var msg = jsonObj.msg;
        $('#popup_container').hide();
        // 处理成功情况
        if (status == "success") {
            showInfoMessage2(msg, "提示信息",function(){
                var url = "../diary/showDiary.action";
                var year = $("#idYear").val();
                var month = $("#idMonth").val();
                var params = new Array();
                params[0] = ["year", year];
                params[1] = ["month", month];
                params[2] = ["day", selectDay];
                
                deptAction(url,params);
                
            });
        } else {
            showInfoMessage(msg, "提示信息",null);
        }
    }
};

var closeDiv= function() {
    $('#popup_container').hide();
};
var closeDiv2= function() {
    $('#popup_container2').hide();
};

var updateDiary = function() {
    var title = $("#editTitle").val();
    var content = $("#editContent").val();
    var id = $("#diaryId").val();
    // 设置参数
    updateparem = {
        "title" : title,
        "content":content,
        "id":id
    };
    ajaxPostAction("../diaryJ/updateDiary.action", updateparem, addResult, "日记修改");

};
var delDiary = function() {
    var id = $("#diaryId").val();
    // 设置参数
    updateparem = {
        "id":id
    };
    ajaxPostAction("../diaryJ/delDiary.action", updateparem, addResult, "日记修改");

};
var index= function(){
    var url = "../bookScan/bookScanAction.action";
    deptAction(url,new Array());
};
