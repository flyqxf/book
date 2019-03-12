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
 showflg="${showflg}";
$(document).ready(function(e) {

    $(".select3").uedSelect({
        width : 152
    });
    initShow();
    $(".scbtn1").click(function() 
    {    if(showflg == '1') {
          $(".seachform2").show();
          showflg="2";
        } else {
            $(".seachform2").hide();
            showflg="1";
        }
        
    }); 
    $("#select").one('click').click(select);
    $("#export").one('click').click(exportExcel); 
    
});
var exportExcel = function() {
    $("#userForm").attr("action","./exportExcel.action");
    $("#userForm").submit();
};

var initShow = function() {
    if(showflg == '1') {
    $(".seachform2").hide();
        } else {
            $(".seachform2").show();
        }
};
var select = function() {
    $("#showflg").val(showflg);
    $("#userForm").submit();
 };
 var detail=function(userId) {
    var url = "../user/userDetail.action";
    $("#userId").val(userId);
    
    $("#userForm").attr("action",url);
    $("#userForm").submit();
 };
 var index = function() {
    var url = "../index/indexAction.action";
    // 迁移参数设定
    var params = new Array();
    deptAction(url,params);
};
var sort = function(type,order) {
    var url = "./saleSort.action";
    
    var showflg = $("#showflg").val();
    // 迁移参数设定
    var params = new Array();
    params[0] = ["orderKey", type];
    params[1] = ["order", order];
    params[2] = ["showflg", showflg];
    deptAction(url,params);
};
</script>
</head>

<body class="sarchbody">
<s:include value="%{pageContext.request.contextPath}/pages/admin/common/header.jsp" />
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0)" onclick="index();">首页</a></li>
    <li>销售统计</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <form id="userForm" method="post" action="./saleAction.action">
    <s:hidden id="showflg" name ="showflg"/>
    <s:hidden id="userId" name ="userId"  />
    <ul class="seachform1">
    
    <li><label>会员ID</label><input name="conditionBean.userId" type="text" class="scinput1" value="${conditionBean.userId}"/></li>
    <li><label>会员名称</label><input name="conditionBean.userName" type="text" class="scinput1" value="${conditionBean.userName}"/></li>
    </ul>
    
    <ul class="seachform2">

    <li><label>当期推荐</label>  
    <div class="vocation">
    <select class="select3" name="conditionBean.flg">
    <option value="" <s:if test='conditionBean.flg == null || conditionBean.flg == ""'>selected</s:if>>全部</option>
    <option value="1" <s:if test='conditionBean.flg == "1"'>selected</s:if>>直接</option>
    <option value="2" <s:if test='conditionBean.flg == "2"'>selected</s:if>>间接</option>
    </select>
    </div>
    </li>
    
    <li><label>人数区间</label><input name="conditionBean.personSumFrom" type="text" class="scinput1" value="${conditionBean.personSumFrom}"/></li>
    <li><label>一</label><input name="conditionBean.personSumTo" type="text" class="scinput1" value="${conditionBean.personSumTo}"/></li> 

    
    </ul>
    
    <ul class="seachform1">
    <li class="sarchbtn"><label>&nbsp;</label><input id="select" type="button" class="scbtn" value="查询"/>   <input name="" type="button" class="scbtn1" value="更多条件"/>   <input id="export" type="button" class="scbtn2" value="导出EXCEL"/></li>  
    </ul>
    </form>
    
    <table class="tablelist">
        <thead>
        <tr>
        <th>会员ID</th>
        <th>会员名称</th>
        <th>入会时间</th>
        <th>直接推荐（累计）<span style="width:7px;"><img alt="" src="${pageContext.request.contextPath}/images/1.gif" onclick="sort('personSum_zhijie','1')"><img alt="" src="${pageContext.request.contextPath}/images/2.gif" onclick="sort('personSum_zhijie','2')"></span></th>
        <th>间接推荐（累计）<span style="width:7px;"><img alt="" src="${pageContext.request.contextPath}/images/1.gif" onclick="sort('personSum_jianjie','1')"><img alt="" src="${pageContext.request.contextPath}/images/2.gif" onclick="sort('personSum_jianjie','2')"></span></th>
        <th>奖励金额（合计）<span style="width:7px;"><img alt="" src="${pageContext.request.contextPath}/images/1.gif" onclick="sort('paySummary','1')"><img alt="" src="${pageContext.request.contextPath}/images/2.gif" onclick="sort('paySummary','2')"></span></th>
        <th>直接推荐（当期）<span style="width:7px;"><img alt="" src="${pageContext.request.contextPath}/images/1.gif" onclick="sort('personThisMonth_zhijie','1')"><img alt="" src="${pageContext.request.contextPath}/images/2.gif" onclick="sort('personThisMonth_zhijie','2')"></span></th>
        <th>间接推荐（当期）<span style="width:7px;"><img alt="" src="${pageContext.request.contextPath}/images/1.gif" onclick="sort('personThisMonth_jianjie','1')"><img alt="" src="${pageContext.request.contextPath}/images/2.gif" onclick="sort('personThisMonth_jianjie','2')"></span></th>
        <th>应付金额<span style="width:7px;"><img alt="" src="${pageContext.request.contextPath}/images/1.gif" onclick="sort('personThisMonth_jianjie','1')"><img alt="" src="${pageContext.request.contextPath}/images/2.gif" onclick="sort('personThisMonth_jianjie','2')"></span></th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="%{#session.saleList.resultList}"
                            begin="%{#session.saleList.indexProperty}"
                            end="%{#session.saleList.endProperty}" 
                            status="res">
        <tr>

        <td>${userId}</td>
        <td>${userName}</td>
        <td>${register_time}</td>
        <td>${personSum_zhijie}人</td>
        <td>${personSum_jianjie}人</td>
        <td>${paySummary}元</td>
        <td>${personThisMonth_zhijie}人</td>
        <td>${personThisMonth_jianjie}人</td>
        <td>${paySummary_thisMonth}元</td>
        <td><a href="javascript:void(0)" onclick="detail('${userId}')">查看个人销售详细</a></td>
        </tr> 
        </s:iterator>

        </tbody>
    </table>
    <gsp:pageLinks totalProperty="totalProperty" indexProperty="indexProperty" rowProperty="rowProperty"
                  submit="true" action="../sale/salePageLinks.action" name="saleList" />   
    </div> 
    </div>
   
   

</body>

</html>
