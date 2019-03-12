
clickFlg=false;

function lockSubmit (formId, action) {
    if (!clickFlg) {
        disableAllComponents();
        clickFlg = true;
        if (action != undefined ) {
            document.getElementById(formId).action=action;
        }
        document.getElementById(formId).submit();
        enableAllComponents();
    }
}
/*********************************************************************************
 * FUNCTION: newWindow
 * PARAMETERS: doc -> Document to open in the new window
 hite -> Height of the new window
 wide -> Width of the new window
 bars -> 1-Scrll bars = YES 0-Scroll Bars = NO
 resize -> 1-Resizable = YES 0-Resizable = NO
 * CALLS: NONE
 * RETURNS: New window instance
 **********************************************************************************/
function newWindow (doc, hite, wide, bars, resize) {
    var winNew="_blank";
    var opt="toolbar=0,location=0,directories=0,status=0,menubar=0,";
    opt+=("scrollbars="+bars+",");
    opt+=("resizable="+resize+",");
    opt+=("width="+wide+",");
    opt+=("height="+hite);
    winHandle=window.open(doc,winNew,opt);
    return;
}

/**
 * 页面跳转按钮按下处理
 * 
 * @param {} actUrl 跳转页面URL
 * @param {} params 迁移参数
 */
var deptAction = function(actUrl, params) {
    $('#deptForm').remove();
    disableAllComponents();
    var deptForm = document.createElement("form");
    deptForm.method="post";
    deptForm.id="deptForm";
    deptForm.action=actUrl;
    if (params != undefined && params.length > 0) {
        for (i=0; i<params.length; i++) {
            var data = params[i];
            if (data != undefined) {
                $("input[name='" + data[0] + "']").remove();
                deptForm.appendChild(addHiddenInputToForm(data[0], data[1]));
            }
        }
    }
    $("body").append(deptForm);
    $(deptForm).submit();
    $('#deptForm').remove();
    enableAllComponents();
};

/**
 * 向指定FROM中追加HIDDEN变量
 * 
 * @param {} addToForm 添加FORM
 * @param {} addToName 添加参数名
 * @param {} addToValue 添加设定值
 */
var addHiddenInputToForm = function(addToName, addToValue) {
    var input = document.createElement("input");
    input.type = "hidden";
    input.name = addToName;
    input.value = addToValue;
    return input;
};

/**
 * ajax调用Action(同步)
 * 
 * @param {} actUrl 调用事件URL
 * @param {} data 调用事件参数
 * @param {} backFunc 回调函数
 * @param {} errMsg 出错信息替换文字
 */
var ajaxPostAction = function(actUrl, data, backFunc, errMsg) {
    $.ajax({
        type : "POST",
        url : actUrl,
        data : data,
        async : false, // true表示异步 false表示同步
        dataType : "json",
        success : backFunc,
        error: function (jqXHR, textStatus, errorThrown) {
            deptAction("../common/error.action");
        }
    });
};

/**
 * ajax调用Action(异步)
 * 
 * @param {} actUrl 调用事件URL
 * @param {} data 调用事件参数
 * @param {} backFunc 回调函数
 * @param {} errMsg 出错信息替换文字
 */
var ajaxPostAsyncAction = function(actUrl, data, backFunc, errMsg) {
    $.ajax({
        type : "POST",
        url : actUrl,
        data : data,
        async : true, // true表示异步 false表示同步
        dataType : "json",
        beforeSend: function(jqXHR, options) {
            // 处理开始时显示处理状态信息
            $("#maskDivId").fadeTo(0, 0.5);
        },
        success : backFunc,
        error: function (jqXHR, textStatus, errorThrown) {
            deptAction("../common/error.action");
        },
        complete: function() {
            // 完成处理时消除处理状态信息
            $("#maskDivId").hide();
        }
    });
};

/**
 * 显示提示信息
 * 
 * @param {} msg 显示信息
 * @param {} title 显示标题
 * @param {} url 回掉Action的URL
 */
var showInfoMsg = function(msg, title, url) {
    $("#infoMsgId").html(msg);
    $("#infoMsgDivId").dialog({
        closeOnEscape: false,
        resizable: false,
        draggable: false,
        modal: true,
        title: title,
        buttons: {
          "确定": function() {
            $( this ).dialog( "close" );
            if (url != undefined) {
                deptAction(url);
            }
            return false;
          }
        }
    });
};

/**
 * 显示确认信息
 * 
 * @param {} btnName 按钮名称
 * @param {} msg 显示信息
 * @param {} title 显示标题
 * @param {} url 回掉Action的URL
 */
var showConfirmMsg = function(msg, title, height, callback) {
    $("#infoMsgId").html(msg);
    $("#infoMsgDivId").dialog({
        height: height,
        closeOnEscape: false,
        resizable: false,
        draggable: false,
        modal: true,
        title: title,
        buttons: {
          "确定": function() {
              $( this ).dialog( "close" );
              if (typeof callback === "function") {
                  callback();
              }
          },
          "取消": function() {
            $( this ).dialog( "close" );
            return false;
          }
        }
    });
};

/**
 * 日期控件
 *  @param  id 日期控件文本框ID
 */
var DateControlFormat = function(id,format,mark) {
    if(mark == "time"){
    	$("#"+id).datetimepicker({
    	 showButtonPanel: true,
    	 changeMonth:true,
    	 changeYear:true,
    	 closeText:"关闭",
    	 currentText:"今天",
    	 dateFormat:format,
    	 dayNames:['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
    	 dayNamesMin:['日','一','二','三','四','五','六'],
    	 monthNamesShort:['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		 timeText: '时间',
		 hourText: '小时',
		 dateFormat:format,
		 timeFormat: "HH:mm:ss",
		 minuteText: '分钟',
		 secondText: '秒',
		 showSecond:true,
		 showTime: true,
	     nextText:"下月",
	     prevText:"上月"
    	 });
    }
    $("#"+id).datetimepicker({
     showButtonPanel: true,
     changeMonth:true,
     changeYear:true,
     closeText:"关闭",
     currentText:"今天",
     dateFormat:format,
     dayNames:['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
     dayNamesMin:['日','一','二','三','四','五','六'],
     monthNamesShort:['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
     timeFormat:"",
     showTime: false,
     nextText:"下月",
     prevText:"上月"
    });
};


/**
 * 日期控件
 *  @param  id 日期控件文本框ID
 */
var DateControl = function(id) {
    
    DateControlFormat(id,"yy-mm-dd");
};

/**
 * 显示·隐藏图表控件
 *  @param {} targetid 控件ID
 */
var toggle = function(targetid) {
    var obj = $("#" + targetid);
    if (obj != undefined){
        if( obj.css("display") == 'block' ) {
            obj.css('display','none'); 
        } else {
            obj.css('display','block'); 
        }
    }
};

/**
 * 屏蔽所有按钮·链接处理
 */
var disableAllComponents = function() {
    $("button").each(function() {
        if (!$(this).attr("disabled")) {
            $(this).attr("disabled", "true");
        }
    });
    $("submit").each(function() {
        if (!$(this).attr("disabled")) {
            $(this).attr("disabled", "true");
        }
    });
    $("a").each(function() {
        if (!$(this).attr("disabled")) {
            $(this).attr("disabled", "true");
            $(this).css("cursor", "default");
        }
    });
};

/**
 * 激活所有按钮·链接处理
 */
var enableAllComponents = function() {
    $("button").each(function() {
        if ($(this).attr("disabled")) {
            $(this).removeAttr("disabled");
        }
    });
    $("submit").each(function() {
        if ($(this).attr("disabled")) {
            $(this).removeAttr("disabled");
        }
    });
    $("a").each(function() {
        if ($(this).attr("disabled")) {
            $(this).removeAttr("disabled");
            $(this).css("cursor", "pointer");
        }
    });
};

/**
 * 清空画面的输入值
 */
var resetPage = function(id) {
    if (id != undefined) {
        $("#"+id).prop("value","");
    }
    $(":text").each(function(){
       if (!$(this).prop("readonly")) {
           $(this).prop("value","");
       }
    });
    //$(":text").prop("value","");
    $(":password").each(function(){
        if (!$(this).prop("readonly")) {
            $(this).prop("value","");
        }
     });
    //$(":password").prop("value","");
    $("select").each(function() {
        $(this).children("option:first").prop("selected",true);
    });
    var preName = "";
    $(":radio").each(function(){
        if (preName != $(this).prop("name")) {
            preName = $(this).prop("name");
            $(this).prop("checked",true);
        } else {
            $(this).prop("checked",false);
        }
    });
    $(":checkbox").each(function() {
        $(this).prop("checked",false);
    });
};

/**
 * 禁止快捷键
 */
(function() {
    $(document).bind("contextmenu", function () { return false; });
    $(document).bind("selectstart", function () { return false; });
    $(document).keydown(function () { return key(arguments[0]) });
    $(document).bind("keydown",function(e) {
        e = window.event;
        alert(e.keyCode);
        // 「F5」
        if(e.keyCode == 116) {
            e.returnValue = false;
            return false;
        }
     // 「F12」
        if(e.keyCode == 123) {
            e.returnValue = false;
            return false;
        }
        // 「Alt + →」「Alt + ←」
        if ((e.altKey) && ((e.keyCode == 37) || (e.keyCode == 39))) {
            e.returnValue = false;
            return false;
        }
        // 「Backspace」
        if(e.keyCode == 8) {
            var src = e.srcElement;
            if(((src.tagName == "INPUT" && (src.type == "text" || src.type == "password")) || src.tagName == "TEXTAREA") && src.readOnly == false){
                return true;
            } else {
                e.returnValue = false;
                return false;
            }
        }
        // 「Ctrl + R」
        if((e.ctrlKey) && (e.keyCode == 82)) {
            e.returnValue = false;
            return false;
        }
        // 「 Ctrl + F5」
        if ((e.ctrlKey) && (e.keyCode == 116)) {
            e.returnValue = false;
            return false;
        }
        // 「Ctrl + K」
        if ((e.ctrlKey) && (e.keyCode == 75)) {
            e.returnValue = false;
            return false;
        }
        // 「Ctrl + Shift + T」
        if ((e.ctrlKey) && (e.shiftKey) && (e.keyCode == 84)) {
            e.returnValue = false;
            return false;
        }
        // 「Ctrl + N」
        if ((e.ctrlKey) && (e.keyCode == 78)) {
            e.returnValue = false;
            return false;
        }
    });
})();
