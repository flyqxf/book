<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<link href="${pageContext.request.contextPath}/css/jiaoxue.css" rel="stylesheet">



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
                '<td><s:textfield id="chapter'+totalIndex+'" name="jiaoxueList['+ totalIndex + '].chapter"  class="jiaoxue_scinput1" theme="simple"/></td>'+
                '<td><s:textfield id="part'+totalIndex+'" name="jiaoxueList['+ totalIndex + '].part" class="jiaoxue_scinput1" theme="simple"/></td>'+
                '<td><s:textfield id="link'+totalIndex+'" name="jiaoxueList['+ totalIndex + '].link" class="jiaoxue_scinput2" theme="simple" maxlength="50"/></td>'+
                 '<td><s:textfield id="sort'+totalIndex+'" name="jiaoxueList['+ totalIndex + '].sort" class="jiaoxue_scinput1" theme="simple" maxlength="10"/></td>'+
                '<td><input type="checkbox" id="chk'+totalIndex+'" value="1"></td>'+
                '<td><input  type="button" class="btn" value="删除" onclick="removeRow('+totalIndex+')" /></td>'+
                '</tr>'
        );
        $("#hiddenDiv").append(
            '<input type="hidden" id="checkbox'+totalIndex+'" name="jiaoxueList['+ totalIndex + '].chk"  value="0">'
        
        );
        totalIndex++;
    };
var removeRow=function(rownum) {
    
    var lastHidIdx = totalIndex-1;
    for(var i = rownum;i<totalIndex;i++) {
            var idx = i;
        if(idx != lastHidIdx) {
            var j=parseInt(idx)+1;
            $("#chapter"+idx).val($("#chapter"+j).val());
            $("#part"+idx).val($("#part"+j).val());
            $("#link"+idx).val($("#link"+j).val());
            $("#sort"+idx).val($("#sort"+j).val());
            if($("#chk"+j).prop("checked")) {
            
                $("#chk"+idx).prop("checked",true);
            } else {
                $("#chk"+idx).prop("checked",false);
            }
        }
    }
    $("#checkbox"+lastHidIdx).remove();
    totalIndex=totalIndex-1;
    $("table tr:last").remove();
    //$("hiddenDiv last").remove();
};
 var update = function() {
    $("input[id^=chk]").each(function () {
            if ($(this).is(":checked")) {
                
                var index = this.id.replace('chk','');
                $("#checkbox"+index).val("1");
                
            }
        });
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
    <li>教学内容</li>
    </ul>
    </div>
<div></div>


   <div style="float:right">
<input name="" type="button" class="btn" value="追加一行" onclick="addRow()"/>

</div>

<form id="jiaoxueForm" method="post" action="../jiaoxue/updateJaoxue.action">
<div id="hiddenDiv">
<s:iterator id="bean" status="result"  value="bookBeans">
  <s:hidden id="checkbox%{#result.index}" name="jiaoxueList[%{#result.index}].chk"  value="0"/>
  </s:iterator>
  </div>
  
<table id="settingTable" width="700"  border="3" class="tablelist">
  <tr>
    <th width="120" bgcolor="#FF9900" scope="col">一级目录</th>
    <th width="120" bgcolor="#FF9900" scope="col">二级目录</th>
    <th width="160" bgcolor="#FF9900" scope="col">内容链接</th>
    <th width="120" bgcolor="#FF9900" scope="col">顺序（可以输入小数）</th>
    <th width="80" bgcolor="#FF9900" scope="col">游客浏览可否</th>
    <th width="150" bgcolor="#FF9900" scope="col">操作</th>
  </tr>
  <s:iterator id="bean" status="result"  value="bookBeans">
  <tr id="row<s:property value="#result.index" />">
    <td><s:textfield id="chapter%{#result.index}" name="jiaoxueList[%{#result.index}].chapter" value="%{chapter}" class="jiaoxue_scinput1" theme="simple"/></td>
    <td><s:textfield id="part%{#result.index}" name="jiaoxueList[%{#result.index}].part" value="%{part}" class="jiaoxue_scinput1" theme="simple"/></td>
    <td><s:textfield id="link%{#result.index}" name="jiaoxueList[%{#result.index}].link" value="%{link}" class="jiaoxue_scinput2" theme="simple" maxlength='50'/></td>
    <td><s:textfield id="sort%{#result.index}" name="jiaoxueList[%{#result.index}].sort" value="%{sort}" class="jiaoxue_scinput1" theme="simple" maxlength='10'/></td>
    <td><input type="checkbox" id="chk<s:property value='#result.index' />"  <s:if test='chk == "1"'>checked</s:if>/></td>
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
