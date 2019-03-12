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
    DateControl("dateFrom");
    DateControl("dateTo");
    $("#select").one('click').click(select);
});
var select = function() {
   
    $("#wenzhangForm").submit();
 };
 
 var detail = function(id) {
    parent.detail(id);
 };

</script>

<body class="sarchbody">
    
    <form method = "post" id="wenzhangForm" action="./tab2Wenzhang.action">
    <ul class="seachform">
    
    <li><label>标题</label><input name="bean.title" type="text" class="scinput" value="${bean.title}"/></li>
    
    <li><label>文章类别</label>  
    <div class="vocation">
    <select class="select3" name="bean.leibie">
    <option value = "" <s:if test='bean.leibie == null || bean.leibie == ""'>selected</s:if>>全部</option>
    <option value = "1" <s:if test='bean.leibie == "1"'>selected</s:if>>答疑</option>
    <option value = "2" <s:if test='bean.leibie == "2"'>selected</s:if>>发表</option>
    </select>
    </div>
    </li>
        
    <li><label>&nbsp;&nbsp;时间</label><input id="dateFrom" type="text" class="scinput1" name="bean.createTime_from" value="${bean.createTime_from}"/></li>
    <li><label>---</label><input id="dateTo" type="text" class="scinput1" name="bean.createTime_to"  value="${bean.createTime_to}"/></li>
    
    <li><label>处理状态</label>  
    <div class="vocation" >
    <select class="select3" name="bean.status">
    <option value = "" <s:if test='bean.status == null || bean.status == ""'>selected</s:if>>全部</option>
    <option value = "0" <s:if test='bean.status == "0"'>selected</s:if>>未处理</option>
    <option value = "1" <s:if test='bean.status == "1"'>selected</s:if>>已处理</option>
    </select>
    </div>
    </li>
    
    <li><label>&nbsp;</label><input id="select" type="button" class="scbtn" value="查询"/></li>
    </ul>
    </form>
    
    <table class="tablelist">
        <thead>
        <tr>
        <th width="10%">序号</th>
        <th width="30%">标题</th>
        <th width="10%">发布者</th>
        <th width="10%">文章类别</th>
        <th width="20%">发布时间</th>
        <th width="10%">处理状态</th>
        <th width="10%">操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="%{#session.wenzhangList.resultList}"
                            begin="%{#session.wenzhangList.indexProperty}"
                            end="%{#session.wenzhangList.endProperty}" 
                            status="res">
        <tr>

        <td>${No}</td>
        <td>${title}</td>
        <td>${createUser}</td>
        <td>${leibie_name}</td>
        <td>${createTime}</td>
        <td>${status_name}</td>
        <td><a href="javascript:void(0)" onclick="detail('${id}')" class="tablelink">查看</a>   </td>
        </tr> 
        </s:iterator>
        </tbody>
    </table>
    <gsp:pageLinks totalProperty="totalProperty" indexProperty="indexProperty" rowProperty="rowProperty"
                  submit="true" action="../wenzhang/pageLinks.action" name="wenzhangList" />
<s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />
</body>

</html>
