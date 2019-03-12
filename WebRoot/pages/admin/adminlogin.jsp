<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/buttons.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/select.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cloud.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    });  
});
//点击触发，发送请求
    function getCode(){
        document.getElementById("imgCode").src="${pageContext.request.contextPath}/sysuser/authCode.action?parm="+Math.random();
    }

    $(document).ready(function () {
        if ("1" == "${showD101Message}") {
            $("#modalMessage").modal("show");
        }
    });
  
</script> 

</head>

<body style="background-color:#df7611; background-image:url(/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

<form id="loginForm" method="post" action="${pageContext.request.contextPath}/manageLogin/adminLogin.action" method="post">

    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
   
    </div>
    
    <div class="loginbody">
    
    
       
    <div class="loginbox loginbox3">
    
    <ul>
    <li><input name="userName" type="text" class="loginuser"  maxlength="32" placeholder="用户名" value="<s:property value="userName" />" /></li>
    <li><input name="password" type="password" class="loginpwd"  maxlength="20"  placeholder="密码"  value="<s:property value="password" />" ></li>
    <li class="yzm">
    <span><input type="text" placeholder="验证码" id="code" name="code" maxlength="4" /></span><cite><img src="${pageContext.request.contextPath}/sysuser/authCode.action" onclick="javascript:getCode();" id="imgCode" /></cite>
    
    </li>
    <li><input name="" type="button" class="loginbtn" value="登录"   onclick="javascript:lockSubmit('loginForm');" /></li>
    </ul>
    
    
    </div>
    
    </div>

</form>
<s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />
</body>

</html>
