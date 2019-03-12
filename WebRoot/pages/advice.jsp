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

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/buttons.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/select.css" rel="stylesheet">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cloud.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/size.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/advice/advice.js"></script>

</head>

<body class="sarchbody">

	<s:include value="%{pageContext.request.contextPath}/pages/common/header.jsp" />

<div id="m-content">
<s:include value="%{pageContext.request.contextPath}/pages/common/menu1.jsp" />
            <div class="m-right-content">
            <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0)" onclick="index()">首页</a></li>
    <li>康复指导</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <s:hidden id="indexProperty" name = "indexProperty"  value="%{#session.ADVICE_LIST.indexProperty}" />
    <div id="usual1" class="usual"> 
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>发布时间</th>
        <th>标题</th>
        <th>适用范围</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="%{#session.ADVICE_LIST.resultList}"
                            begin="%{#session.ADVICE_LIST.indexProperty}"
                            end="%{#session.ADVICE_LIST.endProperty}" 
                            status="res">
        
        <tr>
        <td onclick="detail('${id}')"><s:property value='createTime' /></td>
        <td onclick="detail('${id}')"><s:property value='adviceTitle' /></td>
        <td onclick="detail('${id}')"><s:property value='adviceType' /></td>
        
        </tr>
         
        </s:iterator>
        </tbody>
    </table>
    <gsp:pageLinks totalProperty="totalProperty" indexProperty="indexProperty" rowProperty="rowProperty"
                  submit="true" action="../advice/pageLinks.action" name="ADVICE_LIST" />
	</div> 
    </div>
</div>
</div>


</body>

</html>
