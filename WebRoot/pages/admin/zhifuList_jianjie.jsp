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
$(document).ready(function(e) {

    $("#select").one('click').click(select);
     $("#export").one('click').click(exportExcel); 

});
 var select = function() {
    $("#userForm").submit();
 };

var pay1=function(userId){
     var url = "../user/zhifu.action";
    
    $("#userForm").attr("action",url);
    $("#userId").val(userId);
    $("#flg").val("2");
    $("#userForm").submit();
    
     
};
var exportExcel = function() {
    $("#userForm").attr("action","./exportExcel.action");
    $("#userForm").submit();
};
var index = function() {
var url = "../index/indexAction.action";
    // 迁移参数设定
    var params = new Array();
    deptAction(url,params);
};
</script>
</head>

<body class="sarchbody">

    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    <form id="userForm" method="post" action="../pay/payJianjieAction.action">
    <s:hidden id="userId" name = "userId" />
    <s:hidden id="flg" name = "flg" />
    
    <ul class="seachform1">
    
    <li><label>会员ID</label><input name="bean.userId" type="text" class="scinput1" value="${beanJ.userId}" /></li>
    <li><label>会员名称</label><input name="bean.userName" type="text" class="scinput1" value="${beanJ.userName}" /></li>
    </ul>
    
    
    <ul class="seachform1">
    <li class="sarchbtn"><label>&nbsp;</label><input id="select" type="button" class="scbtn" value="查询"/>   <input id="export" type="button" class="scbtn2" value="导出EXCEL"/></li>  
    </ul>
    </form>
    
    
    <table class="tablelist">
        <thead>
        <tr>
        <th>会员ID</th>
        <th>会员名称</th>
        <th>前前期金额</th>
        <th>前前期待支付金额</th>
        <th>前期金额</th>
        <th>前期待支付金额</th>
        <th>当期金额</th>
        <th>当期待支付</th>
        <th>待支付金额（合计）</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="%{#session.payList_jianjie.resultList}"
                            begin="%{#session.payList_jianjie.indexProperty}"
                            end="%{#session.payList_jianjie.endProperty}" 
                            status="res">
        <tr>
        <td>${userId}</td>
        <td>${userName}</td>
        <td>${pay_qqq}元</td>
        <td>${unpaid_qqq}元</td>
        <td>${pay_qq}元</td>
        <td>${unpaid_qq}元</td>
        <td>${pay_dq}元</td>
        <td>${unpaid_dq}元</td>
        <td>${unpaid_summary}元</td>
        <td><a href="javascript:void(0)" onclick="pay1('${userId}')">去支付</a></td>
        </tr> 
        </s:iterator>

        </tbody>
    </table>   
    </div>
    <gsp:pageLinks totalProperty="totalProperty" indexProperty="indexProperty" rowProperty="rowProperty"
                  submit="true" action="../pay/payPageLinks_jianjie.action" name="payList" /> 
    </div>


</body>

</html>
