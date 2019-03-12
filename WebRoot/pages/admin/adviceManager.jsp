<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/area2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/chooseLocation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/select2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

<script type="text/javascript">
totalIndex = "${size}";
msg="${msg}";
$(document).ready(function(e) {
    $("#update").one('click').click(update);

    if(msg != null && msg !='') {
        showInfoMessage(msg);
    }
});


var addRow=function(){

        $("#settingTable").append(
                '<tr id="row"'+ totalIndex + '>'+
                '<td><s:textfield id="adviceTitle'+totalIndex+'" name="adviceList['+ totalIndex + '].adviceTitle"  class="scinput" theme="simple"/></td>'+
                '<td><s:textfield id="adviceType'+totalIndex+'" name="adviceList['+ totalIndex + '].adviceType" class="scinput" theme="simple"/></td>'+
                '<td><s:textfield id="link'+totalIndex+'" name="adviceList['+ totalIndex + '].link" class="scinput" theme="simple" maxlength="50"/></td>'+
                '<td><input  type="button" class="btn" value="删除" onclick="removeRow('+totalIndex+')" /></td>'+
                '</tr>'
        );
        totalIndex++;
    };
var removeRow=function(rownum) {
    
    var lastHidIdx = totalIndex-1;
    for(var i = rownum;i<totalIndex;i++) {
            var idx = i;
        if(idx != lastHidIdx) {
            var j=parseInt(idx)+1;
            $("#adviceTitle"+idx).val($("#adviceTitle"+j).val());
            $("#adviceType"+idx).val($("#adviceType"+j).val());
            $("#link"+idx).val($("#link"+j).val());
           
        }
    }
    totalIndex=totalIndex-1;
    $("table tr:last").remove();

};
 var update = function() {
    $("#jiaoxueForm").submit();
 };
 var index = function() {
var url = "../index/indexAction.action";
    // 迁移参数设定
    var params = new Array();
    deptAction(url,params);
};
</script>
</head>

<body>
<s:include value="%{pageContext.request.contextPath}/pages/admin/common/header.jsp" />
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0)" onclick="index();">首页</a></li>
    <li>康复指导</li>
    </ul>
    </div>
<div></div>


   <div style="float:right">
<input name="" type="button" class="btn" value="追加一行" onclick="addRow()"/>

</div>

<form id="jiaoxueForm" method="post" action="../adviceManage/updateAdvice.action">
  
<table id="settingTable" width="700"  border="3" class="tablelist">
  <tr>
    <th width="240" bgcolor="#FF9900" scope="col">标题</th>
    <th width="120" bgcolor="#FF9900" scope="col">使用范围</th>
    <th width="120" bgcolor="#FF9900" scope="col">内容链接</th>
    <th width="200"bgcolor="#FF9900" scope="col">操作</th>
  </tr>
  <s:iterator id="bean" status="result"  value="adviceManagerBeans">
  <tr id="row<s:property value="#result.index" />">
    <td><s:textfield id="adviceTitle%{#result.index}" name="adviceList[%{#result.index}].adviceTitle" value="%{adviceTitle}" class="scinput" theme="simple"/></td>
    <td><s:textfield id="adviceType%{#result.index}" name="adviceList[%{#result.index}].adviceType" value="%{adviceType}" class="scinput" theme="simple"/></td>
    <td><s:textfield id="link%{#result.index}" name="adviceList[%{#result.index}].link" value="%{link}" class="scinput" theme="simple" maxlength='50'/></td>
    <td ><input name="" type="button" class="btn" value="删除" onclick="removeRow('<s:property value="#result.index" />')"/></td>
  </tr>
  
  </s:iterator>
</table>
<p style="float:left;font-size:16px;color:red;">&nbsp;&nbsp;※请把添加的文件复制到[${path}]目录下</p><br>

</form>
<div>&nbsp;</div>

<div style="float:left">

<input id="update" type="button" class="btn" value="更新"/>
</div>
<div style="float:right">
<input name="" type="button" class="btn" value="追加一行" onclick="addRow()"/>
</div>
<s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />
</body>

</html>
