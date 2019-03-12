<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>元能100信息服务</title>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
        };
        $(".click").click(function(){
            $(".tip").fadeIn(200);
        });
  
        $(".tiptop a").click(function(){
            $(".tip").fadeOut(200);
        });

        $(".sure").click(function(){
            $(".tip").fadeOut(100);
        });

        $(".cancel").click(function(){
            $(".tip").fadeOut(100);
        });
    });
    
    //监听回车事件
    document.onkeydown=function(e) {
        e = (e) ? e : ((window.event) ? window.event : ""); 
        var key = e.keyCode?e.keyCode:e.which; 
        if(e.keyCode==13) {
          //这里提交你的表单
          $('#loginForm').submit();
        }
    };
    var register = function() {
    var url = "${pageContext.request.contextPath}/register/register.action";
    newWindow(url,600,1100,"yes","yes");
    //deptAction(url,new Array());
};
</script> 

</head>

<body style="background-color:#df7611; background-image:url(/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

<form id="loginForm" method="post" action="${pageContext.request.contextPath}/sysmanage/userLogin.action" method="post">

    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录昊刚教育系统</span>    
    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox loginbox1">
    
    <ul>
    <li><input  type="text"  id="userName" name="userName" class="loginuser" maxlength="32" placeholder="用户名"  value="<s:property value="userName" />" ></li>
    <li><input  type="password" id="password" name="password" class="loginpwd" maxlength="20"  placeholder="密码"  value="<s:property value="password" />"></li>
    <li class="yzm">
    <span><input type="text" placeholder="验证码" id="code" name="code" maxlength="4" /></span><cite><img src="${pageContext.request.contextPath}/sysuser/authCode.action" onclick="javascript:getCode();" id="imgCode" /></cite>
    
    </li>
    <li><input name="" type="button" class="loginbtn" value="登录"  onclick="javascript:lockSubmit('loginForm');"  /><label>
	    <input name="" type="button" class="loginbtn" value="我是游客" onclick="javascript:lockSubmit('loginForm2');" /></label>
		<label><a class="click" href="#">忘记密码？</a>
    </label><label><a  href="javascript:void(0)" onclick="register()">注册</a></label></li>
    </ul>
    
    
    </div>
    
    </div>
    <div class="tip">
    <div class="tiptop"><span>提示信息</span><a></a></div>
    <div class="tipinfo">
        <div class="tipright">
        <p>请通过以下方式联系管理员初始化密码</p>
        <cite>微信：weixin@123</cite><br>
        <cite>QQ：1234567890123</cite><br>
        <cite>手机短信：13800138000</cite><br>
        </div>
     </div>
     <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />
     </div>
    </div>
   </form>
   <form id="loginForm2" method="post" action="${pageContext.request.contextPath}/sysmanage/userLogin2.action" method="post">
   </form>
   <s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />
 </body>

</html>
