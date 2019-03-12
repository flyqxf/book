<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>元能100信息服务</title>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="viewport" content="width=device-width, initial-scale=1">


 
 <link href="${pageContext.request.contextPath}/css/jquery-ui.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/jquery-ui-timepicker-addon.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/select2.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/select.css" rel="stylesheet">



<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/jquery-1.11.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/area.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/chooseLocation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/select2.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/kindeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

<script type="text/javascript">
id = "${bean.id}";
leibie = "${bean.leibie}";
$(document).ready(function(e) {
    $(".select1").uedSelect({
        width : 345           
    });
    $(".select2").uedSelect({
        width : 167  
    });
    $(".select3").uedSelect({
        width : 100
    });
    $("#update").one('click').click(update);
    KE.show({
        id : 'content7'
    });
});
var update = function() {
    var url = "../wenzhangJ/answer.action";
    // 迁移参数设定
    var answer = $("#answer").val();

    parem = {
            
            "leibie":leibie,
            "answer":answer,
            "id":id
        };
    
    ajaxPostAction(url, parem, updateResult,"提示信息");
    
};

//录入后判断返回结果
var updateResult = function(data) {
    if (data != undefined && data != "") {
        var jsonObj = eval("(" + data + ")");
        var status = jsonObj.status;
        var msg = jsonObj.msg;

        // 处理成功情况
        if (status == "success") {
            showInfoMessage2(msg, "提示信息", showWenzhang());
        } else {
            showInfoMessage(msg, "提示信息",null);
        }
    }
};

var showWenzhang= function() {
    parent.showWenzhang();
};
 
</script>

<body class="sarchbody">
    
<ul class="forminfo">
    <li><label>问题标题<b>*</b></label><s:property value="bean.title"/></li>
   
    <li><label>文章类别<b>*</b></label><label><s:property value="bean.leibie_name"/></label></li>
    <li><label>问题内容<b>*</b></label>
    
<textarea id="content7" name="content" style="width:700px;height:250px;visibility:hidden;" maxlength='10000'><s:property value="bean.content"/></textarea>
  <%--  <textarea name="textarea" cols="100" rows="9"><s:property value="bean.content"/></textarea> --%>
    
    </li>
    <li><label>答复<b>*</b></label>
    

    <textarea name="textarea" cols="100" rows="9" id="answer"><s:property value="bean.answer"/></textarea>
    
    </li>
    <li><label>&nbsp;</label><input id = "update" name="" type="button" class="btn" value="提交回答"/>
    </ul>
<s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />
</body>

</html>
