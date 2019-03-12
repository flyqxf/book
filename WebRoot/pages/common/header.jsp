<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<script type="text/javascript">
$(function(){   
    //顶部导航切换
    $(".nav li a").click(function(){
        $(".nav li a.selected").removeClass("selected");
        $(this).addClass("selected");
    });
});
var advice = function() {
    var url = "../advice/adviceList.action";
    deptAction(url,new Array());
};

var successCase = function() {
    var url = "../successCase/successCaseList.action";
    deptAction(url,new Array());
};

var help = function() {
    var url = "../help/help.action";
    deptAction(url,new Array());
};
var article = function() {
    var url = "../article/article.action";
    deptAction(url,new Array());
};
var person = function() {
    var url = "../person/person.action";
    deptAction(url,new Array());
};
var diary = function() {
    var url = "../diary/diary.action";
    deptAction(url,new Array());
};
var logoff = function() {
    var url = "../logoff.action";
    deptAction(url,new Array());
};
var index= function(){
var url = "../bookScan/bookScanAction.action";
    deptAction(url,new Array());
};
var changeSaler = function(){
var url = "../registerJ/checkChangeSalerAction.action";
    $.post(url, null, function(userflg) {
        if(userflg == '0' ||userflg=='2') {
            showInfoMessage("您已经是销售或管理员！");
        } else {
            var url = "${pageContext.request.contextPath}/register/changeSalerTopic.action";
            newWindow(url,600,1100,"yes","yes");
        }
    });

    //var url = "${pageContext.request.contextPath}/register/changeSalerTopic.action";
    //newWindow(url,600,1100,"yes","yes");
};
var downloadPdf = function() {
    var url = "../sysmanage/pdfDownload.action";
    var params = new Array();

    deptAction(url, params);
    
};
</script>
<div id="m-header" style="background:url(${pageContext.request.contextPath}/images/topbg.gif) repeat-x;">
    <div class="topleft">
    <a href="javascript:void(0)" onclick="index()"><img src="${pageContext.request.contextPath}/images/logo.png" title="系统首页" /></a>
    </div>
    <ul class="nav">
    <li><a href="javascript:void(0)" onclick="diary()"><img src="${pageContext.request.contextPath}/images/icon01.png" title="心得日记" /><h2>心得日记</h2></a></li>
    <li><a href="javascript:void(0)" onclick="advice()"><img src="${pageContext.request.contextPath}/images/icon02.png" title="康复指导" /><h2>康复指导</h2></a></li>
    <li><a href="javascript:void(0)" onclick="help()"><img src="${pageContext.request.contextPath}/images/icon03.png" title="解疑答惑" /><h2>解疑答惑</h2></a></li>
    <li><a href="javascript:void(0)" onclick="article()"><img src="${pageContext.request.contextPath}/images/icon04.png" title="我要发表" /><h2>我要发表</h2></a></li>
    <li><a href="javascript:void(0)" onclick="successCase()"><img src="${pageContext.request.contextPath}/images/icon05.png" title="成功案例" /><h2>成功案例</h2></a></li>
    <li><a href="javascript:void(0)" onclick="person()"><img src="${pageContext.request.contextPath}/images/icon06.png" title="个人中心" /><h2>个人中心</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><s:property value='%{#session.LOGIN_UVO.user.userName}' />&nbsp;&nbsp;您好！</li>
    <li><a href="javascript:void(0)" onclick="downloadPdf()">下载</a></li>
    <li><a href="javascript:void(0)" onclick="changeSaler()">成为销售</a></li>
    <li><a href="javascript:void(0)" onclick="logoff()">退出</a></li>
    <!-- <li><a href="register.html" target="_parent">注册</a></li>
    <li><a href="login.html" target="_parent">登录</a></li> -->
    </ul>
     
      
    
    </div>
</div>
<s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />