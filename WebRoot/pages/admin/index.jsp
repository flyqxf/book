<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>元能100信息服务</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/buttons.css" rel="stylesheet">
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


</head>
</head>
<body>
<s:include value="%{pageContext.request.contextPath}/pages/admin/common/header.jsp" />
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <b>Admin早上好，欢迎使用信息管理系统</b>
    </div>
    
    <div class="xline"></div>
    <div class="xline"></div>

    
    <table width="624" class="tablelink">
        <thead>
        <tr>
        <th width="13%">会员总数</th>
        <th width="13%">销售人员数</th>
        <th width="13%">学员数</th>
        <th width="19%">理论总收入</th>
        <th width="20%">已分配支付金额</th>
        <th width="22%" class="toolsli">未分配金额</th>
        </tr>

        <tr>
        <th>${indexBean.personSummary }人</th>
        <th>${indexBean.saleSum }人</th>
        <th>${indexBean.personSum }人</th>
        <th>${indexBean.income }元</th>
        <th>${indexBean.distribution }元</th>
        <th>${indexBean.notDistribution }元</th>
        </tr>

        </thead>
        
    </table>

    
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="${pageContext.request.contextPath}/images/dp.png" alt="提醒" /></span><strong>每月新入会员数一览</strong></div>

    <table class="filetable">
    
    <thead>
        <tr>
        <th width="7.5%">${lastYear }年一月</th>
        <th width="7.5%">二月</th>
        <th width="7.5%">三月</th>
        <th width="7.5%">四月</th>
        <th width="7.5%">五月</th>
        <th width="7.5%">六月</th>
        <th width="7.5%">七月</th>
        <th width="7.5%">八月</th>
        <th width="7.5%">九月</th>
        <th width="7.5%">十月</th>
        <th width="7.5%">十一月</th>
        <th width="7.5%">十二月</th>
        <th width="10%">年小计</th>
        </tr>       
    </thead>
    <tbody>
    
        <tr>
        <s:iterator value="%{lastIndexDetail}" >
        <td>${cnt}</td>
        </s:iterator>
        </tr>
    </tbody>
    
    <table class="filetable">
    
    <thead>
        <tr>
        <th width="7.5%">${thisYear }年一月</th>
        <th width="7.5%">二月</th>
        <th width="7.5%">三月</th>
        <th width="7.5%">四月</th>
        <th width="7.5%">五月</th>
        <th width="7.5%">六月</th>
        <th width="7.5%">七月</th>
        <th width="7.5%">八月</th>
        <th width="7.5%">九月</th>
        <th width="7.5%">十月</th>
        <th width="7.5%">十一月</th>
        <th width="7.5%">十二月</th>
        <th width="10%">年小计</th>
        </tr>       
    </thead>
    <tbody>
    
        <tr>
         <s:iterator value="%{thisIndexDetail }" >
        <td>${cnt}</td>
        </s:iterator>
        </tr>
    </tbody>   
    <div class="xline"></div>  
    
    </div>
</body>
</html>
