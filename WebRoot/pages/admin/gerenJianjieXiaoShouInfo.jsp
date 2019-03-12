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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/area2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/chooseLocation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/select2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>



<script type="text/javascript">
 province_val = "${bean.province_val}";
 city_val = "${bean.city_val}";
 userId = "${userId}";
$(document).ready(function(e) {
$(".select3").uedSelect({
        width : 152
    });

    DateControl("dateFrom");
    DateControl("dateTo");
    $("#select").one('click').click(select);
});
 
     var select = function() {
    
    $("#userId").val(userId);
    $("#jianjieForm").submit();
    
 };
  var pay = function() {
    //parent.pay_Jianjie(userId);
    var url = "./zhifu.action";
    
    $("#jianjieForm").attr("action",url);
    $("#userId").val(userId);
    $("#flg").val("2");
    
    $("#jianjieForm").submit();
 };
</script>

<body class="sarchbody">


<div id="m-content">
    <form id="jianjieForm" method="post" action="./tab3User.action">
<s:hidden id="userId" name = "userId"  />
<s:hidden id="flg" name = "flg" />
    <ul class="seachform">
    
    <li><label>下级会员ID</label><input name="bean.achUserId" type="text" class="scinput" value="${bean.achUserId}"/></li>
    
    
    <li><label>&nbsp;&nbsp;&nbsp;&nbsp;时间区间</label><input id="dateFrom" type="text" class="scinput1" name="bean.register_time_from" value="${bean.register_time_from }"/></li>
    <li><label>一</label><input id="dateTo" type="text" class="scinput1" name="bean.register_time_to"  value="${bean.register_time_to }"/></li>
    
    <li><label>支付状态</label>  
    <div class="vocation">
    <select class="select3" name="bean.pay_status">
    <option value="" <s:if test='bean.pay_status == null || bean.pay_status == ""'>selected</s:if>></option>
    <option value="0" <s:if test='bean.pay_status == "0"'>selected</s:if>>未支付</option>
    <option value="1" <s:if test='bean.pay_status == "1"'>selected</s:if>>已支付</option>
    
    </select>
    </div>
    </li>
    
    <li><label>&nbsp;</label><input id="select" type="button" class="scbtn" value="查询"/></li>
    </ul>
    </form>
    <table class="tablelist">
        <thead>
        <tr>
        <th>下级会员ID</th>
        <th>下级会员名称</th>
        <th>销售人数</th>
        <th>支付状态</th>
        <th>劳务费</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="%{#session.jianjieXiaoshouList.resultList}"
                            begin="%{#session.jianjieXiaoshouList.indexProperty}"
                            end="%{#session.jianjieXiaoshouList.endProperty}" 
                            status="res">
        <tr>
        <td>${userId}</td>
        <td>${userName}</td>
        <td>${xiaoshouPersonSum}</td>
        <td>${pay_status_name}</td>
        <td>${paySum}元</td>
        <td><a href="javascript:void(0)" onclick="pay()">去支付</a></td>
        </tr>
        </s:iterator>
        </tbody>
    </table>
     <gsp:pageLinks totalProperty="totalProperty" indexProperty="indexProperty" rowProperty="rowProperty"
                  submit="true" action="../user/jianjieXiaoshouPageLinks.action" name="jianjieXiaoshouList" />
    
</div> 
 

<s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />
</body>

</html>
