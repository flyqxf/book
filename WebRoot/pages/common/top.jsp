<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cloud.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">

var logoff = function() {
    var url = "../logoff.action";
    deptAction(url,new Array());
};
var msg = function() {
    showInfoMessage("请登录后阅读！","系统提示");
};
 var register = function() {
    var url = "${pageContext.request.contextPath}/register/register.action";
    newWindow(url,600,1100,"yes","yes");
    //deptAction(url,new Array());
};
var successCase = function() {
    var url = "../successCase/successCaseListTourist.action";
    deptAction(url,new Array());
};
var index= function(){
var url = "../tourist/touristAction.action";
    deptAction(url,new Array());
};
</script>
<div id="m-header" style="background:url(${pageContext.request.contextPath}/images/topbg.gif) repeat-x;">
    <div class="topleft">
    <a href="javascript:void(0)" onclick="index()"><img src="${pageContext.request.contextPath}/images/logo.png" title="系统首页" /></a>
    </div>
    <ul class="nav">
    <li><a href="javascript:void(0)" onclick="msg()"><img src="${pageContext.request.contextPath}/images/icon01.png" title="心得日记" /><h2>心得日记</h2></a></li>
    <li><a href="javascript:void(0)" onclick="msg()"><img src="${pageContext.request.contextPath}/images/icon02.png" title="康复指导" /><h2>康复指导</h2></a></li>
    <li><a href="javascript:void(0)" onclick="msg()"><img src="${pageContext.request.contextPath}/images/icon03.png" title="解疑答惑" /><h2>解疑答惑</h2></a></li>
    <li><a href="javascript:void(0)" onclick="msg()"><img src="${pageContext.request.contextPath}/images/icon04.png" title="我要发表" /><h2>我要发表</h2></a></li>
    <li><a href="javascript:void(0)" onclick="successCase()"><img src="${pageContext.request.contextPath}/images/icon05.png" title="成功案例" /><h2>成功案例</h2></a></li>
    <li><a href="javascript:void(0)" onclick="msg()"><img src="${pageContext.request.contextPath}/images/icon06.png" title="个人中心" /><h2>个人中心</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li>游客&nbsp;&nbsp;您好！</li>
    <li><a href="javascript:void(0)" target="_parent" onclick="register()">注册</a></li>
    <li><a href="javascript:void(0)" onclick="logoff()">登录</a></li>
    </ul>
     
      
    
    </div>
</div>
<s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />